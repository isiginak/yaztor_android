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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class mAnasayfa extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button ekle,ara;
    private EditText akts,kredi;
    private AutoCompleteTextView ders_adi;
    String image,user,email2;
    String []languages={"BİLGİSAYAR MİMARİSİ","GENEL MUHASEBE II",
            "GENEL MUHASEBE II","GÖRSEL PROGRAMLAMA I",
            "GÖRSEL PROGRAMLAMA II","CERRAHİ HASTALIKLAR HEMŞİRELİĞİ",
            "TEMEL ELEKTRONİK","ALTERNATİF AKIM DEVRELERİ","MİKRODENETLEYİCİLER",
            "ATATÜRK İLKELERİ VE İNKILAP TARİHİ I","ATATÜRK İLKELERİ VE İNKILAP TARİHİ II",
            "İNTERNET TABANLI PROGRAMLAMA","BİLGİSAYAR VE ÖĞRETİM TEKNOLOJİLERİ ÖĞRETMENLİĞİ",
            "BİLİMSEL ARAŞTIRMA YÖNTEMLERİ","MASAÜSTÜ YAYINCILIK","BİLİMSEL ARAŞTIRMA YÖNTEMLERİ",
            "GENEL FİZİK I","BİLİMİN DOĞASI VE BİLİM TARİHİ","GENEL FİZİK II",
            "GENEL KİMYA II","FİZİKTE ÖZEL KONULAR","GENEL MATEMATİK I",
            "GENEL KİMYA-III(ANALİTİK KİMYA)","GENEL KİMYA-IV(ORGANİK KİMYA)",
            "ÖZEL ÖĞRETİM YÖNTEMLERİ II", "TÜRK DİLİ - I:SES VE YAPI BİLGİSİ",
            "ASTRONOMİ","EĞİTİM SOSYOLOJİSİ","İNSAN HAKLARI VE DEMOKRASİ",
            "SÖYLEM ÇÖZÜM. VE İNGİLİZCE ÖĞRETİMİ","ENVANTER BİLANÇO","SÖZ DİZİMİ ANLAMBİLİM",
            "İNGİLİZCE ÖĞRETİMİNDE YAKLAŞIMLAR-I","DİL EDİNİMİ","ÇOCUKLARA YABANCI DİL ÖĞRETİMİ-II",
            "MUHASEBE DENETİMİ","ÇOCUKLARA YABANCI DİL ÖĞRETİMİ I","MALİ TABLOLAR ANALİZİ",
            "İLKOKUMA VE YAZMA ÖĞRETİMİ","ÖĞRETİM TEKNOLOJİLERİ VE MATERYEL TASARIMI",
            "MATEMATİK ÖĞRETİMİ- I","MALİYET MUHASEBESİ 1","ÖĞRETİM İLKE VE YÖNTEMLERİ",
            "FEN VE TEKNOLOJİ ÖĞRETİMİ-I","MALİYET MUHASEBESİ 2","FEN VE TEKNOLOJİ ÖĞRETİMİ-II",
            "GENEL MUHASEBE 1","ÖĞRETİM İLKE VE YÖNTEMLERİ","FEN VE TEKNOLOJİ ÖĞRETİMİ-I",
            "GENEL MUHASEBE 2","TÜRKÇE ÖĞRETİMİ","EĞİTİM PSİKOLOJİSİ","ULUSLARARASI İŞLETME",
            "MATEMATİK ÖĞRETİMİ II","DAVRANIŞ BİLİMLERİ","İNSAN HAKLARI VE DEMOKRASİ","EĞİTİM BİLİMİNE GİRİŞ",
            "ÜRETİM YÖNETİMİ 1","ÜRETİM YÖNETİMİ 2","İSTATİSTİK 1","ÖZEL ÖĞRETİM YÖNTEMLERİ-I",
            "ÖZEL ÖĞRETİM YÖNTEMLERİ-I","ISL208-1994","ŞİRKETLER MUHASEBESİ","SINIF YÖNETİMİ",
            "FİNANSAL YÖNETİM","SINIF YÖNETİMİ","PARA-BANKA","SERMAYE PİYASASI",
            "MATEMATİK 1","ÖĞRETİM TEKNOLOJİLERİ VE MATERYAL TASARIMI","MATEMATİK 2","YÖNEYLEM ARAŞTIRMA 1",
            "REHBERLİK","YÖNEYLEM ARAŞTIRMA 2","TÜRK EĞİTİM SİSTEMİ VE OKUL YÖNETİMİ",
            "CİNSEL SAĞLIK EĞİTİMİ","ERKEN ÇOCUKLUK DÖNEMİNDE ÇEVRE EĞİTİMİ",
            "EĞİTİM FELSEFESİ","SINIF YÖNETİMİ","ERKEN ÇOCUKLUK DÖNEMİNDE OKUMA YAZMAYA HAZIRLIK DÖNEMİ",
            "DİFERANSİYEL DENKLEMLER","EĞİTİM SOSYOLOJİSİ","İNSAN İLİŞKİLERİ VE İLETİŞİM",
            "ATATÜRK İLKE VE İNKILAPLARI TARİHİ 1","ÖZEL ÖĞRETİM YÖNTEMLERİ II",
            "REHBERLİK VE PSİKOLOJİK DANIŞMANLIK","ATATÜRK İLKE VE İNKILAPLARI TARİHİ 2",
            "İNSAN HAKLARI VE DEMOKRASİ","İNGİLİZCE 1","DAVRANIŞ BOZUKLUKLARI","İNGİLİZCE 2",
            "TÜRK DİLİ 1","TÜRK DİLİ 2","OSMANLI TARİHİ VE UYGARLIĞI I",
            "KÜLTÜREL VE SOSYAL DEĞİŞME","GÜZEL KONUŞMA VE YAZMA","ESKİ TÜRK EDEBİYATI I",
            "ALAN EĞİTİMİNDE ARAŞTIRMA PROJESİ","ANALİZ 3","ANALİZ 3","ARAŞTIRMA PROJESİ 1",
            "ARAŞTIRMA PROJESİ 1","ARAŞTIRMA PROJESİ 2","ATATÜRK İLKE VE İNKILAPLARI TARİHİ 1",
            "BAĞLAMSAL DİLBİLGİSİ 1","BAĞLAMSAL DİLBİLGİSİ 2","BEDEN EĞİTİMİ VE OYUN ÖĞRETİMİ",
            "BİLGİSAYAR DESTEKLİ EĞİTİM","BİLGİSAYAR 1","BİLGİSAYAR 2","BİLİM TARİHİ",
            "BİLİMSEL ARAŞTIRMA YÖNTEMLERİ","COĞRAFİ KAVRAMLAR ANALİZİ","COĞRAFYA ARAŞTIRMALARI 2",
            "COĞRAFYA ÖĞRETİMİNDE DÜŞÜNCE GELİŞİMİ","ÇOCUK EDEBİYATI","ÇOCUKTA DÜŞÜNCE GELİŞİMİ",
            "DİFERANSİYEL DENKLEMLER","DİN EĞİTİMİ","DÜŞÜNME BECERİLERİ EĞİTİMİ",
            "DÜŞÜNME BECERİLERİ EĞİTİMİ","EĞİTİM BİLİMİNE GİRİŞ","EĞİTİM PSİKOLOJİSİ",
            "EĞİTİM PSİKOLOJİSİ","EĞİTİM PSİKOLOJİSİ","ELEKTRİK VE MANYETİZMA","ERKEN ÇOCUKLUK DÖNEMİNDE GELİŞİM",
            "ERKEN ÇOCUKLUK DÖNEMİNDE GELİŞİM 1","GELİŞİM PSİKOLOJİSİ","GENEL MATEMATİK","İLERİ OKUMA VE YAZMA 2",
            "İLERİ OKUMA VE YAZMA 2","İNGİLİZ EDEBİYATI 1","İNGİLİZ EDEBİYATI 2",
            "ALGORİTMA VE PROGRAMLAMA 1","ALGORİTMA VE PROGRAMLAMA 2","BİLGİSAYAR BİLİMİNİN TEMELLERİ",
            "ELEKTRİK DEVRELERİ (BİLGİSAYAR MÜH.)","SİSTEM TEORİSİ","MESLEKİ İNGİLİZCE 1",
            "MESLEKİ İNGİLİZCE 2","BİLGİSAYAR BİLİMİ İÇİN AYRIK MATEMATİK","PROGRAMLAMA DİLLERİ",
            "BİÇİMSEL DİLLER VE OTTOMATA TEORİSİ","ALGORİTMA ANALİZİ","AKIŞKANLARIN MEKANİĞİ",
            "HİDROLİK","İÇME SULARININ ARITIMI","ARITMA TESİSİ HİDROLİĞİ","ATIKSULARIN ARITIMI",
            "ISI TRANSFERİ","SAYISAL YÖNTEMLER","ISI AKTARIMI","KÜTLE VE ENERJİ DENKLİKLERİ",
            "AMERİKA COĞRAFYASI","TÜRKİYE TURİZM  COĞRAFYASI","OSEONOGRAFYA",
            "BÖLGE PLANLAMA","İLKÇAĞ TARİHİ -I","İLKÇAĞ TARİHİ - II","İLKÇAĞ MEDENİYET TARİHİ -II",
            "OSMANLI DİPLOMATİKASI - I","OSMANLI DİPLOMATİKASI -II","KLASİK MANTIK","İLERİ FRANSIZCA DİLBİLGİSİ II","İLERİ FRANSIZCA DİLBİLGİSİ I",
            "TÜRK DİLİNİN VE LEHÇELERİNİN SORUNLARI","HAREZM KIPÇAK TÜRKÇESİ","DOĞA VE ÇEVRE",
            "EVCİL HAYVANLAR","ŞİFALI BİTKİLER","POPÜLER BİYOLOJİ",
            "CANLILAR ARASI İLETİŞİM","HÜCRE VE YAŞAM","ALMANCA VIII",
            "ALMANCA VII","ALMANCA V","FELSEFEYE GİRİŞ","VARLIK FELSEFESİ","MODERN MANTIK",
            "AHLAK FELSEFESİ","GENEL FİZİK - II","İNGİLİZ EDEBİYATI ANAHATLARI-II","EDB. TERİMLERİ VE AKIMLARI-I",
            "MİTOLOJİ-I","BATI EDEBİYATININ KÖKENLERİ - II","İLERİ İNGİLİZCE DİLBİLGİSİ-I","İLERİ İNGİLİZCE DİLBİLGİSİ - II",
            "AMERİKAN KÜLTÜRÜ VE EDEBİYATI-I","AMERİKAN KÜLTÜRÜ VE EDEBİYATI-II","İNGİLİZ KÜLTÜR TARİHİ - I","TİYATROYA GİRİŞ",
            "ORTAÇAĞ İNGİLİZ EDEBİYATI-I","AMERİKAN ROMANI-I","ÇEVİRİYE GİRİŞ-I",
            "ÇEVİRİYE GİRİŞ-II","İNGİLİZ ŞİİRİNE GİRİŞ","SHAKESPEARE I",
            "SHAKESPEARE II","ÇEVİRİ-I","ÇEVİRİ-II","ÇAĞDAŞ AMERİKAN TİYATROSU",
            "BATI EDEBİYATINDA POPÜLER KÜLTÜR-I","20. YY. İNGİLİZ ROMANI-I","20. YY. İNGİLİZ ROMANI-II",
            "TÜRKİYE`NİN TOPLUMSAL YAPISI-I","TÜRKİYE`NİN TOPLUMSAL YAPISI-II","SOSYAL BİLİMLERDE METODOLOJİ",
            "İLETİŞİM SOSYOLOJİSİ","TOPLUMSAL SINIF ANALİZLERİ","GELİŞME SOSYOLOJİSİ","KENT SOSYOLOJİSİ",
            "AYDIN KİMLİĞİ VE TÜRKİYE","SOSYAL BİLİMLERDE İSTATİSTİK VE SPSS","DEĞİŞİM SOSYOLOJİSİ",
            "DEMOKRASİ VE SİYASET","GÜNCEL OLAYLAR SOSYOLOJİSİ","OSMANLICA-II","İLKÇAĞ TARİHİ-I",
            "İLKÇAĞ TARİHİ-II","OSMANLICA TARİH MET-II","ANADOLU`NUN TARİHİ COĞRAFYASI","ÖN ASYA KÜLTÜRÜ TARİHİ",
            "SİYASİ VE İKT.DÜŞ.TAR. - I","OSMANLI TÜRKÇESİ-II","HALK BİLİMİ",
            "YENİ TÜRK EDEBİYATINA GİRİŞ","BATI EDEBİYATINDA EDEBİ EKOLLER","ESKİ TÜRKÇE",
            "MİLLİ EDEBİYAT","ORTA TÜRKÇE","ESKİ ANADOLU TÜRKÇESİ","TÜRK HALK ANLATILARI","ALTAYİSTİĞE GİRİŞ","DİVAN EDEBİYATI-III","TÜRK AŞIK EDEBİYATI",










    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_anasayfa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ders_adi=(AutoCompleteTextView)findViewById(R.id.ders_adi);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,languages);
          ders_adi.setAdapter(adapter);
        ders_adi.setThreshold(1);
        kredi=(EditText)findViewById(R.id.kredi);
        akts=(EditText)findViewById(R.id.akts);
        ara=(Button) findViewById(R.id.ara);


      /*  ekle=(Button)findViewById(R.id.ekle);
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mAnasayfa.this,VerileriEkle.class));
            }
        });*/



        final String dersismi=ders_adi.getText().toString().trim().toLowerCase();
        final String AKTS=akts.getText().toString().trim().toLowerCase();
        final String Kredi=kredi.getText().toString().trim().toLowerCase();

        ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mAnasayfa.this,mDersleriGetir.class);
                intent.putExtra("ders",ders_adi.getText().toString().trim().toLowerCase());
                intent.putExtra("aktsm",akts.getText().toString().trim().toLowerCase());
                intent.putExtra("kredim",kredi.getText().toString().trim().toLowerCase());
                intent.putExtra("user",user);
                intent.putExtra("email",email2);
                intent.putExtra("photo",image);
                startActivity(intent);
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
     //   getMenuInflater().inflate(R.menu.m_anasayfa, menu);
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
            Intent intent=new Intent(mAnasayfa.this,Profil.class);
            intent.putExtra("user",user);
            intent.putExtra("email",email2);
            intent.putExtra("photo",image);
            startActivity(intent);
          //  startActivity(new Intent(mAnasayfa.this,Profil.class));
        } else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(mAnasayfa.this,mAnasayfa.class);
            intent.putExtra("user",user);
            intent.putExtra("email",email2);
            intent.putExtra("photo",image);
            startActivity(intent);
          //  startActivity(new Intent(mAnasayfa.this,mAnasayfa.class));

        } else if (id == R.id.nav_slideshow) {
            Intent intent=new Intent(getApplicationContext(),Yurtlar.class);
            intent.putExtra("user",user);
            intent.putExtra("email",email2);
            intent.putExtra("photo",image);
            startActivity(intent);
           // startActivity(new Intent(getApplicationContext(),Yurtlar.class));

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
        //    startActivity(new Intent(getApplicationContext(),Hakkimizda.class));

        } else if (id == R.id.nav_send) {
            FirebaseAuth.getInstance().signOut();

            //  startActivity(new Intent(getApplicationContext(),KullaniciGirisi.class));
           Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent); android.os.Process.killProcess(android.os.Process.myPid());

//Uygulamamızı sonlandırıyoruz.

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
