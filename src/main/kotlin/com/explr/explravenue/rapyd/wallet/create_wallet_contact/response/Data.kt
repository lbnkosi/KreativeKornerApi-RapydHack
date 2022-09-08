package com.explr.explravenue.rapyd.wallet.create_wallet_contact.response

data class Data(
    var id: String = "",
    var first_name: String = "",
    var last_name: String = "",
    var middle_name: String = "",
    var second_last_name: String = "",
    var gender: String = "",
    var marital_status: String = "",
    var house_type: String = "",
    var contact_type: String = "",
    var phone_number: String = "",
    var email: String = "",
    var identification_type: String = "",
    var identification_number: String = "",
    var issued_card_data: IssuedCardData = IssuedCardData(),
    var date_of_birth: String = "",
    var country: String = "",
    var nationality: String = "",
    var address: Address = Address(),
    var ewallet: String = "",
    var created_at: Int = 0,
    var metadata: MetadataX = MetadataX(),
    var business_details: Any = Any(),
    var compliance_profile: Int = 0,
    var verification_status: String = "",
    var send_notifications: Boolean = false,
    var mothers_name: String = ""
)