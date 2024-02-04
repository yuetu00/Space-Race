package com.example.myapplication

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class LoadingPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(150.dp),

                    ) {
                    // Your Compose UI components go here
                    Image(
                        painter = painterResource(id = R.drawable.loading_earth),
                        contentDescription = null, // Provide a proper content description
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
        }
    }
}