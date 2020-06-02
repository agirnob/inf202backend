package com.company;

public class Sirket {
    private String musteriIsmi;
    private String il;
    private String ilce;
    private String teklifNo;
    private String isEmriNo;


    public Sirket(String musteriIsmi, String il, String ilce, String teklifNo, String isEmriNo) {
        this.musteriIsmi = musteriIsmi;
        this.il = il;
        this.ilce = ilce;
        this.teklifNo = teklifNo;
        this.isEmriNo = isEmriNo;
    }

    public String getMusteriIsmi() {
        return musteriIsmi;
    }

    public String getIl() {
        return il;
    }

    public String getIlce() {
        return ilce;
    }

    public String getTeklifNo() {
        return teklifNo;
    }

    public String getIsEmriNo() {
        return isEmriNo;
    }
}
