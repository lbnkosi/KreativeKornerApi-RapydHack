package com.explr.explravenue.kreativeapi.payout.models

data class FirebaseSinglePayoutRequest(

    var id: String? = "",
    var amount: String? = "",
    var currency: String? = "",
    var payout_currency: String? = "",
    var sender_amount: String? = "",
    var sender_currency: String? = "",
    var sender_country: String? = "",
    var sender: String? = "",
    var sender_id: String? = "",
    var beneficiary_country: String? = "",
    var beneficiary_id: String? = "",
    var beneficiary: String? = "",
    var instrucitons: String? = "",
    var ewallet: String? = "",
    var description: String? = "",
    var statement_descriptor: String? = ""
)
