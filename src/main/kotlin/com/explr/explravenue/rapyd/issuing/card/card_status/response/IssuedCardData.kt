package com.explr.explravenue.rapyd.issuing.card.card_status.response

data class IssuedCardData(
    var preferred_name: String = "",
    var transaction_permissions: String = "",
    var role_in_company: String = ""
)