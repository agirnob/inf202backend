package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    public VBox homeDiff;
    public BorderPane borderPaneMain;
    public Button template1;
    public static BorderPane bord;
    public Button homePage;


    public void homePage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../fxmlFiles/Home.fxml"));
        Main.mainScene = new Scene(root);
        Main.window.setScene(Main.mainScene);
    }

    public void kisiEkleDegistir(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../../fxmlFiles/KisiEkleDegistir.fxml"));
        borderPaneMain.setCenter(root);


    }

    public void renkDegistir(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void open(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../../fxmlFiles/TemplateGecis.fxml"));
        borderPaneMain.setCenter(root);
    }

    public void ekipmanEkleDegistir(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../../fxmlFiles/EkipmanBilgileri.fxml"));
        borderPaneMain.setCenter(root);
    }

    public void sirketEkleDegistir(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../fxmlFiles/SirketBilgileri.fxml"));
        borderPaneMain.setCenter(root);
    }
}
