package controller;

import com.company.DBManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TemplateBir implements Initializable {
    @FXML
    public TextField ekipmanTextField,kutupMesafesiTextField,MPTasiyiciOrtamTexyField,miknatislamaTeknigiTextField,UVIsikSiddetiTextField,isikMesafesiTextField,muayenBolgesiTextField;
    public ComboBox akimTipiComboBox;
    public TextField projeAdiTextField;
    @FXML
    private TextField firmaAdiTextField, teklifNoTextField, isEmriNoTextField,testYeriTextField;
    @FXML
    private AnchorPane templateBir;
    @FXML
    private TextField tarihTextField;

    ObservableList<String> ekipman = FXCollections.observableArrayList();
    ObservableList<String> sirket = FXCollections.observableArrayList();
    ObservableList<String> kullanici = FXCollections.observableArrayList();


    public void setField(String Tarih, String ekipman, String onay, String degerlendiren, String operator, String firma, String proje, String yuzey) {
        tarihTextField.setText(Tarih);
        firmaAdiTextField.setText(firma);
        ekipmanTextField.setText(ekipman);
        projeAdiTextField.setText(proje);
        Statement stmtEkipman = null;
        Statement stmtKullanıcı = null;
        Statement stmtFirma = null;
        akimTipiComboBox.setItems(FXCollections.observableArrayList("AC", "DC"));
        try {
            stmtEkipman = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmtKullanıcı = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmtFirma = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rsF = stmtFirma.executeQuery("SELECT * FROM " + SirketBilgileri.tableName + " WHERE MusteriIsmi = " +"'" +firma +"'");
            while (rsF.next()) {
                teklifNoTextField.setText(rsF.getString("TeklifNo"));
                isEmriNoTextField.setText(rsF.getString("IsemriNo"));
                testYeriTextField.appendText(rsF.getString("Ilce"));
                testYeriTextField.appendText("/");
                testYeriTextField.appendText(rsF.getString("Il"));
            }
            ResultSet rsE = stmtEkipman.executeQuery("SELECT * FROM " + EkipmanBilgileri.tableName + " WHERE ekipmanIsmi = " +"'" +ekipman +"'");
            while (rsE.next()) {
                ekipmanTextField.setText(rsE.getString("ekipmanIsmi"));
                kutupMesafesiTextField.setText(rsE.getString("kutupMesafesi"));
                MPTasiyiciOrtamTexyField.setText(rsE.getString("MPTasiyiciOrtam"));
                miknatislamaTeknigiTextField.setText(rsE.getString("miknatislamaTeknigi"));
                UVIsikSiddetiTextField.setText(rsE.getString("UVIsikSiddeti"));
                isikMesafesiTextField.setText(rsE.getString("isikMesafesi"));
                muayenBolgesiTextField.setText(rsE.getString("muayeneBolgesi"));
                if(rsE.getString("akimTipi").equals("AC")){
                    akimTipiComboBox.getSelectionModel().selectFirst();
                }else {
                    akimTipiComboBox.getSelectionModel().selectLast();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

}