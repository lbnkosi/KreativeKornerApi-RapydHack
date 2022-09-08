package com.explr.explravenue.rapyd.collect.customer.create_customer.request

data class PaymentMethod(
    var type: String = "",
    var fields: Fields = Fields()
)