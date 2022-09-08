package com.explr.explravenue.rapyd.wallet.create_personal.response

data class Contacts(
    var `data`: List<DataX> = listOf(),
    var has_more: Boolean = false,
    var total_count: Int = 0,
    var url: String = ""
)