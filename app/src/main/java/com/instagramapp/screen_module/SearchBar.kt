package com.instagramapp.screen_module

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.instagramapp.R
import com.instagramapp.mvvm_module.ThemeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(themeVM: ThemeViewModel) {
    val surfaceColor = if (themeVM.dark.value) Color.DarkGray else Color.LightGray
    val backgroundColor = if (themeVM.dark.value) Color.DarkGray else Color(0xFFF3F4F6)
    val textColor = if (themeVM.dark.value) Color.White else Color.Black
    val placeholderColor = if (themeVM.dark.value) Color.LightGray else Color.Gray
    val iconColor = if (themeVM.dark.value) Color.White else Color.Black

    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        placeholder = {
            Text(
                text = stringResource(R.string.search),
                color = placeholderColor
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = iconColor
            )
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            focusedContainerColor = backgroundColor,
            unfocusedContainerColor = backgroundColor,
            focusedPlaceholderColor = placeholderColor,
            unfocusedPlaceholderColor = placeholderColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = textColor
        ),
        textStyle = LocalTextStyle.current.copy(color = textColor)
    )
}