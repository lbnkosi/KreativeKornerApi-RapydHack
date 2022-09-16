package com.explr.explravenue.rapyd.webhooks.models.payment_succeeded

data class PaymentMethodData(
    var id: String = "",
    var name: String = "",
    var type: String = "",
    var image: String = "",
    var last4: String = "",
    var category: String = "",
    //var metadata: MetadataX = MetadataX(),
    var acs_check: String = "",
    var cvv_check: String = "",
    var bin_details: BinDetails = BinDetails(),
    var next_action: String = "",
    var webhook_url: String = "",
    var expiration_year: String = "",
    var expiration_month: String = "",
    var fingerprint_token: String = "",
    var supporting_documentation: String = ""
)