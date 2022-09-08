package com.explr.explravenue.rapyd.collect.checkout.response

data class CustomElements(
    var save_card_default: Boolean = false,
    var display_description: Boolean = false,
    var payment_fees_display: Boolean = false,
    var merchant_currency_only: Boolean = false,
    var billing_address_collect: Boolean = false,
    var dynamic_currency_conversion: Boolean = false
)