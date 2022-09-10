package com.explr.explravenue.kreativeapi.van.model

data class FirebaseVan(
    var id: String? = "",
    var merchant_reference_id: String? = "",
    var ewallet: String? = "",
    var beneficiary_name: String? = "",
    var address: String? = "",
    var country_iso: String? = "",
    var country: String? = "",
    var aba_routing_number: String? = "",
    var account_number: String? = "",
    var status: String? = "",
    var description: String? = "",
    var funding_instructions: String? = "",
    var currency: String? = "",
    var transactions: List<Any> = listOf(),
    var iban: String? = "",
    var sort_code: String? = "",
    var bic: String? = "",
    var account_no: String? = ""
)
