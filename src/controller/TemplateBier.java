package controller;

import com.company.TemplateGecis;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TemplateBier implements Initializable {
    ArrayList<String> ililceArray = new ArrayList<String>();
    public TemplateBier(ArrayList arrayList){
        ililceArray =arrayList;
    }

    public ComboBox company;
    public ComboBox muayeneKapsamı;
    private Object ob;
    private final String[] muayeneKapsamiString ={"20","10"};


    public TextField TestYeriTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //muayeneKapsamı.setItems(FXCollections.observableArrayList(ililceArray));
        muayeneKapsamı.getSelectionModel().selectFirst();


    }
}
