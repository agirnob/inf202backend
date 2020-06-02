package com.company;

import controller.EkipmanBilgileri;
import controller.SirketBilgileri;
import controller.TemplateBir;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;

public class TemplateGecis extends Home implements Initializable {

    @FXML
    public ComboBox firmaComboBox, onayCoboBox, operetorCoboBox, degerlendirenCoboBox;
    public ChoiceBox projeAdi;
    @FXML
    private ChoiceBox yuzeyDurumu;
    @FXML
    private ComboBox ekipmanCombo;
    @FXML
    private DatePicker tarih;
    ObservableList<String> ekipman = FXCollections.observableArrayList();
    ObservableList<String> sirket = FXCollections.observableArrayList();
    ObservableList<String> kullanici = FXCollections.observableArrayList();

    public static final LocalDate NOW_LOCAL_DATE (){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Statement stmt = null;
        Statement stmt2 = null;
        Statement stmt3 = null;


        try {
            stmt = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt2 = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt3 = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rsE = stmt.executeQuery("SELECT * FROM " + EkipmanBilgileri.tableName);
            while (rsE.next()) {
                ekipman.add(rsE.getString("ekipmanIsmi"));
            }
            ekipmanCombo.setItems(ekipman);

            ResultSet rsS = stmt2.executeQuery("SELECT * FROM " + SirketBilgileri.tableName);
            while (rsS.next()) {
                sirket.add(rsS.getString("MusteriIsmi"));
            }
            firmaComboBox.setItems(sirket);

            ResultSet rsK = stmt3.executeQuery("SELECT * FROM " + KisiEkleDegistir.tableName);
            while (rsK.next()) {
                kullanici.add(rsK.getString("kullaniciAdi"));
            }
            onayCoboBox.setItems(kullanici);
            operetorCoboBox.setItems(kullanici);
            degerlendirenCoboBox.setItems(kullanici);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        projeAdi.setItems(FXCollections.observableArrayList("Proje 1", "Proje 2", "Proje 3"));
        projeAdi.getSelectionModel().selectFirst();
        firmaComboBox.getSelectionModel().selectFirst();
        ekipmanCombo.getSelectionModel().selectFirst();
        tarih.setValue(NOW_LOCAL_DATE());
        operetorCoboBox.getSelectionModel().selectFirst();
        projeAdi.getSelectionModel().selectFirst();
        degerlendirenCoboBox.getSelectionModel().selectFirst();
        yuzeyDurumu.getSelectionModel().selectFirst();
        onayCoboBox.getSelectionModel().selectFirst();
        yuzeyDurumu.setItems(FXCollections.observableArrayList("paslı", "tozlu", "tuzlu", "baharatlı"));
        yuzeyDurumu.getSelectionModel().selectFirst();

    }


    public void gecis(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxmlFiles/TemplateBir.fxml"));
        Parent root = loader.load();
        TemplateBir tb = (TemplateBir) loader.getController();
        try {
            String ekipman = ekipmanCombo.getValue().toString();
            String operator = operetorCoboBox.getValue().toString();
            String degerlendiren = degerlendirenCoboBox.getValue().toString();
            String onay = onayCoboBox.getValue().toString();
            String firma = firmaComboBox.getValue().toString();
            String proje = projeAdi.getValue().toString();
            String yuzey = yuzeyDurumu.getValue().toString();
            String date = tarih.getValue().getDayOfMonth() + "/" + tarih.getValue().getMonthValue() + "/" + tarih.getValue().getYear();

            tb.setField(date, ekipman, onay, degerlendiren, operator, firma, proje, yuzey);
            ((BorderPane) (((Button) actionEvent.getSource()).getScene().getRoot().lookup("#borderPaneMain"))).setCenter(root);

        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Boş alan hatası");
            errorAlert.setContentText("İlgili kısımları boş bırakamazsınız");
            errorAlert.showAndWait();
            System.out.println(e.toString());
        }

    }


}


