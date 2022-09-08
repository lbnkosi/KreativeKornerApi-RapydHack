package com.explr.explravenue.rapyd.collect.customer.controller

import com.explr.explravenue.rapyd.collect.checkout.request.CreateCheckoutRequest
import com.explr.explravenue.rapyd.collect.checkout.response.CreateCheckoutResponse
import com.explr.explravenue.rapyd.collect.customer.create_customer.request.CreateCustomerRequest
import com.explr.explravenue.rapyd.collect.customer.create_customer.response.CreateCustomerResponse
import com.explr.explravenue.rapyd.util.Constants.BASE_URL
import com.explr.explravenue.rapyd.util.Constants.POST_METHOD
import com.explr.explravenue.rapyd.util.HeaderGenerator.generateRapydApiHeaders
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

}