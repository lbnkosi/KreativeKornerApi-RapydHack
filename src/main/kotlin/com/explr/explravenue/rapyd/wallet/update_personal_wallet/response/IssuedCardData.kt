package com.explr.explravenue.rapyd.wallet.update_personal_wallet.response

data class IssuedCardData(
    var preferred_name: String = "",
    var transaction_permissions: String = "",
    var role_in_company: String = ""
)