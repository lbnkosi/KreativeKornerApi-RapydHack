package com.explr.explravenue.rapyd.collect.payment.bank_transfer.request

data class CreateBankPaymentRequest(
    var amount: Int = 0,
    var currency: String = "",
    var customer: String = "",
    var payment_method: PaymentMethod = PaymentMethod(),
    var description: String = "",
    var statement_descriptor: String = "",
    var metadata: Metadata = Metadata()
)