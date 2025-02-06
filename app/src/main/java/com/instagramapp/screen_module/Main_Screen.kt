package com.instagramapp.screen_module

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.instagramapp.PostScreen

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
//        LoginScreen(navController = navController)
        TopBar(navController = navController)
        StorySection(navController = navController)
        PostScreen(navController = navController)
        FooterSection(navController = navController) // Directly calling FooterSection
    }
}
