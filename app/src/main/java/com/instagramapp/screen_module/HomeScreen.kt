package com.instagramapp.screen_module

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@Composable
fun HomeScreen(navController: NavHostController) {
    val posts = listOf(
        Post(
            userName = "chendaloeut",
            profileImage = "https://i.pinimg.com/736x/a5/f3/10/a5f310a0b4130de23139b0d1d19e410c.jpg",
            postImage = "https://i.pinimg.com/736x/94/38/c8/9438c8b78f397e2442ca0905110d8f0c.jpg",
            description = "Beautiful sunset view 🌅",
            likes = "860K",
            comments = "300",
            shares = "548"
        ),
        Post(
            userName = "sokha_lifestyle",
            profileImage = "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg",
            postImage = "https://i.pinimg.com/736x/d3/f0/29/d3f029e6c10dfd79f36d2147a2ec1c98.jpg",
            description = "Morning coffee ☕",
            likes = "123K",
            comments = "200",
            shares = "389"
        ),
        Post(
            userName = "chendaloeut",
            profileImage = "https://i.pinimg.com/736x/a5/f3/10/a5f310a0b4130de23139b0d1d19e410c.jpg",
            postImage = "https://i.pinimg.com/736x/94/38/c8/9438c8b78f397e2442ca0905110d8f0c.jpg",
            description = "Beautiful sunset view 🌅",
            likes = "860K",
            comments = "300",
            shares = "548"
        ),
        Post(
            userName = "sokha_lifestyle",
            profileImage = "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg",
            postImage = "https://i.pinimg.com/736x/d3/f0/29/d3f029e6c10dfd79f36d2147a2ec1c98.jpg",
            description = "Morning coffee ☕",
            likes = "123K",
            comments = "200",
            shares = "389"
        )

    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            TopBar(navController = navController)
        }

        item {
            StorySection(navController = navController)
        }

        items(posts) { post ->
            PostSection(post = post)
        }
    }
}
