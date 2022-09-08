package com.explr.explravenue.rapyd.issuing.card.get_cards.response

data class PublicDetails(
    var bin: String = "",
    var last4: String = "",
    var sub_bin: String = "",
    var expiration: String = ""
)