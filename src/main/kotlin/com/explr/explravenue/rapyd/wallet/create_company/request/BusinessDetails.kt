package com.explr.explravenue.rapyd.wallet.create_company.request

data class BusinessDetails(
    var entity_type: String = "",
    var name: String = "",
    var registration_number: String = "",
    var industry_category: String = "",
    var industry_sub_category: String = "",
    var address: AddressX = AddressX()
)