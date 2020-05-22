package com.company;

import agirnob.ComboBoxAutoComplete;
import agirnob.ilceler;
import com.company.home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TemplateGecis extends home implements Initializable  {


    public ComboBox autoComplateIl;
    public ComboBox autoComplateIlce;
    private static final String[] LISTA = {"Adana", "Adıyaman", "Afyonkarahisar","Ağrı", "Aksaray", "Amasya", "Ankara", "Antalya",
            "Ardahan", "Artvin", "Aydın", "Balıkesir", "Bartın", "Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu",
            "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Düzce", "Edirne", "Elazığ", "Erzincan",
            "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay", "Iğdır", "Isparta", "İstanbul", "İzmir",
            "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu", "Kayseri", "Kilis", "Kırıkkale", "Kırklareli", "Kırşehir",
            "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu",
            "Osmaniye", "Rize", "Sakarya", "Samsun", "Şanlıurfa", "Siirt", "Sinop", "Sivas", "Şırnak", "Tekirdağ", "Tokat",
            "Trabzon", "Tunceli", "Uşak", "Van", "Yalova", "Yozgat", "Zonguldak" };


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        autoComplateIl.setTooltip(new Tooltip());
        autoComplateIl.getItems().addAll(LISTA);
        new ComboBoxAutoComplete<String>(autoComplateIl);
    }

    public void gecis(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../fxmlFiles/TemplateBir.fxml"));

        ((BorderPane) (((Button) actionEvent.getSource()).getScene().getRoot().lookup("#borderPaneMain"))).setCenter(root);
        int deneme =autoComplateIl.getSelectionModel().getSelectedIndex();
        System.out.println(deneme);
    }


    public void ilSec(ActionEvent actionEvent) {
        autoComplateIlce.setTooltip(new Tooltip());
        autoComplateIlce.getItems().addAll(ilceler.getAdanaIlce());
        new ComboBoxAutoComplete<String>(autoComplateIlce);
    }

    public void ilceSec(ActionEvent actionEvent) {
    }
}
