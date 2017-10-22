package com.example.android.yazokuluuygulamaprototip;

import android.app.Activity;

import android.content.Context;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.yazokuluuygulamaprototip.R.id.akts;
import static com.example.android.yazokuluuygulamaprototip.R.id.dersAdi;
import static com.example.android.yazokuluuygulamaprototip.R.id.kredi;

/**
 * Created by HP on 18.8.2017.
 */

public class CustomAdapter extends BaseAdapter{

    LayoutInflater layoutInflater;
    private List<ModelUyg> arrayList = new ArrayList<ModelUyg>();
    public  Context context1;

    public Context getContext1() {
        return context1;
    }

    public void setContext1(Context context) {
        this.context1 = context;
    }


    public CustomAdapter(Context context) {
        this.context1 = context;
    }

    public  CustomAdapter(Activity activity, List<ModelUyg>arrayList){
        layoutInflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    String uni;
    String faculty;
    String bolum;
    String ders;
    AlertDialog.Builder alert;
    TextView txt;
    ScrollView sv;
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ModelUyg model=arrayList.get(i);
        View satir=layoutInflater.inflate(R.layout.satir_tasarimi,null);
        TextView uni_adi=(TextView)satir.findViewById(R.id.uni_adi);
        TextView uni_fakulte=(TextView)satir.findViewById(R.id.fakulteAdi);
        TextView uni_bolum=(TextView)satir.findViewById(R.id.bolum);
        TextView uni_derskodu=(TextView)satir.findViewById(R.id.dersKodu);
        TextView uni_dersadi=(TextView)satir.findViewById(dersAdi);
        TextView uni_kredi=(TextView)satir.findViewById(kredi);
        TextView uni_AKTS=(TextView)satir.findViewById(akts);
        Button uni_click=(Button)satir.findViewById(R.id.uni_click);
        Button yorum_click=(Button)satir.findViewById(R.id.yorum_click);
        uni_adi.setText(model.getmUniversiteAdi().toUpperCase());
        uni_fakulte.setText(model.getmFakulteAdi().toUpperCase());
        uni_bolum.setText(model.getmBolum().toUpperCase());
        uni_derskodu.setText(model.getmDersKodu());
        uni_dersadi.setText(model.getmDersAdi().toUpperCase());
        uni_kredi.setText(model.getmKredi());
        uni_AKTS.setText(model.getmAKTS());
        yorum_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent myactivity = new Intent(context1, KullaniciGirisi.class);
                context1.startActivity(myactivity);//bu iki satir ile sayfa yonlendirmesi yapabilirsiniz */
                AlertDialog.Builder alert = new AlertDialog.Builder(context1);
                String uniAdi=model.getmUniversiteAdi();
                alert.setTitle(i+". hakkında yorum yap");
                final EditText txt_yorum=new EditText(context1);
                txt_yorum.setHint("yorum yaz...");
                txt_yorum.setPadding(15,50,20,15);
                txt_yorum.setSingleLine();
                alert.setView(txt_yorum);
                alert.setPositiveButton("Yorum Yap", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String value = txt_yorum.getText().toString().trim();

                    }
                });
                alert.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });
                alert.show();
            }
        });

        uni_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 uni=model.getmUniversiteAdi();
                 faculty=model.getmFakulteAdi();
                 bolum=model.getmBolum();
                 ders=model.getmDersAdi();
                 txt=new TextView(context1);
                sv=new ScrollView(context1);
                alert = new AlertDialog.Builder(context1);
                alert.setTitle("Ders İçeriği");
                FirebaseDatabase  firebaseDatabase = FirebaseDatabase.getInstance();
                final DatabaseReference databaseReference = firebaseDatabase.getReference("icerik");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            dataSnapshot.getKey();

                            if (ders.equals(ds.child("mDersAdi").getValue().toString()) && uni.equals(ds.child("mUniversiteAdi").getValue().toString()) && faculty.equals(ds.child("mFakulteAdi").getValue().toString())&& bolum.equals(ds.child("mBolum").getValue().toString())) {
                                String icerik=ds.child("mIcerik").getValue().toString();
                                txt.setText(icerik);
                                sv.addView(txt);
                                alert.setView(sv);
                                alert.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        dialog.cancel();
                                    }
                                });

                                alert.show();

                            }



                            }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            /*    TextView txt=new TextView(context1);
                AlertDialog.Builder alert = new AlertDialog.Builder(context1);
                alert.setTitle("Ders İçeriği");
                String icerik="Yazaç aktarımı ve mikroişlemciler: Yazaç aktarım dili, yazaçlar arası aktarım, veri yolu ve bellek aktarımı, aritmetik mikro işlemler, mantıksal mikro işlemler, kaydırma mikro işlemleri, aritmetik mantık kaydırma birimi. Temel bilgisayar yapısı ve tasarımı: Buyruk kodu, bilgisayar yazaçları, bilgisayar buyrukları, zamanlama ve denetim, buyruk süreci, bellek adreslemeli buyruklar, giriş-çıkış buyrukları ve kesmeler, işlemci yazacı mantık tasarımı, Temel bilgisayarın programlanması: Birleştirici dil gösterimi, derleyici, program döngüleri, aritmetik ve mantıksal işlemlerin programlanması, alt programlar, giriş/çıkışın programlanması. Mikro programlanmış denetim: Denetim belleği, mikro program örneği, denetim birimi tasarımı, genel yazaç kurulumu, buyruk biçimleri, adresleme kipleri, program denetimi. Boru hattı ve vektör işlemleri, aritmetik işlem boru hattı, paralel işleme, buyruk boru hattı, risc boru hattı, vektör işlemleri, dizi işlemleri. Bilgisayar aritmetiği, toplama ve çıkarma, çarpma algoritmaları, bölme algoritmaları. Giriş/Çıkış organizasyonu, giriş/çıkış ara yüzeyi, eş zamanlı olmayan veri transferi, aktarma kipleri, doğrudan bellek erişimi, giriş/çıkış işlemcisi. Bellek tasarımı: ana bellek, yardımcı bellek. Çoklu işlemler: Çoklu işlemcilerin karakteristikleri, işlemciler arası seçim, işlemciler arsı iletişim ve eş zamanlılık.";
           if(bolum.equals("bilgisayar mühendisliği")&&uni.equals("pamukkale üniversitesi")&&faculty.equals("mühendislik fakültesi")){
                txt.setText(icerik);
           }
                alert.setView(txt);
                alert.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });
                alert.show();*/
            }
        });

        return satir;
    }
}
