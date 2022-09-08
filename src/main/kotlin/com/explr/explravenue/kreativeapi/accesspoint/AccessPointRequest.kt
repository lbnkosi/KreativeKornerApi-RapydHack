package com.explr.explravenue.kreativeapi.accesspoint

data class AccessPointRequest (

    var route: String = "",
    var amount: String = "",

    var currency: String = "",
    var customer: String = "",
    var payment_method: String = "",
    var description: String = "",

)