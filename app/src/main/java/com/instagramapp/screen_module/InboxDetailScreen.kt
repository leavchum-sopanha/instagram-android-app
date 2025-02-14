package com.instagramapp.screen_module

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
import kotlinx.serialization.json.Json

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun InboxDetailScreen(navController: NavController, inbox: Inbox) {
//    println("Inbox received: $inbox") // Log the received Inbox object
//
//    val messages = remember { inbox.messages.toMutableList() }
//    val messageText = remember { mutableStateOf("") }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(inbox.name) },
//                navigationIcon = {
//                    IconButton(onClick = { navController.popBackStack() }) {
//                        Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "Back")
//                    }
//                }
//            )
//        }
//    ) { paddingValues ->
//        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
//            LazyColumn(modifier = Modifier.weight(1f)) {
//                items(messages) { chat ->
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(8.dp),
//                        horizontalArrangement = if (chat.sender == "me") Arrangement.End else Arrangement.Start
//                    ) {
//                        Text(
//                            text = chat.message,
//                            modifier = Modifier
//                                .background(if (chat.sender == "me") Color.Blue else Color.Gray)
//                                .padding(8.dp),
//                            color = Color.White
//                        )
//                    }
//                }
//            }
//
//            Row(modifier = Modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
//                TextField(
//                    value = messageText.value,
//                    onValueChange = { messageText.value = it },
//                    modifier = Modifier.weight(1f),
//                    placeholder = { Text("Type a message...") }
//                )
//                Button(onClick = {
//                    messages.add(ChatMessage(sender = "me", message = messageText.value, timestamp = "10:10 AM"))
//                    messageText.value = ""
//                }) {
//                    Text("Send")
//                }
//            }
//        }
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InboxDetailScreen(navController: NavController, inboxJson: String) {
    // Decode the JSON string and replace '+' with spaces
    val decodedJson = inboxJson.replace("+", " ")
    val inbox = Json.decodeFromString<Inbox>(decodedJson)

    val messages = remember { inbox.messages.toMutableList() }
    val messageText = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(inbox.name) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(messages) { chat ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = if (chat.sender == "me") Arrangement.End else Arrangement.Start
                    ) {
                        Text(
                            text = chat.message,
                            modifier = Modifier
                                .background(if (chat.sender == "me") Color.Blue else Color.Gray)
                                .padding(8.dp),
                            color = Color.White
                        )
                    }
                }
            }

            Row(modifier = Modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                TextField(
                    value = messageText.value,
                    onValueChange = { messageText.value = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Type a message...") }
                )
                Button(onClick = {
                    messages.add(ChatMessage(sender = "me", message = messageText.value, timestamp = "10:10 AM"))
                    messageText.value = ""
                }) {
                    Text("Send")
                }
            }
        }
    }
}