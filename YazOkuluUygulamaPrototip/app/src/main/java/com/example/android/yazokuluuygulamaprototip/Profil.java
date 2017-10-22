package com.example.android.yazokuluuygulamaprototip;

import android.app.ProgressDialog;
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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class Profil extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Spinner uniAdi;
    WebView webview;
    String image,user,email2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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



        uniAdi=(Spinner)findViewById(R.id.spinner);
        uniAdi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {




                 if("ABANT İZZET BAYSAL ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://ibu.edu.tr/tr/duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("ABDULLAH GÜL ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.agu.edu.tr/duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("ACIBADEM MEHMET ALİ AYDINLAR ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.acibadem.edu.tr/duyuru");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("ADANA BİLİM VE TEKNOLOJİ ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.adanabtu.edu.tr/PagesTR/DuyuruList.aspx");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }


                else if("ADİYAMAN ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://adiyaman.edu.tr/TR/Duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }


                else if("ADNAN MENDERES ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("https://www.adu.edu.tr/tr/duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("AFYON KOCATEPE ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://aku.edu.tr/category/duyurular/");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("AĞRI İBRAHİM ÇEÇEN ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("https://www.agri.edu.tr/tr/idari/ogrenciisleri/duyuru");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("AHİ EVRAN ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("https://www.ahievran.edu.tr/index.php/arsiv/genel-duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("AKDENİZ ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.akdeniz.edu.tr/tema/tumduyurular.php");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("AKSARAY ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.aksaray.edu.tr/tr/duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("ALANYA ALAADDİN KEYKUBAT ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("https://www.alanya.edu.tr/arsiv/duyuru");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("ALANYA HAMDULLAH EMİN PAŞA ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.ahep.edu.tr/");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("ALTINBAŞ ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://en.kemerburgaz.edu.tr/tr/hakkimizda/duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }

                else if("AMASYA ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("https://www.amasya.edu.tr/tum-duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("ANADOLU ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("https://www.anadolu.edu.tr/duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("ANKA TEKNOLOJİ ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.anka.edu.tr/");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("ANKARA GÜZEL SANATLAR ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.gsf.ankara.edu.tr/");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("ANKARA SOSYAL BİLİMLER ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("https://www.asbu.edu.tr/tr-TR/kddb-duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                else if("ANKARA ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("https://www.ankara.edu.tr/kategori/duyurular/");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("ANKARA YILDIRIM BEYAZIT ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.ybu.edu.tr/content_list-257-duyurular.html");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("ANTALYA AKEV ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.akev.edu.tr/");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("ANTALYA BİLİM ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.antalya.edu.tr/?duyurular-haberler,");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                else if("ARDAHAN ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("https://www.ardahan.edu.tr/tum-haber-duyuru.aspx?type=0");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("ARTVİN ÇORUH ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("https://www.artvin.edu.tr/tr/duyuru/listele");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("ATAŞEHİR ADIGÜZEL MESLEK YÜKSEKOKULU".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.adiguzel.edu.tr/duyurular/");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("ATATÜRK ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("https://atauni.edu.tr/duyurular/ataturk-universitesi");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("ATILIM ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.atilim.edu.tr/content/duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("AVRASYA ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.avrasya.edu.tr/duyurular-2/");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("AVRUPA MESLEK YÜKSEKOKULU".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://avrupa.edu.tr/index.php/tr/haberler-ve-duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("AVRUPA MESLEK YÜKSEKOKULU".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://avrupa.edu.tr/index.php/tr/haberler-ve-duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("BAHÇEŞEHİR ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://bahcesehir.edu.tr/icerik/liste/tip_kodu/blog/blog_id/5962");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                else if("BALIKESİR ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.balikesir.edu.tr/index.php/baun/duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("BANDIRMA ONYEDİ EYLÜL ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("bvhttp://www.bandirma.edu.tr/tr/duyuru/goruntule/liste");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                else if("BARTIN ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://oidb.bartin.edu.tr/Tum-Duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("BAŞKENT ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.baskent.edu.tr/duyurular.php?tip=N");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                else if("BATMAN ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.batman.edu.tr/Sayfalar/Universite-Hakkinda/Duyurular/115");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("BAYBURT ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.bayburt.edu.tr/tr/Duyurular/www");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("BEYKENT ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.beykent.edu.tr/announcements");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("BEZM-İ ÂLEM VAKIF ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://bezmialem.edu.tr/tr/Sayfalar/Index.aspx");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("BİLECİK ŞEYH EDEBALİ ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.bilecik.edu.tr/AnaSayfa/TumDuyuru");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }

                else if("BİNGÖL ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.bingol.edu.tr/tr/duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("BİRUNİ ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("https://www.biruni.edu.tr/index.php/news");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                else if("BİTLİS EREN ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.beu.edu.tr/PKol.aspx?zcms=51&zcmsID=Duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("BOĞAZİÇİ ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.boun.edu.tr/tr_TR/Content/Duyurular/Duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("BOZOK ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://bozok.edu.tr/duyurular.aspx");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("BURSA TEKNİK ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://oidb.btu.edu.tr/index.php?page=duyuru");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("BÜLENT ECEVİT ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://w3.beun.edu.tr/tum-duyurular.html");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }

                else if("CELAL BAYAR ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://uygulama3.cbu.edu.tr/ilansistemi/Ilanlar.aspx?IlanTuru=1");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("CUMHURİYET ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.cumhuriyet.edu.tr/tumduyurular.php");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("ÇAĞ ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.cag.edu.tr/duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                else if("ÇANAKKALE 18 MART ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.comu.edu.tr/duyurular.html");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("ÇANKAYA ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.cankaya.edu.tr/duyuru/index.php");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                else if("ÇANKIRI KARATEKİN ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://oidb.karatekin.edu.tr/");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("ÇUKUROVA ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.cu.edu.tr/tr/TumHaberler.aspx");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                else if("DİCLE ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.dicle.edu.tr/");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("DOĞUŞ ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("https://www.dogus.edu.tr/tr/haberler/giris.asp");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                else if("DOKUZ EYLÜL ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                    webview=(WebView)findViewById(R.id.webview);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.loadUrl("http://www.deu.edu.tr/tum-duyurular");
                    final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                    progress.show();

                    webview.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }
                    });
                }
                 else if("DUMLUPINAR ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.dumlupinar.edu.tr/index/duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("DÜZCE ÜNİVERSİTESİİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("https://www.duzce.edu.tr/fakulte-duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("EGE ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://egeduyuru.ege.edu.tr/tum_duyurular.html");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("ERCİYES ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("https://www.erciyes.edu.tr/Tum-Duyurular/0");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("ERZİNCAN ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.erzincan.edu.tr/tr/category/Duyurular/");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("ERZURUM TEKNİK ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("https://www.erzurum.edu.tr/Duyuru/Duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 } else if("ESKİŞEHİR OSMAN GAZİ ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("https://www.ogu.edu.tr/Web/DuyuruDetay");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 } else if("FARUK SARAÇ TASARIM MESLEK YÜKSEKOKULU".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.faruksarac.edu.tr/myo/duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("FATİH SULTAN MEHMET VAKIF ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.fsm.edu.tr/Tum-Duyuru-Arsivi");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("FIRAT ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.firat.edu.tr/tr/duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("GALATASARAY ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("https://gsu.edu.tr/tr/duyuru-ve-haberler/duyurular/");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("GAZİ ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://gazi.edu.tr/posts?type=news");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("GAZİANTEP ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("https://www.gantep.edu.tr/duyuru/index.php?t=1");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("GAZİOSMANPAŞA ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.gop.edu.tr/Default.aspx?d=tr-TR");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("GEBZE TEKNİK ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.gtu.edu.tr/kategori/9/0/display.aspx?languageId=1");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("GİRESUN ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.giresun.edu.tr/tr/gunceltumilan");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("GÜMÜŞHANE ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.gumushane.edu.tr/haber-arsivi/");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("HACETTEPE ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("https://www.hacettepe.edu.tr/duyuru/guncel-duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("HAKKARİ ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.hu.edu.tr/");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("HALİÇ ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.halic.edu.tr/tr/duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("HARRAN ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("https://www.harran.edu.tr/duylist.aspx?duyPerSay=20&sayfaNum=0");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("HASAN KALYONCU ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://mobil.hku.edu.tr/Duyurular/");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("HİTİT ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.hitit.edu.tr/");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("IĞDIR ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.igdir.edu.tr/t%C3%BCm-duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("IŞIK ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://www.isikun.edu.tr/duyurular");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("İBN HALDUN ÜNİVERSİTESİ".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("http://ibnhaldun.edu.tr/");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }
                 else if("".equals(String.valueOf(uniAdi.getSelectedItem()))){
                     webview=(WebView)findViewById(R.id.webview);
                     webview.getSettings().setJavaScriptEnabled(true);
                     webview.loadUrl("");
                     final ProgressDialog progress=ProgressDialog.show(Profil.this,"Duyurular","yükleniyor",true);
                     progress.show();

                     webview.setWebViewClient(new WebViewClient() {

                         @Override
                         public void onPageFinished(WebView view, String url) {
                             super.onPageFinished(view, url);
                             Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }

                         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                             Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                             progress.dismiss();
                         }
                     });
                 }

























                // Toast.makeText(Profil.this, ""+String.valueOf(uniAdi.getSelectedItem()), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      /*  fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
      //  getMenuInflater().inflate(R.menu.profil, menu);
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
            Intent intent=new Intent(Profil.this,Profil.class);
            intent.putExtra("user",user);
            intent.putExtra("email",email2);
            intent.putExtra("photo",image);
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(Profil.this,mAnasayfa.class);
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
