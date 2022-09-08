package com.explr.explravenue.rapyd.collect.customer.create_customer.response

data class CreateCustomerResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)