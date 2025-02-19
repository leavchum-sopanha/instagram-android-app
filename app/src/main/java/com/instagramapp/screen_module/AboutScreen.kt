package com.instagramapp.screen_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidapp_test.ui.theme.DarkBackground
import com.example.androidapp_test.ui.theme.DarkSurface
import com.example.androidapp_test.ui.theme.DarkText
import com.instagramapp.R
import com.instagramapp.mvvm_module.ThemeViewModel

@Composable
fun AboutScreen(navController: NavHostController, themeVM: ThemeViewModel) {
    val backgroundColor = if (themeVM.dark.value) DarkBackground else Color(0xFFF5F5F5)
    val textColor = if (themeVM.dark.value) DarkText else Color.Black
    val cardColor = if (themeVM.dark.value) DarkSurface else Color.White
    val iconColor = if (themeVM.dark.value) Color.White else Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xFFE91E63))
                .padding(vertical = 3.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Like",
                    tint = Color.White,
                    modifier = Modifier
                        .size(28.dp)
                        .padding(end = 3.dp)
                )

                Text(
                    stringResource(R.string.our_team_members),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Like",
                    tint = Color.White,
                    modifier = Modifier
                        .size(28.dp)
                        .padding(start = 3.dp)
                )
            }
        }

        // List Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            profiles.forEach { profile ->
                ProfileCard(themeVM, profile, cardColor, textColor, iconColor)
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ProfileCard(themeVM: ThemeViewModel, profile: Profile, cardColor: Color, textColor: Color, iconColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(cardColor, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Icon
        Image(
            painter = painterResource(id = profile.imageResId),
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
                color = textColor
            )
            Text(
                text = "ID: ${profile.id}",
                fontSize = 14.sp,
                color = if (themeVM.dark.value) Color.LightGray else Color.Gray
            )
            Text(
                text = "Major: ${profile.major}",
                fontSize = 14.sp,
                color = if (themeVM.dark.value) Color.LightGray else Color.Gray
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Placeholder Icon (e.g., rating)
        Icon(
            painter = painterResource(android.R.drawable.star_big_on), // Placeholder icon
            contentDescription = "Action Icon",
            tint = Color(0xFFFFC107),
            modifier = Modifier.size(24.dp)
        )
    }
}