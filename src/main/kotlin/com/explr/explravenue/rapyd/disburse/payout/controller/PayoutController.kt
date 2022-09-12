package com.explr.explravenue.rapyd.disburse.payout.controller

import com.explr.explravenue.rapyd.disburse.payout.single.request.CreateSinglePayoutRequest
import com.explr.explravenue.rapyd.disburse.payout.single.response.CreateSinglePayoutResponse
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

@RequestMapping("/rapyd/api/payout")
@RestController
object PayoutController {

    const val PATH = "/v1/payouts"

    @PostMapping(value = ["/createpayout"])
    fun createPayout(@RequestBody request: CreateSinglePayoutRequest): CreateSinglePayoutResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.POST_METHOD, PATH, request))
        val response = restTemplate.exchange(Constants.BASE_URL + PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<CreateSinglePayoutResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

}