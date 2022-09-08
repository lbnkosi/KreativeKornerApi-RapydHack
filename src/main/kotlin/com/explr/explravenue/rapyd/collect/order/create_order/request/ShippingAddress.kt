package com.explr.explravenue.rapyd.collect.order.create_order.request

data class ShippingAddress(
    var name: String = "",
    var line_1: String = "",
    var line_2: String = "",
    var line_3: String = "",
    var city: String = "",
    var district: String = "",
    var canton: String = "",
    var state: String = "",
    var country: String = "",
    var zip: String = "",
    var phone_number: String = "",
    var metadata: Metadata = Metadata()
)