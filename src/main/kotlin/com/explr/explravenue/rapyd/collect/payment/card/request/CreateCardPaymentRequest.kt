package com.explr.explravenue.rapyd.collect.payment.card.request

data class CreateCardPaymentRequest(
    var amount: Int = 0,
    var currency: String = "",
    var customer: String = "",
    var payment_method: PaymentMethod = PaymentMethod(),
    var capture: Boolean = false
)