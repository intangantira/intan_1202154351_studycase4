package com.example.android.intan_1202154351_studycase4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tampilNama(View view) {
        //menggunakan intent untuk pindah ke activity nama mahasiswa.class
        Intent ganti = new Intent(getApplicationContext(), NamaMahasiswa.class);
        //memulai activity ke nama mahasiswa
        startActivity(ganti);
    }

    public void cariGambar(View view) {
        //menggunakan intent untuk pindah ke activity cari gambar.class
        Intent i = new Intent(getApplicationContext(), CariGambar.class);
        //memulai activity cari gambar
        startActivity(i);
    }
}