package com.explr.explravenue.rapyd.collect.plan.create_plan.response

data class CreatePlanResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)