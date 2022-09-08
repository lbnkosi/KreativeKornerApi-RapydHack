package com.explr.explravenue.rapyd.wallet.test

import com.explr.explravenue.rapyd.wallet.controller.WalletController
import com.explr.explravenue.rapyd.wallet.create_company.request.CreateCompanyWalletRequest
import com.explr.explravenue.rapyd.wallet.create_personal.request.CreatePersonalWalletRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
@RequestMapping("/api/v1/test/wallet")
class WalletTestController {

    @PostMapping(value = ["/createpersonalwallet"])
    private fun createPersonalWallet(@RequestBody body: CreatePersonalWalletRequest): ResponseEntity<Any> {
        val transfer = WalletController.createPersonalWallet(body)
        return ResponseEntity.ok(transfer)
    }

    @PostMapping(value = ["/createcompanywallet"])
    private fun createCompanyWallet(@RequestBody body: CreateCompanyWalletRequest): ResponseEntity<Any> {
        val transfer = WalletController.createCompanyWallet(body)
        return ResponseEntity.ok(transfer)
    }

}