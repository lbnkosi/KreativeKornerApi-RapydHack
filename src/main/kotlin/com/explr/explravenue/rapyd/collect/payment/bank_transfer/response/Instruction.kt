package com.explr.explravenue.rapyd.collect.payment.bank_transfer.response

data class Instruction(
    var name: String = "",
    var steps: List<Step> = listOf()
)