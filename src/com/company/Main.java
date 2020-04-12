package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "", "");
        System.out.println("bağlanıldı");
        conn.close();
        conn = DriverManager.getConnection("" + "jdbc:h2:~/test", "", "");
        System.out.println("tekrar bağlanıldı");
        conn.close();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World!");
        Pane myPane = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene myScene = new Scene(myPane);
        stage.setScene(myScene);
        stage.show();
    }
}
