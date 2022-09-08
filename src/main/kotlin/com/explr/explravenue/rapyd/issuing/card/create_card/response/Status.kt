package com.explr.explravenue.rapyd.issuing.card.create_card.response

data class Status(
    var error_code: String = "",
    var status: String = "",
    var message: String = "",
    var response_code: String = "",
    var operation_id: String = ""
)