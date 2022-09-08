package com.explr.explravenue.rapyd.wallet.create_company.request

data class Address(
    var name: String = "",
    var line_1: String = "",
    var city: String = "",
    var state: String = "",
    var country: String = "",
    var zip: String = "",
    var phone_number: String = ""
)