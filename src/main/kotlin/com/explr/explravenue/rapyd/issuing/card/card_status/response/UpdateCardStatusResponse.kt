package com.explr.explravenue.rapyd.issuing.card.card_status.response

data class UpdateCardStatusResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)