package com.explr.explravenue.kreativeapi.healthcare.models

data class FirebaseHealthcareRequest(
    var id: String? = "",
    var max_payout: String? = "",
    var monthly_payment: String? = "",
    var plan_id: String? = "",
    var product_id: String? = "",
    var interval: String? = "",
    var has_payout: Boolean = false,
    var payout_id: String? = "",
    var beneficiary_id: String? = "",
    var sender_id: String? = "",
    var customer_id: String? = "",
    var collect_card_number: String? = "",
    var collect_card_id: String? = "",
    var ipi_id: String? = ""
)
