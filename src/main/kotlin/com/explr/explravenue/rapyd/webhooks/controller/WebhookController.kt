package com.explr.explravenue.rapyd.webhooks.controller

import com.explr.explravenue.rapyd.util.EmailServiceImpl
import com.explr.explravenue.rapyd.webhooks.webhookmodel.response.WebhookResponse
import com.google.gson.Gson
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException
import java.util.*
import javax.mail.*
import javax.mail.internet.*


@RestController
@RequestMapping("/api/v1/webhook")
class WebhookController {

    @PostMapping
    fun notification(@RequestBody body: WebhookResponse) {
        //EmailServiceImpl().sendSimpleMessage("rapydhack@gmail.com", "Webhook", Gson().toJson(body))
        sendmail(Gson().toJson(body))
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
        //val attachPart = MimeBodyPart()
        //attachPart.attachFile("/var/tmp/image19.png")
        //multipart.addBodyPart(attachPart)
        msg.setContent(multipart)
        Transport.send(msg)
    }

}