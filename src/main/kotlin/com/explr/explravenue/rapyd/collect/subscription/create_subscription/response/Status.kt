package com.explr.explravenue.rapyd.collect.subscription.create_subscription.response

data class Status(
    var error_code: String = "",
    var status: String = "",
    var message: String = "",
    var response_code: String = "",
    var operation_id: String = ""
)