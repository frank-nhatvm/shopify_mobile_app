package com.fatherofapps.shopifymobileapp.routing

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@OptIn(ExperimentalSerializationApi::class)
val shopifyRouteConfig = SavedStateConfiguration{
    serializersModule = SerializersModule {
        polymorphic(NavKey::class){
            subclassesOfSealed<ShopifyRoute>()
        }
    }
}

@Serializable
sealed interface  TopLevelRoute: ShopifyRoute
@Serializable
data object WishlistRoute: TopLevelRoute, ShopifyRoute
@Serializable
data object ShopRoute: TopLevelRoute, ShopifyRoute
@Serializable
data object SearchRoute: TopLevelRoute, ShopifyRoute
@Serializable
data object AccountRoute: TopLevelRoute, ShopifyRoute

@Serializable
sealed interface ShopifyRoute: NavKey

@Serializable
data object WelcomeRoute: ShopifyRoute
@Serializable
data object HomeRoute: TopLevelRoute,ShopifyRoute

@Serializable
data object DebugRoute: ShopifyRoute
@Serializable
data object ProductDetailRoute : ShopifyRoute