package com.fatherofapps.shopifymobileapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.AndroidUiMode
import androidx.compose.ui.tooling.preview.AndroidUiModes
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatherofapps.shopifymobileapp.ui.components.ShopifyButton
import com.fatherofapps.shopifymobileapp.ui.theme.AppNotoSanFont
import com.fatherofapps.shopifymobileapp.ui.theme.ShopifyAppTheme
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

import shopifymobileapp.app.shared.generated.resources.Res
import shopifymobileapp.app.shared.generated.resources.compose_multiplatform
import shopifymobileapp.app.shared.generated.resources.notosans_condensed_bold
import shopifymobileapp.app.shared.generated.resources.notosans_condensed_semibold
import shopifymobileapp.app.shared.generated.resources.welcome_page_title

@Composable
@Preview(name = "English", locale = "en", showBackground = true)
@Preview(
    name = "Vietnamese",
    locale = "vi",
    showBackground = true,
    uiMode = AndroidUiModes.UI_MODE_NIGHT_YES
)
fun App() {
    ShopifyAppTheme {

        Column(
            modifier = Modifier
                .background(ShopifyAppTheme.colors.backgroundDefault)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                stringResource(Res.string.welcome_page_title),
                style = ShopifyAppTheme.typography.h1.copy(
                    color = ShopifyAppTheme.colors.textDefaultPrimary
                ),
                modifier = Modifier.background(
                    color = ShopifyAppTheme.colors.textDanger,
                    shape = ShopifyAppTheme.shapes.small
                ).padding(12.dp)
            )

            Text(
                stringResource(Res.string.welcome_page_title),
                style = ShopifyAppTheme.typography.h2,
            )

            Text(
                stringResource(Res.string.welcome_page_title),
                style = ShopifyAppTheme.typography.h3.copy(
                    color = ShopifyAppTheme.colors.textDefaultPrimary
                ),
            )

            Text(
                stringResource(Res.string.welcome_page_title),
                style = ShopifyAppTheme.typography.h4.copy(
                    color = ShopifyAppTheme.colors.textDefaultPrimary
                ),
            )

            Text(
                stringResource(Res.string.welcome_page_title),
                style = ShopifyAppTheme.typography.body.copy(
                    color = ShopifyAppTheme.colors.textDefaultPrimary
                ),

                )
            Text(
                stringResource(Res.string.welcome_page_title),
                style = ShopifyAppTheme.typography.caption.copy(
                    color = ShopifyAppTheme.colors.textDefaultPrimary
                ),
            )

            Row(modifier = Modifier.fillMaxWidth(),
horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {

                ShopifyButton.Secondary(
                    label = "Register",
                    onClick = {},
                    modifier = Modifier.weight(1f)
                )
                ShopifyButton.Primary(
                    label = "Sign In",
                    onClick = {

                    },
                    modifier = Modifier.weight(1f)
                )
            }


        }
    }
}