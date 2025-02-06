package com.instagramapp.screen_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun PostSection(posts: List<String>) {
    LazyColumn( // Use LazyColumn for scrollable content
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(posts) { post ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                // Profile Section
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Profile Picture
                    Image(
                        painter = rememberAsyncImagePainter("https://i.pinimg.com/736x/a5/f3/10/a5f310a0b4130de23139b0d1d19e410c.jpg"),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 8.dp)
                            .clip(CircleShape)
                    )
                    // Username
                    Text(
                        text = "chendaloeut",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                // Post Image
                Image(
                    painter = rememberAsyncImagePainter(post),
                    contentDescription = "Post Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                )

                // Post Actions
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    IconButton(onClick = { /* Handle Like Action */ }) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Like",
                            tint = Color.Red,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    IconButton(onClick = { /* Handle Comment Action */ }) {
                        Icon(
                            imageVector = Icons.Default.Comment,
                            contentDescription = "Comment",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    IconButton(onClick = { /* Handle Share Action */ }) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                // Caption
                Text(
                    text = "It's all about the glow",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}
