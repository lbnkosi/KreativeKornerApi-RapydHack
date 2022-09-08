package com.explr.explravenue.rapyd.collect.subscription.create_subscription.response

data class Plan(
    var id: String = "",
    var aggregate_usage: String = "",
    var amount: Int = 0,
    var billing_scheme: String = "",
    var created_at: Int = 0,
    var currency: String = "",
    var interval: String = "",
    var interval_count: Int = 0,
    var metadata: MetadataX = MetadataX(),
    var product: String = "",
    var nickname: String = "",
    var tiers: List<Any> = listOf(),
    var tiers_mode: String = "",
    var transform_usage: TransformUsage = TransformUsage(),
    var trial_period_days: Int = 0,
    var usage_type: String = ""
)