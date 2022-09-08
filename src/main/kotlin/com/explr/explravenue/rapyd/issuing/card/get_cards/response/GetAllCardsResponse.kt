package com.explr.explravenue.rapyd.issuing.card.get_cards.response

data class GetAllCardsResponse(
    var status: Status = Status(),
    var `data`: List<Data> = listOf()
)