package com.mona.movieappusingcompose.data.utils

sealed class ErrorsType : RuntimeException() {

    object Network : ErrorsType()

    object ServerDown : ErrorsType()

    object UnExcepted : ErrorsType()

    object UnAuthorize : ErrorsType()

    object SessionTimeOut : ErrorsType()

    data class Authentication(val errorMessage: String) : ErrorsType()

    data class InvalidToken(val errorMessage: String) : ErrorsType()

    data class GeneralError(val code: Any, val errorMessage: String) : ErrorsType()
}