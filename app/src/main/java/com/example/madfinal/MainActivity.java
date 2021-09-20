package com.example.madfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void register(View view){
        Intent intent=new Intent(this,Register.class);
        startActivity(intent);
    }

    //Admin login is done from this class
    public void AdminLogin(View view){
        Intent intent=new Intent(this,AdminHomeDirect.class);
        startActivity(intent);
    }
}