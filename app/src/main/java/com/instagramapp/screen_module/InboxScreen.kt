package com.instagramapp.screen_module

import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.instagramapp.R
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLEncoder

@Composable
fun InboxScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        TopMenu(navController)
        Box(modifier = Modifier.fillMaxWidth()) {
            SearchBar()
        }
        StorySection(navController)
        MessagesSection(navController)
    }
}

@Composable
fun TopMenu(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Outlined.ArrowBackIos, contentDescription = "Back")
            }
            Text(text = "sopanhahaha", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /* Handle edit action */ }) {
            Icon(imageVector = Icons.Outlined.ModeEditOutline, contentDescription = "Edit")
        }
    }
}

@Composable
fun MessagesSection(navController: NavHostController) {
    val inboxes = listOf(
        Inbox(
            name = "User 1",
            messagePreview = "Hello, how are you?",
            imageRes = R.drawable.sopanha,
            lastSeenDate = "4d",
            messages = listOf(
                ChatMessage("other", "Hello, how are you?", "4d"),
                ChatMessage("me", "I'm good!", "4d")
            )
        ),
        Inbox(
            name = "User 2",
            messagePreview = "Where are you?",
            imageRes = R.drawable.sopanha,
            lastSeenDate = "2d",
            messages = listOf(
                ChatMessage("me", "I'm here!", "2d"),
                ChatMessage("other", "Great!", "2d")
            )
        )
    )

    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        Text("Messages", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
        Text("Requests", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF5661E0))
    }

    LazyColumn {
        items(inboxes) { inbox ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable {
                        // Encode the Inbox object as JSON
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
                        .background(Color.Gray),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(start = 12.dp)) {
                    Text(text = inbox.name, fontSize = 16.sp)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = inbox.messagePreview, fontSize = 12.sp, color = Color.Gray)
                        Spacer(modifier = Modifier.width(3.dp))
                        Icon(imageVector = Icons.Default.Circle, contentDescription = "Time", tint = Color.LightGray, modifier = Modifier.size(4.dp))
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(text = inbox.lastSeenDate, fontSize = 12.sp, color = Color.Gray)
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.Outlined.CameraAlt, contentDescription = "Camera", tint = Color.Gray, modifier = Modifier.size(25.dp))
            }
        }
    }
}