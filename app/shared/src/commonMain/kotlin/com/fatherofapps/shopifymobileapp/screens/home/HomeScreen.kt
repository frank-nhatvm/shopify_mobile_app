package com.fatherofapps.shopifymobileapp.screens.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fatherofapps.shopifymobileapp.ui.theme.ShopifyAppTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Text("Home Screen", style = ShopifyAppTheme.typography.h2.copy(
        color = ShopifyAppTheme.colors.textDefaultPrimary
    ))
}