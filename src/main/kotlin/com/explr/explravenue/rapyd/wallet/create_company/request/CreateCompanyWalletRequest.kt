package com.explr.explravenue.rapyd.wallet.create_company.request

data class CreateCompanyWalletRequest(
    var first_name: String = "",
    var ewallet_reference_id: String = "",
    var metadata: Metadata = Metadata(),
    var type: String = "",
    var contact: Contact = Contact()
)