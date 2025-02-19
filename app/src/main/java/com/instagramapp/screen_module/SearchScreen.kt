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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.instagramapp.R
import com.instagramapp.mvvm_module.ThemeViewModel

@Composable
fun SearchScreen(navController: NavHostController, themeVM: ThemeViewModel) {
    // Determine colors based on the theme
    val backgroundColor = if (themeVM.dark.value) Color.Black else Color.White
    val textColor = if (themeVM.dark.value) Color.White else Color.Black
    val surfaceColor = if (themeVM.dark.value) Color.DarkGray else Color.LightGray
    val iconColor = if (themeVM.dark.value) Color.White else Color.Black
    val secondaryTextColor = if (themeVM.dark.value) Color.LightGray else Color.Gray

    var searchQuery by remember { mutableStateOf("") }
    val recentSearches = listOf(
        SearchUserProfile("njz_official", "NJZ", "https://images.lifestyleasia.com/wp-content/uploads/sites/2/2023/03/07151004/press-release-photo-1-1-576x806-1.jpeg"),
        SearchUserProfile("newjeans.hanni", "NEWJEANS HANNI", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg"),
        SearchUserProfile("newjeans_official", "NewJeans", "https://www.coca-cola.com/content/dam/onexp/in/en/offerings/coke-studio/artists/NEW_JEANS_GROUP_01_WORKING_1-1.jpg", "12.6M followers"),
        SearchUserProfile("0.hanni_", "조한영", "https://i.pinimg.com/736x/a5/f3/10/a5f310a0b4130de23139b0d1d19e410c.jpg"),
        SearchUserProfile("flooraaa___", "Flora", "https://hips.hearstapps.com/hmg-prod/images/sacred-lotus-gettyimages-1143403162-646fa5a441f5d.jpg?crop=0.535xw:1.00xh;0.0519xw,0&resize=980:*"),
        SearchUserProfile("yena.jigumina", "최예나", "https://i.pinimg.com/236x/14/7c/8f/147c8fec62a3589d8896b768ee5f4680.jpg", "2.8M followers")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Search Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchBar(themeVM = themeVM)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.recent),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(R.string.see_all),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5661E0)
            )
        }

        // Recent Search List
        Column(modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp)) {
            recentSearches.forEach { profile ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { }
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberImagePainter(profile.avatarUrl),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(surfaceColor),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = profile.username,
                            style = MaterialTheme.typography.bodyMedium,
                            color = textColor
                        )
                        profile.extraInfo?.let {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.bodySmall,
                                color = secondaryTextColor
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "✖",
                        color = iconColor,
                        modifier = Modifier.clickable { }
                    )
                }
            }
        }
    }
}

data class SearchUserProfile(val username: String, val displayName: String, val avatarUrl: String, val extraInfo: String? = null)
