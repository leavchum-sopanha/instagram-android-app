package com.instagramapp.screen_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.instagramapp.R
import com.instagramapp.mvvm_module.ThemeViewModel

@Composable
fun NotificationScreen(navController: NavController, themeVM: ThemeViewModel) {
    // Determine colors based on the theme
    val backgroundColor = if (themeVM.dark.value) Color.Black else Color.White
    val textColor = if (themeVM.dark.value) Color.White else Color.Black
    val surfaceColor = if (themeVM.dark.value) Color.DarkGray else Color.LightGray
    val iconColor = if (themeVM.dark.value) Color.White else Color.Black
    val buttonColor = if (themeVM.dark.value) Color(0xFF5661E0) else Color(0xFF5661E0)

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            NotificationHeader(navController, iconColor, textColor)
        }

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            SectionHeader(stringResource(R.string.yesterday), textColor)
            NotificationItem(
                username = "phchorng and iam_unaaaa",
                action = "shared notes",
                time = "11h",
                imageUrl = "https://scontent.fpnh9-1.fna.fbcdn.net/v/t39.30808-6/464285754_1743384799730720_4287534339148776544_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeEbQMtdsdO19Al06QWU2m5xbjcVGJzFSiBuNxUYnMVKIEQwzIdD-DyBJyK0kLaV64L5l1yaW9A8lWbRtDT9-b1Q&_nc_ohc=LO0bDTL-h2oQ7kNvgGOSNew&_nc_oc=Adj744oFKqfrTBZwxTNlwNW4O9831hHzKpo8NICVykFmT6Axk1FDLRRNROTeJ54fAA8&_nc_zt=23&_nc_ht=scontent.fpnh9-1.fna&_nc_gid=AcPGfyflm564fdcZyXtdNB5&oh=00_AYD5E5nq533JrJtrVWefCHSGHtscGndhXSgFBUeF8SfSwQ&oe=67B28444",
                textColor = textColor,
                isFollowButton = false,
                buttonColor = buttonColor
            )
            NotificationItem(
                username = "tuxglobalinstitute",
                action = "added a photo to their story",
                time = "14h",
                imageUrl = "https://i.pinimg.com/736x/94/38/c8/9438c8b78f397e2442ca0905110d8f0c.jpg",
                textColor = textColor,
                isFollowButton = false,
                buttonColor = buttonColor
            )
            SectionHeader(stringResource(R.string.last_7_days), textColor)
            NotificationItem(
                username = "rathapich_",
                action = "posted a thread you might like:",
                time = "2d",
                imageUrl = "https://scontent.fpnh9-1.fna.fbcdn.net/v/t39.30808-6/464285754_1743384799730720_4287534339148776544_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeEbQMtdsdO19Al06QWU2m5xbjcVGJzFSiBuNxUYnMVKIEQwzIdD-DyBJyK0kLaV64L5l1yaW9A8lWbRtDT9-b1Q&_nc_ohc=LO0bDTL-h2oQ7kNvgGOSNew&_nc_oc=Adj744oFKqfrTBZwxTNlwNW4O9831hHzKpo8NICVykFmT6Axk1FDLRRNROTeJ54fAA8&_nc_zt=23&_nc_ht=scontent.fpnh9-1.fna&_nc_gid=AcPGfyflm564fdcZyXtdNB5&oh=00_AYD5E5nq533JrJtrVWefCHSGHtscGndhXSgFBUeF8SfSwQ&oe=67B28444",
                textColor = textColor,
                isFollowButton = false,
                buttonColor = buttonColor
            )
            NotificationItem(
                username = "Li Sundika, Chan Veasna Neang",
                action = "shared 14 photos.",
                time = "4d",
                imageUrl = "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg",
                textColor = textColor,
                isFollowButton = false,
                buttonColor = buttonColor
            )
            NotificationItem(
                username = "li_sdika_",
                action = "just shared a post.",
                time = "4d",
                imageUrl = "https://i.pinimg.com/736x/a5/f3/10/a5f310a0b4130de23139b0d1d19e410c.jpg",
                textColor = textColor,
                isFollowButton = false,
                buttonColor = buttonColor
            )
            NotificationItem(
                username = "pheach.phearom.1",
                action = "who you might know, is on Instagram.",
                time = "5d",
                imageUrl = "https://i.pinimg.com/736x/9b/8a/15/9b8a155076809a83617455e1b0dfc7a3.jpg",
                textColor = textColor,
                isFollowButton = true,
                buttonColor = buttonColor
            )
        }
    }
}

@Composable
fun NotificationItem(
    username: String,
    action: String,
    time: String,
    imageUrl: String,
    textColor: Color,
    isFollowButton: Boolean = false,
    buttonColor: Color
) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier.size(48.dp).clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "$username $action",
                fontSize = 14.sp,
                color = textColor
            )
            Text(
                text = time,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        if (isFollowButton) {
            Button(
                shape = RoundedCornerShape(8.dp),
                onClick = { /* Follow User */ },
                colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
            ) {
                Text(text = stringResource(R.string.follow), color = Color.White)
            }
        }
    }
}

@Composable
fun NotificationHeader(navController: NavController, iconColor: Color, textColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowLeft,
                contentDescription = "Back",
                tint = iconColor
            )
        }
        Text(
            text = stringResource(R.string.notification),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}

@Composable
fun SectionHeader(title: String, textColor: Color) {
    Text(
        text = title,
        fontSize = 16.sp,
        modifier = Modifier.padding(vertical = 8.dp),
        color = textColor
    )
}
