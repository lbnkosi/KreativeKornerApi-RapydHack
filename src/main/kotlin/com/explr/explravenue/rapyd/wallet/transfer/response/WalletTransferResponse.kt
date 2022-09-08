package com.explr.explravenue.rapyd.wallet.transfer.response

data class WalletTransferResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)