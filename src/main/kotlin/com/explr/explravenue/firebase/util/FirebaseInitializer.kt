package com.explr.explravenue.firebase.util

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import java.io.IOException
import javax.annotation.PostConstruct
import kotlin.jvm.Throws

@Service
class FirebaseInitializer {

    @PostConstruct
    @Throws(IOException::class)
    fun initialize() {
        val options: FirebaseOptions = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(ClassPathResource("serviceaccount.json").inputStream)).build()
        FirebaseApp.initializeApp(options)
    }

}