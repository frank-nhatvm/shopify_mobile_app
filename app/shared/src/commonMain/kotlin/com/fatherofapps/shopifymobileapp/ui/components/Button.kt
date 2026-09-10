package com.fatherofapps.shopifymobileapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.AndroidUiModes
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatherofapps.shopifymobileapp.ui.theme.ShopifyAppTheme

object ShopifyButton {
    @Composable
    fun Primary(
        label: String,
        onClick: () -> Unit,
        enabled: Boolean = true,
        modifier: Modifier = Modifier
    ) {
        Button(
            label = label, onClick = onClick,
            backgroundColor = ShopifyAppTheme.colors.buttonPrimaryBackground,
            textColor = ShopifyAppTheme.colors.buttonPrimaryContent,
            borderColor = ShopifyAppTheme.colors.buttonPrimaryBackground,
            enabled = enabled,
            modifier = modifier
        )
    }

    @Composable
    fun Secondary(
        label: String,
        onClick: () -> Unit,
        enabled: Boolean = true,
        modifier: Modifier = Modifier
    ) {
        Button(
            label = label, onClick = onClick,
            backgroundColor = Color.Transparent,
            textColor = ShopifyAppTheme.colors.buttonSecondaryContent,
            borderColor = ShopifyAppTheme.colors.buttonSecondaryBorder,
            enabled = enabled,
            modifier = modifier
        )
    }
}

@Composable
fun Button(
    label: String,
    onClick: () -> Unit,
    backgroundColor: Color,
    textColor: Color,
    borderColor: Color,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.alpha(
            if (enabled) 1f else 0.38f
        )
            .background(
                color = backgroundColor,
                shape = ShopifyAppTheme.shapes.medium
            ).clip(
                ShopifyAppTheme.shapes.medium
            ).border(
                width = 1.dp,
                color = borderColor,
                shape = ShopifyAppTheme.shapes.medium
            )
            .clickable(
                enabled = enabled,
                onClick = onClick
            ), contentAlignment = Alignment.Center
    ) {
        Text(
            label,
            style = ShopifyAppTheme.typography.h3.copy(
                color = textColor
            ),
            modifier = Modifier.padding(
                vertical = 8.dp,
                horizontal = 20.dp
            )
        )
    }
}


@Composable
@Preview(name = "light", showBackground = true, uiMode = AndroidUiModes.UI_MODE_NIGHT_NO)
@Preview(name = "dark", showBackground = true, uiMode = AndroidUiModes.UI_MODE_NIGHT_YES)
private fun PreviewButton(modifier: Modifier = Modifier) {
    ShopifyAppTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(
                color = ShopifyAppTheme.colors.backgroundDefault
            ),
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top)
        ) {

            ShopifyButton.Primary(
                label = "Primary button",
                onClick = {

                },
                modifier = Modifier.fillMaxWidth()
            )


            ShopifyButton.Primary(
                label = "Disabled Primary button",
                onClick = {

                },
                modifier = Modifier.fillMaxWidth(),
                enabled = false
            )

            ShopifyButton.Secondary(
                label = "Secondary button",
                onClick = {

                }
            )

        }
    }
}