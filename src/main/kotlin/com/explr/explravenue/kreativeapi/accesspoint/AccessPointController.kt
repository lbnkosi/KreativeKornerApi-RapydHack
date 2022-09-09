package com.explr.explravenue.kreativeapi.accesspoint

import com.explr.explravenue.kreativeapi.accesspoint.Routes.CREATE_USER
import com.explr.explravenue.kreativeapi.user.controller.UserController
import com.google.gson.Gson
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kreative/api/accesspoint")
object AccessPointController {

    @PostMapping(value = ["/post"])
    fun acceptAccessPoint(@RequestBody request: AccessPointRequest): ResponseEntity<Any> {
        val responseHeaders = HttpHeaders()
        responseHeaders.set("Access-Control-Allow-Origin", "*")


        val response = route(request)
        val debug = Gson().toJson(response)
        println("DEBUG_PRINT - $debug")
        return ResponseEntity.ok().headers(responseHeaders).body(response)
    }

    private fun route(request: AccessPointRequest): Any {
        return when (request.route) {
            CREATE_USER -> {
                UserController.createUser(request)
            }
            else -> {
                "Unknown action"
            }
        }
    }
}