package com.explr.explravenue.rapyd.wallet.transactions.response

data class GetTransactionsResponse(
    var status: Status = Status(),
    var `data`: List<Data> = listOf()
)