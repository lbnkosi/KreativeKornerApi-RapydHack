package com.explr.explravenue.rapyd.collect.product.create_service_product.request

data class CreateServiceProductRequest(
    var id: String = "",
    var name: String = "",
    var type: String = "",
    var active: Boolean = false,
    var attributes: List<String> = listOf(),
    var description: String = "",
    var images: List<String> = listOf(),
    var metadata: Metadata = Metadata(),
    var package_dimensions: Any = Any(),
    var shippable: Boolean = false,
    var statement_descriptor: String = "",
    var unit_label: String = ""
)