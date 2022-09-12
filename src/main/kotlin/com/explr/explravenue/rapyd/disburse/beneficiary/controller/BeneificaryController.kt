package com.explr.explravenue.rapyd.disburse.beneficiary.controller

import com.explr.explravenue.rapyd.disburse.beneficiary.request.CreateBankBeneficiaryRequest
import com.explr.explravenue.rapyd.disburse.beneficiary.response.CreateBankBeneficiaryResponse
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

@RequestMapping("/rapyd/api/beneficiary")
@RestController
object BeneificaryController {

    const val PATH = "/v1/payouts/beneficiary"

    @PostMapping(value = ["/createbenef"])
    fun createBeneficiary(@RequestBody requestBank: CreateBankBeneficiaryRequest): CreateBankBeneficiaryResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(requestBank).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.POST_METHOD, PATH, requestBank))
        val response = restTemplate.exchange(Constants.BASE_URL + PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<CreateBankBeneficiaryResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }
}