package com.instagramapp.screen_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.VideoLibrary
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.androidapp_test.ui.theme.DarkBackground
import com.example.androidapp_test.ui.theme.LightBackground
import com.instagramapp.Screen
import com.instagramapp.mvvm_module.ThemeViewModel


@Composable
fun FooterSection(navController: NavHostController, themeVM: ThemeViewModel) {
    val iconColor = if (themeVM.dark.value) Color.White else Color.Black
    val backgroundColor = if (themeVM.dark.value) DarkBackground else LightBackground

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(backgroundColor)
            .padding(top = 0.dp, start = 16.dp, end = 32.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { navController.navigate(Screen.HOME) }) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = iconColor,
                modifier = Modifier.size(30.dp)
            )
        }

        IconButton(onClick = { navController.navigate(Screen.SEARCH) }) {
            Icon(
                Icons.Default.Search,
                contentDescription = "Search",
                tint = iconColor,
                modifier = Modifier.size(30.dp)
            )
        }

        IconButton(onClick = { navController.navigate(Screen.ADD) }) {
            Icon(
                imageVector = Icons.Outlined.AddBox,
                contentDescription = "Add",
                tint = iconColor,
                modifier = Modifier.size(30.dp)
            )
        }

        IconButton(
            onClick = { navController.navigate(Screen.PROFILE) },
            modifier = Modifier.size(30.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://scontent.fpnh9-1.fna.fbcdn.net/v/t39.30808-6/464285754_1743384799730720_4287534339148776544_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeEbQMtdsdO19Al06QWU2m5xbjcVGJzFSiBuNxUYnMVKIEQwzIdD-DyBJyK0kLaV64L5l1yaW9A8lWbRtDT9-b1Q&_nc_ohc=LO0bDTL-h2oQ7kNvgGOSNew&_nc_oc=Adj744oFKqfrTBZwxTNlwNW4O9831hHzKpo8NICVykFmT6Axk1FDLRRNROTeJ54fAA8&_nc_zt=23&_nc_ht=scontent.fpnh9-1.fna&_nc_gid=AcPGfyflm564fdcZyXtdNB5&oh=00_AYD5E5nq533JrJtrVWefCHSGHtscGndhXSgFBUeF8SfSwQ&oe=67B28444"),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(30.dp)
                    .border(2.dp, if (themeVM.dark.value) Color.DarkGray else Color.Gray, CircleShape) // Use theme-aware border color
            )
        }
    }
}