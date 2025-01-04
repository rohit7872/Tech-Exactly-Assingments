package com.example.techexactlyassingments.model


data class APIResult<T>(
    var data: T? = null,
    var loading: Boolean = false,
    var error: ApiError? = null

)

data class ApiError(
    var code: Int = -1,
    var message: String? = null,
    var exception: Throwable

)

