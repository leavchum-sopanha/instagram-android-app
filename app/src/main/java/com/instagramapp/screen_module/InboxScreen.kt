package com.instagramapp.screen_module

import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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


@Composable
fun InboxScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        TopMenu(navController)
        Searchbar()
        StorySection(navController)
        MessagesSection()
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
            IconButton(onClick = {
                navController.popBackStack() // Now using the correct navController
            }) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Searchbar() {
    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        placeholder = { Text(text = "Search") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFF3F4F6),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}

@Composable
fun MessagesSection() {
    val inboxes = listOf(
        Inbox(name = "User 1", messagePreview = "Hello, how are you?", imageRes = R.drawable.sopanha, lastSeenDate = "4d"),
        Inbox(name = "User 2", messagePreview = "Where are you?", imageRes = R.drawable.sopanha, lastSeenDate = "2d"),
        Inbox(name = "User 3", messagePreview = "Let's meet later", imageRes = R.drawable.sopanha, lastSeenDate = "1d"),
        Inbox(name = "User 4", messagePreview = "Good morning!", imageRes = R.drawable.sopanha, lastSeenDate = "3d"),
        Inbox(name = "User 5", messagePreview = "Are you there?", imageRes = R.drawable.sopanha, lastSeenDate = "5d")
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text("Messages", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
        Text("Requests", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF5661E0))
    }

    LazyColumn {
        items(inboxes) { user ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = user.imageRes),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.Gray),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(start = 12.dp)) {
                    Text(text = user.name, fontSize = 16.sp)
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = user.messagePreview, fontSize = 12.sp, color = Color.Gray)
                        Spacer(modifier = Modifier.width(3.dp))
                        Icon(
                            imageVector = Icons.Default.Circle,
                            contentDescription = "Camera",
                            tint = Color.LightGray,
                            modifier = Modifier.size(4.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(text = user.lastSeenDate, fontSize = 12.sp, color = Color.Gray)
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Outlined.CameraAlt,
                    contentDescription = "Camera",
                    tint = Color.Gray,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    }
}