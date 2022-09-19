package com.explr.explravenue.kreativeapi.healthcare.controller

import com.explr.explravenue.firebase.firestore.controller.FirestoreController
import com.explr.explravenue.kreativeapi.accesspoint.AccessPointRequest
import com.explr.explravenue.kreativeapi.healthcare.models.FirebaseHealthcareRequest
import com.explr.explravenue.kreativeapi.insurance.models.FirebaseIncomeProtectionRequest
import com.explr.explravenue.kreativeapi.subscription.controller.UpStreamSubscriptionController
import com.explr.explravenue.rapyd.collect.subscription.controller.SubscriptionController
import com.explr.explravenue.rapyd.collect.subscription.create_subscription.response.CreateSubscriptionResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/explore/api/healthcare")
object HealthCareController {

    @PostMapping(value = ["/create"])
    fun createHealthCare(@RequestBody accessPoint: AccessPointRequest): ResponseEntity<Any> {
        val collectRequest = UpStreamSubscriptionController.configureRequest(accessPoint)
        return try {
            val subscription = SubscriptionController.createSubscription(collectRequest)
            val firebaseRequest = configureFirebaseRequest(accessPoint, subscription)
            FirestoreController.create(accessPoint.user_type, accessPoint.email, "healthcare", firebaseRequest)
            ResponseEntity.ok("Success")
        } catch (e: HttpClientErrorException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    private fun configureFirebaseRequest(accessPoint: AccessPointRequest, subscription: CreateSubscriptionResponse): FirebaseHealthcareRequest {
        val request = FirebaseHealthcareRequest()
        request.id = (System.currentTimeMillis() /1000L).toString()
        request.max_payout = accessPoint.max_payout
        request.monthly_payment = accessPoint.monthly_payment
        request.interval = accessPoint.interval
        request.ipi_id = accessPoint.ipi_id
        request.collect_card_id = accessPoint.collect_card_id
        request.customer_id = accessPoint.customer_id
        request.sender_id = ""
        request.beneficiary_id = ""
        request.monthly_payment = subscription.data.subscription_items.data[0].plan.amount.toString()
        request.plan_id = accessPoint.plan_id
        request.product_id = accessPoint.product_id
        return request
    }

}