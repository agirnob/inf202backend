package controller;

import com.company.DBManager;
import com.company.TemplateGecis;
import com.gluonhq.charm.glisten.control.AutoCompleteTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TemplateBir implements Initializable {


    public TextField testYeri;
    public ComboBox projeAdı;
    public AnchorPane templateBir;


    public void setField(String ilce, String il) {
        System.out.println(ilce + "/" + il);
        testYeri.setText(ilce + "/" + il);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        projeAdı.setItems(FXCollections.observableArrayList("Kaynakçı Testi", "Andere Test", "Ein Andere Test"));
        projeAdı.getSelectionModel().selectFirst();

    }

}
