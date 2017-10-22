package com.example.android.yazokuluuygulamaprototip;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class KullaniciGirisi extends AppCompatActivity {
    private Button giris;
    EditText email, sifre;
    TextView kayitOl;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;
    private String userName;
    private String userPassword;
    private static final int RC_SIGN_IN = 9001;
    private GoogleApiClient mGoogleApiClient;
    private SignInButton signInButton;
    private final static String TAG = "KULLANICI_GIRISI";
    private FirebaseAuth.AuthStateListener mAuthListener;
    String personEmail, personId, userName1;
    Uri personPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_girisi);
        giris = (Button) findViewById(R.id.goster);
        email = (EditText) findViewById(R.id.email);
        sifre = (EditText) findViewById(R.id.sifre);
        kayitOl = (TextView) findViewById(R.id.kayit_ol);
        kayitOl.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        signInButton = (SignInButton) findViewById(R.id.sign_in_google);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .enableAutoManage(this, new
                        GoogleApiClient.OnConnectionFailedListener() {
                            @Override
                            public void onConnectionFailed(@NonNull ConnectionResult
                                                                   connectionResult) {
                                Toast.makeText(getApplicationContext(), "Hatalı giriş denemesi", Toast.LENGTH_SHORT).show();
                            }
                        })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                //    startActivity(new Intent(KullaniciGirisi.this, Profil.class));
// User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
// User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
// ...
            }
        };


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


 /*     if (firebaseUser != null) { // check user session

            Intent i = new Intent(KullaniciGirisi.this, Profil.class);
            startActivity(i);
            finish();
        }*/

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userName = email.getText().toString();
                userPassword = sifre.getText().toString();
                if (userName.isEmpty() || userPassword.isEmpty()) {
                    Toast.makeText(KullaniciGirisi.this, "Lütfen gerekli alanları doldurunuz!", Toast.LENGTH_SHORT).show();
                } else {
                    loginFunc();
                }


            }
        });

        kayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KullaniciGirisi.this, KayitOl.class));
            }
        });


    }
String link="https://image.flaticon.com/icons/svg/417/417746.svg";
    private void loginFunc() {

        auth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(KullaniciGirisi.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent in = new Intent(KullaniciGirisi.this, Profil.class);
                            in.putExtra("user","Kullanıcı");
                            in.putExtra("email",userName);
                            in.putExtra("photo",link);
                            startActivity(in);
                            finish();

                        } else {
                            // hata
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }


    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
// Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
// Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);

               userName1=account.getDisplayName();
                personEmail = account.getEmail();
                personId = account.getId();
                personPhoto = account.getPhotoUrl();

                Intent intent=new Intent(KullaniciGirisi.this,Profil.class);
                intent.putExtra("user",userName1);
                intent.putExtra("email",personEmail);
                intent.putExtra("photo",personPhoto.toString());
                startActivity(intent);
            } else {
// Google Sign In failed, update UI appropriately
// ...
            }
        }
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential =
                GoogleAuthProvider.getCredential(account.getIdToken(), null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new
                        OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "signInWithCredential:onComplete:" +
                                        task.isSuccessful());
// If sign in fails, display a message to the user. If sign in     succeeds

// the auth state listener will be notified and logic to handle the
// signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Log.w(TAG, "signInWithCredential", task.getException());
                                    Toast.makeText(KullaniciGirisi.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
// ...
                            }
                        });
    }


    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            auth.removeAuthStateListener(mAuthListener);
        }
    }
}
