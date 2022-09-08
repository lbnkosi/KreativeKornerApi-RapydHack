package com.explr.explravenue.kreativeapi.user.controller

import com.explr.explravenue.kreativeapi.user.models.CreateUserRequest
import com.explr.explravenue.kreativeapi.user.util.UserUtil
import com.explr.explravenue.firebase.firestore.controller.FirestoreController
import com.explr.explravenue.rapyd.collect.customer.controller.CustomerController
import com.explr.explravenue.rapyd.wallet.controller.WalletController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/explore/api/user")
object UserController {

    private const val USER_TYPE_CUSTOMER = "customer"
    private const val USER_TYPE_BUSINESS = "business"
    private const val USER_TYPE_PARTNER = "partner"

    @PostMapping(value = ["/createuser"])
    fun createUser(@RequestBody request: CreateUserRequest): ResponseEntity<Any> {
        return try {
            val wallet = WalletController.createPersonalWallet(UserUtil.generateWalletRequest(request))
            val customer = CustomerController.createCustomer(UserUtil.generateCustomerRequest(request, wallet))
            FirestoreController.create(request.user_type, UserUtil.generateFirebaseRequest(request, wallet, customer))
            ResponseEntity.ok("Success")
        } catch (e: HttpClientErrorException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }
}