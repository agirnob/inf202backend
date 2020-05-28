package com.company;

public class Ekipman {

    public Ekipman(String kutupMesafesi, String cihazAdi, String MPTasiyiciOrtam, String miknatislamaTeknigi,
                   String uvIsikSiddeti, String isikMesafesi, String muayeneBolgesi, String akimTipi) {
        this.akimTipi=akimTipi;
        this.cihazAdi=cihazAdi;
        this.isikMesafesi=isikMesafesi;
        this.kutupMesafesi=kutupMesafesi;
        this.miknatislamaTeknigi=miknatislamaTeknigi;
        this.MPTasiyiciOrtam=MPTasiyiciOrtam;
        this.muayeneBolgesi=muayeneBolgesi;
        this.uvIsikSiddeti = uvIsikSiddeti;

    }

    private String kutupMesafesi;
    private String cihazAdi;
    private String MPTasiyiciOrtam;
    private String miknatislamaTeknigi;
    private String uvIsikSiddeti;
    private String isikMesafesi;
    private String muayeneBolgesi;
    private String akimTipi;


    public String getKutupMesafesi() {
        return kutupMesafesi;
    }


    public String getCihazAdi() {
        return cihazAdi;
    }


    public String getMPTasiyiciOrtam() {
        return MPTasiyiciOrtam;
    }


    public String getMiknatislamaTeknigi() {
        return miknatislamaTeknigi;
    }


    public String getUvIsikSiddeti() {
        return uvIsikSiddeti;
    }


    public String getIsikMesafesi() {
        return isikMesafesi;
    }

    public String getMuayeneBolgesi() {
        return muayeneBolgesi;
    }


    public String getAkimTipi() {
        return akimTipi;
    }


}
