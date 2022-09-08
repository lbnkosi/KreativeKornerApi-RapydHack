package com.explr.explravenue.rapyd.collect.payment.card.response

data class CreateCardPaymentResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)