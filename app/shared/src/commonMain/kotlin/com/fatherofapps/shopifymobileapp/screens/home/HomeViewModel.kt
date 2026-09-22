package com.fatherofapps.shopifymobileapp.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatherofapps.shopifymobileapp.data.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.stateIn

class HomeViewModel constructor(private val homeRepository: HomeRepository) : ViewModel() {

    val uiState: StateFlow<HomeUIState>

    init {
        val initialState = HomeUIState()
        uiState = merge(loadData())
            .scan(initialState) { state, partialState ->
                partialState.reduce(state)
            }.stateIn(viewModelScope, SharingStarted.Eagerly, initialState)
    }

    private fun loadData(): Flow<HomeUIPartialState> = flow<HomeUIPartialState> {
        val data = homeRepository.getHomeData()
        emit(HomeUIPartialState.Success(data))
    }.catch { e -> emit(HomeUIPartialState.Error(e)) }
        .onStart {
            emit(HomeUIPartialState.Loading)
        }

}