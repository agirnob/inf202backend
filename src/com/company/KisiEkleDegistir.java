package com.company;

import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class KisiEkleDegistir extends Main {


    public void geriGit(ActionEvent actionEvent) {
        window.setScene(mainScene);
    }

    public void kisiEkle(ActionEvent actionEvent) throws Exception {
        DBManager db = new DBManager();
        String str = " CREATE TABLE isim(" +
                "id INT NOT NULL," +
                "isim VARCHAR(50) NOT NULL)";
        db.tableCreate(str);
    }


}
