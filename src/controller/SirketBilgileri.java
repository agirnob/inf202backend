package controller;

import agirnob.ComboBoxAutoComplete;
import com.company.DBManager;
import com.company.Sirket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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

public class SirketBilgileri implements Initializable {
    public static final String tableName = "SrketT";
    public TableView<Sirket> sirketTable;
    public TableColumn d_musteriAdi;
    public TableColumn d_Il;
    public TableColumn d_Ilce;
    public TableColumn d_TeklifNo;
    public TableColumn d_ProjeNo;
    public TextField musteriIsmi;
    public TextField teklifNo;
    public TextField isEmriNo;
    public TextField deg_MusteriAdi;
    public Button musteriSil;
    public TextField deg_MusteriAdiC;
    public TextField deg_Il;
    public TextField deg_Ilce;
    public TextField deg_Proje;
    public TextField deg_TeklifNo;
    private String select = "SELECT * FROM " + tableName;
    private ObservableList<Sirket> data = FXCollections.observableArrayList();
    private static final String[] LISTA = {"Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Aksaray", "Amasya", "Ankara", "Antalya",
            "Ardahan", "Artvin", "Aydın", "Balıkesir", "Bartın", "Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu",
            "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Düzce", "Edirne", "Elazığ", "Erzincan",
            "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay", "Iğdır", "Isparta", "İstanbul", "İzmir",
            "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu", "Kayseri", "Kilis", "Kırıkkale", "Kırklareli", "Kırşehir",
            "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu",
            "Osmaniye", "Rize", "Sakarya", "Samsun", "Şanlıurfa", "Siirt", "Sinop", "Sivas", "Şırnak", "Tekirdağ", "Tokat",
            "Trabzon", "Tunceli", "Uşak", "Van", "Yalova", "Yozgat", "Zonguldak"};
    public ComboBox ilComboBox;
    public ComboBox ilceComboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ilComboBox.setTooltip(new Tooltip());
        ilComboBox.getItems().addAll(LISTA);
        ilceComboBox.getItems().addAll(LISTA);
        ilComboBox.getSelectionModel().selectFirst();
        ilceComboBox.getSelectionModel().selectFirst();
        new ComboBoxAutoComplete<String>(ilComboBox);
        DBManager db = new DBManager();
        try {
            String strTable = "CREATE TABLE " + tableName + "(" +
                    "Il VARCHAR(50) NOT NULL," +
                    "Ilce VARCHAR(50) NOT NULL," +
                    "TeklifNo VARCHAR(50) NOT NULL," +
                    "IsemriNo VARCHAR(50) NOT NULL," +
                    "MusteriIsmi VARCHAR(50) NOT NULL UNIQUE" +
                    ");";
            db.tableCreate(strTable);
            System.out.println("tablecreated");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    @FXML
    private void sirketSil() throws SQLException {
        DBManager db = new DBManager();
        db.deleteUserDB(tableName, "MusteriIsmi", deg_MusteriAdi.getText());
        refreshTableView();
    }


    @FXML
    private void sirketEkle(){
        DBManager db = new DBManager();
        Sirket sirket =new Sirket(musteriIsmi.getText(),ilComboBox.getValue().toString()
                ,ilceComboBox.getValue().toString(),teklifNo.getText(),isEmriNo.getText());
        String insertStr = "INSERT INTO " + tableName +
                " VALUES(" +
                "'" + sirket.getIl() + "'" + "," +
                "'" + sirket.getIlce() + "'" + "," +
                "'" + sirket.getTeklifNo() + "'" + "," +
                "'" + sirket.getIsEmriNo() + "'" + "," +
                "'" + sirket.getMusteriIsmi() + "'" +")";
        try {
            db.insertDB(insertStr);
        } catch (SQLException e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Aynı Sirket girilmesi");
            errorAlert.setContentText("Aynı Sirket adına sahip Sirket oluşturamazsınız");
            errorAlert.showAndWait();
        }
    }
    @FXML
    private void refreshTableView() {
        try {
            Connection con = DBManager.getConn();
            ResultSet rs = con.createStatement().executeQuery(select);

            for (int i = 0; i < sirketTable.getItems().size(); i++) {
                sirketTable.getItems().clear();
            }
            while (rs.next()) {
                data.add(new Sirket(rs.getString("MusteriIsmi"),rs.getString("Il"),
                        rs.getString("Ilce"),rs.getString("TeklifNo"),rs.getString("IsemriNo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        d_Il.setCellValueFactory(new PropertyValueFactory<>("il"));
        d_Ilce.setCellValueFactory(new PropertyValueFactory<>("ilce"));
        d_TeklifNo.setCellValueFactory(new PropertyValueFactory<>("teklifNo"));
        d_ProjeNo.setCellValueFactory(new PropertyValueFactory<>("isEmriNo"));
        d_musteriAdi.setCellValueFactory(new PropertyValueFactory<>("musteriIsmi"));
        sirketTable.setItems(data);

    }
    @FXML
    private void sirketUpdate() throws SQLException {

        String sql = "UPDATE " + tableName + " SET Il ='" + deg_Il.getText() + "' , Ilce = '" + deg_Ilce.getText() +
                "', TeklifNo = '" + deg_TeklifNo.getText() + "' , IsemriNo = '" + deg_Proje.getText()
                + "', MusteriIsmi = '" + deg_MusteriAdiC.getText() + "'";

        sql = sql + " WHERE MusteriIsmi = " + "'"+deg_MusteriAdi.getText()+"'";
        PreparedStatement pstmt = DBManager.getConn().prepareStatement(sql);
        try {
            pstmt.execute();
            refreshTableView();
        } catch (org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Aynı şirket girilmesi");
            errorAlert.setContentText("Aynı şirket adına sahip şirket oluşturamazsınız");
            errorAlert.showAndWait();
        }
    }

    @FXML
    private void displayView(MouseEvent mouseEvent) {
        Sirket user = sirketTable.getSelectionModel().getSelectedItem();
        if (user == null) {
            d_musteriAdi.setText("Nichts gewahlt");
        } else {
            deg_MusteriAdiC.setText((user.getMusteriIsmi()));
            deg_MusteriAdi.setText((user.getMusteriIsmi()));
            deg_TeklifNo.setText(user.getIsEmriNo());
            deg_TeklifNo.setText(user.getTeklifNo());
            deg_Ilce.setText(user.getIlce());
            deg_Il.setText(user.getIl());
        }
    }
}
