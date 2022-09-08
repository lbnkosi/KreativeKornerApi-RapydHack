package com.explr.explravenue.rapyd.issuing.card.activate_card.response

data class ActivateCardResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)