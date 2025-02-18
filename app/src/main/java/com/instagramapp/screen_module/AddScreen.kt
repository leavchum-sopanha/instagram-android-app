package com.instagramapp.screen_module

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.instagramapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen() {
    val imageList = listOf(
        "https://images.unsplash.com/photo-1473172707857-f9e276582ab6?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fGxvb2tpbmd8ZW58MHx8MHx8fDA%3D",
        "https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png",
        "https://cdn.pixabay.com/photo/2014/05/02/12/47/night-335981_640.jpg",
        "https://create.microsoft.com/_next/image?url=https%3A%2F%2Fcdn.create.microsoft.com%2Fimages%2Fimage-creator-T03_cat.webp&w=1920&q=90",
        "https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?cs=srgb&dl=pexels-souvenirpixels-414612.jpg&fm=jpg",
        "https://t3.ftcdn.net/jpg/09/46/81/06/360_F_946810623_GQAbziz1yQTSzNskJwZhdkzCxY9OrcZn.jpg",
        "https://freerangestock.com/sample/111717/person-sitting-on-hill-near-ocean.jpg",
        "https://us.123rf.com/450wm/thevisualsyouneed/thevisualsyouneed1810/thevisualsyouneed181000427/109561289-silhouette-of-young-happy-and-attractive-african-american-runner-woman-exercising-in-running-fitness.jpg?ver=6",
        "https://images.pexels.com/photos/29677897/pexels-photo-29677897/free-photo-of-stunning-beach-sunset-over-tranquil-sea.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
        "https://imagekit.io/blog/content/images/2019/12/image-optimization.jpg",
        "https://static.mywebsites360.com/f6744469750742cba21abbfc64f2fdd0/i/c61ec43e3f1849ffa1860058701253fb/3/4SoifmQp45JMgBnHp7ed2/The%20Why%20and%20How%20of%20Image%20Optimization%20Thumb.jpg",
        "https://www.vinaescuderos.com/wp-content/uploads/2022/06/pexels.png",)

    var selectedImage by remember { mutableStateOf(imageList.firstOrNull()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                tint = Color.White,
                modifier = Modifier
                    .clickable { /* Handle close action */ }
            )

            Text(
                stringResource(R.string.new_post),
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )

            Text(
                stringResource(R.string.next),
                color = Color.Blue,
                fontSize = 18.sp,
                modifier = Modifier
                    .clickable { /* Handle next action */ }
            )
        }

        // Image Preview
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.DarkGray),
            contentAlignment = Alignment.Center
        ) {
            selectedImage?.let {
                Image(
                    painter = rememberAsyncImagePainter(it),
                    contentDescription = "Selected Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } ?: Text("No Image Selected", color = Color.White)
        }

        // Recent Images Section
        Text(
            text = stringResource(R.string.recent),
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            items(imageList) { imageUrl ->
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .padding(1.dp)
                        .background(Color.DarkGray)
                        .clickable { selectedImage = imageUrl }
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(imageUrl),
                        contentDescription = "Recent Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
