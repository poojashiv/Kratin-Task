package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    TextView text_signin;
    EditText et_fullname,et_mobilenumber,et_age,et_password,et_address;
    Button btn_signup;
    String name,mobile,age,password,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        text_signin = findViewById(R.id.text_signin);
        btn_signup = findViewById(R.id.btn_signup);
        et_fullname = findViewById(R.id.et_fullname);
        et_mobilenumber = findViewById(R.id.et_mobilenumber);
        et_age = findViewById(R.id.et_age);
        et_password = findViewById(R.id.et_password);
        et_address = findViewById(R.id.et_address);



        text_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getallvalue();
                if(name.length()==0){
                    Toast.makeText(SignUpActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }else {
                    if (mobile.length() == 0) {
                        Toast.makeText(SignUpActivity.this, "Enter mobile", Toast.LENGTH_SHORT).show();
                    } else {
                        if (age.length() == 0) {
                            Toast.makeText(SignUpActivity.this, "Enter age", Toast.LENGTH_SHORT).show();
                        } else {
                            if (password.length() == 0) {
                                Toast.makeText(SignUpActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                            } else {
                                if (address.length() == 0) {
                                    Toast.makeText(SignUpActivity.this, "Enter address", Toast.LENGTH_SHORT).show();
                                } else {
                                    DatabaseHelper databaseHelper = new DatabaseHelper(SignUpActivity.this);
                                    databaseHelper.addData(name, mobile, age, password, address);
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public void getallvalue(){
        name = et_fullname.getText().toString();
        mobile = et_mobilenumber.getText().toString();
        age = et_age.getText().toString();
        password = et_password.getText().toString();
        address = et_address.getText().toString();
    }
}