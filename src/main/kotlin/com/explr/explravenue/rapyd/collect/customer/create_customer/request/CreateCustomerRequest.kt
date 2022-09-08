package com.explr.explravenue.rapyd.collect.customer.create_customer.request

data class CreateCustomerRequest(
    var name: String = "",
    var business_vat_id: String = "",
    var email: String = "",
    var ewallet: String = "",
    var invoice_prefix: String = "",
    var metadata: Metadata = Metadata(),
    var payment_method: PaymentMethod = PaymentMethod(),
    var phone_number: String = ""
)