package com.explr.explravenue.kreativeapi.subscription.controller

import com.explr.explravenue.firebase.firestore.controller.FirestoreController
import com.explr.explravenue.kreativeapi.accesspoint.AccessPointRequest
import com.explr.explravenue.kreativeapi.payout.UpStreamPayoutController
import com.explr.explravenue.rapyd.collect.subscription.controller.SubscriptionController
import com.explr.explravenue.rapyd.collect.subscription.create_subscription.request.CreateSubscriptionRequest
import com.explr.explravenue.rapyd.collect.subscription.create_subscription.request.Metadata
import com.explr.explravenue.rapyd.collect.subscription.create_subscription.request.SubscriptionItem
import com.explr.explravenue.rapyd.collect.subscription.create_subscription.response.CreateSubscriptionResponse
import com.explr.explravenue.rapyd.disburse.payout.controller.PayoutController
import com.explr.explravenue.rapyd.disburse.payout.single.response.CreateSinglePayoutResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/explore/api/createsubscription")
object UpStreamSubscriptionController {

    @PostMapping(value = ["/createsubscription"])
    fun createSubscription(@RequestBody accessPoint: AccessPointRequest): CreateSubscriptionResponse {
        val request = configureRequest(accessPoint)
        val subscription = SubscriptionController.createSubscription(request)
        FirestoreController.create(accessPoint.user_type, accessPoint.email, "mysubscriptions", subscription)
        return subscription
    }

    fun configureRequest(accessPoint: AccessPointRequest): CreateSubscriptionRequest {
        val request = CreateSubscriptionRequest()
        request.customer = accessPoint.customer_id
        request.billing = "pay_automatically"
        request.cancel_at_period_end = true
        request.days_until_due = ""
        request.payment_method = accessPoint.payment_method
        val subscriptionItem = SubscriptionItem()
        subscriptionItem.plan = accessPoint.plan_id
        subscriptionItem.quantity = 1
        request.subscription_items.add(subscriptionItem)
        request.metadata = Metadata(merchant_defined = true)
        request.tax_percent = 10.5
        request.trial_end = 0
        request.trial_from_plan = true
        request.trial_period_days = ""
        request.plan_token = ""
        return request
    }

}