package com.explr.explravenue.kreativeapi.payout

import com.explr.explravenue.firebase.firestore.controller.FirestoreController
import com.explr.explravenue.kreativeapi.accesspoint.AccessPointRequest
import com.explr.explravenue.kreativeapi.payout.models.FirebaseSinglePayoutRequest
import com.explr.explravenue.rapyd.disburse.beneficiary.controller.BeneificaryController
import com.explr.explravenue.rapyd.disburse.payout.controller.PayoutController
import com.explr.explravenue.rapyd.disburse.payout.single.request.CreateSinglePayoutRequest
import com.explr.explravenue.rapyd.disburse.payout.single.request.Metadata
import com.explr.explravenue.rapyd.disburse.payout.single.response.CreateSinglePayoutResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/explore/api/createpayout")
object UpStreamPayoutController {

    @PostMapping(value = ["/createbenef"])
    fun createPayout(@RequestBody accessPoint: AccessPointRequest): ResponseEntity<Any> {
        val request = configureRequest(accessPoint)
        return try {
            val payout = PayoutController.createPayout(request)
            val firebasePayout = configureFirebaseRequest(accessPoint, payout)
            FirestoreController.create(accessPoint.user_type, accessPoint.email, "singlepayouts", firebasePayout)
            ResponseEntity.ok("Success")
        } catch (e: HttpClientErrorException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    fun configureRequest(accessPoint: AccessPointRequest): CreateSinglePayoutRequest {
        val request = CreateSinglePayoutRequest()
        request.beneficiary = accessPoint.beneficiary_id
        request.beneficiary_country = accessPoint.beneficiary_country
        request.beneficiary_entity_type = "individual"
        request.description = accessPoint.description
        request.merchant_reference_id = (System.currentTimeMillis() / 1000L).toString()
        request.ewallet = "ewallet_d19c17400fbbf7980a9b7a898c0f582b"
        request.payout_amount = accessPoint.amount
        request.payout_currency = accessPoint.payout_currency
        request.payout_method_type = "us_general_bank"
        request.sender = "sender_0393190c75bf0d3de9309d3576e0daa3"
        request.sender_country = "US"
        request.sender_currency = "USD"
        request.sender_entity_type = "individual"
        request.statement_descriptor = "KREATIVEKORNER:" + (System.currentTimeMillis() / 1000L).toString()
        request.metadata = Metadata(merchant_defined = true)
        return request
    }

    private fun configureFirebaseRequest(accessPoint: AccessPointRequest, payoutResponse: CreateSinglePayoutResponse): FirebaseSinglePayoutRequest {
        val request = FirebaseSinglePayoutRequest()
        val response = payoutResponse.data
        request.id = response.id
        request.amount = response.amount.toString()
        request.currency = response.payout_currency
        request.payout_currency = response.payout_currency
        request.sender_amount = response.sender_amount.toString()
        request.sender_currency = response.sender_currency
        request.sender_country = response.sender_country
        request.sender = response.sender.name + " " + response.sender.last_name
        request.sender_id = response.sender.id
        request.beneficiary_country = response.beneficiary_country
        request.beneficiary_id = response.beneficiary.id
        request.beneficiary = response.beneficiary.name + " " + response.beneficiary.last_name
        request.instrucitons = response.instructions[0].steps[0].step1
        request.ewallet = response.ewallets[0].ewallet_id
        request.description = response.description
        request.statement_descriptor = response.statement_descriptor
        return request
    }

}