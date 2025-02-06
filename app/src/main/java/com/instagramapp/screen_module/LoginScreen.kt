package com.instagramapp.screen_module



//import android.net.Uri
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import coil.compose.rememberAsyncImagePainter


@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://cdn.prod.website-files.com/664884473364719e2c0310a2/664c9443d3277bcccf0df9c6_instagram-text-icon.png"),
            contentDescription = "Instagram Logo",
            modifier = Modifier.size(147.dp)
        )

        Text(
            text = "Instagram",
            fontSize = 36.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Phone number, email or username") },
            modifier = Modifier.fillMaxWidth(0.85f)
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(0.85f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle login */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0095F6)),
            modifier = Modifier.fillMaxWidth(0.85f)
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