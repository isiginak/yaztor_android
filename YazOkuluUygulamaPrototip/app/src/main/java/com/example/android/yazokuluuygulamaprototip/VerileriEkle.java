package com.example.android.yazokuluuygulamaprototip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VerileriEkle extends AppCompatActivity {
    private EditText universiteAdi,fakulteAdi,bolum,dersKodu,dersAdi,kredi,akts;
    private Button kaydet,goster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verileri_ekle);


        universiteAdi=(EditText)findViewById(R.id.uni_adi);
        fakulteAdi=(EditText)findViewById(R.id.fakulteAdi);
        bolum=(EditText)findViewById(R.id.bolum);
        dersKodu=(EditText)findViewById(R.id.dersKodu);
        dersAdi=(EditText)findViewById(R.id.dersAdi);
        kredi=(EditText)findViewById(R.id.kredi);
        akts=(EditText)findViewById(R.id.akts);
        kaydet=(Button)findViewById(R.id.kaydet);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("university");
                ModelUyg model=new ModelUyg();
                model.mUniversiteAdi=universiteAdi.getText().toString().trim().toLowerCase();
                model.mFakulteAdi=fakulteAdi.getText().toString().trim().toLowerCase();
                model.mBolum=bolum.getText().toString().trim().toLowerCase();
                model.mDersKodu=dersKodu.getText().toString().trim().toUpperCase();
                model.mDersAdi=dersAdi.getText().toString().trim().toLowerCase();
                model.mKredi=kredi.getText().toString().trim();
                model.mAKTS=akts.getText().toString().trim();


                databaseReference.push().setValue(model);

                Toast.makeText(getApplicationContext(), "Sisteme kaydedildi.", Toast.LENGTH_SHORT).show();
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_goster) {
            startActivity(new Intent(VerileriEkle.this, Listele.class));

        }
        return super.onOptionsItemSelected(item);
    }

}

