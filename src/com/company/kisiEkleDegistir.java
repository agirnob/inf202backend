package com.company;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.company.Main.mainScene;
import static com.company.Main.window;


public class kisiEkleDegistir implements Initializable {

    public Tab degistirButoon;
    public ChoiceBox<String> levelDB;
    public javafx.scene.control.TextField isimDB;
    public TextField soyisimDB;
    public TextField sifreDB;
    public TextField kullaniciDB;
    public TableView<kullanici> degistirDB;
    public TableColumn <kullanici,String>d_isim;
    public TableColumn <kullanici,String>d_soyisim;
    public TableColumn <kullanici,String>d_seviye;
    public TableColumn <kullanici,String>d_kullanici;
    public TableColumn <kullanici,String>d_password;
    String tableName = "qaaarrrr";
    String select = "SELECT * FROM " + tableName;
    public static ObservableList<kullanici> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("denemenemdnemnednemdne");
        levelDB.setItems(FXCollections.observableArrayList("1 level", "2 level", "3 level"));
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
            System.out.println(e);
        }

        try {
            Connection con = DBManager.getConn();
            ResultSet rs = con.createStatement().executeQuery(select);

            while (rs.next()){
                data.add(new kullanici(rs.getString("isim"),rs.getString("soyisim"),rs.getString("seviye"),
                        rs.getString("kullaniciAdi"),rs.getString("password")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        d_isim.setCellValueFactory(new PropertyValueFactory<>("isim"));
        d_soyisim.setCellValueFactory(new PropertyValueFactory<>("soyisim"));
        d_seviye.setCellValueFactory(new PropertyValueFactory<>("seviye"));
        d_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        d_kullanici .setCellValueFactory(new PropertyValueFactory<>("kullaniciAdi"));

        degistirDB.setItems(data);

























    }



    public void geriGit() {
        window.setScene(mainScene);
    }


    public void kisiEkle() throws Exception {
        DBManager db = new DBManager();
        kullanici kisi = new kullanici(isimDB.getText(), soyisimDB.getText(), levelDB.getValue(), kullaniciDB.getText(), sifreDB.getText());

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

        System.out.println("inserted");

    }



}

//    ResultSet rs = DBManager.getConn().createStatement().executeQuery(select);

    /*Adding to column dynamicly*/
    //        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {

//final int j = i;
  //      TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
    //    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
//public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
  //      return new SimpleStringProperty(param.getValue().get(j).toString());
    //    }
      //  });

        //degistirDB.getColumns().addAll(col);
       // System.out.println("Column [" + i + "] ");

        //}
/*Adding info to a list*/




