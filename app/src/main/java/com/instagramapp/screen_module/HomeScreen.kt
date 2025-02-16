package com.instagramapp.screen_module

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.instagramapp.R
import com.instagramapp.mvvm_module.ThemeViewModel

@Composable
fun HomeScreen(navController: NavHostController, themeVM: ThemeViewModel) {
    val posts = listOf(
        Post(
            userName = "phalla_chanheang",
            profileImage = R.drawable.chanheang,
            postImage = "https://scontent.fpnh9-2.fna.fbcdn.net/v/t39.30808-6/469367108_18269623630300153_8408643821212235236_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=127cfc&_nc_eui2=AeGjPLxHhI-aYbam5OoG6ZoQOnynJpSswqU6fKcmlKzCpdqflZWTUc7F411GsBwzOJy7WsJSETLtcbo_Zygd6iWP&_nc_ohc=rDDkBssLCEsQ7kNvgHOg4qI&_nc_oc=Adh-7PCpXWCUjXQlhLKv54rVFVz_9LJG86u2Pi52Quzk2-ds1gtu2qfoQzqqii5LnCw&_nc_zt=23&_nc_ht=scontent.fpnh9-2.fna&_nc_gid=AkToDZs36BZhlZPAjUZRmie&oh=00_AYDkth1StZrQmHqYMGEm19yeMxSIWOqPiFbAFhmA9cm6ZA&oe=67B66F4A",
            description = "Beautiful day 🌅",
            likes = "860K",
            comments = "300",
            shares = "548"
        ),
        Post(
            userName = "rath_sopangna",
            profileImage = R.drawable.sopangna,
            postImage = "https://i.pinimg.com/736x/d3/f0/29/d3f029e6c10dfd79f36d2147a2ec1c98.jpg",
            description = "Morning coffee ☕",
            likes = "123K",
            comments = "200",
            shares = "389"
        ),
        Post(
            userName = "mr_kosal",
            profileImage = R.drawable.kosal,
            postImage = "https://leadschool.in/wp-content/uploads/2022/04/shutterstock_1777292972.jpg",
            description = "Let's code together ☕",
            likes = "123K",
            comments = "200",
            shares = "389"
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            TopBar(navController = navController, themeVM = themeVM)
        }

        item {
            StorySection(navController = navController, themeVM = themeVM)
        }

        items(posts) { post ->
            PostSection(post = post, themeVM)
        }
    }
}