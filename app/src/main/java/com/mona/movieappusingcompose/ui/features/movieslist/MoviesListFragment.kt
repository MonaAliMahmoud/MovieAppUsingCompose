package com.mona.movieappusingcompose.ui.features.movieslist

import android.os.Bundle
import com.mona.movieappusingcompose.ui.base.ViewState
import com.mona.movieappusingcompose.ui.base.di.DIBaseFragment

class MoviesListFragment : DIBaseFragment<MoviesListRepository, MoviesListViewModel>() {

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    companion object {
        private const val ARG_PARAM1 = "param1"

        fun newInstance(param1: String) =
            MoviesListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

    override fun bindViewModel() {}

    override fun initView() {
        viewModel.getMoviesList()
    }

    override fun render(state: ViewState) {
        when(state){
            is MoviesListViewState.MoviesListData ->{
                var moviesList = state.movieData.results

            }
        }
    }
}