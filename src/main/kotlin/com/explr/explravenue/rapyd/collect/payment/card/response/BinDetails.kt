package com.explr.explravenue.rapyd.collect.payment.card.response

data class BinDetails(
    var type: Any = Any(),
    var brand: Any = Any(),
    var level: Any = Any(),
    var country: Any = Any(),
    var bin_number: String = ""
)