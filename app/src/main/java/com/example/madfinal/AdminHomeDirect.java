package com.example.madfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminHomeDirect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_direct);
    }

    //The side pannel is activated from here
    public void Adminsidepanel(View view){
        Intent intent=new Intent(this,AdminHome.class);
        startActivity(intent);
    }
}