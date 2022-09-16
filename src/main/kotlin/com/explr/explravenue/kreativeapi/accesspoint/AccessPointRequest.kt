package com.explr.explravenue.kreativeapi.accesspoint

data class AccessPointRequest (

    var route: String = "",
    var amount: String = "",

    var currency: String = "",
    var customer: String = "",
    var description: String = "",

    var name: String = "",
    var surname: String = "",
    var phone: String = "",
    var email: String = "",
    var country: String = "",
    var user_type: String = "",
    var points: String? = "0",
    var ref_id: String? = "",
    var wallet_amount: String? = "0",
    var wallet_id: String? = "",
    var customer_id: String? = "",
    var payment_method: String? = "",
    var uid: String? = "",

    var capture: Boolean? = true,
    var type: String? = "",
    var card_number: String? = "",
    var expiration_month: String? = "",
    var expiration_year: String? = "",
    var card_holder: String? = "",
    var cvv: String? = "",

    var identification_value: String? = "",
    var account_number: String? = "",
    var beneficiary_id: String? = "",
    var beneficiary_country: String? = "",
    var payout_currency: String? = "",

    var plan_id: String? = "",

    var months: String? = "",
    var interest: String? = "",
    var total_repayment: String? = "",
    var product_id: String? = "",

    var ipi_id: String? = "",
    var max_payout: String? = "",
    var monthly_payment: String? = "",
    var interval: String? = "",

    var has_payout: Boolean = false,
    var payout_id: String? = "",
    var sender_id: String? = "",
    var collect_card_number: String? = "",
    var collect_card_id: String? = "",

    var currently_viewing: String? = "",

)