package com.explr.explravenue.rapyd.collect.subscription.create_subscription.response

data class CreateSubscriptionResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)