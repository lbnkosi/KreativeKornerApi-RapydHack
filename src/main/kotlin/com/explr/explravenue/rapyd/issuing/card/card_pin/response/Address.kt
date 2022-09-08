package com.explr.explravenue.rapyd.issuing.card.card_pin.response

data class Address(
    var id: String = "",
    var name: String = "",
    var line_1: String = "",
    var line_2: String = "",
    var line_3: String = "",
    var city: String = "",
    var state: String = "",
    var country: String = "",
    var zip: String = "",
    var phone_number: String = "",
    var metadata: MetadataXX = MetadataXX(),
    var canton: String = "",
    var district: String = "",
    var created_at: Int = 0
)