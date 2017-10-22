package com.example.android.yazokuluuygulamaprototip;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import static com.example.android.yazokuluuygulamaprototip.R.array.ozel_uni;

public class UniversiteTanitim extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String image,user,email2;
    Spinner spinner;
    Button buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universite_tanitim);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner=(Spinner)findViewById(R.id.spinner1);
        buton=(Button)findViewById(R.id.ozel_tani);
buton.setOnClickListener(new View.OnClickListener() {
    String resim1="https://www.ku.edu.tr/sites/default/files/styles/homepage_slider_image/public/equis-tr.jpg?itok=306JGhAO";
    @Override
    public void onClick(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(UniversiteTanitim.this);

        alert.setTitle("Üniversite Tanıtımı");
ImageView r=new ImageView(UniversiteTanitim.this);
        alert.setView(r);
        if("KOÇ ÜNİVERSİTESİ".equals(String.valueOf(spinner.getSelectedItem()))){
        Picasso.with(getBaseContext()).load(resim1).into(r);}
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
        if(!email2.isEmpty()){
            kullaniciAdi.setText(user);
            email.setText(email2);
            Picasso.with(getBaseContext()).load(image).into(resim);

        }

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
      //  getMenuInflater().inflate(R.menu.universite_tanitim, menu);
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
            Intent intent=new Intent(UniversiteTanitim.this,Profil.class);
            intent.putExtra("user",user);
            intent.putExtra("email",email2);
            intent.putExtra("photo",image);
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(UniversiteTanitim.this,mAnasayfa.class);
            intent.putExtra("user",user);
            intent.putExtra("email",email2);
            intent.putExtra("photo",image);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {
            Intent i1=new Intent(getApplicationContext(),Yurtlar.class);
            i1.putExtra("user",user);
            i1.putExtra("email",email2);
            i1.putExtra("photo",image);
            startActivity(i1);
            //   startActivity(new Intent(getApplicationContext(),Yurtlar.class));

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
            // startActivity(new Intent(getApplicationContext(),Hakkimizda.class));

        } else if (id == R.id.nav_send) {
            FirebaseAuth.getInstance().signOut();
            //   startActivity(new Intent(getApplicationContext(),KullaniciGirisi.class));
            // finish();
            // System.exit(0);
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
