package com.explr.explravenue.rapyd.collect.order.update_order.request

data class Payment(
    var link: String = "",
    var amount: Int = 0,
    var wallet_id: String = "",
    var payment_id: String = "",
    var expected_amount: Int = 0,
    var is_payment_complete: Boolean = false,
    var is_dependent_payment: Boolean = false,
    var amount_deposited_so_far: Int = 0
)