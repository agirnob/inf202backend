package com.company;

import controller.EkipmanBilgileri;
import controller.TemplateBir;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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
    public ComboBox ekipmanCombo;
    public DatePicker tarih;

    ObservableList<String> ekipman = FXCollections.observableArrayList();

    private static final String[] LISTA = {"Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Aksaray", "Amasya", "Ankara", "Antalya",
            "Ardahan", "Artvin", "Aydın", "Balıkesir", "Bartın", "Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu",
            "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Düzce", "Edirne", "Elazığ", "Erzincan",
            "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay", "Iğdır", "Isparta", "İstanbul", "İzmir",
            "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu", "Kayseri", "Kilis", "Kırıkkale", "Kırklareli", "Kırşehir",
            "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu",
            "Osmaniye", "Rize", "Sakarya", "Samsun", "Şanlıurfa", "Siirt", "Sinop", "Sivas", "Şırnak", "Tekirdağ", "Tokat",
            "Trabzon", "Tunceli", "Uşak", "Van", "Yalova", "Yozgat", "Zonguldak"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Statement stmt = null;
        try {
            stmt = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery("SELECT * FROM " +EkipmanBilgileri.tableName );
            while (rs.next()){
               ekipman.add( rs.getString("ekipmanIsmi"));
            }
            ekipmanCombo.setItems(ekipman);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void gecis(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxmlFiles/TemplateBir.fxml"));
        Parent root = loader.load();
        TemplateBir tb = (TemplateBir) loader.getController();
        tb.setField(tarih.getValue().toString(),ekipmanCombo.getValue().toString());
        ((BorderPane) (((Button) actionEvent.getSource()).getScene().getRoot().lookup("#borderPaneMain"))).setCenter(root);

    }

    public void tarihAction(ActionEvent actionEvent) {
        System.out.println(tarih.getValue());
    }
}


