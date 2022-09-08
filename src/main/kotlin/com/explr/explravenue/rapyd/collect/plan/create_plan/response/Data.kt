package com.explr.explravenue.rapyd.collect.plan.create_plan.response

data class Data(
    var id: String = "",
    var aggregate_usage: String = "",
    var amount: Int = 0,
    var billing_scheme: String = "",
    var created_at: Int = 0,
    var currency: String = "",
    var interval: String = "",
    var interval_count: Int = 0,
    var metadata: Metadata = Metadata(),
    var product: Product = Product(),
    var nickname: String = "",
    var tiers: List<Any> = listOf(),
    var tiers_mode: String = "",
    var transform_usage: TransformUsage = TransformUsage(),
    var trial_period_days: Int = 0,
    var usage_type: String = ""
)