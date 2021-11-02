package com.mona.movieappusingcompose.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mona.movieappusingcompose.R
import com.mona.movieappusingcompose.data.utils.ErrorModel
import com.mona.movieappusingcompose.data.utils.ErrorsType
import com.mona.movieappusingcompose.utils.SingleLiveEvent
import com.mona.movieappusingcompose.utils.rx.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer

abstract class BaseViewModel<Repository : BaseRepository>
    (val repository: Repository, private val schedulerProvider: SchedulerProvider) : ViewModel() {

    internal val internalState = SingleLiveEvent<ViewState>()

    val state: LiveData<ViewState> = internalState

    val compositeDisposable = CompositeDisposable()

    fun <T> subscribe(
        observable: Observable<T>?,
        success: Consumer<T>?,
        error: Consumer<Throwable>?,
        allowLoading: Boolean = true
    ) {
        observable
            ?.compose(schedulerProvider.ioToMainObservableScheduler())
            ?.subscribe(success, error).let { compositeDisposable.add(it!!) }
    }

    fun <T> subscribe(
        observable: Single<T>?,
        success: Consumer<T>?,
        error: Consumer<Throwable>? = Consumer {},
        allowLoading: Boolean = true
    ) {

        observable
            ?.compose(schedulerProvider.ioToMainSingleScheduler())
            ?.compose { single ->
                composeSingle<T>(single, allowLoading)
            }
            ?.subscribe(success, error).let {
                compositeDisposable.add(it!!)
            }
    }

    private fun <T> composeSingle(single: Single<T>, allowLoading: Boolean): Single<T> {
        return single.doOnError {
            it.printStackTrace()
            when (it) {
                is ErrorsType.Network -> {
                    internalState.postValue(ViewState.NoInternetConnection)
                }
                is ErrorsType.GeneralError -> {
                    internalState.postValue(
                        ViewState.Error(ErrorModel(code = it.code, apiError = it.errorMessage))
                    )
                }
                is ErrorsType.InvalidToken -> {
                    internalState.postValue(ViewState.InvalidToken)
                }
                else -> {
                    //unexpected error.
                    internalState.postValue(
                        ViewState.Error(ErrorModel(localError = R.string.error_msg))
                    )
                }
            }
        }.doOnSubscribe {
            if (allowLoading)
                internalState.postValue(ViewState.Loading)
        }
    }

    private fun clearSubscription() {
        if (compositeDisposable.isDisposed.not()) compositeDisposable.clear()
    }

    override fun onCleared() {

        clearSubscription()
        super.onCleared()
    }
}