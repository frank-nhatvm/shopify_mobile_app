package com.fatherofapps.shopifymobileapp.screens.debug

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fatherofapps.shopifymobileapp.ui.components.ShopifyButton
import com.fatherofapps.shopifymobileapp.ui.theme.ShopifyAppTheme

@Composable
fun PlaceHolderScreen(modifier: Modifier = Modifier, text: String, action: (() -> Unit)? = null) {
    Column(
        modifier = modifier.fillMaxSize().background(
            ShopifyAppTheme.colors.backgroundDefault
        ).windowInsetsPadding(WindowInsets.systemBars),
        verticalArrangement = Arrangement.spacedBy(24.dp, alignment = Alignment.CenterVertically)
    ) {

        Text(
            text, style = ShopifyAppTheme.typography.h2.copy(
                color = ShopifyAppTheme.colors.textDefaultPrimary
            )
        )

        action?.let{
            ShopifyButton.Primary(
                label = "Action",
                onClick = action
            )
        }


    }

}