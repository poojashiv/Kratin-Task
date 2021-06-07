package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btn_loginpage;
    TextView text_signup;
    EditText et_mobilelogin, et_passwordlogin;
    String mobile, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_signup = findViewById(R.id.text_signup);
        btn_loginpage = findViewById(R.id.btn_loginpage);
        et_mobilelogin = findViewById(R.id.et_mobilelogin);
        et_passwordlogin = findViewById(R.id.et_passwordlogin);

        text_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btn_loginpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getallvalue();
                if (mobile.length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter Mobile", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.length() == 0) {
                        Toast.makeText(MainActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    } else {
                        DatabaseHelper dbUser = new DatabaseHelper(MainActivity.this);
                        if (dbUser.checkUserLogin(mobile, password)) {
                            Toast.makeText(MainActivity.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Invalid Username/Password", Toast.LENGTH_LONG).show();
                        }
                    }
                }

            }
        });
    }

    public void getallvalue() {
        mobile = et_mobilelogin.getText().toString();
        password = et_passwordlogin.getText().toString();
    }
}