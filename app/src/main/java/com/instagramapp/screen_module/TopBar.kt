package com.instagramapp.screen_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MarkUnreadChatAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.instagramapp.R
import com.instagramapp.Screen
import com.instagramapp.mvvm_module.ThemeViewModel

@Composable
fun TopBar(navController: NavHostController, themeVM: ThemeViewModel) {
    // Determine colors based on the theme
    val iconColor = if (themeVM.dark.value) Color.White else Color.Black
    val logoUrl = if (themeVM.dark.value) {
        R.drawable.instagram_white_text // Dark mode logo
    } else {
        "https://cdn.prod.website-files.com/664884473364719e2c0310a2/664c9443d3277bcccf0df9c6_instagram-text-icon.png" // Light mode logo
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Instagram logo
        Box(
            modifier = Modifier
                .height(50.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(logoUrl), // Use theme-aware logo URL
                contentDescription = "Instagram Logo",
                modifier = Modifier.size(100.dp)
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                navController.navigate(Screen.NOTIFICATION)
            }) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Like",
                    tint = iconColor, // Use theme-aware icon color
                    modifier = Modifier.size(28.dp)
                )
            }
            IconButton(onClick = {
                navController.navigate(Screen.INBOX)
            }) {
                Icon(
                    imageVector = Icons.Outlined.MarkUnreadChatAlt,
                    contentDescription = "Message Icon",
                    tint = iconColor // Use theme-aware icon color
                )
            }
            IconButton(onClick = {
                navController.navigate(Screen.ABOUT)
            }) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "About Icon",
                    tint = iconColor // Use theme-aware icon color
                )
            }
        }
    }
}