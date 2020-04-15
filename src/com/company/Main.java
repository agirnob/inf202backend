package com.company;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage window;
    public static Scene mainScene;

    public static void main(String[] args) throws Exception {
        DBManager conn = new DBManager();
        conn.connectDB();
        launch(args);
        conn.closeDB();
    }

    @Override
    public void start(Stage stage) throws Exception {
        window=stage;
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
       mainScene = new Scene(root);

        stage.setTitle("deneme");
        stage.setScene(mainScene);
        stage.show();
    }
}
