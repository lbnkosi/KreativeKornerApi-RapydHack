package com.explr.explravenue.rapyd.collect.checkout.request

data class CreateCheckoutRequest(
    var amount: Double = 0.0,
    var complete_payment_url: String = "",
    var country: String = "",
    var currency: String = "",
    var ewallet: String = "",
    var customer: String = "",
    var error_payment_url: String = "",
    var merchant_reference_id: String = "",
    var cardholder_preferred_currency: Boolean = false,
    var language: String = "",
    var metadata: Metadata = Metadata(),
    var payment_method_types_include: List<String> = listOf(),
    var expiration: Int = 0,
    var payment_method_types_exclude: List<Any> = listOf()
)