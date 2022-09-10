package com.explr.explravenue.kreativeapi.van.controller

import com.explr.explravenue.firebase.firestore.controller.FirestoreController
import com.explr.explravenue.kreativeapi.accesspoint.AccessPointRequest
import com.explr.explravenue.kreativeapi.user.controller.UserController
import com.explr.explravenue.kreativeapi.user.util.UserUtil
import com.explr.explravenue.kreativeapi.van.model.FirebaseVan
import com.explr.explravenue.rapyd.collect.customer.controller.CustomerController
import com.explr.explravenue.rapyd.issuing.van.controller.VanController
import com.explr.explravenue.rapyd.issuing.van.request.IssueVanRequest
import com.explr.explravenue.rapyd.issuing.van.request.Metadata
import com.explr.explravenue.rapyd.issuing.van.response.IssueVanResponse
import com.explr.explravenue.rapyd.wallet.controller.WalletController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/explore/api/van")
object UpStreamVanController {

    @PostMapping(value = ["/issuevan"])
    fun issueVan(@RequestBody accessPoint: AccessPointRequest): ResponseEntity<Any> {
        val request = configureRequest(accessPoint)
        return try {
            val van = VanController.issueVan(request)
            val firebaseVan = configureFirebaseRequest(van)
            FirestoreController.create(accessPoint.user_type, accessPoint.email, "vans", firebaseVan)
            ResponseEntity.ok("Success")
        } catch (e: HttpClientErrorException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    private fun configureRequest(accessPoint: AccessPointRequest): IssueVanRequest {
        val request = IssueVanRequest()
        request.currency = accessPoint.currency
        request.country = accessPoint.country
        request.description = accessPoint.description
        request.ewallet = accessPoint.wallet_id
        request.merchant_reference_id = (System.currentTimeMillis() / 1000L).toString()
        request.metadata = Metadata(merchant_defined = true)
        return request
    }

    private fun configureFirebaseRequest(response: IssueVanResponse?): FirebaseVan {
        val request = FirebaseVan()
        val responseData = response?.data
        request.id = responseData?.id
        request.merchant_reference_id = responseData?.merchant_reference_id
        request.ewallet = responseData?.ewallet
        request.beneficiary_name = responseData?.bank_account?.beneficiary_name
        request.address = responseData?.bank_account?.address
        request.country_iso = responseData?.bank_account?.country_iso
        request.iban = responseData?.bank_account?.iban
        request.sort_code = responseData?.bank_account?.sort_code
        request.account_no = responseData?.bank_account?.account_no
        request.bic = responseData?.bank_account?.bic
        request.aba_routing_number = responseData?.bank_account?.aba_routing_number
        request.account_number = responseData?.bank_account?.account_number
        request.status = responseData?.status
        request.description = responseData?.description
        request.funding_instructions = responseData?.funding_instructions?.toString()
        request.currency = responseData?.currency
        return request
    }

}