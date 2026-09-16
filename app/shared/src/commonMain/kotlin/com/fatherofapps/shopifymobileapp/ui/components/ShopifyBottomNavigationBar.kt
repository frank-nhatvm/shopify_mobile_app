package com.fatherofapps.shopifymobileapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.AndroidUiModes
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatherofapps.shopifymobileapp.routing.ShopifyRoute
import com.fatherofapps.shopifymobileapp.routing.TopLevelRoute
import com.fatherofapps.shopifymobileapp.ui.theme.ShopifyAppTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import shopifymobileapp.app.shared.generated.resources.Res
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_ic_account
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_ic_home
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_ic_search
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_ic_shop
import shopifymobileapp.app.shared.generated.resources.bottom_navigation_ic_wishlist

data class MainNavDestination(
    val label: StringResource,
    val icon: DrawableResource,
    val route: TopLevelRoute
)

@Composable
fun ShopifyBottomNavigationBar(
    destinations: List<MainNavDestination>,
    currentDestination: ShopifyRoute?,
    onClick: (TopLevelRoute) -> Unit,
    modifier: Modifier = Modifier
) {
    SideEffect {
        println("ShopifyBottomNavigationBar ${currentDestination}")
    }
    Row(
        modifier = modifier.fillMaxWidth().background(
            color = ShopifyAppTheme.colors.backgroundDefault
        ).padding(horizontal = 4.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(
            8.dp,
            alignment = Alignment.CenterHorizontally
        )
    ) {
        destinations.forEach { destination ->
            BottomNavigationBarItem(
                icon = destination.icon,
                title = stringResource(destination.label),
                onClick = {
                    onClick(destination.route)
                },
                isSelected = destination.route == currentDestination,
                modifier = Modifier.widthIn(max = 150.dp).fillMaxWidth().weight(1f, fill = false)
            )
        }
    }

}


@Composable
fun BottomNavigationBarItem(
    icon: DrawableResource,
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = ShopifyAppTheme.colors
    val iconContentColor = if (isSelected) colors.iconHighlight else colors.iconDefault
    Column(
        modifier = modifier.clickable(
            onClick = onClick
        ),
        verticalArrangement = Arrangement.spacedBy(4.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // icon
        Icon(
            painterResource(icon), contentDescription = "",
            modifier = Modifier.size(20.dp),
            tint = iconContentColor
        )

        // label
        Text(
            title,
            style = ShopifyAppTheme.typography.caption.copy(
                color = iconContentColor
            )
        )
    }

}


@Composable
@Preview(name = "dark", showBackground = true, uiMode = AndroidUiModes.UI_MODE_NIGHT_YES)
@Preview(name = "light", showBackground = true, uiMode = AndroidUiModes.UI_MODE_NIGHT_NO)
private fun PreviewBottomNavigationBar(modifier: Modifier = Modifier) {
    ShopifyAppTheme {
        Row(
            modifier = modifier.fillMaxWidth().background(
                color = ShopifyAppTheme.colors.backgroundDefault
            ).padding(horizontal = 4.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(
                8.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            BottomNavigationBarItem(
                icon = Res.drawable.bottom_navigation_ic_home,
                title = "Home",
                onClick = {},
                isSelected = true,
                modifier = Modifier.widthIn(max = 150.dp).fillMaxWidth().weight(1f, fill = false)
            )
            BottomNavigationBarItem(
                icon = Res.drawable.bottom_navigation_ic_wishlist,
                title = "Wishlist",
                onClick = {},
                isSelected = false,
                modifier = Modifier.widthIn(max = 150.dp).fillMaxWidth().weight(1f, fill = false)
            )
            BottomNavigationBarItem(
                icon = Res.drawable.bottom_navigation_ic_shop,
                title = "Shop",
                onClick = {},
                isSelected = false,
                modifier = Modifier.widthIn(max = 150.dp).fillMaxWidth().weight(1f, fill = false)
            )

            BottomNavigationBarItem(
                icon = Res.drawable.bottom_navigation_ic_search,
                title = "Search",
                onClick = {},
                isSelected = false,
                modifier = Modifier.widthIn(max = 150.dp).fillMaxWidth().weight(1f, fill = false)
            )

            BottomNavigationBarItem(
                icon = Res.drawable.bottom_navigation_ic_account,
                title = "Account",
                onClick = {},
                isSelected = false,
                modifier = Modifier.widthIn(max = 150.dp).fillMaxWidth().weight(1f, fill = false)
            )
        }
    }
}