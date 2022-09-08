package com.explr.explravenue.kreativeapi.loans.controller

import com.explr.explravenue.kreativeapi.loans.models.CreateCustomerLoanRequest
import com.explr.explravenue.kreativeapi.loans.util.LoanUtil
import com.explr.explravenue.firebase.firestore.controller.FirestoreController
import com.explr.explravenue.rapyd.collect.subscription.controller.SubscriptionController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/explore/api/loan")
object LoanController {

    @PostMapping(value = ["/createcustomerloan"])
    fun createCustomerLoan(@RequestBody request: CreateCustomerLoanRequest): ResponseEntity<Any> {
        return if (request.uid.isNotEmpty()) {
            val loanSubscription = SubscriptionController.createSubscription(LoanUtil.generateSubscriptionRequest(request))
            request.subscription_id = loanSubscription.data.id
            FirestoreController.create("customers", request.uid, "loans", request)
            ResponseEntity.ok("Loan created")
        } else {
            ResponseEntity.badRequest().body("No UID specified")
        }
    }

}