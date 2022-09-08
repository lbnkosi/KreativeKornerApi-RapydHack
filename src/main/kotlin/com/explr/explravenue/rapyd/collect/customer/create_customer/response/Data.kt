package com.explr.explravenue.rapyd.collect.customer.create_customer.response

data class Data(
    var id: String = "",
    var delinquent: Boolean = false,
    var discount: Any = Any(),
    var name: String = "",
    var default_payment_method: String = "",
    var description: String = "",
    var email: String = "",
    var phone_number: String = "",
    var invoice_prefix: String = "",
    var addresses: List<Any> = listOf(),
    var payment_methods: PaymentMethods = PaymentMethods(),
    var subscriptions: Any = Any(),
    var created_at: Int = 0,
    var metadata: Metadata = Metadata(),
    var business_vat_id: String = "",
    var ewallet: String = ""
)