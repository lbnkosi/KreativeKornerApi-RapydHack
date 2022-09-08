package com.explr.explravenue.rapyd.wallet.get_single_wallet.response

data class Data(
    var phone_number: String = "",
    var email: String = "",
    var first_name: String = "",
    var last_name: String = "",
    var id: String = "",
    var status: String = "",
    var accounts: List<Account> = listOf(),
    var verification_status: String = "",
    var type: String = "",
    var metadata: Metadata = Metadata(),
    var ewallet_reference_id: String = "",
    var category: String = "",
    var contacts: Contacts = Contacts()
)