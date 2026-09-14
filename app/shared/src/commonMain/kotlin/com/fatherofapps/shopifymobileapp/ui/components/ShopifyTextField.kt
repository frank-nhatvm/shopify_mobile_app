package com.fatherofapps.shopifymobileapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_NO
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatherofapps.shopifymobileapp.ui.theme.ShopifyAppTheme
import org.jetbrains.compose.resources.painterResource
import shopifymobileapp.app.shared.generated.resources.Res
import shopifymobileapp.app.shared.generated.resources.ic_search

@Composable
fun ShopifyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: String,
    enabled: Boolean = true,
    isError: Boolean = false,
    errorMessage: String? = null,
    singleLine: Boolean = true,
    modifier: Modifier = Modifier,
    trailingIcon: (@Composable () -> Unit)? = null
) {

    val colors = ShopifyAppTheme.colors

    // contentColor
    val contentColor = if (enabled) colors.fieldContent else colors.fieldDisabledContent

    // borderColor
    val borderColor = when {
        !enabled -> colors.fieldDisabledBorder
        isError -> colors.borderDanger
        else -> colors.fieldBorder
    }


    Column(modifier = modifier) {

        // textfield
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = ShopifyAppTheme.typography.body.copy(color = contentColor),
            enabled = enabled,
            singleLine = singleLine,
            modifier = Modifier.fillMaxWidth().background(
                colors.fieldBackground, ShopifyAppTheme.shapes.medium
            ).border(
                1.dp, borderColor, ShopifyAppTheme.shapes.medium
            ),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(modifier = Modifier.weight(1f)) {
                        if (value.isEmpty()) {
                            // placeholder
                            Text(
                                text = placeHolder,
                                style = ShopifyAppTheme.typography.body.copy(color = contentColor)
                            )
                        }
                        innerTextField()
                    }

                    if (trailingIcon != null) {
                        Spacer(Modifier.width(8.dp))
                        CompositionLocalProvider(LocalContentColor provides borderColor) {
                            trailingIcon()
                        }
                    }

                }
            }
        )


        // error message
        if (isError && !errorMessage.isNullOrEmpty()) {
            Text(
                text = errorMessage,
                modifier = Modifier.padding(top = 4.dp),
                style = ShopifyAppTheme.typography.body.copy(
                    color = colors.textDanger
                )
            )
        }
    }

}

@Composable
@Preview(name = "light", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "dark", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun PreviewTextField(modifier: Modifier = Modifier) {
    var normalText by remember {
        mutableStateOf("")
    }


    var disabledText by remember {
        mutableStateOf("")
    }

    var errorText by remember {
        mutableStateOf("")
    }

    ShopifyAppTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(
                color = ShopifyAppTheme.colors.backgroundDefault
            ).padding(
                vertical = 24.dp, horizontal = 16.dp
            ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Text("Active")
            Spacer(modifier = Modifier.height(4.dp))
            ShopifyTextField(
                value = normalText,
                onValueChange = {
                    normalText = it
                },
                placeHolder = "Active State"
            )


            Spacer(modifier = Modifier.height(24.dp))
            Text("Error")
            Spacer(modifier = Modifier.height(4.dp))
            ShopifyTextField(
                value = errorText,
                onValueChange = {
                    errorText = it
                },
                placeHolder = "Error State",
                isError = true,
                errorMessage = "Invalid input"
            )

            Spacer(modifier = Modifier.height(24.dp))
            Text("Disabled")
            Spacer(modifier = Modifier.height(4.dp))
            ShopifyTextField(
                value = disabledText,
                onValueChange = {
                    disabledText = it
                },
                placeHolder = "Disabled State",
                enabled = false
            )


            Spacer(modifier = Modifier.height(24.dp))
            Text("Trailing Icon")
            Spacer(modifier = Modifier.height(4.dp))
            ShopifyTextField(
                value = disabledText,
                onValueChange = {
                    disabledText = it
                },
                placeHolder = "Trailing Icon",

                trailingIcon = {
                    Icon(
                        painterResource(Res.drawable.ic_search), contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                }
            )


            Spacer(modifier = Modifier.height(24.dp))
            Text("Trailing Icon")
            Spacer(modifier = Modifier.height(4.dp))
            ShopifyTextField(
                value = disabledText,
                onValueChange = {
                    disabledText = it
                },
                placeHolder = "Trailing Icon",
                isError = true,
                errorMessage = "something ....",
                trailingIcon = {
                    Icon(
                        painterResource(Res.drawable.ic_search), contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                }
            )
        }
    }


}
