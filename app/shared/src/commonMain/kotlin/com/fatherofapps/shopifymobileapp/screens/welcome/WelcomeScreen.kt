package com.fatherofapps.shopifymobileapp.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fatherofapps.shopifymobileapp.ui.components.ShopifyButton
import com.fatherofapps.shopifymobileapp.ui.theme.ShopifyAppTheme

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit
) {

    Column(
        modifier = modifier.fillMaxSize().background(
            ShopifyAppTheme.colors.backgroundDefault
        ).windowInsetsPadding(WindowInsets.systemBars),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            "Welcome Screen", style = ShopifyAppTheme.typography.h2.copy(
                color = ShopifyAppTheme.colors.textDefaultPrimary
            )
        )

        ShopifyButton.Primary(
            label = "Go Home",
            onClick = onNavigateToHome
        )

    }

}