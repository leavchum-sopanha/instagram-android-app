package com.instagramapp.screen_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter

@Composable
fun SearchScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    val recentSearches = listOf(
        SearchUserProfile("njz_official", "NJZ", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg"),
        SearchUserProfile("newjeans.hanni", "NEWJEANS HANNI", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg"),
        SearchUserProfile("newjeans_official", "NewJeans", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg", "12.6M followers"),
        SearchUserProfile("0.hanni_", "조한영", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg"),
        SearchUserProfile("flooraaa___", "Flora", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg"),
        SearchUserProfile("yena.jigumina", "최예나", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg", "2.8M followers")
    )

    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        // Search Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchBar()
//            Text(
//                text = "Cancel",
//                color = Color.Blue,
//                modifier = Modifier.clickable { searchQuery = "" }.padding(8.dp)
//            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text("Recent", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.weight(1f))
            Text("See all", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF5661E0))
        }

        // Recent Search List
        Column(modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp)) {

            recentSearches.forEach { profile ->
                Row(
                    modifier = Modifier.fillMaxWidth().clickable { }
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
//                    Surface(
//                        shape = CircleShape,
//                        modifier = Modifier
//                            .size(50.dp)
//                            .border(2.dp, Color.Gray, CircleShape),
//                        color = Color.LightGray
//                    ) {
//                        Image(
//                            painter = rememberImagePainter(profile.avatarUrl),
//                            contentDescription = profile.username,
//                            modifier = Modifier.size(40.dp)
//                                .background(Color.Gray, shape = CircleShape),
//                            contentScale = ContentScale.Crop
//                        )
//                    }
                        Image(
                            painter = rememberImagePainter(profile.avatarUrl),
                            contentDescription = "Profile",
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color.Gray),
                            contentScale = ContentScale.Crop
                        )


                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(text = profile.username, style = MaterialTheme.typography.bodyMedium)
                        profile.extraInfo?.let {
                            Text(text = it, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "✖", modifier = Modifier.clickable { })
                }
            }
        }
    }
}

data class SearchUserProfile(val username: String, val displayName: String, val avatarUrl: String, val extraInfo: String? = null)
