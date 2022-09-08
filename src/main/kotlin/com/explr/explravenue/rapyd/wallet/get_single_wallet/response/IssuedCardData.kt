package com.explr.explravenue.rapyd.wallet.get_single_wallet.response

data class IssuedCardData(
    var preferred_name: String = "",
    var transaction_permissions: String = "",
    var role_in_company: String = ""
)