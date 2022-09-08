package com.explr.explravenue.rapyd.collect.order.create_order.request

data class MetadataX(
    var is_order_complete: Boolean = false,
    var instructions: Instructions = Instructions(),
    var transaction_history: List<TransactionHistory> = listOf(),
    var main_payment: MainPayment = MainPayment(),
    var add_on_payment: AddOnPayment = AddOnPayment(),
    var merchant_defined: Boolean = false
)