package com.instagramapp.screen_module


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesomeMosaic
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
//            .background(Color.Red),
//            .padding(8.dp),
            .padding(horizontal = 16.dp),

    horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        // Instagram logo
        Box(
            modifier = Modifier
                .height(50.dp)
//                .border(width = 4.dp, color = Color(0xFF19355D), shape = RoundedCornerShape(8.dp)) // Set the border color to #19355d
//                .clip(RoundedCornerShape(8.dp)) // Clip the image itself with rounded corners
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://cdn.prod.website-files.com/664884473364719e2c0310a2/664c9443d3277bcccf0df9c6_instagram-text-icon.png"),
                contentDescription = "Instagram Logo",
                modifier = Modifier.size(100.dp)

            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(3.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Handle heart click */ }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Notification Icon",
                    tint = Color.Red
                )
            }
            IconButton(onClick = { /* Handle message click */ }) {
                Icon(
                    imageVector = Icons.Default.ChatBubble,
                    contentDescription = "Message Icon",
                    tint = Color.Black
                )
            }
            IconButton(onClick = {
                navController.navigate(Screen.ABOUT)
            }) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "About Icon",
                    tint = Color.Black
                )
            }
        }
    }
}
