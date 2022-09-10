package com.explr.explravenue.rapyd.issuing.van.simulate_response

data class SimulateVanTransferResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)