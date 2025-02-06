package com.instagramapp.screen_module

import com.instagramapp.R

data class Profile(
    val imageResId: Int, // Use Int for drawable resource ID
    val name: String,
    val id: String,
    val major: String
)

val profiles = listOf(
    Profile(
        imageResId = R.drawable.photo_panha, // Reference to drawable resource
        name = "Leavchum Sopanha",
        id = "0003838",
        major = "Business IT"
    ),
    Profile(
        imageResId = R.drawable.chanheang,
        name = "Phalla Chanheang",
        id = "0003476",
        major = "Business IT"
    ),
    Profile(
        imageResId = R.drawable.photo_panha,
        name = "Jane Smith",
        id = "0005678",
        major = "Financial Technology"
    )
)
