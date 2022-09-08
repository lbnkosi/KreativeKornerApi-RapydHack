package com.explr.explravenue.rapyd.issuing.card.create_card.response

data class PublicDetails(
    var bin: String = "",
    var last4: String = "",
    var sub_bin: String = "",
    var expiration: String = ""
)