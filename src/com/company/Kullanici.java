package com.company;

public class Kullanici {


    private String isim;
    private String soyisim;
    private String seviye;
    private String kullaniciAdi;
    private String password;


    public Kullanici(String isim, String soyisim, String seviye, String kullaniciAdi, String password) {

        this.isim = isim;
        this.soyisim = soyisim;
        this.seviye = seviye;
        this.kullaniciAdi = kullaniciAdi;
        this.password = password;

    }
    public Kullanici(){}







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

    public String getSeviye() {
        return seviye;
    }

    public void setSeviye(String seviye) {
        this.seviye = seviye;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
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
