package com.explr.explravenue.rapyd.collect.order.update_order.request

data class Metadata(
    var instructions: Instructions = Instructions(),
    var main_payment: MainPayment = MainPayment(),
    var add_on_payment: AddOnPayment = AddOnPayment(),
    var merchant_defined: Boolean = false,
    var is_order_complete: Boolean = false,
    var transaction_history: List<TransactionHistory> = listOf()
)