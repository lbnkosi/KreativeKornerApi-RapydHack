package com.explr.explravenue.rapyd.collect.payment.card.request

data class PaymentMethod(
    var type: String? = "",
    var fields: Fields? = Fields(),
    var metadata: Metadata? = Metadata()
)