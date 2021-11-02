package com.mona.movieappusingcompose.data.utils

import com.google.gson.annotations.SerializedName

data class ResponseBody<T>(
    @SerializedName("status") val status: Int,
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: T?,
    @SerializedName("error") val error: ErrorResponse?,
    @SerializedName("pagination") val pagination: Pagination?
)

data class Pagination(
    @SerializedName("total")
    val total: Int = 0,
    @SerializedName("perPage")
    val perPage: Int = 0,
    @SerializedName("totalPages")
    var totalPages: Int = 0,
    @SerializedName("currentPage")
    val currentPage: Int = 0
)
