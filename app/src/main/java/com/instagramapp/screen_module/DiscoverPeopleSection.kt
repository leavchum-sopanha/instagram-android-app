package com.instagramapp.screen_module

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

data class UserProfile(
    val name: String,
    val imageUrl: String,
    val followersInfo: String
)

@Composable
fun DiscoverPeopleSection() {
    val users = listOf(
        UserProfile("John Doe", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg", "Followed by heang_eries + 3..."),
        UserProfile("Jane Smith", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg", "Followed by alex_92 + 2..."),
        UserProfile("Mike Ross", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg", "Followed by sarah.k + 5..."),
        UserProfile("Rachel Zane", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg", "Followed by tommy_c + 4..."),
        UserProfile("Harvey Specter", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg", "Followed by donna.p + 3..."),
        UserProfile("Louis Litt", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg", "Followed by harvey_s + 6...")
    )

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Discover People", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = "See All", color = Color.Blue, fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(users.size) { index ->
                val user = users[index]
                Box(modifier = Modifier.width(170.dp)) {
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, Color.LightGray), // Set border color to white
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Surface(
                                shape = CircleShape,
                                modifier = Modifier
                                    .size(120.dp)
                                    .border(2.dp, Color.White, CircleShape), // Profile border white
                                color = Color.LightGray
                            ) {
                                Image(
                                    painter = rememberAsyncImagePainter(user.imageUrl),
                                    contentDescription = "Profile Picture",
                                    contentScale = ContentScale.Crop,
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = user.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = user.followersInfo,
                                fontSize = 14.sp,
                                color = Color.Gray,
                                textAlign = TextAlign.Center // Corrected
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(8.dp),
                                onClick = { /* Follow User */ },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5661E0))
                            ) {
                                Text(text = "Follow", color = Color.White)
                            }
                        }
                    }
                    // Close icon (top-right)
                    IconButton(
                        onClick = { /* Handle remove user logic */ },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Remove",
                            tint = Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}
