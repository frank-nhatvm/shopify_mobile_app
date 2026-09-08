package com.fatherofapps.shopifymobileapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import shopifymobileapp.app.shared.generated.resources.Res
import shopifymobileapp.app.shared.generated.resources.notosans_condensed_bold
import shopifymobileapp.app.shared.generated.resources.notosans_condensed_regular
import shopifymobileapp.app.shared.generated.resources.notosans_condensed_semibold

val AppNotoSanFont: FontFamily
@Composable
get() = FontFamily(
    Font(
        resource = Res.font.notosans_condensed_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resource = Res.font.notosans_condensed_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resource = Res.font.notosans_condensed_semibold,
        weight = FontWeight.SemiBold
    )
)


class ShopifyTypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val body: TextStyle,
    val caption: TextStyle,
)

val defaultShopifyTypography: ShopifyTypography
@Composable
get() = ShopifyTypography(
    h1 = TextStyle(
        fontFamily = AppNotoSanFont,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        lineHeight = 32.sp
    ),
    h2 = TextStyle(
        fontFamily = AppNotoSanFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = AppNotoSanFont,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = AppNotoSanFont,
        fontSize = 13.sp,
        lineHeight = 20.sp,
    ),
    body = TextStyle(
        fontFamily = AppNotoSanFont,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    caption = TextStyle(
        fontFamily = AppNotoSanFont,
        fontSize = 13.sp,
        lineHeight = 20.sp,
    ),
)