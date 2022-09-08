package com.explr.explravenue.rapyd.wallet.get_single_wallet.response

data class GetSingleWalletResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)