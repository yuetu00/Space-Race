package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {

                val gradientBrush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.mainLight),
                        colorResource(id = R.color.mainMiddle),
                        colorResource(id = R.color.mainDark)
                    )
                )

                // Set the gradient background directly on the Box
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(brush = gradientBrush)
                        .padding(110.dp),

                    ) {
                    // Text composable in the top-middle of the screen
                    Text(
                        text = "Space Race",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 200.dp),
                        style = TextStyle(
                            color = Color.Blue,
                            fontSize = 30.sp, // Adjust the font size as needed
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}