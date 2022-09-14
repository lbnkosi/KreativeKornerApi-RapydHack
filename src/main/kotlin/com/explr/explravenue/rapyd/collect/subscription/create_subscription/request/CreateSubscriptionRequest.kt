package com.explr.explravenue.rapyd.collect.subscription.create_subscription.request

data class CreateSubscriptionRequest(
    var customer: String? = "",
    var billing: String? = "",
    var billing_cycle_anchor: String? = "",
    var cancel_at_period_end: Boolean = false,
    var coupon: String? = "",
    var days_until_due: String? = null,
    var payment_method: String? = "",
    var subscription_items: MutableList<SubscriptionItem> = mutableListOf(),
    var metadata: Metadata = Metadata(),
    var tax_percent: Double = 0.0,
    var trial_end: Int = 0,
    var trial_from_plan: Boolean = false,
    var trial_period_days: String? = null,
    var plan_token: String? = ""
)