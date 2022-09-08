package com.explr.explravenue.kreativeapi.accesspoint

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kreative/api/accesspoint")
object AccessPointController {

    @PostMapping(value = ["/accept"])
    fun acceptAccessPoint(@RequestBody request: AccessPointRequest): ResponseEntity<Any> {
        return ResponseEntity.ok(request)
    }
}