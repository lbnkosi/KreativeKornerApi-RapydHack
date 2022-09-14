package com.explr.explravenue.kreativeapi.cashadvance.models

data class FirebaseCashAdvanceRequest(

    var id: String? = "",
    var amount: String? = "",
    var amount_payable: String? = "",
    var interest_percentage: String? = "",
    var invoice_id: String? = "",

    var sender_id: String? = "",
    var beneficiary_id: String? = "",

    var collect_card_number: String? = "",
    var collect_card_id: String? = "",

    var disburse_account_number: String? = "",
    var disburse_payout_id: String? = "",

    var status: Boolean = false,

    var single_collection: Boolean? = true,
    var billing_cycle: String? = "30 Days",

    var months: String? = "",
    var monthly_payment: String? = ""

)