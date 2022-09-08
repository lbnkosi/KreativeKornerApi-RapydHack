package com.explr.explravenue.rapyd.util

data class Headers(
    var contentType: String = "",
    var accessKey: String = "",
    var salt: String = "",
    var timestamp: String = "",
    var signature: String = "",
    var body: String? = "",
)