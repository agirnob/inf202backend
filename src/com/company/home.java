package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class home extends kisiEkleDegistir implements Initializable {

    @FXML
    public VBox homeDiff;
    public BorderPane borderPaneMain;

    public void homePage(ActionEvent actionEvent) {

    }

    public void kisiEkleDegistir(ActionEvent actionEvent) throws IOException {

       Parent root = FXMLLoader.load(getClass().getResource("../../fxmlFiles/kisiEkleDegistir.fxml"));
       borderPaneMain.setCenter(root);


    }

    public void renkDegistir(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
