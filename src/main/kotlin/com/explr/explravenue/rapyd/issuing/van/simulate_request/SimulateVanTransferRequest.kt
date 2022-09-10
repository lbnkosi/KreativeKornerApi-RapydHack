package com.explr.explravenue.rapyd.issuing.van.simulate_request

data class SimulateVanTransferRequest(
    var issued_bank_account: String = "",
    var amount: String = "",
    var currency: String = ""
)