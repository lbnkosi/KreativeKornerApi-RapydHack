package com.explr.explravenue.rapyd.collect.payment.controller

import com.explr.explravenue.rapyd.collect.payment.bank_transfer.request.CreateBankPaymentRequest
import com.explr.explravenue.rapyd.collect.payment.bank_transfer.response.CreateBankPaymentResponse
import com.explr.explravenue.rapyd.collect.payment.card.request.CreateCardPaymentRequest
import com.explr.explravenue.rapyd.collect.payment.card.response.CreateCardPaymentResponse
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

@RequestMapping("/rapyd/api/payment")
@RestController
object PaymentsController {

    private const val PAYMENT_PATH = "/v1/payments"

    @PostMapping(value = ["/card"])
    fun createCardPayment(@RequestBody request: CreateCardPaymentRequest): CreateCardPaymentResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.POST_METHOD, PAYMENT_PATH, request))
        val response = restTemplate.exchange(Constants.BASE_URL + PAYMENT_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<CreateCardPaymentResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @PostMapping(value = ["/bank"])
    fun createBankPayment(@RequestBody request: CreateBankPaymentRequest): CreateBankPaymentResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.POST_METHOD, PAYMENT_PATH, request))
        val response = restTemplate.exchange(Constants.BASE_URL + PAYMENT_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<CreateBankPaymentResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

}