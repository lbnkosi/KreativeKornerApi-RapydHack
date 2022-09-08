package com.explr.explravenue.rapyd.collect.payment.bank_transfer.response

data class CreateBankPaymentResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)