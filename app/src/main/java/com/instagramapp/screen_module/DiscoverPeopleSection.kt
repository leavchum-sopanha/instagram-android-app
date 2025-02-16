package com.instagramapp.screen_module

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.androidapp_test.ui.theme.DarkBackground
import com.example.androidapp_test.ui.theme.DarkSurface
import com.example.androidapp_test.ui.theme.DarkText
import com.example.androidapp_test.ui.theme.LightBackground
import com.example.androidapp_test.ui.theme.LightSurface
import com.example.androidapp_test.ui.theme.LightText
import com.instagramapp.R
import com.instagramapp.mvvm_module.ThemeViewModel

data class UserProfile(
    val name: String,
    val imageUrl: String,
    val followersInfo: String
)

@Composable
fun DiscoverPeopleSection(themeVM: ThemeViewModel) {
    val users = listOf(
        UserProfile("John Doe", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS88D2cTGWYgyj_LoqhAkDtzHw1Q28znf-7rg&s", "Followed by heang_eries + 3..."),
        UserProfile("Jane Smith", "https://images.pexels.com/photos/1704488/pexels-photo-1704488.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500", "Followed by alex_92 + 2..."),
        UserProfile("Mike Ross", "https://wallpapers.com/images/hd/cool-profile-picture-paper-bag-head-4co57dtwk64fb7lv.jpg", "Followed by sarah.k + 5..."),
        UserProfile("Rachel Zane", "https://images.unsplash.com/photo-1529665253569-6d01c0eaf7b6?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8cHJvZmlsZXxlbnwwfHwwfHx8MA%3D%3D", "Followed by tommy_c + 4..."),
        UserProfile("Harvey Specter", "https://images.ctfassets.net/h6goo9gw1hh6/2sNZtFAWOdP1lmQ33VwRN3/24e953b920a9cd0ff2e1d587742a2472/1-intro-photo-final.jpg?w=1200&h=992&fl=progressive&q=70&fm=jpg", "Followed by donna.p + 3..."),
        UserProfile("Louis Litt", "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg", "Followed by harvey_s + 6...")
    )

    val backgroundColor = if (themeVM.dark.value) DarkBackground else LightBackground
    val textColor = if (themeVM.dark.value) DarkText else LightText
    val cardColor = if (themeVM.dark.value) DarkSurface else LightSurface
    val borderColor = if (themeVM.dark.value) Color.DarkGray else Color.LightGray

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text  = stringResource(R.string.discover_people),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = textColor
            )
            Text(
                text = stringResource(R.string.see_all),
                color = Color.Blue,
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(users.size) { index ->
                val user = users[index]
                Box(modifier = Modifier.width(170.dp)) {
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, borderColor), // Use theme-aware border color
                        colors = CardDefaults.cardColors(containerColor = cardColor), // Use theme-aware card color
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Surface(
                                shape = CircleShape,
                                modifier = Modifier
                                    .size(120.dp)
                                    .border(2.dp, borderColor, CircleShape), // Use theme-aware border color
                                color = Color.LightGray
                            ) {
                                Image(
                                    painter = rememberAsyncImagePainter(user.imageUrl),
                                    contentDescription = "Profile Picture",
                                    contentScale = ContentScale.Crop,
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = user.name,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = textColor // Use theme-aware text color
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = user.followersInfo,
                                fontSize = 14.sp,
                                color = if (themeVM.dark.value) Color.LightGray else Color.Gray, // Use theme-aware text color
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(8.dp),
                                onClick = { /* Follow User */ },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5661E0)) // Keep button color consistent
                            ) {
                                Text(text = stringResource(R.string.follow), color = Color.White)
                            }
                        }
                    }
                    // Close icon (top-right)
                    IconButton(
                        onClick = { /* Handle remove user logic */ },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Remove",
                            tint = if (themeVM.dark.value) Color.LightGray else Color.Gray, // Use theme-aware icon color
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}