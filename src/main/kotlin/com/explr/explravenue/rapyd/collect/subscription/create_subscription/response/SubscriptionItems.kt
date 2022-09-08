package com.explr.explravenue.rapyd.collect.subscription.create_subscription.response

data class SubscriptionItems(
    var `data`: List<DataX> = listOf(),
    var has_more: Boolean = false,
    var total_count: Int = 0,
    var url: String = ""
)