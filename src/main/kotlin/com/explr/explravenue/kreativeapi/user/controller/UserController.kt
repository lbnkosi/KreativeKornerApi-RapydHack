package com.explr.explravenue.kreativeapi.user.controller

import com.explr.explravenue.kreativeapi.user.models.CreateUserRequest
import com.explr.explravenue.kreativeapi.user.util.UserUtil
import com.explr.explravenue.firebase.firestore.controller.FirestoreController
import com.explr.explravenue.kreativeapi.accesspoint.AccessPointRequest
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
    private const val USER_TYPE_BUSINESS = "creator"
    private const val USER_TYPE_PARTNER = "partner"

    @PostMapping(value = ["/createuser"])
    fun createUser(@RequestBody accessPoint: AccessPointRequest): ResponseEntity<Any> {
        val request = configureRequest(accessPoint)
        return try {
            val wallet = WalletController.createCompanyWallet(UserUtil.generateWalletRequest(request))
            val savingsWallet = WalletController.createCompanyWallet(UserUtil.generateWalletRequest(request))
            val customer = CustomerController.createCustomer(UserUtil.generateCustomerRequest(request, wallet))
            FirestoreController.create(request.uid, request.user_type, UserUtil.generateFirebaseRequest(request, wallet, customer))
            ResponseEntity.ok("Success")

            //Create second wallet
            //Add mywallets collection
        } catch (e: HttpClientErrorException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    private fun configureRequest(accessPoint: AccessPointRequest): CreateUserRequest {
        val request = CreateUserRequest()
        request.apply {
            name = accessPoint.name
            surname = accessPoint.surname
            phone = accessPoint.phone
            email = accessPoint.email
            country = accessPoint.country
            user_type = accessPoint.user_type
            points = accessPoint.points
            ref_id = accessPoint.ref_id
            wallet_amount = accessPoint.wallet_amount
            wallet_id = accessPoint.wallet_id
            customer_id = accessPoint.customer_id
            payment_method = accessPoint.payment_method
            uid = accessPoint.email
        }
        return request
    }
}