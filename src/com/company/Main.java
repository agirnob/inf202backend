package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage window;
    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "", "");
        System.out.println("bağlanıldı");
        conn.close();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window=stage;
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("deneme");
        stage.setScene(scene);
        stage.show();
    }
}
