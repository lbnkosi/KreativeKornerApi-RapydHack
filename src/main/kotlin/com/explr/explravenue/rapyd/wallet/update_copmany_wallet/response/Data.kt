package com.explr.explravenue.rapyd.wallet.update_copmany_wallet.response

data class Data(
    var phone_number: Any = Any(),
    var email: Any = Any(),
    var first_name: String = "",
    var last_name: Any = Any(),
    var id: String = "",
    var status: String = "",
    var accounts: List<Any> = listOf(),
    var verification_status: String = "",
    var type: String = "",
    var metadata: Metadata = Metadata(),
    var ewallet_reference_id: String = "",
    var category: Any = Any(),
    var contacts: Contacts = Contacts()
)