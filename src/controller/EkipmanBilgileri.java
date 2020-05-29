package controller;

import com.company.DBManager;
import com.company.Ekipman;
import com.company.Kullanici;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EkipmanBilgileri implements Initializable {
    public ComboBox akimTipi;
    public TextField kutupMesafesi, MPTasiyiciOrtam, miknatislamaTeknigi, UVIsikSiddeti, isikMesafesi, muayeneBolgesi, ekipmanIsmi;
    public Button ekle;
    public TableColumn d_ekipmanIsmi,d_MiknatislamaTeknigi,d_IsikMesafesi,d_MuayeneTeknigi,d_KutupMesafesi,d_MPTasiyiciOrtam,d_UVIsikSiddeti,d_AkimTipi;
    public TextField deg_EkipmanIsmi,deg_EkipmanIsmiC,deg_MiknatıislamaTeknigi,deg_IsikMesafesi,deg_MuayeneBolgesi,deg_MPTasiyiciOrtam,deg_KutupMesafesi,deg_UVIsikSiddeti;
    public ComboBox deg_AkimTipi;
    private final String tableName = "ekipmanT";
    private String select = "SELECT * FROM " + tableName;
    private ObservableList<Kullanici> data = FXCollections.observableArrayList();

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
        Ekipman ekipman = new Ekipman(kutupMesafesi.getText(),ekipmanIsmi.getText(),MPTasiyiciOrtam.getText(),miknatislamaTeknigi.getText(),UVIsikSiddeti.getText(),isikMesafesi.getText(),muayeneBolgesi.getText(),akimTipi.getValue().toString());

        String insertStr = "INSERT INTO " + tableName +
                " VALUES(" +
                "'" + ekipman.getKutupMesafesi() + "'" + "," +
                "'" + ekipman.getIsikMesafesi() + "'" + "," +
                "'" + ekipman.getMPTasiyiciOrtam() + "'" + "," +
                "'" + ekipman.getMiknatislamaTeknigi() + "'" + "," +
                "'" + ekipman.getUvIsikSiddeti() + "'" + "," +
                "'" + ekipman.getMuayeneBolgesi() + "'" + "," +
                "'" + ekipman.getAkimTipi() + "'" + "," +
                "'" +ekipman.getCihazAdi() + "')";
        try {
            db.insertDB(insertStr);
        } catch (SQLException e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Aynı kullanıcı girilmesi");
            errorAlert.setContentText("Aynı kullanıcı adına sahip kişi oluşturamazsınız");
            errorAlert.showAndWait();
        }

        System.out.println("inserted");
    }

    public void ekipmanSil() throws SQLException {
        DBManager db = new DBManager();

    }

}

