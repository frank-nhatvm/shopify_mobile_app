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
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.fatherofapps.shopifymobileapp.routing.DebugRoute
import com.fatherofapps.shopifymobileapp.routing.HomeRoute
import com.fatherofapps.shopifymobileapp.routing.WelcomeRoute
import com.fatherofapps.shopifymobileapp.routing.shopifyRouteConfig
import com.fatherofapps.shopifymobileapp.screens.debug.DebugScreen
import com.fatherofapps.shopifymobileapp.screens.home.HomeScreen
import com.fatherofapps.shopifymobileapp.screens.welcome.WelcomeScreen
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

    val backStack = rememberNavBackStack(shopifyRouteConfig, WelcomeRoute)
    ShopifyAppTheme {

        NavDisplay(
            backStack = backStack,
            entryProvider = {
                key ->
                when(key) {
                    is WelcomeRoute -> NavEntry(key){
                        WelcomeScreen {
                            // backStack.clear()
                            backStack.add(HomeRoute)
                        }
                    }

                    is HomeRoute -> NavEntry(key){
                        HomeScreen()
                    }

                    is DebugRoute -> NavEntry(key){
                        DebugScreen()
                    }

                    else -> NavEntry(key){
                        Text("Unknown Route")
                    }
                }
            }
        )

    }
}