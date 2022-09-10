package com.explr.explravenue.rapyd.issuing.van.controller

import com.explr.explravenue.rapyd.issuing.van.request.IssueVanRequest
import com.explr.explravenue.rapyd.issuing.van.response.IssueVanResponse
import com.explr.explravenue.rapyd.issuing.van.simulate_request.SimulateVanTransferRequest
import com.explr.explravenue.rapyd.issuing.van.simulate_response.SimulateVanTransferResponse
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
@RequestMapping("/rapyd/api/issuing/van")
object VanController {

    private const val ISSUING_PATH = "/v1/issuing/bankaccounts"

    private const val SIMULATE_PATH = "/v1/issuing/bankaccounts/bankaccounttransfertobankaccount"

    @PostMapping(value = ["/issuevan"])
    fun issueVan(@RequestBody request: IssueVanRequest): IssueVanResponse? {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.POST_METHOD, ISSUING_PATH, request))
        val response = restTemplate.exchange(Constants.BASE_URL + ISSUING_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<IssueVanResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @PostMapping(value = ["/simulate"])
    fun simulateTransfer(@RequestBody request: SimulateVanTransferRequest): SimulateVanTransferResponse? {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.POST_METHOD, SIMULATE_PATH, request))
        val response = restTemplate.exchange(Constants.BASE_URL + SIMULATE_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<IssueVanResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

}