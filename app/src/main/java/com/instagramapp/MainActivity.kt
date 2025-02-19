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
import kotlinx.serialization.json.Json
import com.instagramapp.mvvm_module.ThemeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.instagramapp.mvvm_module.LanguageViewModel
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.example.androidapp_test.ui.theme.DarkBackground
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.instagramapp.mvvm_module.LanguageViewModelFactory
import com.instagramapp.mvvm_module.ThemeViewModelFactory
import com.instagramapp.ui.theme.InstagramAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val languageVM: LanguageViewModel = viewModel(
                factory = LanguageViewModelFactory(this)
            )
            val themeVM: ThemeViewModel = viewModel(
                factory = ThemeViewModelFactory(this)
            )

            InstagramAppTheme {
                StartingPoint(languageVM, themeVM)
            }
        }
    }
}

object Screen {
    const val LOGIN = "login"
    const val HOME = "home"
    const val ABOUT = "about"
    const val ADD = "add"
    const val SEARCH = "search"
    const val PROFILE = "profile"
    const val INBOX = "inbox"
    const val NOTIFICATION = "notification"
    const val DETAIL = "detail/{itemId}"
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    InstagramAppTheme() {
        LoginScreen(navController = rememberNavController(), themeVM = viewModel())
    }
}

@Composable
fun StartingPoint(
    languageVM: LanguageViewModel,
    themeVM: ThemeViewModel
) {
    val nc = rememberNavController()
    val backgroundColor = if (themeVM.dark.value) DarkBackground else Color.White
    val duration = 400

    val systemUiController = rememberSystemUiController()
    val darkTheme = themeVM.dark.value

    SideEffect {
        systemUiController.setStatusBarColor(
            color = if (darkTheme) Color(0xFF121212) else Color.White,
            darkIcons = !darkTheme
        )
        systemUiController.setNavigationBarColor(
            color = if (darkTheme) Color(0xFF121212) else Color.White,
            darkIcons = !darkTheme
        )
    }

    Scaffold(
        bottomBar = { FooterSection(navController = nc, themeVM = themeVM) },
        containerColor = backgroundColor
    ) { paddingValues ->
        NavHost(
            navController = nc,
            startDestination = "login",
            modifier = Modifier.padding(paddingValues),
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start,
                    tween(duration))
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
                    tween(duration))
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End,
                    tween(duration)
                )
            }
        ) {
            // Add LoginScreen as the initial destination
            composable("login") {
                LoginScreen(navController = nc, themeVM = themeVM)
            }
            composable(Screen.LOGIN) {
                LoginScreen(navController = nc, themeVM = themeVM)
            }
            // Other screens
            composable(Screen.HOME) {
                HomeScreen(navController = nc, themeVM = themeVM)
            }
            composable(Screen.ABOUT) {
                AboutScreen(navController = nc, themeVM = themeVM)
            }
            composable(Screen.INBOX) {
                InboxScreen(navController = nc, themeVM = themeVM)
            }
            composable(Screen.SEARCH) {
                SearchScreen(navController = nc, themeVM = themeVM)
            }
            composable(Screen.ADD) {
                AddScreen()
            }
            composable(Screen.PROFILE) {
                ProfileScreen(navController = nc, themeVM = themeVM, languageVM = languageVM)
            }
            composable(Screen.NOTIFICATION) {
                NotificationScreen(navController = nc, themeVM = themeVM)
            }
            composable("inbox/{inboxJson}") { backStackEntry ->
                val inboxJson = backStackEntry.arguments?.getString("inboxJson") ?: return@composable
                val decodedJson = inboxJson.replace("+", " ")
                val inbox = Json.decodeFromString<Inbox>(decodedJson)
                InboxDetailScreen(
                    navController = nc,
                    inboxJson = inboxJson,
                    themeVM = themeVM
                )
            }
        }
    }
}
