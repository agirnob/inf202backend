package controller;

import agirnob.ComboBoxAutoComplete;
import com.company.DBManager;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;

import java.net.URL;
import java.util.ResourceBundle;

public class SirketBilgileri implements Initializable {
    private static final String tableName = "SirketT";
    private static final String[] LISTA = {"Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Aksaray", "Amasya", "Ankara", "Antalya",
            "Ardahan", "Artvin", "Aydın", "Balıkesir", "Bartın", "Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu",
            "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Düzce", "Edirne", "Elazığ", "Erzincan",
            "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay", "Iğdır", "Isparta", "İstanbul", "İzmir",
            "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu", "Kayseri", "Kilis", "Kırıkkale", "Kırklareli", "Kırşehir",
            "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu",
            "Osmaniye", "Rize", "Sakarya", "Samsun", "Şanlıurfa", "Siirt", "Sinop", "Sivas", "Şırnak", "Tekirdağ", "Tokat",
            "Trabzon", "Tunceli", "Uşak", "Van", "Yalova", "Yozgat", "Zonguldak"};
    public ComboBox ilComboBox;
    public ComboBox ilceComboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ilComboBox.setTooltip(new Tooltip());
        ilComboBox.getItems().addAll(LISTA);
        ilComboBox.getSelectionModel().selectFirst();
        new ComboBoxAutoComplete<String>(ilComboBox);
        DBManager db = new DBManager();
        try {
            String strTable = "CREATE TABLE " + tableName + "(" +
                    "Il VARCHAR(50) NOT NULL," +
                    "Ilce VARCHAR(50) NOT NULL," +
                    "TeklifNo VARCHAR(50) NOT NULL," +
                    "IsemriNo VARCHAR(50) NOT NULL," +
                    "MusteriIsmi VARCHAR(50) NOT NULL," +
                    ");";
            db.tableCreate(strTable);
            System.out.println("tablecreated");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
