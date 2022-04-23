package com.example.lab8b_lttbdd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnLogin,btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin=findViewById(R.id.btnSinginMain);
        btnRegister=findViewById(R.id.btnSingin);
        final Intent intentLogin=new Intent(this, ActivityLogin.class);
        final Intent intentRegister=new Intent(this,ActivityRegister.class);
        btnRegister.setOnClickListener((view -> {startActivity(intentRegister);}));
        btnLogin.setOnClickListener(view -> {startActivity(intentLogin);});
    }
}