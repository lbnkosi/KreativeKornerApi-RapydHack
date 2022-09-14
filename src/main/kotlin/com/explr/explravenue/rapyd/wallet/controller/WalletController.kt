package com.explr.explravenue.rapyd.wallet.controller

import com.explr.explravenue.rapyd.util.Constants
import com.explr.explravenue.rapyd.util.HeaderGenerator
import com.explr.explravenue.rapyd.wallet.create_company.request.CreateCompanyWalletRequest
import com.explr.explravenue.rapyd.wallet.create_company.response.CreateCompanyWalletResponse
import com.explr.explravenue.rapyd.wallet.create_personal.request.CreatePersonalWalletRequest
import com.explr.explravenue.rapyd.wallet.create_personal.response.CreatePersonalWalletResponse
import com.explr.explravenue.rapyd.wallet.create_wallet_contact.request.WalletContactRequest
import com.explr.explravenue.rapyd.wallet.create_wallet_contact.response.WalletContactResponse
import com.explr.explravenue.rapyd.wallet.delete_wallet.response.DeleteWalletResponse
import com.explr.explravenue.rapyd.wallet.disable_enable.request.EnableDisableWalletRequest
import com.explr.explravenue.rapyd.wallet.disable_enable.response.EnableDisableWalletResponse
import com.explr.explravenue.rapyd.wallet.get_single_wallet.response.GetSingleWalletResponse
import com.explr.explravenue.rapyd.wallet.transactions.response.GetTransactionsResponse
import com.explr.explravenue.rapyd.wallet.transfer.request.WalletTransferRequest
import com.explr.explravenue.rapyd.wallet.transfer.response.WalletTransferResponse
import com.explr.explravenue.rapyd.wallet.update_copmany_wallet.request.UpdateCompanyWalletRequest
import com.explr.explravenue.rapyd.wallet.update_copmany_wallet.response.UpdateCompanyWalletResponse
import com.explr.explravenue.rapyd.wallet.update_personal_wallet.request.UpdatePersonalWalletRequest
import com.explr.explravenue.rapyd.wallet.update_personal_wallet.response.UpdatePersonalWalletResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import java.lang.reflect.Type

@RequestMapping("/rapyd/api/wallet")
@RestController
object WalletController {

    private const val WALLET_PATH = "/v1/user"
    private const val ENABLE_WALLET_PATH = "/v1/user/enable"
    private const val DISABLE_WALLET_PATH = "/v1/user/disable"
    private const val ACCOUNT_TRANSFER_PATH = "/v1/account/transfer"
    private const val WALLET_CONTACT_PATH = "/v1/ewallets"
    private const val WALLET_TRANSACTIONS = "/v1/user"

