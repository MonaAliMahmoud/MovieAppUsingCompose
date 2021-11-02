package com.mona.movieappusingcompose.ui.base.di

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.mona.movieappusingcompose.data.utils.ErrorModel
import com.mona.movieappusingcompose.ui.base.*
import sa.org.monshaat.di.helper.Injectable
import javax.inject.Inject

abstract class DIBaseFragment<Repository : BaseRepository, VM : BaseViewModel<Repository>> :
    BaseFragment(), Injectable {

    @Inject
    lateinit var viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, Observer { baseRender(it) })

        initView()
        bindViewModel()
    }

    fun baseRender(state: ViewState) {
        when (state) {
            is ListViewState.NetworkToast -> networkToast()
            is ViewState.Error -> {
                render(state)
            }
            else -> {
                render(state)
            }
        }
    }

    abstract fun bindViewModel()

    abstract fun initView()

    abstract fun render(state: ViewState)

    private fun showError(message: ErrorModel) {
        message.apiError?.let {
            context?.let { it1 ->
                Toast.makeText(it1, it, Toast.LENGTH_LONG).show()
            }
        }

        message.localError?.let {
            context?.let { it1 ->
                Toast.makeText(it1, getString(it), Toast.LENGTH_LONG).show()
            }
        }
    }

    fun networkToast() {
        context?.let {
            Toast.makeText(it, "check connection", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        viewModel.state.removeObservers(this)
        super.onDestroy()
    }
}