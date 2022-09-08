package com.explr.explravenue.rapyd.issuing.card.create_card.response

data class CreateCardResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)