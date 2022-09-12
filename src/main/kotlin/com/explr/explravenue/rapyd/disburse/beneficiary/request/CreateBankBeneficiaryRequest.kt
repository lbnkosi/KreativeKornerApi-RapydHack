package com.explr.explravenue.rapyd.disburse.beneficiary.request

data class CreateBankBeneficiaryRequest(
    var category: String? = "",
    var default_payout_method_type: String? = "",
    var country: String? = "",
    var currency: String? = "",
    var entity_type: String? = "",
    var first_name: String? = "",
    var identification_type: String? = "",
    var identification_value: String? = "",
    var last_name: String? = "",
    var payment_type: String? = "",
    var address: String? = "",
    var city: String? = "",
    var postcode: String? = "",
    var account_number: String? = "",
    var merchant_reference_id: String? = "",
    var company_name: String? = "",
    var bic_swift: String? = "",
    var bank_account_type: String? = "",
    var state: String? = "",
    var aba: String? = ""
)