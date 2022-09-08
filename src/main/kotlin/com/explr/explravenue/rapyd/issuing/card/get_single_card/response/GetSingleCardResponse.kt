package com.explr.explravenue.rapyd.issuing.card.get_single_card.response

data class GetSingleCardResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)