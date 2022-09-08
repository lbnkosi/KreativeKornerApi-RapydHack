package com.explr.explravenue.rapyd.collect.subscription.create_subscription.response

data class Data(
    var id: String = "",
    var billing: String = "",
    var billing_cycle_anchor: Int = 0,
    var created_at: Int = 0,
    var customer_token: String = "",
    var days_until_due: Int = 0,
    var metadata: Metadata = Metadata(),
    var tax_percent: Double = 0.0,
    var cancel_at_period_end: Boolean = false,
    var canceled_at: Any = Any(),
    var current_period_end: Int = 0,
    var current_period_start: Int = 0,
    var discount: Any = Any(),
    var ended_at: Any = Any(),
    var subscription_items: SubscriptionItems = SubscriptionItems(),
    var status: String = "",
    var trial_end: Any = Any(),
    var trial_start: Any = Any(),
    var payment_method: String = "",
    var payment_fields: Any = Any(),
    var payout_fields: Any = Any(),
    var type: String = ""
)