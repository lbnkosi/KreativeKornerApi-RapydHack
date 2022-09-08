package com.explr.explravenue.rapyd.collect.checkout.response

data class Ewallet(
    var ewallet: String = "",
    var amount: Double = 0.0,
    var percent: Int = 0
)