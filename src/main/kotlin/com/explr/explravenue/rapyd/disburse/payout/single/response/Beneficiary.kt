package com.explr.explravenue.rapyd.disburse.payout.single.response

data class Beneficiary(
    var id: String = "",
    var last_name: String = "",
    var first_name: String = "",
    var country: String = "",
    var entity_type: String = "",
    var address: String = "",
    var name: String = "",
    var postcode: String = "",
    var city: String = "",
    var state: String = "",
    var company_name: String = "",
    var account_number: String = "",
    var currency: String = "",
    var identification_type: String = "",
    var identification_value: String = "",
    var merchant_reference_id: String = "",
    var bic_swift: String = "",
    var aba: String = "",
    var bank_account_type: String = "",
    var payment_type: String = "",
    var category: String = "",
    var default_payout_method_type: String = ""
)