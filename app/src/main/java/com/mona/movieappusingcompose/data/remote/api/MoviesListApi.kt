package com.mona.movieappusingcompose.data.remote.api

import com.mona.movieappusingcompose.data.model.MovieData
import com.mona.movieappusingcompose.data.remote.ApiEndPoints
import com.mona.movieappusingcompose.data.remote.ApiKeys
import com.mona.movieappusingcompose.data.utils.ResponseBody
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesListApi {
    @GET(ApiEndPoints.MOVIES_LIST)
    fun getMoviesList(
        @Query(ApiKeys.API_KEY) id: String = "ebea8cfca72fdff8d2624ad7bbf78e4c",
        @Query(ApiKeys.PAGE) page: Int
    ): Single<ResponseBody<MovieData>>
}