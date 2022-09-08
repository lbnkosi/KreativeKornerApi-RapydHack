package com.explr.explravenue.rapyd.wallet.get_single_wallet.response

data class Contacts(
    var `data`: List<DataX> = listOf(),
    var has_more: Boolean = false,
    var total_count: Int = 0,
    var url: String = ""
)