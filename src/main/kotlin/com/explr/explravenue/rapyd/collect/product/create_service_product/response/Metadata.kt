package com.explr.explravenue.rapyd.collect.product.create_service_product.response

data class Metadata(
    var price: Int = 0,
    var is_add_on: Boolean = false,
    var merchant_defined: Boolean = false
)