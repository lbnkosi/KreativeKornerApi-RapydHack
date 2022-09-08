package com.explr.explravenue.rapyd.collect.order.create_order.response

data class AddOnPayment(
    var payments: List<Payment> = listOf(),
    var product_id: String = "",
    var product_name: String = "",
    var product_price: Int = 0,
    var product_payment_type: String = ""
)