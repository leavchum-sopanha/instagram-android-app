package com.instagramapp.screen_module

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.androidapp_test.ui.theme.DarkBackground
import com.example.androidapp_test.ui.theme.LightBackground
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.instagramapp.R
import com.instagramapp.mvvm_module.ThemeViewModel
import kotlinx.serialization.json.Json

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InboxDetailScreen(navController: NavController, inboxJson: String, themeVM: ThemeViewModel) {
    val backgroundColor = if (themeVM.dark.value) DarkBackground else LightBackground
    val textColor = if (themeVM.dark.value) Color.White else Color.Black
    val secondaryTextColor = if (themeVM.dark.value) Color.LightGray else Color.Gray
    val iconColor = if (themeVM.dark.value) Color.White else Color.Black
    val surfaceColor = if (themeVM.dark.value) Color.DarkGray else Color.White
    val buttonColor = if (themeVM.dark.value) Color(0xFF5661E0) else Color(0xFF5661E0)
    val placeholderColor = if (themeVM.dark.value) Color.DarkGray else Color(0xFFF3F4F6)

    val decodedJson = inboxJson.replace("+", " ")
    val inbox = Json.decodeFromString<Inbox>(decodedJson)

    val messages = remember { inbox.messages.toMutableList() }
    val messageText = remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp), // Remove any padding
                color = backgroundColor
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Outlined.ArrowBack,
                                contentDescription = "Back",
                                tint = iconColor
                            )
                        }
                        AsyncImage(
                            model = inbox.imageRes,
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .border(2.dp, surfaceColor, CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = inbox.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = textColor
                            )
                            Text(
                                text = "${inbox.followers} ${stringResource(R.string.followers)}",
                                fontSize = 12.sp,
                                color = secondaryTextColor
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Outlined.Call,
                            contentDescription = "Call",
                            tint = iconColor
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Icon(
                            imageVector = Icons.Outlined.Videocam,
                            contentDescription = "Video Call",
                            tint = iconColor
                        )
                    }
                }
            }
        },
        containerColor = backgroundColor,
        content = { paddingValues ->
            Column(modifier = Modifier.fillMaxSize().padding(paddingValues).background(backgroundColor)) {
                LazyColumn(modifier = Modifier.weight(1f).padding(horizontal = 8.dp, vertical = 8.dp)) {
                    items(messages.size) { index ->
                        val chat = messages[index]

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = if (chat.sender == "me") Arrangement.End else Arrangement.Start
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        if (chat.sender == "me") buttonColor else placeholderColor,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                                    .padding(12.dp)
                            ) {
                                Text(
                                    text = chat.message,
                                    color = if (chat.sender == "me") Color.White else textColor,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Start
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(backgroundColor)
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        value = messageText.value,
                        onValueChange = { messageText.value = it },
                        modifier = Modifier
                            .weight(1f)
                            .background(placeholderColor, shape = RoundedCornerShape(16.dp))
                            .padding(12.dp),
                        textStyle = TextStyle(fontSize = 16.sp, color = textColor),
                        decorationBox = { innerTextField ->
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                if (messageText.value.isEmpty()) {
                                    Text(
                                        text = "${stringResource(R.string.messages)}...",
                                        color = textColor,
                                        fontSize = 16.sp
                                    )
                                }
                                innerTextField()
                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                        onClick = {
                            if (messageText.value.isNotBlank()) {
                                messages.add(ChatMessage(sender = "me", message = messageText.value, timestamp = "10:10 AM"))
                                messageText.value = ""
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = "Share",
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                                .padding(bottom = 5.dp)
                                .graphicsLayer(rotationZ = -25f)
                        )
                    }
                }
            }
        }
    )
}