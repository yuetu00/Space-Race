package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainPlanetPage : ComponentActivity() {
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

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(brush = gradientBrush)

                    )
                {
                    ImageButtonYoga(
                        modifier = Modifier
                            .size(100.dp)
                            .offset(x = 60.dp, y = 50.dp)
                    )

            }
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mainplanetsplit),
                        contentDescription = null,
                        modifier = Modifier
                            .size(950.dp)
                            .paddingFromBaseline(bottom =0.dp), // Adjust the top padding for a lower position
                    )
                }
            }
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainPlanetPage, YogaPlanet::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }


    @Composable
    fun ImageButtonYoga(modifier: Modifier = Modifier) {
        // Replace the placeholder with your image resource
        Image(
            painter = painterResource(id = R.drawable.yogaplanet),
            contentDescription = null,
            modifier = modifier
        )
    }
}