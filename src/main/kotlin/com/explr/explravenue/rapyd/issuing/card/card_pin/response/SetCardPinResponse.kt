package com.explr.explravenue.rapyd.issuing.card.card_pin.response

data class SetCardPinResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)