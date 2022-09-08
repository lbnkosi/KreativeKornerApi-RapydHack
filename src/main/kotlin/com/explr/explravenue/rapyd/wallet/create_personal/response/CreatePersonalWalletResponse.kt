package com.explr.explravenue.rapyd.wallet.create_personal.response

data class CreatePersonalWalletResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)