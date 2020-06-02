package controller;

import agirnob.ExcellExport;
import com.company.DBManager;
import com.company.KisiEkleDegistir;
import com.company.MuayeneSonuclari;
import com.company.Sirket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TemplateBir implements Initializable {
    @FXML
    public TextField ekipmanTextField, kutupMesafesiTextField, MPTasiyiciOrtamTexyField, miknatislamaTeknigiTextField, UVIsikSiddetiTextField, isikMesafesiTextField, muayenBolgesiTextField;
    public ComboBox akimTipiComboBox;
    public TextField projeAdiTextField;
    public TableView<MuayeneSonuclari> muayeneSonuclariTableView;
    public TextField hataTipiAddText;
    public TextField hataninYeriAddYeri;
    public TextField capAddText;
    public TextField kalinlikAddText;
    public TextField kontrolUzunAddText;
    public TextField kaynakAddText;
    public ComboBox sonucAddText;
    public TextField kaynakYonAddText;
    public TextField deg_HataTip;
    public TextField deg_HataYer;
    public TextField deg_Cap;
    public TextField deg_Kalin;
    public TextField deg_Yon;
    public TextField deg_Kontrol;
    public TextField deg_Kaynak;
    public ChoiceBox deg_Sonuc;
    public Label operatorAd;
    public Label operatorSeviye;
    public Label tarih;
    public Label tarihD;
    public Label tarihON;
    public Label degerlendirenAd;
    public Label onayAd;
    public Label degerlendirenSeviye;
    public Label onaySeviye;
    @FXML
    private TableColumn<MuayeneSonuclari, String> kaynakColumn, uzunColumn, yonColumn, kalinlikColumn, capColumn, hataTipColumn, hataYerColumn, sonucColumn;

    @FXML
    private TextField firmaAdiTextField, teklifNoTextField, isEmriNoTextField, testYeriTextField;
    @FXML
    private AnchorPane templateBir;
    @FXML
    private TextField tarihTextField;

    ObservableList<String> ekipman = FXCollections.observableArrayList();
    ObservableList<String> sirket = FXCollections.observableArrayList();
    ObservableList<String> kullanici = FXCollections.observableArrayList();
    ObservableList<MuayeneSonuclari> muayeneSonuclaris = FXCollections.observableArrayList();



    public void setField(String Tarih, String ekipman, String onay, String degerlendiren, String operator, String firma, String proje, String yuzey) {
        tarihTextField.setText(Tarih);
        firmaAdiTextField.setText(firma);
        ekipmanTextField.setText(ekipman);
        projeAdiTextField.setText(proje);
        Statement stmtEkipman = null;
        Statement stmtKullanıcı = null;
        Statement stmtKullanıcı2 = null;
        Statement stmtKullanıcı3 = null;
        Statement stmtFirma = null;

        akimTipiComboBox.setItems(FXCollections.observableArrayList("AC", "DC"));
        try {
            stmtEkipman = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmtKullanıcı = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmtKullanıcı2 = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmtKullanıcı3 = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmtFirma = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rsF = stmtFirma.executeQuery("SELECT * FROM " + SirketBilgileri.tableName + " WHERE MusteriIsmi = " + "'" + firma + "'");
            while (rsF.next()) {
                teklifNoTextField.setText(rsF.getString("TeklifNo"));
                isEmriNoTextField.setText(rsF.getString("IsemriNo"));
                testYeriTextField.appendText(rsF.getString("Ilce"));
                testYeriTextField.appendText("/");
                testYeriTextField.appendText(rsF.getString("Il"));
            }
            ResultSet rsE = stmtEkipman.executeQuery("SELECT * FROM " + EkipmanBilgileri.tableName + " WHERE ekipmanIsmi = " + "'" + ekipman + "'");
            while (rsE.next()) {
                ekipmanTextField.setText(rsE.getString("ekipmanIsmi"));
                kutupMesafesiTextField.setText(rsE.getString("kutupMesafesi"));
                MPTasiyiciOrtamTexyField.setText(rsE.getString("MPTasiyiciOrtam"));
                miknatislamaTeknigiTextField.setText(rsE.getString("miknatislamaTeknigi"));
                UVIsikSiddetiTextField.setText(rsE.getString("UVIsikSiddeti"));
                isikMesafesiTextField.setText(rsE.getString("isikMesafesi"));
                muayenBolgesiTextField.setText(rsE.getString("muayeneBolgesi"));
                if (rsE.getString("akimTipi").equals("AC")) {
                    akimTipiComboBox.getSelectionModel().selectFirst();
                } else {
                    akimTipiComboBox.getSelectionModel().selectLast();
                }
            }
            ResultSet rsK = stmtKullanıcı.executeQuery("SELECT * FROM " + KisiEkleDegistir.tableName + " WHERE kullaniciAdi = " + "'" + operator + "'");
            while (rsK.next()){
                operatorSeviye.setText(rsK.getString("seviye"));
                operatorAd.setText(rsK.getString("isim") + " " +rsK.getString("soyisim"));
            }
            ResultSet rsK1 = stmtKullanıcı2.executeQuery("SELECT * FROM " + KisiEkleDegistir.tableName + " WHERE kullaniciAdi = " + "'" + degerlendiren + "'");
            while (rsK1.next()){
                degerlendirenSeviye.setText(rsK1.getString("seviye"));
                degerlendirenAd.setText(rsK1.getString("isim") +" " + rsK1.getString("soyisim"));
            }
            ResultSet rsK2 = stmtKullanıcı3.executeQuery("SELECT * FROM " + KisiEkleDegistir.tableName + " WHERE kullaniciAdi = " + "'" + onay + "'");
            while (rsK2.next()){
                onaySeviye.setText(rsK2.getString("seviye"));
                onayAd.setText(rsK2.getString("isim") + " " + rsK2.getString("soyisim"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tarih.setText(Tarih);
        tarihD.setText(Tarih);
        tarihON.setText(Tarih);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        operatorAd.setText("deneme");
        sonucAddText.setItems(FXCollections.observableArrayList("OK", "RED"));
        deg_Sonuc.setItems(FXCollections.observableArrayList("OK", "RED"));

        Statement stmt = null;
        Statement stmt2 = null;
        Statement stmt3 = null;








    }

    @FXML
    private void delete() {
        muayeneSonuclaris.remove(muayeneSonuclariTableView.getSelectionModel().getFocusedIndex());
    }

    public void addToTable(ActionEvent actionEvent) {
        kaynakColumn.setCellValueFactory(new PropertyValueFactory<>("kaynak"));
        uzunColumn.setCellValueFactory(new PropertyValueFactory<>("uzun"));
        yonColumn.setCellValueFactory(new PropertyValueFactory<>("yon"));
        kalinlikColumn.setCellValueFactory(new PropertyValueFactory<>("kalin"));
        capColumn.setCellValueFactory(new PropertyValueFactory<>("cap"));
        hataTipColumn.setCellValueFactory(new PropertyValueFactory<>("hata"));
        hataYerColumn.setCellValueFactory(new PropertyValueFactory<>("hatayer"));
        sonucColumn.setCellValueFactory(new PropertyValueFactory<>("sonuc"));


        muayeneSonuclaris.add(new MuayeneSonuclari(kaynakAddText.getText(), kontrolUzunAddText.getText(), kaynakYonAddText.getText(), kalinlikAddText.getText(), capAddText.getText(), hataTipiAddText.getText(), hataninYeriAddYeri.getText(), sonucAddText.getValue().toString()));


        muayeneSonuclariTableView.setItems(muayeneSonuclaris);
    }


    public void displayView(MouseEvent mouseEvent) {
        deg_Cap.setText(muayeneSonuclariTableView.getSelectionModel().getSelectedItem().getCap());
        deg_HataTip.setText(muayeneSonuclariTableView.getSelectionModel().getSelectedItem().getHata());
        deg_HataYer.setText(muayeneSonuclariTableView.getSelectionModel().getSelectedItem().getHatayer());
        deg_Kalin.setText(muayeneSonuclariTableView.getSelectionModel().getSelectedItem().getKalin());
        deg_Kaynak.setText(muayeneSonuclariTableView.getSelectionModel().getSelectedItem().getKaynak());
        deg_Kontrol.setText(muayeneSonuclariTableView.getSelectionModel().getSelectedItem().getUzun());
        if (muayeneSonuclariTableView.getSelectionModel().getSelectedItem().getSonuc().equals("OK")) {
            deg_Sonuc.getSelectionModel().selectFirst();
        } else {
            deg_Sonuc.getSelectionModel().selectLast();
        }
        deg_Yon.setText(muayeneSonuclariTableView.getSelectionModel().getSelectedItem().getYon());
    }

    public void degistir(ActionEvent actionEvent) {
        muayeneSonuclaris.set(muayeneSonuclariTableView.getSelectionModel().getFocusedIndex(),new MuayeneSonuclari(deg_Kaynak.getText(),deg_Kontrol.getText(),deg_Yon.getText(),deg_Kalin.getText(),deg_Cap.getText(),deg_HataTip.getText(),deg_HataYer.getText(),deg_Sonuc.getValue().toString()));
    }

    public void exportExcell(ActionEvent actionEvent) throws IOException {
        ExcellExport ee = new ExcellExport();
        ee.excelExpo();
    }

    public void exportPdf(ActionEvent actionEvent) {
    }
}