package com.example.madfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText user_name,email,DOB,password;
    Button submit;
    RadioButton mal_e,femal_e;
    FirebaseDatabase mydb;
    DatabaseReference reference;
    String gen="";
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user_name=findViewById(R.id.Username);
        email=findViewById(R.id.Email);
        DOB=findViewById(R.id.DOB);
        password=findViewById(R.id.Password);
        submit=findViewById(R.id.Submit);
        mal_e=findViewById(R.id.Male);
        femal_e=findViewById(R.id.female);

        reference=FirebaseDatabase.getInstance().getReference("User");
        firebaseAuth = FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=user_name.getText().toString();
                String mail=email.getText().toString();
                String date_of_birth=DOB.getText().toString();
                String pw=password.getText().toString();


                if(mal_e.isChecked()){
                    gen="Male";
                }
                if(femal_e.isChecked()){
                    gen="Female";
                }

                if(TextUtils.isEmpty(mail)){
                    Toast.makeText(Register.this,"Please enter Email",Toast.LENGTH_SHORT);
                }

                if(TextUtils.isEmpty(pw)){
                    Toast.makeText(Register.this,"Please enter passowrd",Toast.LENGTH_SHORT);
                }

                if(TextUtils.isEmpty(name)){
                    Toast.makeText(Register.this,"Please enter User name",Toast.LENGTH_SHORT);
                }

                if(TextUtils.isEmpty(date_of_birth)){
                    Toast.makeText(Register.this,"Please enter Date of Birth",Toast.LENGTH_SHORT);
                }

                firebaseAuth.createUserWithEmailAndPassword(mail,pw)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    user info=new user(name,mail,gen,date_of_birth);

                                    FirebaseDatabase.getInstance().getReference("User")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(Register.this,"Registration Complete",Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(),homepageClient.class));
                                        }
                                    });
                                }
                                else {

                                }
                            }
                        });
            }
        });

    }

    //Moving to main client page
    public void ClientDirect(View view){
        Intent intent=new Intent(this,homepageClient.class);
        startActivity(intent);
    }
}