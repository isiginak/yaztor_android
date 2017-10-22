package com.example.android.yazokuluuygulamaprototip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class mDersleriGetir extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView listele;
    ArrayList<ModelUyg> arrayList;
    FirebaseDatabase firebaseDatabase;
    String dersAdi, kredi, akts;
    ModelUyg model;
    String image, user, email2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_dersleri_getir);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        if (!email2.isEmpty()) {
            kullaniciAdi.setText(user);
            email.setText(email2);
            Picasso.with(getBaseContext()).load(image).into(resim);

        }

        listele = (ListView) findViewById(R.id.liste);
        listele.setClickable(true);
        listele.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(), "Test " + position, Toast.LENGTH_SHORT).show();

            }
        });
        arrayList = new ArrayList<ModelUyg>();


        firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = firebaseDatabase.getReference("university");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Bundle bundle = getIntent().getExtras();
                    dersAdi = bundle.getString("ders");
                    kredi = bundle.getString("kredim");
                    akts = bundle.getString("aktsm");

                    dataSnapshot.getKey();
                    if (dersAdi.equals(ds.child("mDersAdi").getValue().toString()) && kredi.equals(ds.child("mKredi").getValue().toString()) && akts.equals(ds.child("mAKTS").getValue().toString())) {
                        String uni_adi = ds.child("mUniversiteAdi").getValue().toString();
                        String fakulteAdi = ds.child("mFakulteAdi").getValue().toString();
                        String bolum = ds.child("mBolum").getValue().toString();
                        String dersKodu = ds.child("mDersKodu").getValue().toString();
                        String dersAdi = ds.child("mDersAdi").getValue().toString();
                        String Kredi = ds.child("mKredi").getValue().toString();
                        String AKTS = ds.child("mAKTS").getValue().toString();

                        arrayList.add(new ModelUyg(uni_adi, fakulteAdi, bolum, dersKodu, dersAdi, Kredi, AKTS));
                    } else {

                    }

                }
                final CustomAdapter customAdapter = new CustomAdapter(mDersleriGetir.this, arrayList);
                customAdapter.setContext1(mDersleriGetir.this);
                listele.setAdapter(customAdapter);
                databaseReference.removeEventListener(this);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void listDinle() {

    }

    private void yorumYap() {
    }

    private void uniSayfasinaGit() {
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
      //  getMenuInflater().inflate(R.menu.m_dersleri_getir, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      /*  if (id == R.id.action_settings) {
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
            Intent intent = new Intent(getApplicationContext(), Profil.class);
            intent.putExtra("user", user);
            intent.putExtra("email", email2);
            intent.putExtra("photo", image);
            startActivity(intent);
            // startActivity(new Intent(getApplicationContext(),Profil.class));
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(getApplicationContext(), mAnasayfa.class);
            intent.putExtra("user", user);
            intent.putExtra("email", email2);
            intent.putExtra("photo", image);
            startActivity(intent);
            //   startActivity(new Intent(getApplicationContext(),mAnasayfa.class));

        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(getApplicationContext(), Yurtlar.class);
            intent.putExtra("user", user);
            intent.putExtra("email", email2);
            intent.putExtra("photo", image);
            startActivity(intent);
            //  startActivity(new Intent(getApplicationContext(),Yurtlar.class));

        }
        else if(id==R.id.nav_uni){
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
            //startActivity(new Intent(getApplicationContext(),Hakkimizda.class));

        } else if (id == R.id.nav_send) {
            FirebaseAuth.getInstance().signOut();
            //  startActivity(new Intent(getApplicationContext(),KullaniciGirisi.class));
            //  android.os.Process.killProcess(android.os.Process.myPid());
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
//Uygulamamızı sonlandırıyoruz.

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
