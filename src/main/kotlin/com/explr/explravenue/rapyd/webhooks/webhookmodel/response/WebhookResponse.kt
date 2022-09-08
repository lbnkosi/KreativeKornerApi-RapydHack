package com.explr.explravenue.rapyd.webhooks.webhookmodel.response

data class WebhookResponse(
    var id: String = "",
    var type: String = "",
    var `data`: Any = Any(),
    var trigger_operation_id: String = "",
    var status: String = "",
    var created_at: Int = 0
)