package com.explr.explravenue.rapyd.wallet.update_copmany_wallet.request

data class UpdateCompanyWalletRequest(
    var phone_number: String = "",
    var email: String = "",
    var first_name: String = "",
    var last_name: String = "",
    var ewallet: String = "",
    var id: String = "",
    var status: String = "",
    var accounts: List<Any> = listOf(),
    var verification_status: String = "",
    var type: String = "",
    var metadata: Metadata = Metadata(),
    var ewallet_reference_id: String = "",
    var category: String = "",
    var contacts: Contacts = Contacts()
)