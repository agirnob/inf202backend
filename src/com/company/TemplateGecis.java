package com.company;

import agirnob.ComboBoxAutoComplete;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;

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
        FXMLLoader  mainLoaderFXML = new FXMLLoader();
        mainLoaderFXML.load(getClass().getResource("../../fxmlFiles/home.fxml"));

        Parent root = FXMLLoader.load(getClass().getResource("../../fxmlFiles/TemplateBir.fxml"));
        borderPaneMain.setCenter(root);

    }
}
