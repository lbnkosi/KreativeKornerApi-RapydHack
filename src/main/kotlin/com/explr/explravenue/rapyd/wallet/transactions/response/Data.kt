package com.explr.explravenue.rapyd.wallet.transactions.response

data class Data(
    var id: String = "",
    var currency: String = "",
    var amount: Int = 0,
    var ewallet_id: String = "",
    var type: String = "",
    var balance_type: String = "",
    var balance: Int = 0,
    var created_at: Int = 0,
    var status: String = "",
    var reason: String = "",
    var metadata: Metadata = Metadata()
)