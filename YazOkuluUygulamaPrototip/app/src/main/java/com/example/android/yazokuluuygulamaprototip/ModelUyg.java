package com.example.android.yazokuluuygulamaprototip;

/**
 * Created by HP on 18.8.2017.
 */

public class ModelUyg {

    String mUniversiteAdi,
            mFakulteAdi,
            mBolum,
            mDersKodu,
            mDersAdi,
            mKredi,
            mAKTS;
    public ModelUyg(){

    }

    public ModelUyg(String mUniversiteAdi, String mFakulteAdi, String mBolum, String mDersKodu, String mDersAdi, String mKredi, String mAKTS) {
        this.mUniversiteAdi = mUniversiteAdi;
        this.mFakulteAdi = mFakulteAdi;
        this.mBolum = mBolum;
        this.mDersKodu = mDersKodu;
        this.mDersAdi = mDersAdi;
        this.mKredi = mKredi;
        this.mAKTS = mAKTS;
    }

    public String getmUniversiteAdi() {
        return mUniversiteAdi;
    }

    public void setmUniversiteAdi(String mUniversiteAdi) {
        this.mUniversiteAdi = mUniversiteAdi;
    }

    public String getmFakulteAdi() {
        return mFakulteAdi;
    }

    public void setmFakulteAdi(String mFakulteAdi) {
        this.mFakulteAdi = mFakulteAdi;
    }

    public String getmBolum() {
        return mBolum;
    }

    public void setmBolum(String mBolum) {
        this.mBolum = mBolum;
    }

    public String getmDersKodu() {
        return mDersKodu;
    }

    public void setmDersKodu(String mDersKodu) {
        this.mDersKodu = mDersKodu;
    }

    public String getmDersAdi() {
        return mDersAdi;
    }

    public void setmDersAdi(String mDersAdi) {
        this.mDersAdi = mDersAdi;
    }

    public String getmKredi() {
        return mKredi;
    }

    public void setmKredi(String mKredi) {
        this.mKredi = mKredi;
    }

    public String getmAKTS() {
        return mAKTS;
    }

    public void setmAKTS(String mAKTS) {
        this.mAKTS = mAKTS;
    }
}
