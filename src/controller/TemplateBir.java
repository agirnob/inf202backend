package controller;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class TemplateBir implements Initializable {


    public ComboBox company;
    public ComboBox muayeneKapsamı;
    private final String[] muayeneKapsamiString ={"20","10"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        muayeneKapsamı.setItems(FXCollections.observableArrayList(muayeneKapsamiString));
        muayeneKapsamı.getSelectionModel().selectFirst();
    }
}
