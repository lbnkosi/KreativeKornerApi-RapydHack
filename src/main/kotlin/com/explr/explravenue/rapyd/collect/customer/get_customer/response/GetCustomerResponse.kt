package com.explr.explravenue.rapyd.collect.customer.get_customer.response

data class GetCustomerResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)