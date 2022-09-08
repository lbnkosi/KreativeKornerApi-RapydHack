package com.explr.explravenue.rapyd.collect.subscription.controller

import com.explr.explravenue.rapyd.collect.customer.controller.CustomerController
import com.explr.explravenue.rapyd.collect.subscription.create_subscription.request.CreateSubscriptionRequest
import com.explr.explravenue.rapyd.collect.subscription.create_subscription.response.CreateSubscriptionResponse
import com.explr.explravenue.rapyd.util.Constants
import com.explr.explravenue.rapyd.util.HeaderGenerator
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.lang.reflect.Type

@RestController
@RequestMapping("/rapyd/api/subscription")
object SubscriptionController {

    private const val SUBSCRIPTIONS_PATH = "/v1/payments/subscriptions"

    @PostMapping(value = ["/createsubscription"])
    fun createSubscription(@RequestBody request: CreateSubscriptionRequest): CreateSubscriptionResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.POST_METHOD, SUBSCRIPTIONS_PATH, request))
        val response = restTemplate.exchange(Constants.BASE_URL + SUBSCRIPTIONS_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<CreateSubscriptionResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

}