package com.explr.explravenue.rapyd.collect.payment.bank_transfer.response

data class PaymentMethodData(
    var id: String = "",
    var type: String = "",
    var category: String = "",
    var metadata: Metadata = Metadata(),
    var image: String = "",
    var webhook_url: String = "",
    var supporting_documentation: String = "",
    var next_action: String = "",
    var bic_swift: String = "",
    var account_last4: String = ""
)