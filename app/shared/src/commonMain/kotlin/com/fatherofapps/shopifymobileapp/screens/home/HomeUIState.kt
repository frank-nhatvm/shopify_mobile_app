package com.fatherofapps.shopifymobileapp.screens.home

import com.fatherofapps.shopifymobileapp.models.HomeData

data class HomeUIState(
    val isLoading: Boolean = false,
    val homeData: HomeData? = null,
    val error: Throwable? = null,
)

sealed interface HomeUIViewIntent{

}

sealed interface HomeUIPartialState{
  data object  Loading: HomeUIPartialState
  data class Error(val error: Throwable): HomeUIPartialState
  data class Success(val homeData: HomeData): HomeUIPartialState

    fun reduce(current: HomeUIState): HomeUIState = when(this){
        is Loading -> current.copy(isLoading = true)
        is Error -> current.copy(isLoading = false, error = error)
        is Success -> current.copy(homeData = homeData, isLoading = false)
    }
}