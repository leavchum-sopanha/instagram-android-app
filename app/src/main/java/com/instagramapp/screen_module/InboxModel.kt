package com.instagramapp.screen_module

import kotlinx.serialization.Serializable

@Serializable
data class Inbox(
    val name: String,
    val messagePreview: String,
    val imageRes: Int,
    val profilePicture: String,
    val followers: Int,
    val lastSeenDate: String,
    val messages: List<ChatMessage>
)
@Serializable
data class ChatMessage(
    val sender: String,
    val message: String,
    val timestamp: String
)