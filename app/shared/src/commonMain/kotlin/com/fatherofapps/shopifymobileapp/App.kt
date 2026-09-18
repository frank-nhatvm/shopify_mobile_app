package com.fatherofapps.shopifymobileapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
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
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Optional
import com.fatherofapps.shopifymobileapp.routing.AccountRoute
import com.fatherofapps.shopifymobileapp.routing.DebugRoute
import com.fatherofapps.shopifymobileapp.routing.HomeRoute
import com.fatherofapps.shopifymobileapp.routing.ProductDetailRoute
import com.fatherofapps.shopifymobileapp.routing.SearchRoute
import com.fatherofapps.shopifymobileapp.routing.ShopRoute
import com.fatherofapps.shopifymobileapp.routing.ShopifyRoute
import com.fatherofapps.shopifymobileapp.routing.TopLevelRoute
import com.fatherofapps.shopifymobileapp.routing.WelcomeRoute
import com.fatherofapps.shopifymobileapp.routing.WishlistRoute
import com.fatherofapps.shopifymobileapp.routing.shopifyRouteConfig
import com.fatherofapps.shopifymobileapp.screens.account.AccountScreen
import com.fatherofapps.shopifymobileapp.screens.debug.DebugScreen
import com.fatherofapps.shopifymobileapp.screens.home.HomeScreen
import com.fatherofapps.shopifymobileapp.screens.products.ProductDetailScreen
import com.fatherofapps.shopifymobileapp.screens.search.SearchScreen
import com.fatherofapps.shopifymobileapp.screens.shop.ShopScreen
import com.fatherofapps.shopifymobileapp.screens.welcome.WelcomeScreen
import com.fatherofapps.shopifymobileapp.screens.wishlist.WishlistScreen
import com.fatherofapps.shopifymobileapp.ui.components.MainNavDestination
import com.fatherofapps.shopifymobileapp.ui.components.ShopifyBottomNavigationBar
import com.fatherofapps.shopifymobileapp.ui.components.ShopifyButton
import com.fatherofapps.shopifymobileapp.ui.theme.AppNotoSanFont
import com.fatherofapps.shopifymobileapp.ui.theme.ShopifyAppTheme
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

import shopifymobileapp.app.shared.generated.resources.Res
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_account_title
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_home_title
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_ic_account
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_ic_home
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_ic_search
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_ic_shop
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_ic_wishlist
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_search_title
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_shop_title
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_wishlist_title
import shopifymobileapp.app.shared.generated.resources.compose_multiplatform
import shopifymobileapp.app.shared.generated.resources.notosans_condensed_bold
import shopifymobileapp.app.shared.generated.resources.notosans_condensed_semibold
import shopifymobileapp.app.shared.generated.resources.welcome_page_title


val bottomNavDestinations = listOf(
    MainNavDestination(
        label = Res.string.bottom_navigation_home_title,
        icon = Res.drawable.bottom_navigation_ic_home,
        route = HomeRoute
    ),
    MainNavDestination(
        label = Res.string.bottom_navigation_wishlist_title,
        icon = Res.drawable.bottom_navigation_ic_wishlist,
        route = WishlistRoute
    ),
    MainNavDestination(
        label = Res.string.bottom_navigation_shop_title,
        icon = Res.drawable.bottom_navigation_ic_shop,
        route = ShopRoute
    ),
    MainNavDestination(
        label = Res.string.bottom_navigation_search_title,
        icon = Res.drawable.bottom_navigation_ic_search,
        route = SearchRoute
    ),
    MainNavDestination(
        label = Res.string.bottom_navigation_account_title,
        icon = Res.drawable.bottom_navigation_ic_account,
        route = AccountRoute
    ),
)

@Composable
@Preview(name = "English", locale = "en", showBackground = true)
@Preview(
    name = "Vietnamese",
    locale = "vi",
    showBackground = true,
    uiMode = AndroidUiModes.UI_MODE_NIGHT_YES
)
fun App() {

    LaunchedEffect(Unit) {
        val apolloClient = ApolloClient.Builder().serverUrl("https://apollo-fullstack-tutorial.herokuapp.com/graphql").build()
        val response = apolloClient.query(LaunchListQuery(pageSize = Optional.present(1))).execute().data?.launches?.launches?.firstOrNull()
        println(response)
    }

    val backStack = rememberNavBackStack(shopifyRouteConfig, WelcomeRoute)

    val currentDestination by remember(backStack) {
        derivedStateOf {
            backStack.lastOrNull() as? ShopifyRoute
        }
    }

    val showBottomNavigationBar by remember(currentDestination) {
        derivedStateOf {
            currentDestination is TopLevelRoute
        }
    }

    ShopifyAppTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(
                ShopifyAppTheme.colors.backgroundDefault
            ).windowInsetsPadding(WindowInsets.systemBars)
        ) {

            Box(modifier = Modifier.weight(1f)) {
                NavDisplay(
                    backStack = backStack,
                    entryProvider = { key ->
                        when (key) {
                            is WelcomeRoute -> NavEntry(key) {
                                WelcomeScreen {
                                    // backStack.clear()
                                    backStack.add(HomeRoute)
                                }
                            }

                            is HomeRoute -> NavEntry(key) {
                                HomeScreen {
                                    backStack.add(ProductDetailRoute)
                                }
                            }

                            is DebugRoute -> NavEntry(key) {
                                DebugScreen()
                            }

                            is WishlistRoute -> NavEntry(key) {
                                WishlistScreen()
                            }

                            is ShopRoute -> NavEntry(key) {
                                ShopScreen()
                            }

                            is AccountRoute -> NavEntry(key) {
                                AccountScreen()
                            }

                            is SearchRoute -> NavEntry(key) {
                                SearchScreen()
                            }

                            is ProductDetailRoute -> NavEntry(key) {
                                ProductDetailScreen()
                            }

                            else -> NavEntry(key) {
                                Text("Unknown Route")
                            }


                        }
                    }
                )
            }
            if (showBottomNavigationBar) {
                ShopifyBottomNavigationBar(
                    currentDestination = currentDestination,
                    destinations = bottomNavDestinations,
                    onClick = { route ->
                        println("App navigate to $route")
                        backStack.add(route)
                    },
                    modifier = Modifier.fillMaxWidth()
                )

            }
        }
    }
}