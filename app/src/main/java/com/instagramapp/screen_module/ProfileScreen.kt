package com.instagramapp.screen_module

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.instagramapp.Screen
import androidx.compose.ui.platform.LocalConfiguration
import com.instagramapp.mvvm_module.LanguageViewModel
import com.instagramapp.mvvm_module.ThemeViewModel
import androidx.compose.ui.res.stringResource
import com.instagramapp.R
import androidx.compose.ui.platform.LocalContext
import com.example.androidapp_test.ui.theme.DarkBackground
import com.example.androidapp_test.ui.theme.DarkSurface
import com.example.androidapp_test.ui.theme.DarkText
import com.example.androidapp_test.ui.theme.LightBackground
import com.example.androidapp_test.ui.theme.LightSurface
import com.example.androidapp_test.ui.theme.LightText
import java.util.Locale

@Composable
fun ProfileScreen(
    navController: NavHostController,
    themeVM: ThemeViewModel,
    languageVM: LanguageViewModel
) {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val backgroundColor = if (themeVM.dark.value) DarkBackground else LightBackground
    val textColor = if (themeVM.dark.value) DarkText else LightText

    // Observe language changes and update the configuration
    LaunchedEffect(languageVM.currentLanguage.value) {
        val locale = Locale(languageVM.currentLanguage.value)
        val config = Configuration(configuration)
        config.setLocale(locale)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item { TopMenuProfile(navController, themeVM, languageVM, textColor, backgroundColor, context) }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { ProfileHeader(languageVM, textColor) }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { ActionButtons(languageVM, textColor) }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { DiscoverPeopleSection(themeVM) }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { StoryHighlights(textColor) }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { ProfileGridLayout(textColor) }
        }
    }
}

@Composable
fun TopMenuProfile(
    navController: NavHostController,
    themeVM: ThemeViewModel,
    languageVM: LanguageViewModel,
    textColor: Color,
    backgroundColor: Color,
    context: Context
) {
    val isMenuExpanded = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "leavchum_sopanha", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = textColor)
        Icon(imageVector = Icons.Outlined.KeyboardArrowDown, contentDescription = "Dropdown", tint = textColor)

        Spacer(modifier = Modifier.weight(1f))

        // Add button
        IconButton(onClick = { navController.navigate(Screen.ADD) }) {
            Icon(imageVector = Icons.Outlined.AddBox, contentDescription = "Add", tint = textColor)
        }

        // Settings button with dropdown menu
        Box {
            IconButton(onClick = { isMenuExpanded.value = !isMenuExpanded.value }) {
                Icon(imageVector = Icons.Outlined.Menu, contentDescription = "Settings", tint = textColor)
            }

            // Dropdown menu
            DropdownMenu(
                expanded = isMenuExpanded.value,
                onDismissRequest = { isMenuExpanded.value = false },
                modifier = Modifier.background(if (themeVM.dark.value) DarkSurface else LightSurface)
            ) {
                // Dark Mode Toggle
                DropdownMenuItem(
                    onClick = {
                        if (themeVM.dark.value) {
                            themeVM.toLightMode()
                        } else {
                            themeVM.toDarkMode()
                        }
                        isMenuExpanded.value = false
                    },
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = if (themeVM.dark.value) "${stringResource(R.string.light_mode)}" else "${stringResource(R.string.dark_mode)}",
                                fontSize = 16.sp,
                                modifier = Modifier.weight(1f),
                                color = textColor)
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                imageVector = if (themeVM.dark.value) Icons.Default.LightMode else Icons.Default.DarkMode,
                                contentDescription = if (themeVM.dark.value) "Light Mode" else "Dark Mode",
                                tint = textColor
                            )
                        }
                    }
                )

                // Language Toggle
                DropdownMenuItem(
                    onClick = {
                        languageVM.switchLanguage(context) // Pass the context here
                        isMenuExpanded.value = false
                    },
                    text = {
                        Text(
                            text = "${stringResource(R.string.switch_language)} (${languageVM.currentLanguage.value})",
                            fontSize = 16.sp,
                            color = textColor)
                    }
                )

                // Logout
                DropdownMenuItem(
                    onClick = {
                        navController.navigate(Screen.LOGIN)
                        isMenuExpanded.value = false
                    },
                    text = {
                        Text(
                            text = stringResource(R.string.log_out),
                            fontSize = 16.sp,
                            color = textColor)
                    }
                )
            }
        }
    }
}

