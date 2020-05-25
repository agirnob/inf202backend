package com.company;

import agirnob.ComboBoxAutoComplete;
import agirnob.Ilceler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import agirnob.IlIlceArray;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TemplateGecis extends Home implements Initializable {

    @FXML private ComboBox autoComplateIl;
    @FXML private ComboBox autoComplateIlce;
    private static final String[] LISTA = {"Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Aksaray", "Amasya", "Ankara", "Antalya",
            "Ardahan", "Artvin", "Aydın", "Balıkesir", "Bartın", "Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu",
            "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Düzce", "Edirne", "Elazığ", "Erzincan",
            "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay", "Iğdır", "Isparta", "İstanbul", "İzmir",
            "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu", "Kayseri", "Kilis", "Kırıkkale", "Kırklareli", "Kırşehir",
            "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu",
            "Osmaniye", "Rize", "Sakarya", "Samsun", "Şanlıurfa", "Siirt", "Sinop", "Sivas", "Şırnak", "Tekirdağ", "Tokat",
            "Trabzon", "Tunceli", "Uşak", "Van", "Yalova", "Yozgat", "Zonguldak"};

    public ArrayList<String>iliceList = new ArrayList<String>();
    @FXML private AnchorPane templateGecis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iliceList.add("");
        iliceList.add("");
        System.out.println(iliceList.size());
        autoComplateIl.setTooltip(new Tooltip());
        autoComplateIl.getItems().addAll(LISTA);
        new ComboBoxAutoComplete<String>(autoComplateIl);
    }

    public void gecis(ActionEvent actionEvent) throws IOException {
        AnchorPane root = (AnchorPane) FXMLLoader.load(Main.class.getResource("../../fxmlFiles/TemplateBir.fxml"));
        ((BorderPane) (((Button) actionEvent.getSource()).getScene().getRoot().lookup("#borderPaneMain"))).setCenter(root);
        int deneme = autoComplateIl.getSelectionModel().getSelectedIndex();
        System.out.println(deneme);
        //TemplateBier tb = new TemplateBier(iliceList);

    }



    public void ilSec(ActionEvent actionEvent) {
        int x = 0;
        x = autoComplateIl.getSelectionModel().getSelectedIndex()+1;
        System.out.println(x);
        switch (x) {
            case 1:
                autoComplateIlce.setTooltip(new Tooltip());
                autoComplateIlce.getItems().setAll(Ilceler.getAdanaIlce());
                new ComboBoxAutoComplete<String>(autoComplateIlce);
                autoComplateIlce.getSelectionModel().selectFirst();
                iliceList.set(0,(String)autoComplateIl.getValue());
                break;
            case 2:
                autoComplateIlce.setTooltip(new Tooltip());
                autoComplateIlce.getItems().setAll(Ilceler.getAdıyaman());
                new ComboBoxAutoComplete<String>(autoComplateIlce);
                autoComplateIlce.getSelectionModel().selectFirst();
                iliceList.set(0,(String)autoComplateIl.getValue());
                break;
            case 3:
                autoComplateIlce.getItems().removeAll();
                autoComplateIlce.setTooltip(new Tooltip());
                autoComplateIlce.getItems().setAll(Ilceler.getAfyonkarahisar());
                new ComboBoxAutoComplete<String>(autoComplateIlce);
                autoComplateIlce.getSelectionModel().selectFirst();
                iliceList.set(0,(String)autoComplateIl.getValue());
                break;
        }
    }


    public void ilceSec(ActionEvent actionEvent) {
        System.out.println(IlIlceArray.ilIlce);
        iliceList.set(1,(String)autoComplateIlce.getValue());
    }
}



/*
 case 4:
         break;
         case 5:
         break;
         case 6:
         break;
         case 7:
         break;
         case 8:
         break;
         case 9:
         break;
         case 10:
         break;
         case 11:
         break;
         case 12:
         break;
         case 13:
         break;
         case 14:
         break;
         case 15:
         break;
         case 16:
         break;
         case 17:
         break;
         case 18:
         break;
         case 19:
         break;
         case 20:
         break;
 */