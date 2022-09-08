package com.explr.explravenue.rapyd.issuing.card.card_status.request

data class UpdateCardStatusRequest(
    var card: String = "",
    var status: String = ""
)