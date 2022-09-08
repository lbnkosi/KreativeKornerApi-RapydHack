package com.explr.explravenue.kreativeapi.loans.models

data class CreateCustomerLoanRequest(
    var uid: String = "",
    var customer_id: String = "",
    var payment_method: String = "",
    var plan_id: String = "",
    var subscription_id: String = "",
    var interest: String = "",
    var load_id: String = "",
    var payment_type: String = "",
    var repayment_amount: String = "",
    var status: String = "",
    var term: String = ""
)
