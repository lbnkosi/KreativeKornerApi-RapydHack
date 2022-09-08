package com.explr.explravenue.rapyd.wallet.create_company.request

data class AddressX(
    var name: String = "",
    var line_1: String = "",
    var line_2: String = "",
    var city: String = "",
    var state: String = "",
    var country: String = "",
    var nationality: String = "",
    var zip: String = "",
    var phone_number: String = "",
    var metadata: Metadata = Metadata()
)