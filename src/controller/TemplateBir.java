package controller;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class TemplateBir implements Initializable {

    public TextField testYeri;
    public ComboBox projeAdı;
    public AnchorPane templateBir;
    public TextField tarihTextField;
    public TextField ekipmanAdi;

    public void setField(String Tarih, String ekipman) {
        tarihTextField.setText(Tarih);
        ekipmanAdi.setText(ekipman);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        projeAdı.setItems(FXCollections.observableArrayList("Kaynakçı Testi", "Andere Test", "Ein Andere Test"));
        projeAdı.getSelectionModel().selectFirst();

    }

}