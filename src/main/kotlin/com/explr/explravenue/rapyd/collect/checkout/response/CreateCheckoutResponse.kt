package com.explr.explravenue.rapyd.collect.checkout.response

data class CreateCheckoutResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)