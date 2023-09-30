package com.devroid.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private final String CREDENTIAL_SHARED_PREF="our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText email=findViewById(R.id.emailET);
        final EditText mobile=findViewById(R.id.mobileET);
        final EditText password=findViewById(R.id.passwordET);
        final EditText conPassword=findViewById(R.id.conPasswordET);
        final EditText fullName=findViewById(R.id.FullNameET);

        final AppCompatButton signUpBtn= findViewById(R.id.signUpBtn);


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPassword = password.getText().toString();
                String strConfirmPassword = conPassword.getText().toString();
                String setEmail = email.getText().toString();
                String setUsername=fullName.getText().toString();
                String setMobile=mobile.getText().toString();

                if (strPassword.isEmpty() || strConfirmPassword.isEmpty() || setEmail.isEmpty() || setUsername.isEmpty() || setMobile.isEmpty()) {
                    Toast.makeText(Register.this, "All field's were compulsory to fill!!", Toast.LENGTH_SHORT).show();
                }
                else if(!strPassword.equals(strConfirmPassword)){
                    Toast.makeText(Register.this, "Password is Not Matching.", Toast.LENGTH_SHORT).show();
                }
                else {

                    if (strPassword != null && strConfirmPassword != null && strPassword.equalsIgnoreCase(strConfirmPassword)) {
                       SharedPreferences sharedPreferences = getSharedPreferences(CREDENTIAL_SHARED_PREF, MODE_PRIVATE);
                       SharedPreferences.Editor editor = sharedPreferences.edit();
                       editor.putString("Password", strPassword);
                       editor.putString("Username", setUsername);
                       editor.putString("Email", setEmail);
                       editor.putString("Mobile", setMobile);
                       editor.apply();


                        Intent inow=new Intent(Register.this, Login.class);
                        startActivity(inow);


                        Toast.makeText(Register.this, "Registration is Successful.", Toast.LENGTH_SHORT).show();
//                        Intent inow=new Intent(Register.this,.class);
//                        inow.putExtra("pswd",strPassword);
//                        inow.putExtra("un",setUsername);
//                        inow.putExtra("email",setEmail);
//                        inow.putExtra("mobile",setMobile);
//                        startActivity(inow);



                        //  finish();
                    }
                }
            }
        });

    }
}