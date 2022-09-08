package com.explr.explravenue.rapyd.collect.order.create_order.response

data class CreateOrderResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)