@Composable
fun ProfileHeader(languageVM: LanguageViewModel, textColor: Color) {
    val currentLanguage = languageVM.currentLanguage.value

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .padding(bottom = 16.dp)
            .padding(horizontal = 16.dp)
    ) {
        // Profile Picture
        Surface(
            shape = CircleShape,
            modifier = Modifier
                .size(80.dp)
                .border(1.dp, Color.LightGray, CircleShape),
            color = Color.LightGray
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://scontent.fpnh9-1.fna.fbcdn.net/v/t39.30808-6/464285754_1743384799730720_4287534339148776544_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeEbQMtdsdO19Al06QWU2m5xbjcVGJzFSiBuNxUYnMVKIEQwzIdD-DyBJyK0kLaV64L5l1yaW9A8lWbRtDT9-b1Q&_nc_ohc=LO0bDTL-h2oQ7kNvgGOSNew&_nc_oc=Adj744oFKqfrTBZwxTNlwNW4O9831hHzKpo8NICVykFmT6Axk1FDLRRNROTeJ54fAA8&_nc_zt=23&_nc_ht=scontent.fpnh9-1.fna&_nc_gid=AcPGfyflm564fdcZyXtdNB5&oh=00_AYD5E5nq533JrJtrVWefCHSGHtscGndhXSgFBUeF8SfSwQ&oe=67B28444"),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(70.dp)
            )
        }

        // Posts, Followers, Following
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "9", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = textColor)
            Text(text = stringResource(R.string.posts), fontSize = 16.sp, color = textColor)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "100", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = textColor)
            Text(text = stringResource(R.string.followers), fontSize = 16.sp, color = textColor)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "159", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = textColor)
            Text(text = stringResource(R.string.following), fontSize = 16.sp, color = textColor)
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column {
            Text(text = "Sopanha LEAVCHUM", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = textColor)
            Text(text = "Nothing here!", fontSize = 14.sp, color = textColor)
        }
    }
}

@Composable
fun StoryHighlights(textColor: Color) {
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
                Text(text = years[index], fontSize = 12.sp, color = textColor)
            }
        }
    }
}

@Composable
fun ProfileGridLayout(textColor: Color) {
    val images = listOf(
        "https://scontent.fpnh9-1.fna.fbcdn.net/v/t39.30808-6/467423980_1760677718001428_3031366759025337024_n.jpg?stp=c0.79.720.720a_cp6_dst-jpg_s206x206_tt6&_nc_cat=109&ccb=1-7&_nc_sid=50ad20&_nc_eui2=AeH0opf83yJZalys0GQB0d-s_aLah16I25v9otqHXojbm7rCzuy65yoRLelM5WddgMwaodHdqfRo5v_vWUIlPQtD&_nc_ohc=Ks4v76HKBF8Q7kNvgFLiU9z&_nc_oc=AdixDu_1QUoxtveIgPAH2p2E8MdRuwZ-yQr-4AWsaJ48s4yoCJLDLkjeuz4KW_0Rn3A&_nc_zt=23&_nc_ht=scontent.fpnh9-1.fna&_nc_gid=ASsE4seC0f5HvfluJ52MS14&oh=00_AYCxdDN-e-fW2Z4JT1SnTsP0dkXXSO7DGME9NOlewVcYpw&oe=67B61E68",
        "https://scontent.fpnh9-1.fna.fbcdn.net/v/t39.30808-6/467326376_1760676798001520_2107614633406651451_n.jpg?stp=cp6_dst-jpg_tt6&_nc_cat=101&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeFJcOpnq9-OG1GmR5WXxYmr5ZaQWBeJY0TllpBYF4ljRHQUix1p-U9LYHi9ojMKM2LWmVN4oqYtTXV12x5fEFXw&_nc_ohc=ekt0FKuw9t8Q7kNvgGtl3VP&_nc_oc=AdiRA47oXGH__e458u_A8oxhTd5cwdgmVhS2xcbF59sGMkZiF1bC0aMBJBbN7D_Khpc&_nc_zt=23&_nc_ht=scontent.fpnh9-1.fna&_nc_gid=Amcsp7G949oae77Eo2mUj8H&oh=00_AYAoqJGBKNEeWhCDqMC_IQnlmTuQsVOHib-hSxBXk6TwYA&oe=67B628E8",
        "https://scontent.fpnh9-1.fna.fbcdn.net/v/t39.30808-6/464014567_1741231933279340_9057204410751260605_n.jpg?stp=cp6_dst-jpg_tt6&_nc_cat=107&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeE325vFV0_JBgAj7S4GMVuK25jLgvpwDO_bmMuC-nAM71Xi7Bbxs0iJDGBAx4JXfT9c7iNP-kcrzv5ImVF9n_T6&_nc_ohc=2H7sOiA6MYsQ7kNvgH27Ws5&_nc_oc=AdhVx3KAZZXozsvEw9c0hB8wEzOdSqYDUwF7BYl1zBBYwYUibW2X9yacjOykV7t9V2E&_nc_zt=23&_nc_ht=scontent.fpnh9-1.fna&_nc_gid=Axym9akGIGKj_UO2hpoYmW_&oh=00_AYBq0qm7ww_qc9cdaUbxnk5ooKJLeWkfHHOP1JB0amyWXg&oe=67B61771",
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(imageVector = Icons.Default.GridOn, contentDescription = "Posts", tint = textColor)
            Icon(imageVector = Icons.Default.VideoLibrary, contentDescription = "Videos", tint = textColor)
            Icon(imageVector = Icons.Default.Person, contentDescription = "Tagged", tint = textColor)
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
                            .border(1.dp, Color.LightGray)
                    )
                }
            }
        }
    }
}