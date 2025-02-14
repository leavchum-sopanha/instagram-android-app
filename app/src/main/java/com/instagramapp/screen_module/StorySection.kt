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
import androidx.navigation.NavHostController

@Composable
fun StorySection(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val stories = listOf(
                Pair("Your story", "https://scontent.fpnh9-1.fna.fbcdn.net/v/t39.30808-6/464285754_1743384799730720_4287534339148776544_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeEbQMtdsdO19Al06QWU2m5xbjcVGJzFSiBuNxUYnMVKIEQwzIdD-DyBJyK0kLaV64L5l1yaW9A8lWbRtDT9-b1Q&_nc_ohc=LO0bDTL-h2oQ7kNvgGOSNew&_nc_oc=Adj744oFKqfrTBZwxTNlwNW4O9831hHzKpo8NICVykFmT6Axk1FDLRRNROTeJ54fAA8&_nc_zt=23&_nc_ht=scontent.fpnh9-1.fna&_nc_gid=AcPGfyflm564fdcZyXtdNB5&oh=00_AYD5E5nq533JrJtrVWefCHSGHtscGndhXSgFBUeF8SfSwQ&oe=67B28444"),
                Pair("magazine", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg"),
                Pair("creators", "https://i.pinimg.com/736x/a5/f3/10/a5f310a0b4130de23139b0d1d19e410c.jpg"),
                Pair("natgeo", "https://i.pinimg.com/736x/9b/8a/15/9b8a155076809a83617455e1b0dfc7a3.jpg"),
                Pair("lasaka", "https://i.pinimg.com/236x/14/7c/8f/147c8fec62a3589d8896b768ee5f4680.jpg"),
            )

            items(stories.size) { index ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(
                            start = if (index == 0) 16.dp else 0.dp,
                            end = if (index == stories.size - 1) 16.dp else 0.dp
                        )
                ) {
                    Surface(
                        shape = CircleShape,
                        modifier = Modifier.size(70.dp).border(1.dp, Color.LightGray, CircleShape),
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

//@Composable
//fun StorySectionpreview(navController: NavHostController) {
//    Column(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        StorySection(navController = navController) // Pass the navController here
//    }
//}


