package com.explr.explravenue.rapyd.collect.customer.controller

import com.explr.explravenue.rapyd.collect.customer.create_customer.request.CreateCustomerRequest
import com.explr.explravenue.rapyd.collect.customer.create_customer.response.CreateCustomerResponse
import com.explr.explravenue.rapyd.collect.customer.get_customer.response.GetCustomerResponse
import com.explr.explravenue.rapyd.util.Constants.BASE_URL
import com.explr.explravenue.rapyd.util.Constants.GET_METHOD
import com.explr.explravenue.rapyd.util.Constants.POST_METHOD
import com.explr.explravenue.rapyd.util.HeaderGenerator.generateRapydApiHeaders
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import java.lang.reflect.Type

@RestController
@RequestMapping("/rapyd/api/customer")
object CustomerController {

    private const val CHECKOUT_PATH = "/v1/checkout"

    private const val CUSTOMERS_CARD_PATH = "/v1/customers"

    @PostMapping(value = ["/createcustomer"])
    fun createCustomer(@RequestBody request: CreateCustomerRequest): CreateCustomerResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), generateRapydApiHeaders(POST_METHOD, CUSTOMERS_CARD_PATH, request))
        val response = restTemplate.exchange(BASE_URL + CUSTOMERS_CARD_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<CreateCustomerResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @GetMapping(value = ["/getcustomer"])
    fun getCustomer(@RequestParam(name = "customerId") customerId: String?): GetCustomerResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(null, generateRapydApiHeaders(GET_METHOD, "${CUSTOMERS_CARD_PATH}/$customerId", null))
        val response = restTemplate.exchange("$BASE_URL${CUSTOMERS_CARD_PATH}/$customerId", HttpMethod.GET, entity, String::class.java)
        val type: Type = object : TypeToken<GetCustomerResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

}