package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit


class YogaPlanet : ComponentActivity(){

    private var remainingTimeMillis: Long by mutableStateOf(0L)
    private var formattedTime: String by mutableStateOf("  00:00:00")

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val gradientBrush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.sunRiseLight),
                        colorResource(id = R.color.sunRiseDark)
                    )
                )

                    // IconButton and Icon in a Column

                    // Set the gradient background directly on the Box
                // Set the gradient background directly on the Box
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(brush = gradientBrush)
                )

                    {
                        ImageButtonBack(
                            modifier = Modifier
                                .size(40.dp)
                                .offset(x = 5.dp, y =10.dp)
                        )


                        Text(
                            text = " " + formattedTime,
                            modifier = Modifier
                                .fillMaxWidth()
//                            .padding(top = 2.dp, start = 16.dp, end = 16.dp)                            .paddingFromBaseline(top =  400.dp) // Adjust the top padding for the row
                                .paddingFromBaseline(top =  200.dp) // Adjust the top padding for the row
                            ,
                            color = Color(android.graphics.Color.parseColor("#FFDFED")),
                            fontSize = 70.sp,
                        )


                        Image(
                            painter = painterResource(id = R.drawable.yogaplanetanimal),
                            contentDescription = null,
                            modifier = Modifier.size(500.dp).scale(0.75f)
                                .paddingFromBaseline(top =  400.dp) // Adjust the top padding for the row
                            ,
                        )

                        Row(
                            modifier = Modifier
                                .paddingFromBaseline(top =  500.dp) // Adjust the top padding for the row
                                .padding(horizontal = 15.dp ,vertical = 100.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = { adjustTimer(-1) },
                                modifier = Modifier
                                    .padding(7.dp)
                                    .wrapContentWidth()  // Wrap the width around the content
                                    .wrapContentHeight(),
                                colors = ButtonDefaults.buttonColors(
                                    Color(
                                        android.graphics.Color.parseColor(
                                            "#FFFCF5"
                                        )
                                    )
                                ) // Replace with your hex color
                                // Change the color here
                            ) {
                                Text(
                                    text = "-",
                                    color = Color(android.graphics.Color.parseColor("#77AED4")) // Change the text color here
                                )
                            }
                            Button(
                                onClick = { startTimer() },
                                modifier = Modifier
                                    .padding(7.dp)
                                    .wrapContentWidth()  // Wrap the width around the content
                                    .wrapContentHeight()   // Set the desired height
                            ) {
                                Text("start")
                            }
                            Button(
                                onClick = { adjustTimer(1) },
                                modifier = Modifier
                                    .padding(7.dp)
                                    .wrapContentWidth()  // Wrap the width around the content
                                    .wrapContentHeight(),
                                colors = ButtonDefaults.buttonColors(
                                    Color(
                                        android.graphics.Color.parseColor(
                                            "#FFFCF5"
                                        )
                                    )
                                ), // Replace with your hex color
                            ) {
                                Text(
                                    text = "+",
                                    color = Color(android.graphics.Color.parseColor("#77AED4")) // Change the text color here
                                )
                            }

                        }

                    }
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.yogaplanetsplit),
                            contentDescription = null,
                            modifier = Modifier
                                .size(950.dp)
                                .paddingFromBaseline(bottom = 0.dp), // Adjust the top padding for a lower position
                        )
                    }
                }

        }
    }

    private fun adjustTimer(minutes: Int) {
        val tenMinutesInMillis: Long = 10 * 60 * 1000

        // Adjust the timer duration by adding or subtracting ten minutes
        remainingTimeMillis += minutes * tenMinutesInMillis
        // Ensure the timer does not go below zero
        if (remainingTimeMillis < 0) {
            remainingTimeMillis = 0
        }

        // Update formattedTime with the adjusted time
        updateFormattedTime()
    }


    private fun updateFormattedTime() {
        formattedTime = formatTime(remainingTimeMillis)
        updateUI()
    }

    private fun formatTime(millis: Long): String {
        val hours = TimeUnit.MILLISECONDS.toHours(millis)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millis) % 60
        val seconds = TimeUnit.MILLISECONDS.toSeconds(millis) % 60
        return String.format(" %02d:%02d:%02d", hours, minutes, seconds)
    }

    override fun onDestroy() {
        super.onDestroy()
        // No need to cancel the timer here since we're not using a separate timer object
    }

    private fun startTimer() {
        CoroutineScope(Dispatchers.Main).launch {
            while (remainingTimeMillis > 0) {
                delay(1000)
                remainingTimeMillis -= 1000
                updateFormattedTime()
            }
        }
    }

    private fun updateUI() {
        // Call this function whenever you need to update the UI with the latest values
        setContent {
            // Reapply the Compose UI with updated values
            MyApplicationTheme {
                val gradientBrush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.sunRiseLight),
                        colorResource(id = R.color.sunRiseDark)
                    )
                )

                    // Set the gradient background directly on the Box
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(brush = gradientBrush)
                )

                {
                    ImageButtonBack(
                        modifier = Modifier
                            .size(40.dp)
                            .offset(x = 5.dp, y =10.dp)
                    )

                    Text(
                        text = "  " + formattedTime,
                        modifier = Modifier
                            .fillMaxWidth()
//                            .padding(top = 2.dp, start = 16.dp, end = 16.dp)                            .paddingFromBaseline(top =  400.dp) // Adjust the top padding for the row
                            .paddingFromBaseline(top =  200.dp) // Adjust the top padding for the row
                        ,
                        color = Color(android.graphics.Color.parseColor("#FFDFED")),
                        fontSize = 70.sp,
                    )

                    Image(
                        painter = painterResource(id = R.drawable.yogaplanetanimal),
                        contentDescription = null,
                        modifier = Modifier.size(500.dp).scale(0.75f)
                            .paddingFromBaseline(top =  400.dp) // Adjust the top padding for the row
                        ,
                    )

                    Row(
                        modifier = Modifier
                            .paddingFromBaseline(top =  500.dp) // Adjust the top padding for the row
                            .padding(horizontal = 15.dp ,vertical = 100.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    // Adjust the overall vertical padding for the row
//                        horizontalArrangement = Arrangement.SpaceEvenly // Adjust the horizontal arrangement
                    ){
                        Button(
                            onClick = { adjustTimer(-1)},
                            modifier = Modifier
                                .padding(7.dp)
                                .wrapContentWidth()  // Wrap the width around the content
                                .wrapContentHeight(),
                            colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#FFFCF5"))) // Replace with your hex color
                            // Change the color here
                        ) {
                            Text(
                                text = "-",
                                color = Color(android.graphics.Color.parseColor("#77AED4")) // Change the text color here
                            )
                        }
                        Button(
                            onClick = { startTimer() },
                            modifier = Modifier
                                .padding(7.dp)
                                .wrapContentWidth()  // Wrap the width around the content
                                .wrapContentHeight()   // Set the desired height
                        ) {
                            Text("start")
                        }
                        Button(
                            onClick = { adjustTimer(1) },
                            modifier = Modifier
                                .padding(7.dp)
                                .wrapContentWidth()  // Wrap the width around the content
                                .wrapContentHeight(),
                            colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#FFFCF5"))), // Replace with your hex color
                        ) {
                            Text(
                                text = "+",
                                color = Color(android.graphics.Color.parseColor("#77AED4")) // Change the text color here
                            )
                        }

                    }

                }
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.yogaplanetsplit),
                        contentDescription = null,
                        modifier = Modifier
                            .size(950.dp)
                            .paddingFromBaseline(bottom =0.dp), // Adjust the top padding for a lower position
                    )
                }
            }
        }
    }
    @Composable
    fun ImageButtonBack(modifier: Modifier = Modifier) {
        // Replace the placeholder with your image resource
        Image(
            painter = painterResource(id = R.drawable.backarrow),
            contentDescription = null,
            modifier = modifier
        )
    }
}
