package controller;

import com.company.DBManager;
import com.company.Ekipman;
import com.company.Kullanici;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EkipmanBilgileri implements Initializable {
    public ComboBox<String> akimTipi;
    public TextField kutupMesafesi, MPTasiyiciOrtam, miknatislamaTeknigi, UVIsikSiddeti, isikMesafesi, muayeneBolgesi, ekipmanIsmi;
    public Button ekle;
    public TableColumn<Object, Object> d_AkimTipi;
    public TableColumn<Object, Object> d_MiknatislamaTeknigi;
    public TableColumn<Object, Object> d_IsikMesafesi;
    public TableColumn<Object, Object> d_MuayeneTeknigi;
    public TableColumn<Object, Object> d_KutupMesafesi;
    public TableColumn<Object, Object> d_MPTasiyiciOrtam;
    public TableColumn<Object, Object> d_UVIsikSiddeti;
    public TableColumn<Object, Object> d_ekipmanIsmi;
    public TextField deg_EkipmanIsmi, deg_EkipmanIsmiC, deg_MiknatislamaTeknigi, deg_IsikMesafesi, deg_MuayeneBolgesi, deg_MPTasiyiciOrtam, deg_KutupMesafesi, deg_UVIsikSiddeti;
    public ComboBox deg_AkimTipi;
    public TableView<Ekipman> ekipmanTable;
    private final String tableName = "ekipmanT2";
    private String select = "SELECT * FROM " + tableName;
    private ObservableList<Ekipman> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        akimTipi.setItems(FXCollections.observableArrayList("AC", "DC"));
        deg_AkimTipi.setItems(FXCollections.observableArrayList("AC", "DC"));

        DBManager db = new DBManager();
        try {
            String strTable = "CREATE TABLE " + tableName + "(" +
                    "kutupMesafesi VARCHAR(50) NOT NULL," +
                    "isikMesafesi VARCHAR(50) NOT NULL," +
                    "MPTasiyiciOrtam VARCHAR(50) NOT NULL," +
                    "miknatislamaTeknigi VARCHAR(50) NOT NULL," +
                    "UVIsikSiddeti VARCHAR(50) NOT NULL," +
                    "muayeneBolgesi VARCHAR(50) NOT NULL," +
                    "akimTipi VARCHAR(50) NOT NULL," +
                    "ekipmanIsmi VARCHAR(50) NOT NULL UNIQUE" +
                    ");";
            db.tableCreate(strTable);
            System.out.println("tablecreated");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void ekipmanUpdate() throws SQLException {

        String sql = "UPDATE " + tableName + " SET kutupMesafesi ='" + deg_KutupMesafesi.getText() + "' , isikMesafesi = '" +
                deg_IsikMesafesi.getText() + "', MPTasiyiciOrtam = '" + deg_MPTasiyiciOrtam.getText()
                + "' , miknatislamaTeknigi = '" + deg_MiknatislamaTeknigi.getText() + "', UVIsikSiddeti = '" +
                deg_UVIsikSiddeti.getText() + "', muayeneBolgesi = '" + deg_MuayeneBolgesi.getText() + "' , akimTipi = '" +
                deg_AkimTipi.getValue() + "' , ekipmanIsmi = '" + deg_EkipmanIsmiC.getText() + "'"  ;


        sql = sql + " WHERE ekipmanIsmi = " + "'" + deg_EkipmanIsmi.getText() + "';";
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

    public void ekipmanEkle() {
        DBManager db = new DBManager();
        Ekipman ekipman = new Ekipman(kutupMesafesi.getText(), ekipmanIsmi.getText(), MPTasiyiciOrtam.getText(), miknatislamaTeknigi.getText(), UVIsikSiddeti.getText(), isikMesafesi.getText(), muayeneBolgesi.getText(), akimTipi.getValue().toString());

        String insertStr = "INSERT INTO " + tableName +
                " VALUES(" +
                "'" + ekipman.getKutupMesafesi() + "'" + "," +
                "'" + ekipman.getIsikMesafesi() + "'" + "," +
                "'" + ekipman.getMPTasiyiciOrtam() + "'" + "," +
                "'" + ekipman.getMiknatislamaTeknigi() + "'" + "," +
                "'" + ekipman.getUvIsikSiddeti() + "'" + "," +
                "'" + ekipman.getMuayeneBolgesi() + "'" + "," +
                "'" + ekipman.getAkimTipi() + "'" + "," +
                "'" + ekipman.getCihazAdi() + "')";
        try {
            db.insertDB(insertStr);
        } catch (SQLException e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Aynı kullanıcı girilmesi");
            errorAlert.setContentText("Aynı kullanıcı adına sahip kişi oluşturamazsınız");
            errorAlert.showAndWait();
        }

    }

    public void ekipmanSil() throws SQLException {
        DBManager db = new DBManager();
        db.deleteUserDB(tableName, "ekipmanIsmi", deg_EkipmanIsmi.getText());
        refreshTableView();
    }


    public void refreshTableView() {
        try {
            Connection con = DBManager.getConn();
            ResultSet rs = con.createStatement().executeQuery(select);

            for (int i = 0; i < ekipmanTable.getItems().size(); i++) {
                ekipmanTable.getItems().clear();
            }
            while (rs.next()) {
                data.add(new Ekipman(rs.getString("kutupMesafesi"), rs.getString("ekipmanIsmi"), rs.getString("MPTasiyiciOrtam"),
                        rs.getString("miknatislamaTeknigi"), rs.getString("UVIsikSiddeti"), rs.getString("isikMesafesi"),
                        rs.getString("muayeneBolgesi"), rs.getString("akimTipi")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        d_ekipmanIsmi.setCellValueFactory(new PropertyValueFactory<>("cihazAdi"));
        d_AkimTipi.setCellValueFactory(new PropertyValueFactory<>("akimTipi"));
        d_IsikMesafesi.setCellValueFactory(new PropertyValueFactory<>("isikMesafesi"));
        d_KutupMesafesi.setCellValueFactory(new PropertyValueFactory<>("kutupMesafesi"));
        d_MiknatislamaTeknigi.setCellValueFactory(new PropertyValueFactory<>("miknatislamaTeknigi"));
        d_MPTasiyiciOrtam.setCellValueFactory(new PropertyValueFactory<>("MPTasiyiciOrtam"));
        d_MuayeneTeknigi.setCellValueFactory(new PropertyValueFactory<>("muayeneBolgesi"));
        d_UVIsikSiddeti.setCellValueFactory(new PropertyValueFactory<>("uvIsikSiddeti"));
        ekipmanTable.setItems(data);
    }

    public void displayView(MouseEvent mouseEvent) {
        Ekipman user = ekipmanTable.getSelectionModel().getSelectedItem();
        if (user == null) {
            deg_EkipmanIsmi.setText("Nichts gewahlt");
        } else {
            deg_EkipmanIsmi.setText((user.getCihazAdi()));
            deg_EkipmanIsmiC.setText(user.getCihazAdi());
            deg_UVIsikSiddeti.setText(user.getUvIsikSiddeti());
            deg_MiknatislamaTeknigi.setText(user.getMiknatislamaTeknigi());
            deg_MPTasiyiciOrtam.setText(user.getMPTasiyiciOrtam());
            deg_IsikMesafesi.setText(user.getIsikMesafesi());
            deg_KutupMesafesi.setText(user.getKutupMesafesi());
            deg_MuayeneBolgesi.setText(user.getMuayeneBolgesi());
        }
    }
}

