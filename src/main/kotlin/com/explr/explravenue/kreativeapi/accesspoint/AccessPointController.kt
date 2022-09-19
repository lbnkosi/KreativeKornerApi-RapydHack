package com.explr.explravenue.kreativeapi.accesspoint

import com.explr.explravenue.kreativeapi.accesspoint.Routes.ADD_CARD
import com.explr.explravenue.kreativeapi.accesspoint.Routes.CREATE_ADVANCE
import com.explr.explravenue.kreativeapi.accesspoint.Routes.CREATE_BENEF
import com.explr.explravenue.kreativeapi.accesspoint.Routes.CREATE_CHECKOUT
import com.explr.explravenue.kreativeapi.accesspoint.Routes.CREATE_HEALTHCARE
import com.explr.explravenue.kreativeapi.accesspoint.Routes.CREATE_INCOME_INSURANCE
import com.explr.explravenue.kreativeapi.accesspoint.Routes.CREATE_LOAN
import com.explr.explravenue.kreativeapi.accesspoint.Routes.CREATE_PAYOUT
import com.explr.explravenue.kreativeapi.accesspoint.Routes.CREATE_USER
import com.explr.explravenue.kreativeapi.accesspoint.Routes.CREATE_VAN
import com.explr.explravenue.kreativeapi.accesspoint.Routes.UPDATE_CHAT
import com.explr.explravenue.kreativeapi.addcard.controller.UpStreamCardController
import com.explr.explravenue.kreativeapi.beneficiary.controller.UpStreamBeneficiaryController
import com.explr.explravenue.kreativeapi.cashadvance.controller.CashAdvanceController
import com.explr.explravenue.kreativeapi.chat.controller.FirebaseChatController
import com.explr.explravenue.kreativeapi.checkout.controller.UpStreamCheckoutController
import com.explr.explravenue.kreativeapi.healthcare.controller.HealthCareController
import com.explr.explravenue.kreativeapi.insurance.controller.IncomeProtectionController
import com.explr.explravenue.kreativeapi.loans.controller.LoanController
import com.explr.explravenue.kreativeapi.payout.UpStreamPayoutController
import com.explr.explravenue.kreativeapi.user.controller.UserController
import com.explr.explravenue.kreativeapi.van.controller.UpStreamVanController
import com.google.gson.Gson
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

//@CrossOrigin(origins = ["https://kreativekorner.flutterflow.app", "https://explravenue.com/kreative/api/accesspoint/post", "https://explravenue.com"], maxAge = 3600)
@RestController
@RequestMapping("/kreative/api/accesspoint")
object AccessPointController {

    @PostMapping(value = ["/post"])
    fun acceptAccessPoint(@RequestBody request: AccessPointRequest): ResponseEntity<Any> {
        val response = route(request)
        val debug = Gson().toJson(response)
        println("DEBUG_PRINT - $debug")
        return ResponseEntity.ok(response)
    }

    private fun route(request: AccessPointRequest): Any {
        return when (request.route) {
            CREATE_USER -> UserController.createUser(request)
            CREATE_VAN -> UpStreamVanController.issueVan(request)
            ADD_CARD -> UpStreamCardController.addCard(request)
            CREATE_BENEF -> UpStreamBeneficiaryController.createBeneficiary(request)
            CREATE_PAYOUT -> UpStreamPayoutController.createPayout(request)
            CREATE_ADVANCE -> CashAdvanceController.createAdvance(request)
            CREATE_LOAN -> LoanController.createCustomerLoan(request)
            CREATE_INCOME_INSURANCE -> IncomeProtectionController.createIncomeProtection(request)
            UPDATE_CHAT -> FirebaseChatController.updateChat(request)
            CREATE_CHECKOUT -> UpStreamCheckoutController.createCheckout(request)
            CREATE_HEALTHCARE -> HealthCareController.createHealthCare(request)
            else -> "Unknown action"
        }
    }
}