package com.explr.explravenue.rapyd.issuing.card.card_pin.request

data class SetCardPinRequest(
    var card: String = "",
    var new_pin: String = ""
)