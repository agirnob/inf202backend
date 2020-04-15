package com.company;

public class kullanici {

    private long ID;
    private String isim;
    private String soyisim;
    private int seviye;
    private String kullanciAdi;
    private String password;

    public void kullaniciEkle(/*obje*/){
        //büyük ihtimalle controllerdan al ve database ekle sql sınıfıyla
    }
    public void kullaniciCıkar(/*obje*/){
        //controllerdan al databaseden düşür sql sınıfıyla
    }
    public void kullaniciDuzenle(){
        //controllerdan al update sql sınıfyla
    }



    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public int getSeviye() {
        return seviye;
    }

    public void setSeviye(int seviye) {
        this.seviye = seviye;
    }

    public String getKullanciAdi() {
        return kullanciAdi;
    }

    public void setKullanciAdi(String kullanciAdi) {
        this.kullanciAdi = kullanciAdi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    private String job;

}
