package com.explr.explravenue.kreativeapi.loans.controller

import com.explr.explravenue.firebase.firestore.controller.FirestoreController
import com.explr.explravenue.kreativeapi.accesspoint.AccessPointRequest
import com.explr.explravenue.kreativeapi.cashadvance.models.FirebaseCashAdvanceRequest
import com.explr.explravenue.kreativeapi.loans.models.FirebaseLoanRequest
import com.explr.explravenue.kreativeapi.payout.UpStreamPayoutController
import com.explr.explravenue.kreativeapi.subscription.controller.UpStreamSubscriptionController
import com.explr.explravenue.rapyd.collect.subscription.controller.SubscriptionController
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
@RequestMapping("/explore/api/loan")
object LoanController {

    @PostMapping(value = ["/createcustomerloan"])
    fun createCustomerLoan(@RequestBody accessPoint: AccessPointRequest): ResponseEntity<Any> {
        val payoutRequest = UpStreamPayoutController.configureRequest(accessPoint)
        val collectRequest = UpStreamSubscriptionController.configureRequest(accessPoint)
        return try {
            val payout = PayoutController.createPayout(payoutRequest.apply { payout_amount = "2000" })
            val subscription = SubscriptionController.createSubscription(collectRequest)
            val firebaseRequest = configureFirebaseRequest(accessPoint, subscription, payout)
            FirestoreController.create(accessPoint.user_type, accessPoint.email, "my_loans", firebaseRequest)
            ResponseEntity.ok("Success")
        } catch (e: HttpClientErrorException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    private fun configureFirebaseRequest(accessPoint: AccessPointRequest, subscription: CreateSubscriptionResponse, payoutResponse: CreateSinglePayoutResponse): FirebaseLoanRequest {
        val request = FirebaseLoanRequest()
        request.id = (System.currentTimeMillis() / 1000L).toString()
        request.amount = subscription.data.subscription_items.data[0].plan.amount.toString()
        request.amount_payable = request.amount
        request.interest_percentage = accessPoint.interest
        request.invoice_id = ""
        request.sender_id = payoutResponse.data.sender.id
        request.beneficiary_id = payoutResponse.data.beneficiary.id

        request.collect_card_id = accessPoint.payment_method
        request.disburse_account_number = payoutResponse.data.beneficiary.account_number
        request.disburse_payout_id = payoutResponse.data.id

        request.status = false

        request.single_collection = true
        request.billing_cycle = "30 Days"

        request.months = accessPoint.months
        request.monthly_payment = subscription.data.subscription_items.data[0].plan.amount.toString()

        request.plan_id = accessPoint.plan_id
        return request
    }

}