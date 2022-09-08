package com.explr.explravenue.rapyd.issuing.card.create_card.request

data class CreateCardRequest(
    var ewallet_contact: String = "",
    var card_program: String = ""
)