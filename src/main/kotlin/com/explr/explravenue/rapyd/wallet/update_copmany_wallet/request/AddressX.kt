package com.explr.explravenue.rapyd.wallet.update_copmany_wallet.request

data class AddressX(
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
    var metadata: Metadata = Metadata(),
    var canton: String = "",
    var district: String = "",
    var created_at: Int = 0
)