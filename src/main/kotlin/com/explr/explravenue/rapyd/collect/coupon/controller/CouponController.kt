package com.explr.explravenue.rapyd.collect.coupon.controller

import com.explr.explravenue.rapyd.collect.coupon.create_coupon.request.CreateCouponRequest
import com.explr.explravenue.rapyd.collect.coupon.create_coupon.response.CreateCouponResponse
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
@RequestMapping("/rapyd/api/collect/coupon")
object CouponController {

    private const val COUPON_PATH = "/v1/coupons"

    @PostMapping(value = ["/createcoupon"])
    fun createCoupon(@RequestBody request: CreateCouponRequest): CreateCouponResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.POST_METHOD, COUPON_PATH, request))
        val response = restTemplate.exchange(Constants.BASE_URL + COUPON_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<CreateCouponResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

}