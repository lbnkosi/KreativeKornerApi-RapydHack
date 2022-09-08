package com.explr.explravenue.rapyd.collect.subscription.create_subscription.response

data class DataX(
    var id: String = "",
    var created: Int = 0,
    var metadata: Any = Any(),
    var quantity: Int = 0,
    var plan: Plan = Plan()
)