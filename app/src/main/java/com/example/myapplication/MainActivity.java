//package com.example.myapplication;
//import com.example.myapplication.R;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.TypedValue;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.content.Context;
//import android.hardware.SensorManager;
//import android.hardware.Sensor;
//import android.app.Activity;
//import android.Manifest;
//import android.widget.Toast;
//
//public class MainActivity extends AppCompatActivity{
//    private Button start_PYoga;
//    private TextView textViewStepCounter;
//    private SensorManager sensorManager;
//    private Sensor stepCounter;
//    private boolean counterSensorPresent;
//    Intent intent=new Intent();
//
//    startActivity(intent);
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        viewSetup();
//
//        start_PYoga.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ifErrorOnOutput();
//                exceedLength();
//                t1.setText(t1.getText().toString() + "1");
//            }
//        });
//}
