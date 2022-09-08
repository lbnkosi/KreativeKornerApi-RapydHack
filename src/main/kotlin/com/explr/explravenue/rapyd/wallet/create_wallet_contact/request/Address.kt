package com.explr.explravenue.rapyd.wallet.create_wallet_contact.request

data class Address(
    var name: String = "",
    var line_1: String = "",
    var line_2: String = "",
    var line_3: String = "",
    var city: String = "",
    var state: String = "",
    var zip: String = "",
    var phone_number: String = "",
    var metadata: MetadataX = MetadataX(),
    var canton: String = "",
    var district: String = ""
)