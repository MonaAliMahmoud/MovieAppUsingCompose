package com.mona.movieappusingcompose.ui.base

import com.mona.movieappusingcompose.data.utils.ErrorModel

abstract class ViewState {
    object Loading : ViewState()
    object HideLoading : ViewState()
    object PagingLoading : ViewState()
    object HidePagingLoading : ViewState()
    object NoData : ViewState()
    object NoInternetConnection : ViewState()
    object NetworkAvailable : ViewState()
    object NavigateToLogin : ViewState()
    data class Error(val error: ErrorModel?) : ViewState()
    object AuthenticationError : ViewState()
    object InvalidToken : ViewState()
    abstract class Loaded<out T>(val result: T) : ViewState()
    abstract class LoadedMultiParam<out T, out J>(val obj1: T, val obj2: J) : ViewState()
    abstract class LoadedWithoutData : ViewState()
}