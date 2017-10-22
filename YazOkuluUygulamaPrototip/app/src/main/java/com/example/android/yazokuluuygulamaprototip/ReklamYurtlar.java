package com.example.android.yazokuluuygulamaprototip;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ReklamYurtlar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String image, user, email2, sehir,yurtAdi1,im,neresi,yurtResmi,yurtAdresi,yurtAdim;
    TextView yurtAdi;
    ImageView imageYurt;
    FirebaseDatabase firebaseDatabase;
    private TextView yurtAd, baslik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reklam_yurtlar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        yurtAdi = (TextView) findViewById(R.id.baslik);
        imageYurt = (ImageView) findViewById(R.id.yurtResmi);
        yurtAd = (TextView) findViewById(R.id.yurtAdi);
        firebaseDatabase = FirebaseDatabase.getInstance();
        baslik = (TextView) findViewById(R.id.baslik);
        final DatabaseReference databaseReference = firebaseDatabase.getReference("icerik");
        DatabaseReference dr=firebaseDatabase.getReference("yurtlar");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    dataSnapshot.getKey();
                    neresi=ds.child("sehir").getValue().toString();
                    yurtResmi=ds.child("yurtresmi").getValue().toString();
                    yurtAdim=ds.child("yurtadi").getValue().toString();
                    yurtAdresi=ds.child("yurtAdresi").getValue().toString();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Bundle bundle = getIntent().getExtras();
        TextView kullaniciAdi = (TextView) navigationView.getHeaderView(0).findViewById(R.id.kullaniciAdi);
        TextView email = (TextView) navigationView.getHeaderView(0).findViewById(R.id.textView);
        ImageView resim = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.imageView);
        user = bundle.getString("user");
        email2 = bundle.getString("email");
        image = bundle.getString("photo");
        sehir = bundle.getString("sehirAdi");

        if (!email2.isEmpty()) {
            kullaniciAdi.setText(user);
            email.setText(email2);
            Picasso.with(getBaseContext()).load(image).into(resim);

        }
        baslik.setText(sehir.toUpperCase() + " YURT REKLAMLARI");
        if (sehir.equals("Elazığ")) {
            im = "http://www.huzurkizyurdu.com/wp-content/uploads/2017/07/slider3.jpg";
            yurtAdi1 = "Özel Huzur Kız Öğrenci Yurdu";
            Picasso.with(getBaseContext()).load(im).into(imageYurt);
            yurtAd.setText(yurtAdi1);


        }else if (sehir.equals("Eskişehir")) {
            im = "http://www.eskisehirburada.com/firmalogo/platin_kiz_apart.gif";
            yurtAdi1 = "Platin Kız Apart";
            Picasso.with(getBaseContext()).load(im).into(imageYurt);
            yurtAd.setText(yurtAdi1);


        }
       imageYurt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(ReklamYurtlar.this);
                alert.setTitle("Özel Huzur Kız Öğrenci Yurdu");
                WebView wv = new WebView(ReklamYurtlar.this);
                wv.loadUrl("http://www.huzurkizyurdu.com/");
                wv.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);

                        return true;
                    }
                });
                alert.setView(wv);
                alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                alert.show();
            }
        });

     /*   databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    dataSnapshot.getKey();
                    if (sehir.equals(ds.child("yurtSehir").getValue().toString())) {
                        im = ds.child("yurtResmi").getValue().toString();
                        yurtAdi1 = ds.child("yurtAdi").getValue().toString();
                        Picasso.with(getBaseContext()).load(im).into(imageYurt);
                        yurtAd.setText(yurtAdi1);


                    }
                    else{
                        baslik.setText(sehir.toUpperCase() + " YURT REKLAMLARI");
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //  getMenuInflater().inflate(R.menu.reklam_yurtlar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
     /*   if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(ReklamYurtlar.this, Profil.class);
            intent.putExtra("user", user);
            intent.putExtra("email", email2);
            intent.putExtra("photo", image);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(getApplicationContext(), mAnasayfa.class);
            intent.putExtra("user", user);
            intent.putExtra("email", email2);
            intent.putExtra("photo", image);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(getApplicationContext(), Yurtlar.class);
            intent.putExtra("user", user);
            intent.putExtra("email", email2);
            intent.putExtra("photo", image);
            startActivity(intent);

        }
        else if(id==R.id.nav_uni){
         /*   UniTanitimFragment fragment=new UniTanitimFragment();
            android.support.v4.app.FragmentTransaction and=getSupportFragmentManager().beginTransaction();
            and.replace(R.id.uni_fragment,fragment);
            and.commit();*/
            Intent i1=new Intent(getApplicationContext(),UniversiteTanitim.class);
            i1.putExtra("user",user);
            i1.putExtra("email",email2);
            i1.putExtra("photo",image);
            startActivity(i1);

        }
        else if (id == R.id.nav_share) {
            Intent intent = new Intent(getApplicationContext(), Hakkimizda.class);
            intent.putExtra("user", user);
            intent.putExtra("email", email2);
            intent.putExtra("photo", image);
            startActivity(intent);

        } else if (id == R.id.nav_send) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
