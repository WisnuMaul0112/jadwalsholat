package com.pahlawancoding.jadwalsholat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.pahlawancoding.jadwalsholat.R;

import androidx.appcompat.app.AppCompatActivity;

public class DzikirActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzikir);
    }

    public void DzikirPagi(View view) {
        Intent intent = new Intent(DzikirActivity.this, PagiActivity.class);
        startActivity(intent);
    }

    public void DzikirSore(View view) {
        Intent intent = new Intent(DzikirActivity.this, SoreActivity.class);
        startActivity(intent);
    }
}