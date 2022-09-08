package com.explr.explravenue.rapyd.collect.payment.bank_transfer.response

data class Ewallet(
    var ewallet_id: String = "",
    var amount: Int = 0,
    var percent: Int = 0,
    var refunded_amount: Int = 0
)