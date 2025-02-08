package com.instagramapp.screen_module

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.instagramapp.Screen

@Composable
fun FooterSection(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .background(Color.Red)
            .height(56.dp)
            .padding(top = 0.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { navController.navigate(Screen.HOME) }) {
            Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black)
        }
        IconButton(onClick = { navController.navigate(Screen.SEARCH) }) {
            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Black)
        }
        IconButton(onClick = { navController.navigate("add_screen") }) {
            Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.Black)
        }
        IconButton(onClick = { navController.navigate("favorite_screen") }) {
            Icon(Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.Black)
        }
        IconButton(onClick = { navController.navigate("profile_screen") }) {
            Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.Black)
        }
    }
}

@Composable
fun FooterSectionPreview(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Your main content goes here
            Box(modifier = Modifier.weight(1f)) {
                // Main content
            }
            FooterSection(navController = navController) // Pass navController here
        }
    }
}
