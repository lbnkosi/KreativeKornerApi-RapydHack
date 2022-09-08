package com.explr.explravenue.rapyd.wallet.create_personal.request

data class Contact(
    var phone_number: String = "",
    var email: String = "",
    var first_name: String = "",
    var last_name: String = "",
    var mothers_name: String = "",
    var contact_type: String = "",
    var address: Address = Address(),
    var identification_type: String = "",
    var identification_number: String = "",
    var date_of_birth: String = "",
    var country: String = "",
    var nationality: String = "",
    var metadata: Metadata = Metadata()
)