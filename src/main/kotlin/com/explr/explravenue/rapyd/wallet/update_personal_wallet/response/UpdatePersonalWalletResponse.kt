package com.explr.explravenue.rapyd.wallet.update_personal_wallet.response

data class UpdatePersonalWalletResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)