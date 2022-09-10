package com.explr.explravenue.rapyd.issuing.van.response

data class IssueVanResponse(
    var status: Status = Status(),
    var `data`: Data = Data()
)