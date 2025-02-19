package com.instagramapp.screen_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ModeComment
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.instagramapp.mvvm_module.ThemeViewModel

@Composable
fun PostSection(post: Post, themeVM: ThemeViewModel) {
    // Determine colors based on the theme
    val textColor = if (themeVM.dark.value) Color.White else Color.Black
    val iconColor = if (themeVM.dark.value) Color.White else Color.Black
    val borderColor = if (themeVM.dark.value) Color.DarkGray else Color.LightGray

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(post.profileImage),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.dp, borderColor, CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = post.userName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        }

        Image(
            painter = rememberAsyncImagePainter(post.postImage),
            contentDescription = "Post Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Handle Like Action */ }) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Like",
                        tint = iconColor, // Use theme-aware icon color
                        modifier = Modifier.size(28.dp))
                }
                Text(
                    post.likes,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor // Use theme-aware text color
                )

                Spacer(modifier = Modifier.width(10.dp))

                IconButton(onClick = { /* Handle Comment Action */ }) {
                    Icon(
                        imageVector = Icons.Outlined.ModeComment,
                        contentDescription = "Comment",
                        tint = iconColor, // Use theme-aware icon color
                        modifier = Modifier.size(28.dp))
                }
                Text(
                    post.comments,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor // Use theme-aware text color
                )

                Spacer(modifier = Modifier.width(10.dp))

                IconButton(onClick = { /* Handle Share Action */ }) {
                    Icon(
                        imageVector = Icons.Default.Send,
                        contentDescription = "Share",
                        tint = iconColor, // Use theme-aware icon color
                        modifier = Modifier
                            .size(28.dp)
                            .padding(bottom = 5.dp)
                            .graphicsLayer(rotationZ = -25f)
                    )
                }
                Text(
                    post.shares,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor // Use theme-aware text color
                )
            }

            IconButton(onClick = { /* Handle Save Action */ }) {
                Icon(
                    imageVector = Icons.Default.BookmarkBorder,
                    contentDescription = "Save",
                    tint = iconColor, // Use theme-aware icon color
                    modifier = Modifier.size(28.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = post.userName,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = textColor // Use theme-aware text color
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = post.description,
                fontSize = 14.sp,
                color = textColor // Use theme-aware text color
            )
        }
    }
}