package com.explr.explravenue.rapyd.wallet.create_personal.request

data class CreatePersonalWalletRequest(
    var first_name: String = "",
    var last_name: String = "",
    var email: String = "",
    var ewallet_reference_id: String = "",
    var metadata: Metadata = Metadata(),
    var phone_number: String = "",
    var type: String = "",
    var contact: Contact = Contact()
)