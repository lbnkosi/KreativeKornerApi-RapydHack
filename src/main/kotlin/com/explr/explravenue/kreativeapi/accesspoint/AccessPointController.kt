package com.explr.explravenue.kreativeapi.accesspoint

import com.explr.explravenue.kreativeapi.accesspoint.Routes.CREATE_USER
import com.explr.explravenue.kreativeapi.user.controller.UserController
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
        return ResponseEntity.ok(route(request))
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