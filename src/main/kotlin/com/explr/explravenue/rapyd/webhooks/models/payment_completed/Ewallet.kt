package com.explr.explravenue.rapyd.webhooks.models.payment_completed

data class Ewallet(
    var amount: Double = 0.0,
    var percent: Int = 0,
    var ewallet_id: String = "",
    var refunded_amount: Int = 0
)