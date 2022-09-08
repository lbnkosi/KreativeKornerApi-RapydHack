package com.explr.explravenue.rapyd.wallet.create_personal.response

data class IssuedCardData(
    var preferred_name: String = "",
    var transaction_permissions: String = "",
    var role_in_company: String = ""
)