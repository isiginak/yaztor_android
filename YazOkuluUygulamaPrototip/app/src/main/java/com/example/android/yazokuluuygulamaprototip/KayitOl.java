package com.example.android.yazokuluuygulamaprototip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.android.yazokuluuygulamaprototip.R.id.userName;
import static com.example.android.yazokuluuygulamaprototip.R.id.userPassword;

public class KayitOl extends AppCompatActivity {
EditText KullaniciAdi,sifre,email;
    Button kayit;
    private FirebaseAuth mAuth;
    private String userAdi;
    private String userSifre,eposta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);
        KullaniciAdi=(EditText)findViewById(userName);
        email=(EditText)findViewById(R.id.userEmail);
        sifre=(EditText)findViewById(userPassword);
        kayit=(Button)findViewById(R.id.kayit);
        mAuth = FirebaseAuth.getInstance();

        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eposta=email.getText().toString();
                userSifre=sifre.getText().toString();
                userAdi=KullaniciAdi.getText().toString();
                if(eposta.isEmpty()||userSifre.isEmpty()||userSifre.isEmpty()){

                    Toast.makeText(KayitOl.this, "Lütfen gerekli alanları doldurunuz.", Toast.LENGTH_SHORT).show();
                }
                else{
                    registerFunc();
                }

            }
        });
    }




    private void registerFunc() {

        mAuth.createUserWithEmailAndPassword(eposta,userSifre)
                .addOnCompleteListener(KayitOl.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i = new Intent(KayitOl.this,KullaniciGirisi.class);
                            startActivity(i);
                            finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}
