package com.instagramapp.screen_module

import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ModeEditOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.instagramapp.Screen

@Composable
fun ProfileScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item { TopMenu() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { ProfileHeader() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { ActionButtons() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { DiscoverPeopleSection() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { StoryHighlights() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { ProfileGridLayout() }
    }
}

@Composable
fun TopMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "sopanhahaha", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Icon(imageVector = Icons.Outlined.KeyboardArrowDown, contentDescription = "Dropdown")

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = { /* Handle edit action */ }) {
            Icon(imageVector = Icons.Outlined.AddBox, contentDescription = "Add")
        }
        IconButton(onClick = { /* Handle edit action */ }) {
            Icon(imageVector = Icons.Outlined.Menu, contentDescription = "Setting")
        }
    }
}

@Composable
fun ProfileHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .padding(bottom =  16.dp)
            .padding(horizontal = 16.dp)
    ) {
        Surface(
            shape = CircleShape,
            modifier = Modifier
                .size(80.dp)
                .border(2.dp, Color.Gray, CircleShape),
            color = Color.LightGray
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://scontent.fpnh9-1.fna.fbcdn.net/v/t39.30808-6/464285754_1743384799730720_4287534339148776544_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeEbQMtdsdO19Al06QWU2m5xbjcVGJzFSiBuNxUYnMVKIEQwzIdD-DyBJyK0kLaV64L5l1yaW9A8lWbRtDT9-b1Q&_nc_ohc=LO0bDTL-h2oQ7kNvgGOSNew&_nc_oc=Adj744oFKqfrTBZwxTNlwNW4O9831hHzKpo8NICVykFmT6Axk1FDLRRNROTeJ54fAA8&_nc_zt=23&_nc_ht=scontent.fpnh9-1.fna&_nc_gid=AcPGfyflm564fdcZyXtdNB5&oh=00_AYD5E5nq533JrJtrVWefCHSGHtscGndhXSgFBUeF8SfSwQ&oe=67B28444"),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(70.dp)
            )
        }

        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "9", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "posts", fontSize = 16.sp,)
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "100", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "followers", fontSize = 16.sp,)
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "159", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "following", fontSize = 16.sp,)
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column {
            Text(text = "Sopanha LEAVCHUM", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = "Nothing here!", fontSize = 14.sp)
        }

    }
}

@Composable
fun ActionButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        OutlinedButton(
            onClick = { /* Edit Profile Action */ },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Edit Profile", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedButton(
            onClick = { /* Share Profile Action */ },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Share Profile", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun StoryHighlights() {
    val years = listOf("2025\uD83C\uDF89", "2024\uD83E\uDEF6", "2023\uD83E\uDD1F")
    val imageUrls = listOf(
        "https://instagram.fpnh18-3.fna.fbcdn.net/v/t15.5256-10/472172722_958287419542765_3936859893918799611_n.jpg?stp=c0.90.1080.1080a_dst-jpg_e15_s150x150_tt6&_nc_ht=instagram.fpnh18-3.fna.fbcdn.net&_nc_cat=101&_nc_oc=Q6cZ2AFbifvdeaRm_mdBdYV7-s2gxaOShcS0i5exK4jUAr_VZIFWlZQkuaAICV_xAqLIMnw&_nc_ohc=Tw7F3keRP2UQ7kNvgHqTLc7&_nc_gid=645a97025b30414797b398d69bcb9238&edm=AGXveE0AAAAA&ccb=7-5&oh=00_AYDUAhPm4zPRwkNBSiMKjIO4tPTfM0dfCl_VwKgFlVNgkw&oe=67B35FB9&_nc_sid=522435",
        "https://instagram.fpnh18-3.fna.fbcdn.net/v/t51.29350-15/418669407_902195381430047_4405013305901129605_n.jpg?stp=c0.483.1242.1242a_dst-jpg_e35_s150x150_tt6&_nc_ht=instagram.fpnh18-3.fna.fbcdn.net&_nc_cat=111&_nc_oc=Q6cZ2AFbifvdeaRm_mdBdYV7-s2gxaOShcS0i5exK4jUAr_VZIFWlZQkuaAICV_xAqLIMnw&_nc_ohc=vlVEwB3UvVoQ7kNvgEzWJIg&_nc_gid=645a97025b30414797b398d69bcb9238&edm=AGXveE0BAAAA&ccb=7-5&oh=00_AYCwOEHb5ZpEGua_f9Q_VKs39sMrT_US8CP0ImaewceMCw&oe=67B36C52&_nc_sid=522435",
        "https://instagram.fpnh18-1.fna.fbcdn.net/v/t51.29350-15/414468907_876323707463124_1099333788208306737_n.jpg?stp=c0.483.1242.1242a_dst-jpg_e35_s150x150_tt6&_nc_ht=instagram.fpnh18-1.fna.fbcdn.net&_nc_cat=100&_nc_oc=Q6cZ2AFbifvdeaRm_mdBdYV7-s2gxaOShcS0i5exK4jUAr_VZIFWlZQkuaAICV_xAqLIMnw&_nc_ohc=V0X1Q0fSCK4Q7kNvgGSFRj2&_nc_gid=645a97025b30414797b398d69bcb9238&edm=AGXveE0BAAAA&ccb=7-5&oh=00_AYBAKGuGI4W8s8k6MVcs1v-Ia0YCqyYCWKHMEvi6_x-Idg&oe=67B33BA1&_nc_sid=522435"
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(years.size) { index ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Surface(
                    shape = CircleShape,
                    modifier = Modifier
                        .size(70.dp)
                        .border(2.dp, Color.Gray, CircleShape),
                    color = Color.LightGray
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(imageUrls[index]),
                        contentDescription = "Story Highlight",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(70.dp).clip(CircleShape)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = years[index], fontSize = 12.sp)
            }
        }
    }
}


@Composable
fun ProfileGridLayout() {
    val images = listOf(
        "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg",
        "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg",
        "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg",
        "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg",
        "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg",
        "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg",
        "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg",
        "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg",
        "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg"
    )

    Column(
        modifier = Modifier.
            fillMaxWidth()
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 16.dp)
            ,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(imageVector = Icons.Default.GridOn, contentDescription = "Posts")
            Icon(imageVector = Icons.Default.VideoLibrary, contentDescription = "Videos")
            Icon(imageVector = Icons.Default.Person, contentDescription = "Tagged")
        }

        val rows = images.chunked(3)
        for (row in rows) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (imageUrl in row) {
                    Image(
                        painter = rememberAsyncImagePainter(imageUrl),
                        contentDescription = "Profile Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
//                            .padding(1.dp) // Optional padding
//                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, Color.LightGray)
                    )
                }
            }
        }
    }
}