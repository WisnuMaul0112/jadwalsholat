package com.pahlawancoding.jadwalsholat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

import com.pahlawancoding.jadwalsholat.R;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    Vibrator vibe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void Dzikir(View view) {
        Intent intent = new Intent(MainActivity.this, DzikirActivity.class);
        startActivity(intent);
        vibe.vibrate(100);
    }


    public void DoaHarian(View view) {
        Intent intent = new Intent(MainActivity.this, JadwalActivity.class);
        startActivity(intent);
        vibe.vibrate(100);
    }

    public void ArahKiblat(View view) {
        Intent intent = new Intent(MainActivity.this, KompasActivity.class);
        startActivity(intent);
        vibe.vibrate(100);
    }


    public void JadwalSholat(View view) {
        Intent intent = new Intent(MainActivity.this, JadwalActivity.class);
        startActivity(intent);
        vibe.vibrate(100);
    }

    //menambahkan background sesuai waktu
   // public void setBackground(ImageView view)  {
        Calendar c = Calendar.getInstance();

    public void masjid(View view) {
        Intent intent = new Intent(MainActivity.this, CariMasjidActivity.class);
        startActivity(intent);
        vibe.vibrate(100);
    }
    //   int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

       // if(timeOfDay >= 18 && timeOfDay < 6){
           // view.setBackground(R.color.);
        //}else if(timeOfDay >= 6 && timeOfDay < 18){
          //  view.setBackground(R.drawable.masjidsiang);
        //}

    //}

}