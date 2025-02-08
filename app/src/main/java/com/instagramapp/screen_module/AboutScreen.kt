package com.instagramapp.screen_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

@Composable
fun AboutScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Light gray background
    ) {
        // Header Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE91E63)) // Pink background
                .padding(vertical = 3.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://cdn.prod.website-files.com/664884473364719e2c0310a2/664c9443d3277bcccf0df9c6_instagram-text-icon.png"),
                contentDescription = "Instagram Logo",
                modifier = Modifier.size(100.dp)
            )
        }

        // List Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            profiles.forEach { profile ->
                ProfileCard(profile)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Navigation Bar
//        FooterSectionPreview(navController = navController)
    }
}

@Composable
fun ProfileCard(profile: Profile) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Icon
        Image(
            painter = painterResource(id = profile.imageResId), // Use painterResource for profile image
            contentDescription = "Profile Icon",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Text Content
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = profile.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "ID: ${profile.id}",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Text(
                text = "Major: ${profile.major}",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Placeholder Icon (e.g., rating)
        Icon(
            painter = painterResource(android.R.drawable.star_big_on), // Placeholder icon
            contentDescription = "Action Icon",
            tint = Color(0xFFFFC107), // Yellow star color
            modifier = Modifier.size(24.dp)
        )
    }
}
