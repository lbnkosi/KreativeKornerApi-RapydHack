package com.explr.explravenue.rapyd.collect.payment.card.request

data class Fields(
    var number: String? = "",
    var expiration_month: String? = "",
    var expiration_year: String? = "",
    var name: String? = "",
    var cvv: String? = ""
)