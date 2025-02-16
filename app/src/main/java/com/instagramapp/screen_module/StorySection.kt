package com.instagramapp.screen_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.instagramapp.R
import com.instagramapp.mvvm_module.ThemeViewModel

@Composable
fun StorySection(navController: NavHostController, themeVM: ThemeViewModel) {
    val yourStoryText = stringResource(R.string.your_story) // Move stringResource here

    val textColor = if (themeVM.dark.value) Color.White else Color.Black
    val borderColor = if (themeVM.dark.value) Color.DarkGray else Color.LightGray
    val surfaceColor = if (themeVM.dark.value) Color.DarkGray else Color.LightGray

    val stories = listOf(
        Pair(yourStoryText, "https://scontent.fpnh9-1.fna.fbcdn.net/v/t39.30808-6/..."),
        Pair("magazine", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg"),
        Pair("creators", "https://i.pinimg.com/736x/a5/f3/10/a5f310a0b4130de23139b0d1d19e410c.jpg"),
        Pair("natgeo", "https://i.pinimg.com/736x/9b/8a/15/9b8a155076809a83617455e1b0dfc7a3.jpg"),
        Pair("lasaka", "https://i.pinimg.com/236x/14/7c/8f/147c8fec62a3589d8896b768ee5f4680.jpg"),
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp)
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(stories.size) { index ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(
                        start = if (index == 0) 16.dp else 0.dp,
                        end = if (index == stories.size - 1) 16.dp else 0.dp
                    )
                ) {
                    Surface(
                        shape = CircleShape,
                        modifier = Modifier
                            .size(70.dp)
                            .border(1.dp, borderColor, CircleShape),
                        color = surfaceColor
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
                        color = textColor,
                        modifier = Modifier.widthIn(max = 70.dp)
                    )
                }
            }
        }
    }
}
