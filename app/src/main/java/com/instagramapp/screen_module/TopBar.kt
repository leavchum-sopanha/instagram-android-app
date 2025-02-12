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
import com.instagramapp.Screen

@Composable
fun TopBar(navController: NavHostController) {
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
                painter = rememberAsyncImagePainter("https://cdn.prod.website-files.com/664884473364719e2c0310a2/664c9443d3277bcccf0df9c6_instagram-text-icon.png"),
                contentDescription = "Instagram Logo",
                modifier = Modifier.size(100.dp)

            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Handle Like Action */ }) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Like",
                    tint = Color.Black,
                    modifier = Modifier.size(28.dp)
                )
            }
            IconButton(onClick = {
                navController.navigate(Screen.INBOX)
            }) {
                Icon(
                    imageVector = Icons.Outlined.MarkUnreadChatAlt,
                    contentDescription = "Message Icon",
                    tint = Color.Black
                )
            }
            IconButton(onClick = {
                navController.navigate(Screen.ABOUT)
            }) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "About Icon",
                    tint = Color.Black
                )
            }
        }
    }
}
