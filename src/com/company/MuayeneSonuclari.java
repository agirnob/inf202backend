package com.company;

public class MuayeneSonuclari {
    private String kaynak;
    private String uzun;
    private String yon;
    private String kalin;
    private String cap;

    private String hata;
    private String hatayer;


    public String getKaynak() {
        return kaynak;
    }

    public String getUzun() {
        return uzun;
    }

    public String getYon() {
        return yon;
    }

    public String getKalin() {
        return kalin;
    }

    public String getCap() {
        return cap;
    }

    public String getHata() {
        return hata;
    }

    public String getHatayer() {
        return hatayer;
    }

    public String getSonuc() {
        return sonuc;
    }

    private String sonuc;

    public MuayeneSonuclari(String kaynak, String uzun, String yon, String kalin, String cap, String hata, String hatayer, String sonuc) {
        this.kaynak = kaynak;
        this.uzun = uzun;
        this.yon = yon;
        this.kalin = kalin;
        this.cap = cap;
        this.hata = hata;
        this.hatayer = hatayer;
        this.sonuc = sonuc;
    }

}
