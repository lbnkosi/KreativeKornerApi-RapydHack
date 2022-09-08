package com.explr.explravenue.kreativeapi.user.models

data class CreateFirebaseUserRequest(
    var name: String = "",
    var surname: String = "",
    var phone: String = "",
    var email: String = "",
    var country: String = "",
    var user_type: String = "",
    var points: String = "",
    var ref_id: String = "",
    var wallet_amount: String = "",
    var wallet_id: String = "",
    var customer_id: String = "",
    var payment_method: String = ""
)
