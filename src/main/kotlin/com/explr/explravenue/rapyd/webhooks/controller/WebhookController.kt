package com.explr.explravenue.rapyd.webhooks.controller

import com.explr.explravenue.firebase.firestore.controller.FirestoreController
import com.explr.explravenue.rapyd.issuing.card.create_card.response.CreateCardResponse
import com.explr.explravenue.rapyd.webhooks.models.payment_succeeded.PaymentSucceededWebhook
import com.explr.explravenue.rapyd.webhooks.webhookmodel.response.WebhookResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException
import java.lang.reflect.Type
import java.util.*
import javax.mail.*
import javax.mail.internet.*

@RestController
@RequestMapping("/api/v1/webhook")
class WebhookController {

    @PostMapping
    fun notification(@RequestBody body: WebhookResponse) {
        if (body.type == "PAYMENT_SUCCEEDED") {
            val response = Gson().toJson(body)
            val type: Type = object : TypeToken<PaymentSucceededWebhook>() {}.type
            val payment: PaymentSucceededWebhook =  Gson().fromJson(response, type)
            val metadata = payment.data.metadata
            FirestoreController.updatePaid(metadata.email, metadata.user_type, metadata.reference, "checkout")
        }
        //sendmail(Gson().toJson(body))
    }

    @Throws(AddressException::class, MessagingException::class, IOException::class)
    fun sendmail(body: String?) {
        val props = Properties()
        props["mail.smtp.auth"] = "true"
        props["mail.smtp.starttls.enable"] = "true"
        props["mail.smtp.host"] = "smtp.gmail.com"
        props["mail.smtp.port"] = "587"
        val session: Session = Session.getInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication("rapydhack@gmail.com", "prhbsgcgjclalkdw")
            }
        })
        val msg: Message = MimeMessage(session)
        msg.setFrom(InternetAddress("rapydhack@gmail.com", false))
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("rapydhack@gmail.com"))
        msg.subject = "Rapyd Webhook Response"
        msg.setContent(body, "text/html")
        msg.sentDate = Date()
        val messageBodyPart = MimeBodyPart()
        messageBodyPart.setContent(body, "text/html")
        val multipart: Multipart = MimeMultipart()
        multipart.addBodyPart(messageBodyPart)
        msg.setContent(multipart)
        Transport.send(msg)
    }

}