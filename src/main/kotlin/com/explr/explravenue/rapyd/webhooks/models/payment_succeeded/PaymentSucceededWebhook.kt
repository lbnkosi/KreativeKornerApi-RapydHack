package com.explr.explravenue.rapyd.webhooks.models.payment_succeeded

data class PaymentSucceededWebhook(
    var id: String = "",
    var type: String = "",
    var `data`: Data = Data(),
    var trigger_operation_id: String = "",
    var status: String = "",
    var created_at: Int = 0
)