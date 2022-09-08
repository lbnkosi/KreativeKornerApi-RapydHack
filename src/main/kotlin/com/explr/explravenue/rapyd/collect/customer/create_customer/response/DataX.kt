package com.explr.explravenue.rapyd.collect.customer.create_customer.response

data class DataX(
    var id: String = "",
    var type: String = "",
    var category: String = "",
    var metadata: Any = Any(),
    var image: String = "",
    var webhook_url: String = "",
    var supporting_documentation: String = "",
    var next_action: String = "",
    var name: Any = Any(),
    var last4: String = "",
    var acs_check: String = "",
    var cvv_check: String = "",
    var bin_details: BinDetails = BinDetails(),
    var expiration_year: String = "",
    var expiration_month: String = "",
    var fingerprint_token: String = "",
    var redirect_url: String = ""
)