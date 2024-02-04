//package com.example.myapplication
//
//import android.content.Intent
//import android.os.Bundle
//import android.os.Handler
//import android.os.Looper
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.myapplication.ui.theme.MyApplicationTheme
//import android.widget.Button
//
//class GymPageSelection : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
////
////        val hiitButton: Button = findViewById(R.id.hiitButton)  // add button in xml
////
////        hiitButton.setOnClickListener {
////            onHiitButtonClick()
////        }
//
//        setContent {
//            MyApplicationTheme {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color.Blue)
//                        .padding(150.dp, 250.dp),
//                ) {
//                    // Use Column to arrange Image and Text vertically
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Text(
//                            text = "HIIT",
//                            modifier = Modifier.padding(top = 16.dp),
//                            style = TextStyle(
//                                color = Color.White,
//                                fontSize = 20.sp,
//                                fontWeight = FontWeight.Bold
//                            )
//                        )
//                        Background()
//                    }
//                }
//            }
//        }
////
////        val button = findViewById<Button>()
////        button.setOnClickListener
////        }
//
////        private fun onHiitButtonClick() {
////            val intent = Intent(this, activity_gym_page::class.kotlin)
////            startActivity(intent)
////        }
////    }
//
////    @Composable
////    fun Background() {
////        Box(modifier = Modifier.fillMaxSize()) {
////            Image(
////                painter = painterResource(id = R.drawable.gym_options),
////                contentScale = ContentScale.FillBounds,
////                modifier = Modifier.matchParentSize()
////            )
////        }
////    }
//}
