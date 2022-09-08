package com.explr.explravenue.rapyd.collect.order.update_order.response

data class UpdateOrderResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)