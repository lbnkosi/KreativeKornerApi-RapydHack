package com.explr.explravenue.rapyd.issuing.controller

import com.explr.explravenue.rapyd.issuing.card.activate_card.request.ActivateCardRequest
import com.explr.explravenue.rapyd.issuing.card.activate_card.response.ActivateCardResponse
import com.explr.explravenue.rapyd.issuing.card.card_pin.request.SetCardPinRequest
import com.explr.explravenue.rapyd.issuing.card.card_pin.response.SetCardPinResponse
import com.explr.explravenue.rapyd.issuing.card.card_status.request.UpdateCardStatusRequest
import com.explr.explravenue.rapyd.issuing.card.card_status.response.UpdateCardStatusResponse
import com.explr.explravenue.rapyd.issuing.card.create_card.request.CreateCardRequest
import com.explr.explravenue.rapyd.issuing.card.create_card.response.CreateCardResponse
import com.explr.explravenue.rapyd.issuing.card.get_cards.response.GetAllCardsResponse
import com.explr.explravenue.rapyd.issuing.card.get_single_card.response.GetSingleCardResponse
import com.explr.explravenue.rapyd.util.Constants
import com.explr.explravenue.rapyd.util.Constants.BASE_URL
import com.explr.explravenue.rapyd.util.Constants.POST_METHOD
import com.explr.explravenue.rapyd.util.HeaderGenerator
import com.explr.explravenue.rapyd.util.HeaderGenerator.generateRapydApiHeaders
import com.explr.explravenue.rapyd.wallet.controller.WalletController
import com.explr.explravenue.rapyd.wallet.get_single_wallet.response.GetSingleWalletResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import java.lang.reflect.Type

@RestController
@RequestMapping("/rapyd/api/issuing")
object IssuingController {

    private const val ISSUING_PATH = "/v1/issuing/cards"
    private const val ACTIVATE_CARD_PATH = "/v1/issuing/cards/activate"
    private const val UPDATE_CARD_STATUS_PATH = "/v1/issuing/cards/status"
    private const val SET_CARD_PIN_PATH = "/v1/issuing/cards/pin"
    private const val GET_CARD_PATH = "/v1/issuing/cards"

    @PostMapping(value = ["/createcard"])
    fun createCard(@RequestBody request: CreateCardRequest): CreateCardResponse? {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), generateRapydApiHeaders(POST_METHOD, ISSUING_PATH, request))
        val response = restTemplate.exchange(BASE_URL + ISSUING_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<CreateCardResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @PostMapping(value = ["/activatecard"])
    fun activateCard(@RequestBody request: ActivateCardRequest): ActivateCardResponse? {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), generateRapydApiHeaders(POST_METHOD, ACTIVATE_CARD_PATH, request))
        val response = restTemplate.exchange(BASE_URL + ACTIVATE_CARD_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<ActivateCardResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @PostMapping(value = ["/updatecardstatus"])
    fun updateCardStatus(@RequestBody request: UpdateCardStatusRequest): UpdateCardStatusResponse? {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), generateRapydApiHeaders(POST_METHOD, UPDATE_CARD_STATUS_PATH, request))
        val response = restTemplate.exchange(BASE_URL + UPDATE_CARD_STATUS_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<UpdateCardStatusResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @PostMapping(value = ["/setcardpin"])
    fun setCardPin(@RequestBody request: SetCardPinRequest): SetCardPinResponse? {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(Gson().toJson(request).replace(" ", ""), generateRapydApiHeaders(POST_METHOD, SET_CARD_PIN_PATH, request))
        val response = restTemplate.exchange(BASE_URL + SET_CARD_PIN_PATH, HttpMethod.POST, entity, String::class.java)
        val type: Type = object : TypeToken<SetCardPinResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @GetMapping(value = ["/getcard"])
    fun getSingleCard(@RequestParam(name = "cardId") cardId: String?): GetSingleCardResponse? {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(null, generateRapydApiHeaders(Constants.GET_METHOD, "${GET_CARD_PATH}/$cardId", null))
        val response = restTemplate.exchange("$BASE_URL${GET_CARD_PATH}/$cardId", HttpMethod.GET, entity, String::class.java)
        val type: Type = object : TypeToken<GetSingleCardResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

    @GetMapping(value = ["/getallcards"])
    fun getAllCards(): GetAllCardsResponse? {
        val restTemplate = RestTemplate()
        val entity = HttpEntity(null, generateRapydApiHeaders(Constants.GET_METHOD, GET_CARD_PATH, null))
        val response = restTemplate.exchange("$BASE_URL${GET_CARD_PATH}", HttpMethod.GET, entity, String::class.java)
        val type: Type = object : TypeToken<GetAllCardsResponse>() {}.type
        return Gson().fromJson(response.body, type)
    }

}