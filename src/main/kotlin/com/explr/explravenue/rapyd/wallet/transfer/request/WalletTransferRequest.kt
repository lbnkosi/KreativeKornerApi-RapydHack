package com.explr.explravenue.rapyd.wallet.transfer.request

data class WalletTransferRequest(
    var amount: Int = 0,
    var currency: String = "",
    var source_ewallet: String = "",
    var destination_ewallet: String = "",
    var metadata: MetaData = MetaData()
)