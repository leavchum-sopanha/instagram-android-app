package com.instagramapp.screen_module

import com.instagramapp.R

data class Profile(
    val imageResId: Int,
    val name: String,
    val id: String,
    val major: String
)

val profiles = listOf(
    Profile(
        imageResId = R.drawable.sopanha,
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
        imageResId = R.drawable.sopangna,
        name = "Rath Sopangna",
        id = "0005678",
        major = "Financial Technology"
    )
)
