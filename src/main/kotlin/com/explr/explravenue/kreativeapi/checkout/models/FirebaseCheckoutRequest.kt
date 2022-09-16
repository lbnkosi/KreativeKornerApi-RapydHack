package com.explr.explravenue.kreativeapi.checkout.models


data class FirebaseCheckoutRequest(
    var checkout_id: String? = "",
    var checkout_url: String? = "",
    var local_checkout_url: String? = "",
    var price: String? = "",
    var product_id: String? = "",
    var collection: String? = "",
    var checkout_type: String? = "",
    var reference: String? = "",
    var merchant_reference_id: String? = "",
    var paid: Boolean? = false,
    var customer_id: String? = "",
    var user_type: String? = "",
    var email: String? = ""
)