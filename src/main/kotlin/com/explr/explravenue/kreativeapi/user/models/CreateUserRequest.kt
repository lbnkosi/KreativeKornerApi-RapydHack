package com.explr.explravenue.kreativeapi.user.models

data class CreateUserRequest(
    var name: String = "",
    var surname: String = "",
    var phone: String = "",
    var email: String = "",
    var country: String = "",
    var user_type: String = "",
    var points: String? = "0",
    var ref_id: String? = "",
    var wallet_amount: String? = "0",
    var wallet_id: String? = "",
    var customer_id: String? = "",
    var payment_method: String? = ""
)
