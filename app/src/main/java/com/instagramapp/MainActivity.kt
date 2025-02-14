package com.instagramapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.instagramapp.screen_module.*
import com.instagramapp.ui.theme.InstagramAppTheme
import kotlinx.serialization.json.Json // Add this import

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StartingPoint()
        }
    }
}

object Screen {
    const val HOME = "home"
    const val ABOUT = "about"
    const val ADD = "add"
    const val SEARCH = "search"
    const val PROFILE = "profile"
    const val INBOX = "inbox"
    const val DETAIL = "detail/{itemId}"
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    InstagramAppTheme {
        LoginScreen(navController = rememberNavController())
    }
}

@Preview(showSystemUi = true)
@Composable
fun StartingPoint() {
    val nc = rememberNavController() // Declare navController here
    val duration = 400

    Scaffold(
        bottomBar = { FooterSection(navController = nc) }
    ) { paddingValues ->
        NavHost(
            navController = nc,
            startDestination = Screen.HOME,
            modifier = Modifier.padding(paddingValues),
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
                HomeScreen(navController = nc)
            }
            composable(Screen.ABOUT) {
                AboutScreen(navController = nc)
            }
            composable(Screen.INBOX) {
                InboxScreen(navController = nc)
            }
            composable(Screen.SEARCH) {
                SearchScreen(navController = nc)
            }
            composable(Screen.ADD) {
                AddScreen()
            }
            composable(Screen.PROFILE) {
                ProfileScreen(navController = nc)
            }
//            composable("inbox/{inbox}") { backStackEntry ->
//                val inboxJson = backStackEntry.arguments?.getString("inbox")
//                val inbox = inboxJson?.let { Json.decodeFromString<Inbox>(it) } ?: return@composable
//                InboxDetailScreen(
//                    navController = nc,
//                    inbox = inbox // Pass the entire Inbox object
//                )
//            }

            composable("inbox/{inboxJson}") { backStackEntry ->
                val inboxJson = backStackEntry.arguments?.getString("inboxJson") ?: return@composable
                val decodedJson = inboxJson.replace("+", " ")
                val inbox = Json.decodeFromString<Inbox>(decodedJson)
                InboxDetailScreen(
                    navController = nc,
                    inboxJson = inboxJson // Pass the encoded JSON string
                )
            }
        }
    }
}