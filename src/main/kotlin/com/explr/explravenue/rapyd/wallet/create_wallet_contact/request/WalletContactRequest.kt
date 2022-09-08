package com.explr.explravenue.rapyd.wallet.create_wallet_contact.request

data class WalletContactRequest(
    var first_name: String = "",
    var last_name: String = "",
    var middle_name: String = "",
    var second_last_name: String = "",
    var mothers_name: String = "",
    var gender: String = "",
    var marital_status: String = "",
    var house_type: String = "",
    var contact_type: String = "",
    var phone_number: String = "",
    var email: String = "",
    var identification_type: String = "",
    var identification_number: String = "",
    var date_of_birth: String = "",
    var country: String = "",
    var nationality: String = "",
    var address: Address = Address(),
    var metadata: MetadataX = MetadataX()
)