package com.fatherofapps.shopifymobileapp.ui.theme

import androidx.compose.ui.graphics.Color

// highlight color
val primaryPink = Color(0xFFEC6BAD)

// highlight element and text color
val primaryLightPink = Color(0xffF6A8D0)

// Site wide background & text on dark background or imagery
val white = Color(0xFFFFFFFF)

// Occasional background & Stroke
val lightGrey = Color(0xFFECECEC)

// text color
val matteBlack = Color(0xFF252424)

// border color
val secondaryIron = Color(0xffCDCDCD)

// subdued text
val secondaryGrey = Color(0xff828282)

// subdued text
val secondaryCharcoal = Color(0xff595959)

// error
val systemRed = Color(0xffCB0000)

// success
val systemGreen = Color(0xff026800)
val Black100 = Color(0xFFF5F7FA)


data class ShopifyAppColors(
    val isDark: Boolean,

    val backgroundDefault: Color,
    val backgroundSecondary: Color,
    val backgroundTertiary: Color,

    val textDefaultPrimary: Color,
    val textDefaultSecondary: Color,
    val textDefaultTertiary: Color,
    val textDanger: Color,

    val buttonPrimaryBackground: Color,
    val buttonPrimaryContent: Color,
    val buttonSecondaryContent: Color,
    val buttonSecondaryBorder: Color,

    val fieldBackground: Color,
    val fieldContent: Color,
    val fieldBorder: Color,
    val fieldDisabledContent: Color,
    val fieldDisabledBorder: Color,

    val borderDefault: Color,
    val borderDanger: Color,
    val iconDefault: Color,
    val iconHighlight: Color,
)

val lightColors = ShopifyAppColors(
    isDark = false,

    backgroundDefault = Color(0xFFF5F7FA),
    backgroundSecondary = white,
    backgroundTertiary = lightGrey,

    textDefaultPrimary = matteBlack,
    textDefaultSecondary = secondaryCharcoal,
    textDefaultTertiary = Color(0xFF6F6F6F),
    textDanger = systemRed,

    buttonPrimaryBackground = primaryPink,
    buttonPrimaryContent = matteBlack,
    buttonSecondaryContent = matteBlack,
    buttonSecondaryBorder = matteBlack,

    fieldBackground = white,
    fieldContent = matteBlack,
    fieldBorder = matteBlack,
    fieldDisabledContent = secondaryGrey,
    fieldDisabledBorder = lightGrey,

    borderDefault = secondaryIron,
    borderDanger = systemRed,
    iconDefault = matteBlack,
    iconHighlight = primaryPink,
)

val darkColors = ShopifyAppColors(
    isDark = true,

    backgroundDefault = Color(0xFF121212),
    backgroundSecondary = Color(0xFF1E1E1E),
    backgroundTertiary = Color(0xFF2A2A2A),

    textDefaultPrimary = Color(0xFFF5F5F5),
    textDefaultSecondary = Color(0xFFC2C2C2),
    textDefaultTertiary = Color(0xFF9E9E9E),
    textDanger = Color(0xFFFF7B7B),

    buttonPrimaryBackground = primaryLightPink,
    buttonPrimaryContent = matteBlack,
    buttonSecondaryContent = Color(0xFFF5F5F5),
    buttonSecondaryBorder = Color(0xFFF5F5F5),

    fieldBackground = Color(0xFF1E1E1E),
    fieldContent = Color(0xFFF5F5F5),
    fieldBorder = Color(0xFFF5F5F5),
    fieldDisabledContent = Color(0xFF9E9E9E),
    fieldDisabledBorder = Color(0xFF6B6B6B),

    borderDefault = Color(0xFF6B6B6B),
    borderDanger = Color(0xFFFF7B7B),
    iconDefault = Color(0xFFF5F5F5),
    iconHighlight = primaryPink
)