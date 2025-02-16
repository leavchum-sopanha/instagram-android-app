package com.instagramapp.screen_module

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.instagramapp.R
import com.instagramapp.mvvm_module.LanguageViewModel

@Composable
fun ActionButtons(languageVM: LanguageViewModel, textColor: Color) {
    val currentLanguage = languageVM.currentLanguage.value

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        OutlinedButton(
            onClick = { /* Edit Profile Action */ },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = textColor),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(R.string.edit_profile, currentLanguage), // This will update automatically
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedButton(
            onClick = { /* Share Profile Action */ },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = textColor),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(R.string.share_profile, currentLanguage),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}