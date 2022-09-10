package com.explr.explravenue.rapyd.issuing.van.simulate_response

data class Transaction(
    var id: String = "",
    var amount: Int = 0,
    var currency: String = "",
    var created_at: Int = 0
)