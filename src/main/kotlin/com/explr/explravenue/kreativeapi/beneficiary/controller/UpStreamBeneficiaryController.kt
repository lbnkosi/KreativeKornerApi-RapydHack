package com.explr.explravenue.kreativeapi.beneficiary.controller

import com.explr.explravenue.firebase.firestore.controller.FirestoreController
import com.explr.explravenue.kreativeapi.accesspoint.AccessPointRequest
import com.explr.explravenue.kreativeapi.beneficiary.model.FirebaseBeneficiaryRequest
import com.explr.explravenue.rapyd.disburse.beneficiary.controller.BeneificaryController
import com.explr.explravenue.rapyd.disburse.beneficiary.request.CreateBankBeneficiaryRequest
import com.explr.explravenue.rapyd.disburse.beneficiary.response.CreateBankBeneficiaryResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/explore/api/createbenef")
object UpStreamBeneficiaryController {

    @PostMapping(value = ["/createbenef"])
    fun createBeneficiary(@RequestBody accessPoint: AccessPointRequest): ResponseEntity<Any> {
        val request = configureRequest(accessPoint)
        return try {
            val beneficiary = BeneificaryController.createBeneficiary(request)
            val firebaseBenef = configureFirebaseRequest(accessPoint, beneficiary)
            FirestoreController.create(accessPoint.user_type, accessPoint.email, "beneficiaries", firebaseBenef)
            ResponseEntity.ok("Success")
        } catch (e: HttpClientErrorException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    private fun configureRequest(accessPoint: AccessPointRequest): CreateBankBeneficiaryRequest {
        val request = CreateBankBeneficiaryRequest()
        request.category = "bank"
        request.default_payout_method_type = "us_wires_bank"
        request.country = accessPoint.country
        request.currency = accessPoint.currency
        request.entity_type = "individual"
        request.first_name = accessPoint.name
        request.last_name = accessPoint.surname
        request.identification_type = "work_permit"
        request.identification_value = accessPoint.identification_value
        request.payment_type = "regular"
        request.address = "123 Main Street"
        request.city = "NY"
        request.postcode = "12345"
        request.account_number = accessPoint.account_number
        request.merchant_reference_id = (System.currentTimeMillis() / 1000L).toString()
        request.company_name = accessPoint.name + accessPoint.surname
        request.bic_swift = "ABCDEFG"
        request.bank_account_type = "CACC"
        request.state = "NY"
        request.aba = "573675777"
        return request
    }

    fun configureFirebaseRequest(accessPoint: AccessPointRequest, response: CreateBankBeneficiaryResponse): FirebaseBeneficiaryRequest {
        val request = FirebaseBeneficiaryRequest()
        request.id = response.data.id
        request.name = accessPoint.name
        request.surname = accessPoint.surname
        request.country = accessPoint.country
        request.currency = accessPoint.currency
        request.account_number = accessPoint.account_number
        return request
    }

}