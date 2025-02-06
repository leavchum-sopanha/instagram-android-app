package com.instagramapp.screen_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.material3.Text
import androidx.navigation.NavHostController

@Composable
fun StorySection(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp) // Adds space below the app bar or top
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp), // Horizontal padding for stories
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val stories = listOf(
                Pair("Your story", "https://i.pinimg.com/736x/94/38/c8/9438c8b78f397e2442ca0905110d8f0c.jpg"),
                Pair("magazine", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg"),
                Pair("creators", "https://i.pinimg.com/736x/a5/f3/10/a5f310a0b4130de23139b0d1d19e410c.jpg"),
                Pair("natgeo", "https://i.pinimg.com/736x/9b/8a/15/9b8a155076809a83617455e1b0dfc7a3.jpg"),
                Pair("lasaka", "https://i.pinimg.com/236x/14/7c/8f/147c8fec62a3589d8896b768ee5f4680.jpg")
            )

            items(stories.size) { index ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(
                        shape = CircleShape,
                        modifier = Modifier.size(70.dp),
                        color = Color.LightGray
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(stories[index].second),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(70.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stories[index].first,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.widthIn(max = 70.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun StorySectionpreview(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StorySection(navController = navController) // Pass the navController here
    }
}


