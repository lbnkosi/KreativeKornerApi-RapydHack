package com.explr.explravenue.rapyd.collect.order.create_order.request

data class CreateOrderRequest(
    var customer: String = "",
    var currency: String = "",
    var external_coupon_code: String = "",
    var items: List<Item> = listOf(),
    var shipping_address: ShippingAddress = ShippingAddress(),
    var tax_percent: Int = 0,
    var upstream_id: String = "",
    var email: String = "",
    var metadata: MetadataX = MetadataX()
)