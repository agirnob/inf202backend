package com.company;

import javafx.event.ActionEvent;

public class KisiEkleDegistir extends Main {

    public javafx.scene.control.TextField isimDB;

    public void geriGit(ActionEvent actionEvent) {
        window.setScene(mainScene);
    }



    public void kisiEkle(ActionEvent actionEvent) throws Exception {
        DBManager db = new DBManager();
        String str = "user";
        db.tableCreate(str);
        System.out.println(isimDB.getText());

    }



}
