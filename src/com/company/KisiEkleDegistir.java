package com.company;


import javafx.scene.control.TextField;

import java.util.ArrayList;

public class KisiEkleDegistir extends Main {
    int i = 0;
    public javafx.scene.control.TextField isimDB;
    public TextField soyisimDB;
    public TextField seviyeDB;
    public TextField sifreDB;
    public TextField kullaniciDB;

    public void geriGit() {
        window.setScene(mainScene);
    }


    public void kisiEkle() throws Exception {
        DBManager db = new DBManager();
        String str = "qwwwwwwr";

        String strTable = " CREATE TABLE " + str + "(" +
                "isim VARCHAR(50) NOT NULL," +
                "soyisim VARCHAR(50) NOT NULL," +
                "seviye INT NOT NULL," +
                "password VARCHAR(50) NOT NULL," +
                "kullanıcıAdı VARCHAR(50) NOT NULL UNIQUE" +
                ")";
        db.tableCreate(strTable);
        System.out.println("tablecreated");


        String insertStr = "INSERT INTO " + str +
                " VALUES("+"'" + info().get(0) + "','" + info().get(1) + "'," + info().get(2) + ",'" + info().get(3) + "','" + info().get(4) + "')";
        db.insertDB(insertStr);
        System.out.println("inserted");
        i = i+1;
    }

    private ArrayList<String> info() {
        ArrayList<String> deneme = new ArrayList<>();
        deneme.add(isimDB.getText());
        deneme.add(soyisimDB.getText());
        deneme.add(seviyeDB.getText());
        deneme.add(sifreDB.getText());
        deneme.add(kullaniciDB.getText());

        return deneme;
    }


}
