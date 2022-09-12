package com.explr.explravenue.rapyd.disburse.payout.single.response

data class CreateSinglePayoutResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)