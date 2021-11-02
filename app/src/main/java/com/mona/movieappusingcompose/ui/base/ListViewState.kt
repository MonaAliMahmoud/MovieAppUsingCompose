package com.mona.movieappusingcompose.ui.base

abstract class ListViewState : ViewState() {
    object Shimmer : ViewState()
    object HideShimmer : ViewState()
    object NetworkToast : ViewState()
    data class MoreData(val hasMore: Boolean) : ViewState.Loaded<Boolean>(hasMore)
}