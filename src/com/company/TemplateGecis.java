package com.company;

import controller.EkipmanBilgileri;
import controller.SirketBilgileri;
import controller.TemplateBir;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TemplateGecis extends Home implements Initializable {
    @FXML
    public ComboBox firmaComboBox, onayCoboBox, operetorCoboBox, degerlendirenCoboBox;
    @FXML
    private ComboBox ekipmanCombo;
    @FXML
    private DatePicker tarih;

    ObservableList<String> ekipman = FXCollections.observableArrayList();
    ObservableList<String> sirket = FXCollections.observableArrayList();
    ObservableList<String> kullanici = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Statement stmt = null;
        Statement stmt2 = null;
        Statement stmt3 = null;
        try {
            stmt = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt2 = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt3 = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rsE = stmt.executeQuery("SELECT * FROM " + EkipmanBilgileri.tableName);
            while (rsE.next()) {
                ekipman.add(rsE.getString("ekipmanIsmi"));
            }
            ekipmanCombo.setItems(ekipman);

            ResultSet rsS = stmt2.executeQuery("SELECT * FROM " + SirketBilgileri.tableName);
            while (rsS.next()) {
                sirket.add(rsS.getString("MusteriIsmi"));
            }
            firmaComboBox.setItems(sirket);

            ResultSet rsK = stmt3.executeQuery("SELECT * FROM " + KisiEkleDegistir.tableName);
            while (rsK.next()) {
                kullanici.add(rsK.getString("kullaniciAdi"));
            }
            onayCoboBox.setItems(kullanici);
            operetorCoboBox.setItems(kullanici);
            degerlendirenCoboBox.setItems(kullanici);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void gecis(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxmlFiles/TemplateBir.fxml"));
        Parent root = loader.load();
        TemplateBir tb = (TemplateBir) loader.getController();
        tb.setField(tarih.getValue().toString(), ekipmanCombo.getValue().toString());
        ((BorderPane) (((Button) actionEvent.getSource()).getScene().getRoot().lookup("#borderPaneMain"))).setCenter(root);

    }

    public void tarihAction(ActionEvent actionEvent) {
        System.out.println(tarih.getValue());
    }
}


