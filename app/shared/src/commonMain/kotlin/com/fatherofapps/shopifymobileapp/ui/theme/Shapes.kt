package com.fatherofapps.shopifymobileapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

data class ShopifyAppShapes(
    val medium: RoundedCornerShape,
    val small: RoundedCornerShape,
)

val defaultShopifyAppShapes = ShopifyAppShapes(
    medium = RoundedCornerShape(16.dp),
    small = RoundedCornerShape(8.dp)
)
