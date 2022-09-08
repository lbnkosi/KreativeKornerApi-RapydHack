package com.explr.explravenue.rapyd.wallet.transfer.request

import com.explr.explravenue.rapyd.wallet.transfer.request.MetaData

data class WalletTransferRequest(
    var amount: Int = 0,
    var currency: String = "",
    var source_ewallet: String = "",
    var destination_ewallet: String = "",
    var metadata: MetaData = MetaData()
)