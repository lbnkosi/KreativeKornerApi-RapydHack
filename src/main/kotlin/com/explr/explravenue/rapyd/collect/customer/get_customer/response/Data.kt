package com.explr.explravenue.rapyd.collect.customer.get_customer.response

data class Data(
    var id: String = "",
    var delinquent: Boolean = false,
    var name: String = "",
    var default_payment_method: String = "",
    var description: String = "",
    var email: String = "",
    var phone_number: String = "",
    var invoice_prefix: String = "",
    var payment_methods: PaymentMethods = PaymentMethods(),
    var subscriptions: Any = Any(),
    var created_at: Int = 0,
    var metadata: MetadataX = MetadataX(),
    var business_vat_id: String = "",
    var ewallet: String = ""
)