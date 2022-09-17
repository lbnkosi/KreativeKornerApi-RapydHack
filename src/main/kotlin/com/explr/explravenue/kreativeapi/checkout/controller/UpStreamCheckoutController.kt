package com.explr.explravenue.kreativeapi.checkout.controller

import com.explr.explravenue.firebase.firestore.controller.FirestoreController
import com.explr.explravenue.kreativeapi.accesspoint.AccessPointRequest
import com.explr.explravenue.kreativeapi.checkout.models.FirebaseCheckoutRequest
import com.explr.explravenue.rapyd.collect.checkout.controller.CheckoutController
import com.explr.explravenue.rapyd.collect.checkout.request.CreateCheckoutRequest
import com.explr.explravenue.rapyd.collect.checkout.request.Metadata
import com.explr.explravenue.rapyd.collect.checkout.response.CreateCheckoutResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/explore/api/checkout")
object UpStreamCheckoutController {

    @PostMapping(value = ["/update"])
    fun createCheckout(@RequestBody accessPoint: AccessPointRequest): ResponseEntity<Any> {
        return try {
            val checkout = CheckoutController.createCheckoutForCustomer(configureCheckoutRequest(accessPoint))
            val firebaseRequest = configureFirebaseRequest(accessPoint, checkout)
            FirestoreController.create(accessPoint.ref_id, accessPoint.user_type, accessPoint.email, "checkout", firebaseRequest)
            ResponseEntity.ok("Success")
        } catch (e: HttpClientErrorException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    private fun configureFirebaseRequest(accessPoint: AccessPointRequest, checkoutResponse: CreateCheckoutResponse): FirebaseCheckoutRequest {
        val request = FirebaseCheckoutRequest()
        request.checkout_id = checkoutResponse.data.id
        request.checkout_url = checkoutResponse.data.redirect_url
        request.price = accessPoint.amount
        request.product_id = accessPoint.product_id
        request.checkout_type = accessPoint.checkout_type
        request.reference = checkoutResponse.data.metadata.reference
        request.merchant_reference_id = checkoutResponse.data.payment.merchant_reference_id
        request.user_type = accessPoint.user_type
        request.email = accessPoint.email
        request.paid = false
        request.customer_id = accessPoint.customer_id
        request.collection_name = accessPoint.collection_name
        return request
    }

    private fun configureCheckoutRequest(accessPoint: AccessPointRequest): CreateCheckoutRequest {
        val request = CreateCheckoutRequest()
        request.amount = accessPoint.amount.toDouble()
        request.country = accessPoint.country
        request.currency = accessPoint.currency
        request.customer = accessPoint.customer_id
        request.merchant_reference_id = accessPoint.ref_id
        request.cardholder_preferred_currency = true
        request.language = "en"
        request.expiration = 1671984524
        request.payment_method_types_include = paymentMethods()
        val metadata2 = Metadata()
        metadata2.merchant_defined = true
        metadata2.email = accessPoint.email
        metadata2.user_type = accessPoint.user_type
        metadata2.reference = accessPoint.ref_id
        metadata2.product_id = accessPoint.product_id
        request.metadata = metadata2
        return request
    }

    private fun paymentMethods(): ArrayList<String> {
        val paymentMethods: ArrayList<String> = arrayListOf()
        paymentMethods.add("us_debit_discover_card")
        paymentMethods.add("us_debit_visa_card")
        paymentMethods.add("us_debit_mastercard_card")
        paymentMethods.add("us_debit_discover_card")
        paymentMethods.add("us_debit_visa_card")
        paymentMethods.add("us_debit_mastercard_card")
        return paymentMethods
    }

}