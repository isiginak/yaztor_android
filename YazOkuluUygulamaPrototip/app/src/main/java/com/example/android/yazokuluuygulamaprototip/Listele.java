package com.example.android.yazokuluuygulamaprototip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Listele extends AppCompatActivity {
private ListView listele;
    ArrayList<ModelUyg> arrayList;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);
        arrayList=new ArrayList<ModelUyg>();
        listele=(ListView)findViewById(R.id.list);


        firebaseDatabase=FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference=firebaseDatabase.getReference("university");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    dataSnapshot.getKey();

                    String uni_adi=ds.child("mUniversiteAdi").getValue().toString();
                    String fakulteAdi=ds.child("mFakulteAdi").getValue().toString();
                    String bolum=ds.child("mBolum").getValue().toString();
                    String dersKodu=ds.child("mDersKodu").getValue().toString();
                    String dersAdi=ds.child("mDersAdi").getValue().toString();
                    String Kredi=ds.child("mKredi").getValue().toString();
                    String AKTS=ds.child("mAKTS").getValue().toString();

                    arrayList.add(new ModelUyg(uni_adi,fakulteAdi,bolum,dersKodu,dersAdi,Kredi,AKTS));
                }

                CustomAdapter customAdapter=new CustomAdapter(Listele.this,arrayList);
                listele.setAdapter(customAdapter);
                databaseReference.removeEventListener(this);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    }

