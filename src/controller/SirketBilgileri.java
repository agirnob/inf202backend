package controller;

import agirnob.ComboBoxAutoComplete;
import agirnob.ilceler;
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
    public TableColumn<Object, Object> d_musteriAdi;
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
    public ComboBox<String> ilComboBox;
    public ComboBox<String> ilceComboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ilComboBox.getItems().addAll(LISTA);
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
    private void sirketEkle() {
        DBManager db = new DBManager();
        Sirket sirket = new Sirket(musteriIsmi.getText(), ilComboBox.getValue().toString()
                , ilceComboBox.getValue().toString(), teklifNo.getText(), isEmriNo.getText());
        String insertStr = "INSERT INTO " + tableName +
                " VALUES(" +
                "'" + sirket.getIl() + "'" + "," +
                "'" + sirket.getIlce() + "'" + "," +
                "'" + sirket.getTeklifNo() + "'" + "," +
                "'" + sirket.getIsEmriNo() + "'" + "," +
                "'" + sirket.getMusteriIsmi() + "'" + ")";
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
                data.add(new Sirket(rs.getString("MusteriIsmi"), rs.getString("Il"),
                        rs.getString("Ilce"), rs.getString("TeklifNo"), rs.getString("IsemriNo")));
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

        sql = sql + " WHERE MusteriIsmi = " + "'" + deg_MusteriAdi.getText() + "'";
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

    @FXML
    private void ilSec() {
        int x = 0;
        x = ilComboBox.getSelectionModel().getSelectedIndex();
        switch (x+1) {
            case 1:
                ilceComboBox.getItems().setAll(ilceler.getIlceAdana());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 2:
                ilceComboBox.getItems().setAll(ilceler.getIlceAdiyaman());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 3:
                ilceComboBox.getItems().setAll(ilceler.getIlceAfyonkarahisar());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 4:
                ilceComboBox.getItems().setAll(ilceler.getIlceAgri());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 5:
                ilceComboBox.getItems().setAll(ilceler.getIlceAksaray());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 6:
                ilceComboBox.getItems().setAll(ilceler.getIlceAmasya());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 7:
                ilceComboBox.getItems().setAll(ilceler.getIlceAnkara());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 8:
                ilceComboBox.getItems().setAll(ilceler.getIlceAntalya());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 9:
                ilceComboBox.getItems().setAll(ilceler.getIlceArdahan());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 10:
                ilceComboBox.getItems().setAll(ilceler.getIlceArtvin());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 11:
                ilceComboBox.getItems().setAll(ilceler.getIlceAydin());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 12:
                ilceComboBox.getItems().setAll(ilceler.getIlceBalikesir());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 13:
                ilceComboBox.getItems().setAll(ilceler.getIlceBartin());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 14:
                ilceComboBox.getItems().setAll(ilceler.getIlceBatman());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 15:
                ilceComboBox.getItems().setAll(ilceler.getIlceBayburt());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 16:
                ilceComboBox.getItems().setAll(ilceler.getIlceBilecik());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 17:
                ilceComboBox.getItems().setAll(ilceler.getIlceBingol());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 18:
                ilceComboBox.getItems().setAll(ilceler.getIlceBitlis());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 19:
                ilceComboBox.getItems().setAll(ilceler.getIlceBolu());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 20:
                ilceComboBox.getItems().setAll(ilceler.getIlceBurdur());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 21:
                ilceComboBox.getItems().setAll(ilceler.getIlceBursa());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 22:
                ilceComboBox.getItems().setAll(ilceler.getIlceCanakkale());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 23:
                ilceComboBox.getItems().setAll(ilceler.getIlceCankiri());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 24:
                ilceComboBox.getItems().setAll(ilceler.getIlceCorum());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 25:
                ilceComboBox.getItems().setAll(ilceler.getIlceDenizli());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 26:
                ilceComboBox.getItems().setAll(ilceler.getIlceDiyarbakir());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 27:
                ilceComboBox.getItems().setAll(ilceler.getIlceDuzce());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 28:
                ilceComboBox.getItems().setAll(ilceler.getIlceEdirne());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 29:
                ilceComboBox.getItems().setAll(ilceler.getIlceElazig());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 30:
                ilceComboBox.getItems().setAll(ilceler.getIlceErzincan());
                ilceComboBox.getSelectionModel().selectFirst();
                break;

            case 31:
                ilceComboBox.getItems().setAll(ilceler.getIlceErzurum());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 32:
                ilceComboBox.getItems().setAll(ilceler.getIlceEskisehir());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 33:
                ilceComboBox.getItems().setAll(ilceler.getIlceGaziantep());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 34:
                ilceComboBox.getItems().setAll(ilceler.getIlceGiresun());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 35:
                ilceComboBox.getItems().setAll(ilceler.getIlceGumushane());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 36:
                ilceComboBox.getItems().setAll(ilceler.getIlceHakkari());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 37:
                ilceComboBox.getItems().setAll(ilceler.getIlceHatay());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 38:
                ilceComboBox.getItems().setAll(ilceler.getIlceigdir());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 39:
                ilceComboBox.getItems().setAll(ilceler.getIlceisparta());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 40:
                ilceComboBox.getItems().setAll(ilceler.getIlceistanbul());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 41:
                ilceComboBox.getItems().setAll(ilceler.getIlceizmir());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 42:
                ilceComboBox.getItems().setAll(ilceler.getIlceKahramanmaras());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 43:
                ilceComboBox.getItems().setAll(ilceler.getIlceKarabuk());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 44:
                ilceComboBox.getItems().setAll(ilceler.getIlceKaraman());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 45:
                ilceComboBox.getItems().setAll(ilceler.getIlceKars());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 46:
                ilceComboBox.getItems().setAll(ilceler.getIlceKastamonu());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 47:
                ilceComboBox.getItems().setAll(ilceler.getIlceKayseri());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 48:
                ilceComboBox.getItems().setAll(ilceler.getIlceKilis());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 49:
                ilceComboBox.getItems().setAll(ilceler.getIlceKirikkale());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 50:
                ilceComboBox.getItems().setAll(ilceler.getIlceKirklareli());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 51:
                ilceComboBox.getItems().setAll(ilceler.getIlceKirsehir());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 52:
                ilceComboBox.getItems().setAll(ilceler.getIlceKocaeli());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 53:
                ilceComboBox.getItems().setAll(ilceler.getIlceKonya());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 54:
                ilceComboBox.getItems().setAll(ilceler.getIlceKutahya());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 55:
                ilceComboBox.getItems().setAll(ilceler.getIlceMalatya());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 56:
                ilceComboBox.getItems().setAll(ilceler.getIlceManisa());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 57:
                ilceComboBox.getItems().setAll(ilceler.getIlceMardin());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 58:
                ilceComboBox.getItems().setAll(ilceler.getIlceMersin());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 59:
                ilceComboBox.getItems().setAll(ilceler.getIlceMugla());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 60:
                ilceComboBox.getItems().setAll(ilceler.getIlceMus());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 61:
                ilceComboBox.getItems().setAll(ilceler.getIlceNevsehir());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 62:
                ilceComboBox.getItems().setAll(ilceler.getIlceNigde());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 63:
                ilceComboBox.getItems().setAll(ilceler.getIlceOrdu());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 64:
                ilceComboBox.getItems().setAll(ilceler.getIlceOsmaniye());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 65:
                ilceComboBox.getItems().setAll(ilceler.getIlceRize());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 66:
                ilceComboBox.getItems().setAll(ilceler.getIlceSakarya());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 67:
                ilceComboBox.getItems().setAll(ilceler.getIlceSamsun());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 68:
                ilceComboBox.getItems().setAll(ilceler.getIlcesanliurfa());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 69:
                ilceComboBox.getItems().setAll(ilceler.getIlceSiirt());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 70:
                ilceComboBox.getItems().setAll(ilceler.getIlceSinop());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 71:
                ilceComboBox.getItems().setAll(ilceler.getIlceSivas());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 72:
                ilceComboBox.getItems().setAll(ilceler.getIlcesirnak());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 73:
                ilceComboBox.getItems().setAll(ilceler.getIlceTekirdag());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 74:
                ilceComboBox.getItems().setAll(ilceler.getIlceTokat());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 75:
                ilceComboBox.getItems().setAll(ilceler.getIlceTrabzon());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 76:
                ilceComboBox.getItems().setAll(ilceler.getIlceTunceli());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 77:
                ilceComboBox.getItems().setAll(ilceler.getIlceUsak());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 78:
                ilceComboBox.getItems().setAll(ilceler.getIlceVan());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 79:
                ilceComboBox.getItems().setAll(ilceler.getIlceYalova());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 80:
                ilceComboBox.getItems().setAll(ilceler.getIlceYozgat());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
            case 81:
                ilceComboBox.getItems().setAll(ilceler.getIlceZonguldak());
                ilceComboBox.getSelectionModel().selectFirst();
                break;
        }
    }
}
