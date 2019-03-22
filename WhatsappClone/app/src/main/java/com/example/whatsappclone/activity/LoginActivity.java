package com.example.whatsappclone.activity;

import android.graphics.PorterDuff;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toolbar;

import com.example.whatsappclone.R;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
