package com.explr.explravenue.kreativeapi.loans.util

import com.explr.explravenue.kreativeapi.loans.models.CreateCustomerLoanRequest
import com.explr.explravenue.rapyd.collect.subscription.create_subscription.request.CreateSubscriptionRequest
import com.explr.explravenue.rapyd.collect.subscription.create_subscription.request.Metadata
import com.explr.explravenue.rapyd.collect.subscription.create_subscription.request.SubscriptionItem

object LoanUtil {

    fun generateSubscriptionRequest(loanRequest: CreateCustomerLoanRequest): CreateSubscriptionRequest {
        val request = CreateSubscriptionRequest()
        request.customer = loanRequest.customer_id
        request.billing = "pay_automatically"
        request.billing_cycle_anchor = ""
        request.cancel_at_period_end = true
        request.coupon = ""
        request.days_until_due = null
        request.payment_method = loanRequest.payment_method
        request.subscription_items.add(SubscriptionItem(plan = loanRequest.plan_id, quantity = 1))
        request.metadata = Metadata(merchant_defined = true)
        request.tax_percent = 10.5
        request.trial_end = 0
        request.trial_from_plan = true
        request.trial_period_days = null
        request.plan_token = ""
        return request
    }

}