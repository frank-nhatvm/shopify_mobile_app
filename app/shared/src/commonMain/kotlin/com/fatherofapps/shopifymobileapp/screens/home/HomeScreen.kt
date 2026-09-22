package com.fatherofapps.shopifymobileapp.screens.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.fatherofapps.shopifymobileapp.screens.debug.PlaceHolderScreen
import com.fatherofapps.shopifymobileapp.ui.theme.ShopifyAppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    onNavigate: () -> Unit
) {
    val uiState by homeViewModel.uiState.collectAsState()
    uiState.homeData
    PlaceHolderScreen(
        text = "Home Screen",
        action = {
            onNavigate()
        }
    )
}