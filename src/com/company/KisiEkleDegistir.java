package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class KisiEkleDegistir implements Initializable {
    @FXML
    protected Tab degistirButoon;
    @FXML
    protected ChoiceBox<String> levelDB;
    @FXML
    protected javafx.scene.control.TextField isimDB;
    @FXML
    protected TextField soyisimDB;
    @FXML
    protected TextField sifreDB;
    @FXML
    protected TextField kullaniciDB;
    @FXML
    protected TableView<Kullanici> degistirDB;
    @FXML
    protected TableColumn <Kullanici,String>d_isim;
    @FXML
    protected TableColumn <Kullanici,String>d_soyisim;
    @FXML
    protected TableColumn <Kullanici,String>d_seviye;
    @FXML
    protected TableColumn <Kullanici,String>d_kullanici;
    @FXML
    protected Button kisiyiSil;
    @FXML
    protected Button updateButton;
    @FXML
    protected TextField degistir_soyisim,degistir_seviye,degistir_ikullanici,degistir_isim, kullaniciAdi_Deg;
    @FXML
    protected PasswordField degistir_sifreS;

    private String tableName = "denememi";
    private String select = "SELECT * FROM " + tableName;
    private ObservableList<Kullanici> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        levelDB.setItems(FXCollections.observableArrayList("1 level", "2 level", "3 level"));
        levelDB.getSelectionModel().selectFirst();
        DBManager db = new DBManager();
        try {
            String strTable = "CREATE TABLE " + tableName + "(" +
                    "isim VARCHAR(50) NOT NULL," +
                    "soyisim VARCHAR(50) NOT NULL," +
                    "seviye VARCHAR(19) NOT NULL," +
                    "password VARCHAR(50) NOT NULL," +
                    "kullaniciAdi VARCHAR(50) NOT NULL UNIQUE" +
                    ");";
            db.tableCreate(strTable);
            System.out.println("tablecreated");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void kisiEkle() throws Exception {
        DBManager db = new DBManager();
        Kullanici kisi = new Kullanici(isimDB.getText(), soyisimDB.getText(), levelDB.getValue(), kullaniciDB.getText(), sifreDB.getText());

        String insertStr = "INSERT INTO " + tableName +
                " VALUES(" +
                "'" + kisi.getIsim() + "'" + "," +
                "'" + kisi.getSoyisim() + "'" + "," +
                "'" + kisi.getSeviye() + "'" + "," +
                "'" + kisi.getPassword() + "'" + "," +
                "'" + kisi.getKullaniciAdi() + "')";
        try {
            db.insertDB(insertStr);
        } catch (org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Aynı kullanıcı girilmesi");
            errorAlert.setContentText("Aynı kullanıcı adına sahip kişi oluşturamazsınız");
            errorAlert.showAndWait();
        } catch (org.h2.jdbc.JdbcSQLSyntaxErrorException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Boş alan hatası");
            errorAlert.setContentText("İlgili kısımları boş bırakamazsınız");
            errorAlert.showAndWait();
        }


    }

    public void kisiSil() throws SQLException {
        DBManager db = new DBManager();
        db.deleteUserDB(tableName,"kullaniciAdi",kullaniciAdi_Deg.getText());
        refreshTableView();
    }

    public void kisiUpdate() throws SQLException {

        String sql = "UPDATE " + tableName + " SET isim ='" + degistir_isim.getText() + "' , soyisim = '" + degistir_soyisim.getText() +
                "', seviye = '" + degistir_seviye.getText() + "' , password = '" + degistir_sifreS.getText()
                + "', kullaniciAdi = '" + degistir_ikullanici.getText() + "'";

        sql = sql + " WHERE kullaniciAdi = " + "'"+kullaniciAdi_Deg.getText()+"'";
        PreparedStatement pstmt = DBManager.getConn().prepareStatement(sql);
        try {
            pstmt.execute();
            refreshTableView();
        } catch (org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Aynı kullanıcı girilmesi");
            errorAlert.setContentText("Aynı kullanıcı adına sahip kişi oluşturamazsınız");
            errorAlert.showAndWait();
        }
    }

    public void displayView(MouseEvent mouseEvent) {
        Kullanici user = degistirDB.getSelectionModel().getSelectedItem();
        if(user == null){
            kullaniciAdi_Deg.setText("Nichts gewahlt");
        }else{
            kullaniciAdi_Deg.setText(user.getKullaniciAdi());
            degistir_isim.setText(user.getIsim());
            degistir_soyisim.setText(user.getSoyisim());
            degistir_ikullanici.setText(user.getKullaniciAdi());
            degistir_seviye.setText(user.getSeviye());
            degistir_sifreS.setText(user.getPassword());
        }
    }

    public void refreshTableView(){
        try {
            Connection con = DBManager.getConn();
            ResultSet rs = con.createStatement().executeQuery(select);

            for ( int i = 0; i<degistirDB.getItems().size(); i++) {
                degistirDB.getItems().clear();
            }

            while (rs.next()){
                data.add(new Kullanici(rs.getString("isim"),rs.getString("soyisim"),rs.getString("seviye"),
                        rs.getString("kullaniciAdi"),rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        d_isim.setCellValueFactory(new PropertyValueFactory<>("isim"));
        d_soyisim.setCellValueFactory(new PropertyValueFactory<>("soyisim"));
        d_seviye.setCellValueFactory(new PropertyValueFactory<>("seviye"));
        d_kullanici .setCellValueFactory(new PropertyValueFactory<>("kullaniciAdi"));

        degistirDB.setItems(data);
    }
}





