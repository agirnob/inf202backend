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
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "", "");
        System.out.println("bağlanıldı");
        Statement stmt = conn.createStatement();

        try {
            String sql = "CREATE TABLE isim(" +
                    "id INT NOT NULL," +
                    "isim VARCHAR(50) NOT NULL)";
            stmt.executeUpdate(sql);
            System.out.println("table başarılı bir şekilde oluşturuldu.");
        }catch (Exception e){
            System.out.println("bu zaten önceden var açmana gerek yok");
        }
        conn.close();
    }


}
