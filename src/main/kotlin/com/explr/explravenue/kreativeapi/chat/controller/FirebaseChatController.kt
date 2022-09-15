package com.explr.explravenue.kreativeapi.chat.controller

import com.explr.explravenue.firebase.firestore.controller.FirestoreController
import com.explr.explravenue.kreativeapi.accesspoint.AccessPointRequest
import com.explr.explravenue.kreativeapi.chat.models.FirebaseChatRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/explore/api/firebasechat")
object FirebaseChatController {

    @PostMapping(value = ["/update"])
    fun updateChat(@RequestBody accessPoint: AccessPointRequest): ResponseEntity<Any> {
        return try {
            val firebaseChatRequest = configureFirebaseRequest(accessPoint)
            FirestoreController.update(accessPoint.email, "chat", firebaseChatRequest)
            ResponseEntity.ok("Success")
        } catch (e: HttpClientErrorException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    private fun configureFirebaseRequest(accessPoint: AccessPointRequest): FirebaseChatRequest {
        val request = FirebaseChatRequest()
        request.email = accessPoint.email
        request.name = accessPoint.name
        request.surname = accessPoint.surname
        request.currently_viewing = accessPoint.currently_viewing
        return request
    }

}