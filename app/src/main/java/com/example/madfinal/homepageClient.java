package com.example.madfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class homepageClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_client);
    }

    //The side pannel is activated from here
    public void Clientsidepanel(View view){
        Intent intent=new Intent(this,SidePannelClient.class);
        startActivity(intent);
    }
}