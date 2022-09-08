package com.explr.explravenue.rapyd.wallet.create_company.response

data class BusinessDetails(
    var id: String = "",
    var name: String = "",
    var registration_number: String = "",
    var entity_type: String = "",
    var industry_category: String = "",
    var industry_sub_category: String = "",
    var address: AddressX = AddressX(),
    var created_at: Int = 0,
    var annual_revenue: Int = 0,
    var establishment_date: Any = Any(),
    var legal_entity_type: Any = Any(),
    var cnae_code: Any = Any()
)