package com.explr.explravenue.rapyd.collect.product.create_service_product.request

data class Metadata(
    var price: Int = 0,
    var merchant_defined: Boolean = false,
    var is_add_on: Boolean = false
)