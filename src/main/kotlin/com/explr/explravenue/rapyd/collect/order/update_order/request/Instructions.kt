package com.explr.explravenue.rapyd.collect.order.update_order.request

data class Instructions(
    var allot_to_order: Boolean = false,
    var amount_to_allot: Int = 0
)