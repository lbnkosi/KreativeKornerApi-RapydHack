package com.explr.explravenue.rapyd.collect.payment.card.response

data class PaymentMethodData(
    var id: String = "",
    var type: String = "",
    var category: String = "",
    var metadata: Metadata = Metadata(),
    var image: String = "",
    var webhook_url: String = "",
    var supporting_documentation: String = "",
    var next_action: String = "",
    var name: String = "",
    var last4: String = "",
    var acs_check: String = "",
    var cvv_check: String = "",
    var bin_details: BinDetails = BinDetails(),
    var expiration_year: String = "",
    var expiration_month: String = "",
    var fingerprint_token: String = ""
)