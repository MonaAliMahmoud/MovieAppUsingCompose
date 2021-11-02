package com.mona.movieappusingcompose.data.utils

import androidx.annotation.StringRes

data class ErrorModel(
    val code: Any? = 0,
    val apiError: String? = null,
    @StringRes val localError: Int? = null
)