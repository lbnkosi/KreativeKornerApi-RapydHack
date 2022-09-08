package com.explr.explravenue.rapyd.collect.order.update_order.request

data class Item(
    var amount: Int = 0,
    var currency: String = "",
    var description: String = "",
    var parent: String = "",
    var quantity: Int = 0,
    var type: String = ""
)