package com.explr.explravenue.rapyd.collect.customer.create_customer.request

data class Fields(
    var number: String = "",
    var expiration_month: String = "",
    var expiration_year: String = "",
    var cvv: String = ""
)