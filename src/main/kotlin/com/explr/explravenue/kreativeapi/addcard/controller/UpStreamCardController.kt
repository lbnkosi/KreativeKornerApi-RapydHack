package com.explr.explravenue.kreativeapi.addcard.controller

import com.explr.explravenue.firebase.firestore.controller.FirestoreController
import com.explr.explravenue.kreativeapi.accesspoint.AccessPointRequest
import com.explr.explravenue.kreativeapi.addcard.model.FirebaseAddCardRequest
import com.explr.explravenue.rapyd.collect.customer.controller.CustomerController
import com.explr.explravenue.rapyd.collect.customer.get_customer.response.GetCustomerResponse
import com.explr.explravenue.rapyd.collect.payment.card.request.CreateCardPaymentRequest
import com.explr.explravenue.rapyd.collect.payment.card.request.Fields
import com.explr.explravenue.rapyd.collect.payment.card.request.Metadata
import com.explr.explravenue.rapyd.collect.payment.card.request.PaymentMethod
import com.explr.explravenue.rapyd.collect.payment.card.response.CreateCardPaymentResponse
import com.explr.explravenue.rapyd.collect.payment.controller.PaymentsController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/explore/api/addcard")
object UpStreamCardController {

    @PostMapping(value = ["/addCard"])
    fun addCard(@RequestBody accessPoint: AccessPointRequest): ResponseEntity<Any> {
        val request = configureRequest(accessPoint)
        return try {
            val card = PaymentsController.createCardPayment(request)
            val customer = CustomerController.getCustomer(accessPoint.customer_id)
            val firebaseVan = createFirebaseRequest(accessPoint, card, customer)
            FirestoreController.create(accessPoint.user_type, accessPoint.email, "mycards", firebaseVan)
            ResponseEntity.ok("Success")
        } catch (e: HttpClientErrorException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    private fun configureRequest(accessPoint: AccessPointRequest): CreateCardPaymentRequest {
        val request = CreateCardPaymentRequest()
        request.amount = 1
        request.currency = accessPoint.currency
        request.customer = accessPoint.customer_id
        request.capture = true
        val paymentMethod = PaymentMethod()
        paymentMethod.type = accessPoint.type
        paymentMethod.metadata = Metadata(merchant_defined = true)
        val fields = Fields()
        fields.cvv = accessPoint.cvv
        fields.expiration_month = accessPoint.expiration_month
        fields.expiration_year = accessPoint.expiration_year
        fields.name = accessPoint.card_holder
        fields.number = accessPoint.card_number
        paymentMethod.fields = fields
        request.payment_method = paymentMethod
        return request
    }

    fun createFirebaseRequest(accessPoint: AccessPointRequest, card: CreateCardPaymentResponse ,customer: GetCustomerResponse): FirebaseAddCardRequest {
        val request = FirebaseAddCardRequest()
        val details = customer.data.payment_methods.data.find { predicate -> card.data.payment_method_data.id == predicate.id }
        request.type = accessPoint.type
        request.customerId = accessPoint.customer_id
        request.cvv = accessPoint.cvv
        request.expiration_month = accessPoint.expiration_month
        request.expiration_year = accessPoint.expiration_year
        request.card_holder = accessPoint.card_holder
        request.card_number = accessPoint.card_number
        request.logo = details?.image
        request.card_id = details?.id
        request.category = details?.category
        request.last4 = details?.last4
        request.fingerprint_token = details?.fingerprint_token
        request.ewallet_id = card.data.ewallet_id
        return request
    }
}