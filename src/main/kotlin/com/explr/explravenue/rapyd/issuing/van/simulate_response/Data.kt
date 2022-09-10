package com.explr.explravenue.rapyd.issuing.van.simulate_response

data class Data(
    var id: String = "",
    var merchant_reference_id: String = "",
    var ewallet: String = "",
    var bank_account: BankAccount = BankAccount(),
    var metadata: Metadata = Metadata(),
    var status: String = "",
    var description: String = "",
    var funding_instructions: Any = Any(),
    var currency: String = "",
    var transactions: List<Transaction> = listOf()
)