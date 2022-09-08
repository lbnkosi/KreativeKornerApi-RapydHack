package com.explr.explravenue.rapyd.collect.order.create_order.request

data class MainPayment(
    var product_name: String = "",
    var product_id: String = "",
    var product_price: Int = 0,
    var order_amount: Int = 0,
    var product_payment_type: String = "",
    var listed_payments: List<ListedPayments> = listOf()
)