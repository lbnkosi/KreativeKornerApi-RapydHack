package com.explr.explravenue.rapyd.collect.checkout.response

data class Metadata(
    var merchant_defined: Boolean = false,
    var user_type: String? = "",
    var email: String? = "",
    var reference: String? = "",
    var product_id: String? = ""
)