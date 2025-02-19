package com.instagramapp.screen_module

import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.ModeEditOutline
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
import com.instagramapp.R
import com.instagramapp.mvvm_module.ThemeViewModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLEncoder

@Composable
fun InboxScreen(navController: NavHostController, themeVM: ThemeViewModel) {
    val backgroundColor = if (themeVM.dark.value) Color.Black else Color.White
    val textColor = if (themeVM.dark.value) Color.White else Color.Black
    val iconColor = if (themeVM.dark.value) Color.White else Color.Black
    val secondaryTextColor = if (themeVM.dark.value) Color.LightGray else Color.Gray
    val surfaceColor = if (themeVM.dark.value) Color.DarkGray else Color.LightGray

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopMenu(navController, iconColor, textColor)
        Box(modifier = Modifier.fillMaxWidth()) {
            SearchBar(themeVM = themeVM)
        }
        StorySection(navController, themeVM = themeVM)
        MessagesSection(navController, textColor, secondaryTextColor, iconColor, surfaceColor)
    }
}

@Composable
fun TopMenu(navController: NavHostController, iconColor: Color, textColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBackIos,
                    contentDescription = "Back",
                    tint = iconColor
                )
            }
            Text(
                text = "sopanhahaha",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /* Handle edit action */ }) {
            Icon(
                imageVector = Icons.Outlined.ModeEditOutline,
                contentDescription = "Edit",
                tint = iconColor
            )
        }
    }
}

@Composable
fun MessagesSection(
    navController: NavHostController,
    textColor: Color,
    secondaryTextColor: Color,
    iconColor: Color,
    surfaceColor: Color
) {
    val inboxes = listOf(
        Inbox(
            name = "phalla_chanheang",
            messagePreview = "I'm good!",
            imageRes = R.drawable.chanheang,
            profilePicture = "https://i.pinimg.com/736x/94/38/c8/9438c8b78f397e2442ca0905110d8f0c.jpg",
            followers = 1200,
            lastSeenDate = "1d",
            messages = listOf(
                ChatMessage("other", "Hello, how are you?", "4d"),
                ChatMessage("me", "I'm good!", "4d")
            )
        ),
        Inbox(
            name = "rath_sopangna",
            messagePreview = "I'm here!",
            imageRes = R.drawable.sopangna,
            profilePicture = "https://i.pinimg.com/736x/94/38/c8/9438c8b78f397e2442ca0905110d8f0c.jpg",
            followers = 800,
            lastSeenDate = "4d",
            messages = listOf(
                ChatMessage("me", "I'm here!", "4d"),
                ChatMessage("other", "Great!", "4d")
            )
        )
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.messages),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(R.string.requests),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5661E0)
        )
    }

    LazyColumn {
        items(inboxes) { inbox ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable {
                        val inboxJson = Json.encodeToString(inbox)
                        navController.navigate("inbox/${URLEncoder.encode(inboxJson, "UTF-8")}")
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = inbox.imageRes),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(surfaceColor)
                        .border(1.dp, surfaceColor, CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(start = 12.dp)) {
                    Text(
                        text = inbox.name,
                        fontSize = 16.sp,
                        color = textColor
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = inbox.messagePreview,
                            fontSize = 12.sp,
                            color = secondaryTextColor
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Icon(
                            imageVector = Icons.Default.Circle,
                            contentDescription = "Time",
                            tint = secondaryTextColor,
                            modifier = Modifier.size(4.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = inbox.lastSeenDate,
                            fontSize = 12.sp,
                            color = secondaryTextColor
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Outlined.CameraAlt,
                    contentDescription = "Camera",
                    tint = iconColor,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    }
}