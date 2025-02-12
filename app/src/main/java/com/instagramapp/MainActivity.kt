package com.instagramapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.instagramapp.PostScreen
import com.instagramapp.screen_module.AboutScreen
import com.instagramapp.screen_module.FooterSection
import com.instagramapp.screen_module.HomeScreen
import com.instagramapp.screen_module.InboxScreen
//import com.instagramapp.screen_module.PostSection
import com.instagramapp.screen_module.LoginScreen
import com.instagramapp.screen_module.ProfileScreen
import com.instagramapp.screen_module.SearchScreen
import com.instagramapp.screen_module.StorySection
import com.instagramapp.screen_module.StorySectionpreview
import com.instagramapp.screen_module.TopBar
import com.instagramapp.ui.theme.InstagramAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            LoginPreview()
            StartingPoint()
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun LoginPreview() {
//    InstagramAppTheme {
//        LoginScreen(navController = navController)
//    }
//}

//@Composable
//fun PostScreen(navController: NavHostController) {
//    val posts = listOf(
//        "https://i.pinimg.com/736x/94/38/c8/9438c8b78f397e2442ca0905110d8f0c.jpg",
//        "https://i.pinimg.com/736x/d4/19/64/d41964a397666648b688d3c82640ee0a.jpg",
//        "https://i.pinimg.com/736x/a5/f3/10/a5f310a0b4130de23139b0d1d19e410c.jpg",
//        "https://i.pinimg.com/736x/d3/f0/29/d3f029e6c10dfd79f36d2147a2ec1c98.jpg",
//        "https://i.pinimg.com/736x/f8/0b/c0/f80bc09997706e2da19b5da5a2113a01.jpg"
//    )
//    Column(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Box(
//            modifier = Modifier.weight(1f)
//        ) {
//            PostSection(posts = posts)
//        }
//        FooterSection(navController = navController) // Use FooterSection instead of FooterSectionpreview
//    }
//}


object Screen {
    const val HOME = "home"
    const val ABOUT = "about"
    const val SEARCH = "search"
    const val PROFILE = "profile"
    const val INBOX = "inbox"
}
@Preview(showSystemUi = true)
@Composable
fun StartingPoint() {
    val nc = rememberNavController()
    val duration = 400

    Scaffold(
        bottomBar = { FooterSection(navController = nc) } // Ensure footer is always visible
    ) { paddingValues ->
        NavHost(
            navController = nc,
            startDestination = Screen.HOME,
            modifier = Modifier.padding(paddingValues), // Avoid overlapping UI with footer
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start,
                    tween(duration)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start,
                    tween(duration)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End,
                    tween(duration)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End,
                    tween(duration)
                )
            }
        ) {
            composable(Screen.HOME) {
                HomeScreen(nc)
            }
            composable(Screen.ABOUT) {
                AboutScreen(nc)
            }
            composable(Screen.INBOX) {
                InboxScreen(nc)
            }
            composable(Screen.SEARCH) {
                SearchScreen(nc)
            }
            composable(Screen.PROFILE) {
                ProfileScreen(nc)
            }

        }
    }
}
