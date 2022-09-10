package com.explr.explravenue.rapyd.issuing.van.simulate_response

data class BankAccount(
    var beneficiary_name: String = "",
    var address: String = "",
    var country_iso: String = "",
    var country: String = "",
    var aba_routing_number: String = "",
    var account_number: String = ""
)