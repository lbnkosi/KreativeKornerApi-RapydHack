package com.explr.explravenue.rapyd.issuing.card.get_single_card.response

data class IssuedCardData(
    var preferred_name: String = "",
    var transaction_permissions: String = "",
    var role_in_company: String = ""
)