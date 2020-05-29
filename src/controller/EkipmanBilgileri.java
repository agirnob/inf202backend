package controller;

import com.company.DBManager;
import com.company.Ekipman;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EkipmanBilgileri implements Initializable {
    public ComboBox<String> akimTipi;
    public TextField kutupMesafesi, MPTasiyiciOrtam, miknatislamaTeknigi, UVIsikSiddeti, isikMesafesi, muayeneBolgesi, ekipmanIsmi;
    public Button ekle;
    public TableColumn<Object, Object> d_ekipmanIsmi;
    public TableColumn<Object, Object> d_MiknatislamaTeknigi;
    public TableColumn<Object, Object> d_IsikMesafesi;
    public TableColumn<Object, Object> d_MuayeneTeknigi;
    public TableColumn<Object, Object> d_KutupMesafesi;
    public TableColumn<Object, Object> d_MPTasiyiciOrtam;
    public TableColumn<Object, Object> d_UVIsikSiddeti;
    public TableColumn<Object, Object> d_AkimTipi;
    public TextField deg_EkipmanIsmi, deg_EkipmanIsmiC, deg_MiknatislamaTeknigi, deg_IsikMesafesi, deg_MuayeneBolgesi, deg_MPTasiyiciOrtam, deg_KutupMesafesi, deg_UVIsikSiddeti;
    public ComboBox deg_AkimTipi;
    public TableView<Ekipman> ekipmanTable;
    private final String tableName = "ekipmanT";
    private String select = "SELECT * FROM " + tableName;
    private ObservableList<Ekipman> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        akimTipi.setItems(FXCollections.observableArrayList("AC", "DC"));
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

    }

    public void refreshTableView(Event event) {
        try {
            Connection con = DBManager.getConn();
            ResultSet rs = con.createStatement().executeQuery(select);

            for (int i = 0; i < ekipmanTable.getItems().size(); i++) {
                ekipmanTable.getItems().clear();
            }
            while (rs.next()) {
                data.add(new Ekipman(rs.getString("kutupMesafesi"), rs.getString("isikMesafesi"), rs.getString("MPTasiyiciOrtam"),
                        rs.getString("miknatislamaTeknigi"),rs.getString("UVIsikSiddeti"),rs.getString("muayeneBolgesi"),
                        rs.getString("akimTipi"),rs.getString("ekipmanIsmi") ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("degisti");
        d_AkimTipi.setCellValueFactory(new PropertyValueFactory<>("akimTipi"));
        d_ekipmanIsmi.setCellValueFactory(new PropertyValueFactory<>("cihazAdi"));
        d_IsikMesafesi.setCellValueFactory(new PropertyValueFactory<>("isikMesafesi"));
        d_KutupMesafesi.setCellValueFactory(new PropertyValueFactory<>("kutupMesafesi"));
        d_MiknatislamaTeknigi.setCellValueFactory(new PropertyValueFactory<>("miknatislamaTeknigi"));
        d_MPTasiyiciOrtam.setCellValueFactory(new PropertyValueFactory<>("MPTasiyiciOrtam"));
        d_MuayeneTeknigi.setCellValueFactory(new PropertyValueFactory<>("muayeneBolgesi"));
        d_UVIsikSiddeti.setCellValueFactory(new PropertyValueFactory<>("uvIsikSiddeti"));
        ekipmanTable.setItems(data);
    }
}

