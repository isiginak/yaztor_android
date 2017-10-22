package com.example.android.yazokuluuygulamaprototip;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class SehirIpuclari extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String image,user,email2,sehir;
    Button txt3,txt4,txt5,txt6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sehir_ipuclari);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt3=(Button)findViewById(R.id.textView3);
        txt4=(Button)findViewById(R.id.textView4);
        txt5=(Button)findViewById(R.id.textView5);
        txt6=(Button)findViewById(R.id.textView6);
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SehirIpuclari.this);
                alert.setTitle("Nereleri Gezebilirim?");
                TextView textView=new TextView(SehirIpuclari.this);
                textView.setPadding(15,50,20,15);
                if(sehir.equals("Ankara")){
                    String ss="Hamam Önü,Mehmet Akif Ersoy Müzesi,Anıtkabir,Ankara Kalesi,Gençlik Parkı,Dikmen";
                    textView.setText(ss);
                    textView.setTextColor(Color.BLACK);
                    alert.setView(textView);

                }
                else if(sehir.equals("Elazığ")){
                    String ss="Harput,Sivrice Gölü,Keban Barajı,Kültür Park,Hazar Baba Kayak Merkezi,Buzluk Mağarası";
                    textView.setText(ss);
                    textView.setTextColor(Color.BLACK);
                    alert.setView(textView);

                }

                alert.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });
                alert.show();
            }
        });
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SehirIpuclari.this);
                alert.setTitle("En ucuz kitap nerede?");
                alert.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });
                alert.show();
            }
        });
        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SehirIpuclari.this);
                alert.setTitle("Nerede Ne Yenir?");
                alert.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });
                alert.show();
            }
        });
        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SehirIpuclari.this);
                alert.setTitle("Nerede Ne Var?");
                alert.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });
                alert.show();
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Bundle bundle=getIntent().getExtras();
        TextView kullaniciAdi=(TextView)navigationView.getHeaderView(0).findViewById(R.id.kullaniciAdi);
        TextView email=(TextView)navigationView.getHeaderView(0).findViewById(R.id.textView);
        ImageView resim=(ImageView)navigationView.getHeaderView(0).findViewById(R.id.imageView);
        user=bundle.getString("user");
        email2=bundle.getString("email");
        image=bundle.getString("photo");
        sehir=bundle.getString("sehirAdi");
        if(!email2.isEmpty()){
            kullaniciAdi.setText(user);
            email.setText(email2);
            Picasso.with(getBaseContext()).load(image).into(resim);

        }
        TextView baslik=(TextView)findViewById(R.id.baslik);
        baslik.setText(sehir.toUpperCase()+" ŞEHİR İPUÇLARI");
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
     //   getMenuInflater().inflate(R.menu.sehir_ipuclari, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
    /*    if (id == R.id.action_settings) {
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent=new Intent(getApplicationContext(),Profil.class);
            intent.putExtra("user",user);
            intent.putExtra("email",email2);
            intent.putExtra("photo",image);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(getApplicationContext(),mAnasayfa.class);
            intent.putExtra("user",user);
            intent.putExtra("email",email2);
            intent.putExtra("photo",image);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {
            Intent intent=new Intent(getApplicationContext(),Yurtlar.class);
            intent.putExtra("user",user);
            intent.putExtra("email",email2);
            intent.putExtra("photo",image);
            startActivity(intent);

        }
        else if(id==R.id.nav_uni){

            Intent i1=new Intent(getApplicationContext(),UniversiteTanitim.class);
            i1.putExtra("user",user);
            i1.putExtra("email",email2);
            i1.putExtra("photo",image);
            startActivity(i1);
        }
        else if (id == R.id.nav_share) {
            Intent intent=new Intent(getApplicationContext(),Hakkimizda.class);
            intent.putExtra("user",user);
            intent.putExtra("email",email2);
            intent.putExtra("photo",image);
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
