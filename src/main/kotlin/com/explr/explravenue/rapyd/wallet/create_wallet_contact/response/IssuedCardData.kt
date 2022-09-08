package com.explr.explravenue.rapyd.wallet.create_wallet_contact.response

data class IssuedCardData(
    var preferred_name: String = "",
    var transaction_permissions: String = "",
    var role_in_company: String = ""
)