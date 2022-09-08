package com.explr.explravenue.rapyd.webhooks.controller

import com.explr.explravenue.rapyd.util.EmailServiceImpl
import com.explr.explravenue.rapyd.webhooks.webhookmodel.response.WebhookResponse
import com.google.gson.Gson
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/webhook")
class WebhookController {

    @PostMapping
    fun notification(@RequestBody body: WebhookResponse) {
        EmailServiceImpl().sendSimpleMessage("rapydhack@gmail.com", "Webhook", Gson().toJson(body))
    }

}