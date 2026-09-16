package com.fatherofapps.shopifymobileapp.screens.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fatherofapps.shopifymobileapp.screens.debug.PlaceHolderScreen
import com.fatherofapps.shopifymobileapp.ui.theme.ShopifyAppTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onNavigate: ()  -> Unit) {
    PlaceHolderScreen(
        text = "Home Screen",
        action = {
            onNavigate()
        }
    )
}