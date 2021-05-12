package com.example.sayitahmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {
    private ImageView imageViewSonuc;
    private TextView textViewsonuc;
    private Button buttonTekrar;

    private boolean sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        imageViewSonuc=findViewById(R.id.imageViewSonuc);
        textViewsonuc=findViewById(R.id.textViewsonuc);
        buttonTekrar=findViewById(R.id.buttonTekrar);

        sonuc=getIntent().getBooleanExtra("sonuc",false);
        if(sonuc){  //true ise..
            textViewsonuc.setText("KAZANDINIZ");
            imageViewSonuc.setImageResource(R.drawable.mutlu_resim);
        }
        else {
            textViewsonuc.setText("KAYBETTİNİZ");
            imageViewSonuc.setImageResource(R.drawable.mutsuz);
        }

       buttonTekrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(SonucActivity.this,TahminActivity.class));
               finish();
           }
       });
    }
}
