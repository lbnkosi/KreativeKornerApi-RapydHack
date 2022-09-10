package com.explr.explravenue.rapyd.issuing.van.request

data class IssueVanRequest(
    var currency: String = "",
    var country: String = "",
    var description: String = "",
    var ewallet: String? = "",
    var merchant_reference_id: String = "",
    var metadata: Metadata = Metadata()
)