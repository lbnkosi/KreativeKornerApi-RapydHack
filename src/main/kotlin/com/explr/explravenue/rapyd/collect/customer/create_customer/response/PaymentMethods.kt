package com.explr.explravenue.rapyd.collect.customer.create_customer.response

data class PaymentMethods(
    var `data`: List<DataX> = listOf(),
    var has_more: Boolean = false,
    var total_count: Int = 0,
    var url: String = ""
)