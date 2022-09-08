package com.explr.explravenue.rapyd.wallet.update_copmany_wallet.request

data class Contacts(
    var `data`: List<Data> = listOf(),
    var has_more: Boolean = false,
    var total_count: Int = 0,
    var url: String = ""
)