package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class controllerHome extends Main implements Initializable {


    public void homePage(ActionEvent actionEvent) {

    }

    public void kisiEkleDegistir(ActionEvent actionEvent) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("kisiEkleDegistir.fxml"));
       Scene scene = new Scene(root);
       window.setScene(scene);

    }

    public void renkDegistir(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
