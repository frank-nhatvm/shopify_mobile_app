package com.fatherofapps.shopifymobileapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf


val LocalTypography = compositionLocalOf<ShopifyTypography> {
    error("ShopifyTheme must be part of the call hierarchy to .... ")
}

val LocalColors = compositionLocalOf<ShopifyAppColors> {
    error("ShopifyTheme must be part of the call hierarchy to .... ")
}

val LocalShapes  = compositionLocalOf<ShopifyAppShapes> {
    error("ShopifyTheme must be part of the call hierarchy to .... ")
}

object ShopifyAppTheme {
    val typography: ShopifyTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current


    val colors: ShopifyAppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val shapes: ShopifyAppShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}

@Composable
fun ShopifyAppTheme(
    colors: ShopifyAppColors = if (isSystemInDarkTheme()) darkColors else lightColors,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTypography provides defaultShopifyTypography,
        LocalColors provides colors,
        LocalShapes provides defaultShopifyAppShapes
    ) {
        content()
    }
}


