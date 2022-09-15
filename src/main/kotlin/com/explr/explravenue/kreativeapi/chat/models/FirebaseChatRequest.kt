package com.explr.explravenue.kreativeapi.chat.models

data class FirebaseChatRequest(
    var email: String? = "",
    var name: String? = "",
    var surname: String? = "",
    var currently_viewing: String? = ""
)