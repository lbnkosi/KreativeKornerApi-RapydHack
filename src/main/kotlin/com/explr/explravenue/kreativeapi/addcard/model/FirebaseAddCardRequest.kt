package com.explr.explravenue.kreativeapi.addcard.model

data class FirebaseAddCardRequest(

    var type: String? = "",
    var card_number: String? = "",
    var expiration_month: String? = "",
    var expiration_year: String? = "",
    var card_holder: String? = "",
    var cvv: String? = "",
    var customerId: String? = "",

    var logo: String? = "",
    var card_id: String? = "",
    var category: String? = "",
    var last4: String? = "",
    var fingerprint_token: String? = "",
    var ewallet_id: String? = ""

)
