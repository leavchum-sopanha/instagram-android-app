package com.instagramapp.screen_module

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@Composable
fun HomeScreen(navController: NavHostController) {
    val posts = listOf(
        "https://i.pinimg.com/736x/94/38/c8/9438c8b78f397e2442ca0905110d8f0c.jpg",
        "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg",
        "https://i.pinimg.com/736x/a5/f3/10/a5f310a0b4130de23139b0d1d19e410c.jpg",
        "https://i.pinimg.com/736x/d3/f0/29/d3f029e6c10dfd79f36d2147a2ec1c98.jpg",
        "https://i.pinimg.com/736x/f8/0b/c0/f80bc09997706e2da19b5da5a2113a01.jpg"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
//            .padding(bottom = 8.dp)
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