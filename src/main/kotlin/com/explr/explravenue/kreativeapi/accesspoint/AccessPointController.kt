package com.explr.explravenue.kreativeapi.accesspoint

import com.explr.explravenue.kreativeapi.accesspoint.Routes.ADD_CARD
import com.explr.explravenue.kreativeapi.accesspoint.Routes.CREATE_USER
import com.explr.explravenue.kreativeapi.accesspoint.Routes.CREATE_VAN
import com.explr.explravenue.kreativeapi.addcard.controller.UpStreamCardController
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
        //val responseHeaders = HttpHeaders()
        //responseHeaders["Access-Control-Allow-Origin"] = "*"

        val response = route(request)
        val debug = Gson().toJson(response)
        println("DEBUG_PRINT - $debug")
        return ResponseEntity.ok(response)//.headers(responseHeaders).body(response)
    }

    private fun route(request: AccessPointRequest): Any {
        return when (request.route) {
            CREATE_USER -> UserController.createUser(request)
            CREATE_VAN -> UpStreamVanController.issueVan(request)
            ADD_CARD -> UpStreamCardController.addCard(request)
            else -> "Unknown action"
        }
    }
}