package com.example.android.intan_1202154351_studycase4;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Intan Gantira on 3/18/2018.
 */

public class CariGambar extends AppCompatActivity {

    private EditText inputGambar;
    private ImageView inigambar;
    private Button btn_cari;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carigambar);

        // Memanggil variable yang sudah di inisiasi
        inputGambar = (EditText) findViewById(R.id.gambar);
        inigambar = (ImageView) findViewById(R.id.hasilGambar);
        btn_cari = (Button) findViewById(R.id.cari);

    }

    public void cari(View view)  {
        loadImageInit();
    }

    private void loadImageInit(){
        String ImgUrl = inputGambar.getText().toString();
        //AsyncTask untuk mencari gambar di internet
        new loadImage().execute(ImgUrl);
    }
    private class loadImage extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Membuat Progress Dialog
            mProgressDialog = new ProgressDialog(CariGambar.this);

            // setting pada progress dialog
            mProgressDialog.setMessage("Loading...");

            // menampilkan Progress Dialog
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            try {
                // mendownload gambar dari url
                URL url = new URL(params[0]);
                // mengkonversikan gambar ke bitmap
                bitmap = BitmapFactory.decodeStream((InputStream)url.getContent());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            //mengembalikan nilai bitmap
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            // menampung gambar ke imageView dan menampilkannya
            inigambar.setImageBitmap(bitmap);

            // menghilangkan Progress Dialog
            mProgressDialog.dismiss();
        }
    }
}


