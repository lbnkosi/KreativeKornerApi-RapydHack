package com.explr.explravenue.rapyd.disburse.payout.single.response

data class Instruction(
    var name: String = "",
    var steps: List<Step> = listOf()
)