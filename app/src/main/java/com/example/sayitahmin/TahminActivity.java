package com.example.sayitahmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {
        private TextView textViewYardim,textViewKalan;
        private Button buttonTahmin;
        private EditText editTextGir;

        private int rastgele;
        private int sayac=7;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);

        textViewKalan=findViewById(R.id.textViewKalan);
        textViewYardim=findViewById(R.id.textViewYardim);
        buttonTahmin=findViewById(R.id.buttonTahmin);
        editTextGir=findViewById(R.id.editTextGir);

        Random r=new Random();
        rastgele=r.nextInt(101);//0-100
        Log.e("Rastgele sayı",String.valueOf(rastgele));

        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayac=sayac-1;
                int tahmin=Integer.parseInt(editTextGir.getText().toString());
                if(tahmin==rastgele){
                    Intent i=new Intent(TahminActivity.this,SonucActivity.class);
                    i.putExtra("sonuc",true);
                    startActivity(i);
                    finish();
                    return;
                }
                if(tahmin>rastgele){
                    textViewYardim.setText("Azalt");
                    textViewKalan.setText("Kalan Hak : "+sayac);
                }
                if(tahmin<rastgele){
                    textViewYardim.setText("Arttır");
                    textViewKalan.setText("Kalan Hak : "+sayac);
                }
                if (sayac==0){
                    Intent i=new Intent(TahminActivity.this,SonucActivity.class);
                    i.putExtra("sonuc",false);
                    startActivity(i);
                    finish();
                }
                editTextGir.setText("");


            }
        });
    }
}
