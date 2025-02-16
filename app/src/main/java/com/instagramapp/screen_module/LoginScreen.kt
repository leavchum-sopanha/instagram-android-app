package com.instagramapp.screen_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.androidapp_test.ui.theme.DarkBackground
import com.example.androidapp_test.ui.theme.DarkText
import com.example.androidapp_test.ui.theme.LightBackground
import com.example.androidapp_test.ui.theme.LightText
import com.instagramapp.R
import com.instagramapp.Screen
import com.instagramapp.mvvm_module.ThemeViewModel

@Composable
fun LoginScreen(navController: NavHostController, themeVM: ThemeViewModel) {
    val backgroundColor = if (themeVM.dark.value) DarkBackground else LightBackground
    val textColor = if (themeVM.dark.value) DarkText else LightText
    val buttonColor = if (themeVM.dark.value) Color(0xFF0095F6) else Color(0xFF0095F6) // Keep button color consistent
    val iconColor = if (themeVM.dark.value) Color.White else Color.Black
    val logoUrl = if (themeVM.dark.value) {
        R.drawable.instagram_white_text // Dark mode logo
    } else {
        "https://cdn.prod.website-files.com/664884473364719e2c0310a2/664c9443d3277bcccf0df9c6_instagram-text-icon.png" // Light mode logo
    }

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
            .background(backgroundColor), // Use theme-aware background color
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(logoUrl),
            contentDescription = "Instagram Logo",
            modifier = Modifier.size(150.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Phone number, email or username", color = textColor) }, // Use theme-aware text color
            modifier = Modifier.fillMaxWidth(0.85f),
            colors = TextFieldDefaults.colors(
                focusedTextColor = textColor,
                unfocusedTextColor = textColor,
                focusedContainerColor = backgroundColor,
                unfocusedContainerColor = backgroundColor,
                focusedLabelColor = textColor,
                unfocusedLabelColor = textColor
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", color = textColor) }, // Use theme-aware text color
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null,
                        tint = iconColor // Use theme-aware icon color
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(0.85f),
            colors = TextFieldDefaults.colors(
                focusedTextColor = textColor,
                unfocusedTextColor = textColor,
                focusedContainerColor = backgroundColor,
                unfocusedContainerColor = backgroundColor,
                focusedLabelColor = textColor,
                unfocusedLabelColor = textColor
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Screen.HOME) },
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
            modifier = Modifier.fillMaxWidth(0.85f),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(text = "Log In", color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Forgot your login details? Get help logging in.",
            fontSize = 14.sp,
            color = Color(0xFF0095F6),
            modifier = Modifier.clickable { /* Handle help */ }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "OR",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Log in with Facebook",
            fontSize = 14.sp,
            color = Color(0xFF0095F6),
            modifier = Modifier.clickable { /* Handle Facebook login */ }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Don't have an account? Sign up.",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.clickable { /* Handle sign-up */ }
        )
    }
}