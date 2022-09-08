package com.explr.explravenue.rapyd.wallet.create_personal.response

data class Account(
    var id: String = "",
    var currency: String = "",
    var alias: String = "",
    var balance: Double = 0.0,
    var received_balance: Double = 0.0,
    var on_hold_balance: Double = 0.0,
    var reserve_balance: Double = 0.0,
    var limits: Any = Any(),
    var limit: Any = Any()
)