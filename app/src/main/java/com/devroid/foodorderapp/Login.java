package com.devroid.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private final String CREDENTIAL_SHARED_PREF="our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameET=findViewById(R.id.usernameET);
        final EditText passwordET=findViewById(R.id.passwordET);
        final TextView signUpBtn=findViewById(R.id.signUpBtn);
        final AppCompatButton signInBtn=findViewById(R.id.signInBtn);
        sharedPreferences=getSharedPreferences(CREDENTIAL_SHARED_PREF,MODE_PRIVATE);

        String email_admin = sharedPreferences.getString("Username", null);
        if (email_admin != null) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        signInBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                sharedPreferences = getSharedPreferences(CREDENTIAL_SHARED_PREF, MODE_PRIVATE);
                String strUsername = sharedPreferences.getString("Username", null);
                String strPassword = sharedPreferences.getString("Password", null);
                String username_from_ed = usernameET.getText().toString();
                String password_from_ed = passwordET.getText().toString();
                if (username_from_ed.isEmpty() || password_from_ed.isEmpty()) {
                    Toast.makeText(Login.this, "All field is compulsory to fill!!", Toast.LENGTH_SHORT).show();
                } else {
                    if (strUsername != null && username_from_ed != null && strUsername.equalsIgnoreCase(username_from_ed)) {
                        if (strPassword != null && password_from_ed != null && strPassword.equalsIgnoreCase(password_from_ed)) {
                            Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent ihome = new Intent(Login.this, MainActivity.class);
                            startActivity(ihome);
                            finish();
                        } else {
                            Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
    }
}