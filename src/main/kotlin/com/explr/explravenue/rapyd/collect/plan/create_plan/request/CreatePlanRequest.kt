package com.explr.explravenue.rapyd.collect.plan.create_plan.request

data class CreatePlanRequest(
    var currency: String = "",
    var interval: String = "",
    var product: String = "",
    var aggregate_usage: String = "",
    var billing_scheme: String = "",
    var nickname: String = "",
    var transform_usage: TransformUsage = TransformUsage(),
    var trial_period_days: Int = 0,
    var usage_type: String = ""
)