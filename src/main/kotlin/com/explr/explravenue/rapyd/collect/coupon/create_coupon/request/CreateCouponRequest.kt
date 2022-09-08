package com.explr.explravenue.rapyd.collect.coupon.create_coupon.request

data class CreateCouponRequest(
    var amount_off: Int = 0,
    var currency: String = "",
    var duration: String = "",
    var duration_in_months: Int = 0,
    var id: String = "",
    var max_redemptions: Int = 0,
    var metadata: Metadata = Metadata(),
    var percent_off: Int = 0,
    var redeem_by: Int = 0
)