    @PostMapping(value = ["/createpersonalwallet"])
    fun createPersonalWallet(@RequestBody wallet: CreatePersonalWalletRequest): CreatePersonalWalletResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(wallet).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.POST_METHOD, WALLET_PATH, wallet))
        val response = restTemplate.exchange(Constants.BASE_URL + WALLET_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<CreatePersonalWalletResponse>() {}.type
        val walletObject: CreatePersonalWalletResponse = Gson().fromJson(response.body, type)
        return Gson().fromJson(response.body, type)
    }

    @PostMapping(value = ["/createcompanywallet"])
    fun createCompanyWallet(@RequestBody wallet: CreateCompanyWalletRequest): CreateCompanyWalletResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(wallet).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.POST_METHOD, WALLET_PATH, wallet))
        val response = restTemplate.exchange(Constants.BASE_URL + WALLET_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<CreateCompanyWalletResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @PutMapping(value = ["/updatepersonalwallet"])
    fun updatePersonalWallet(@RequestBody personalWallet: UpdatePersonalWalletRequest): UpdatePersonalWalletResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(personalWallet).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.PUT_METHOD, WALLET_PATH, personalWallet))
        val response = restTemplate.exchange(Constants.BASE_URL + WALLET_PATH, HttpMethod.PUT, entity, String::class.java)
        val type: Type = object : TypeToken<UpdatePersonalWalletResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @PutMapping(value = ["/updatecompanywallet"])
    fun updateCompanyWallet(@RequestBody wallet: UpdateCompanyWalletRequest): UpdateCompanyWalletResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(wallet).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.PUT_METHOD, WALLET_PATH, wallet))
        val response = restTemplate.exchange(Constants.BASE_URL + WALLET_PATH, HttpMethod.PUT, entity, String::class.java)
        val type: Type = object : TypeToken<UpdateCompanyWalletResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @GetMapping(value = ["/getwallet"])
    fun getWallet(@RequestParam(name = "walletId") walletId: String?): GetSingleWalletResponse? {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(null, HeaderGenerator.generateRapydApiHeaders(Constants.GET_METHOD, "${WALLET_PATH}/$walletId", null))
        val response = restTemplate.exchange("${Constants.BASE_URL}${WALLET_PATH}/$walletId", HttpMethod.GET, entity, String::class.java)
        val type: Type = object : TypeToken<GetSingleWalletResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @GetMapping(value = ["/getwallettransactions"])
    fun getWalletTransactions(@RequestParam(name = "walletId") walletId: String?): GetTransactionsResponse? {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(null, HeaderGenerator.generateRapydApiHeaders(Constants.GET_METHOD, "${WALLET_TRANSACTIONS}/$walletId/transactions", null))
        val response = restTemplate.exchange("${Constants.BASE_URL}${WALLET_TRANSACTIONS}/$walletId/transactions", HttpMethod.GET, entity, String::class.java)
        val type: Type = object : TypeToken<GetTransactionsResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @PostMapping(value = ["/transfer"])
    fun transferFundsBetweenWallet(@RequestBody request: WalletTransferRequest): WalletTransferResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.POST_METHOD, ACCOUNT_TRANSFER_PATH, request))
        val response = restTemplate.exchange(Constants.BASE_URL + ACCOUNT_TRANSFER_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<WalletTransferResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @PutMapping(value = ["/enablewallet"])
    fun enableWallet(@RequestBody wallet: EnableDisableWalletRequest): EnableDisableWalletResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(wallet).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.PUT_METHOD, ENABLE_WALLET_PATH, wallet))
        val response = restTemplate.exchange(Constants.BASE_URL + ENABLE_WALLET_PATH, HttpMethod.PUT, entity, String::class.java)
        val type: Type = object : TypeToken<EnableDisableWalletResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @PutMapping(value = ["/disablewallet"])
    fun disablewallet(@RequestBody wallet: EnableDisableWalletRequest): EnableDisableWalletResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(wallet).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.PUT_METHOD, DISABLE_WALLET_PATH, wallet))
        val response = restTemplate.exchange(Constants.BASE_URL + DISABLE_WALLET_PATH, HttpMethod.PUT, entity, String::class.java)
        val type: Type = object : TypeToken<EnableDisableWalletResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @DeleteMapping(value = ["/deletewallet"])
    fun deleteWallet(@RequestParam(name = "walletId") walletId: String?): DeleteWalletResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(null, HeaderGenerator.generateRapydApiHeaders(Constants.DELETE_METHOD, "${WALLET_PATH}/$walletId", null))
        val response = restTemplate.exchange("${Constants.BASE_URL}${WALLET_PATH}/$walletId", HttpMethod.DELETE, entity, String::class.java)
        val type: Type = object : TypeToken<DeleteWalletResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @PostMapping(value = ["/createwalletcontact"])
    fun createWalletContact(@RequestParam(name = "walletId") walletId: String?, @RequestBody request: WalletContactRequest): WalletContactResponse {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), HeaderGenerator.generateRapydApiHeaders(Constants.POST_METHOD, "${WALLET_CONTACT_PATH}/$walletId/contacts", request))
        val response = restTemplate.exchange("${Constants.BASE_URL}${WALLET_CONTACT_PATH}/$walletId/contacts", HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<WalletContactResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

}