package com.company;

import java.sql.*;

public class DBManager {
    private static Connection conn;


    public void connectDB() throws Exception {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:~/test", "", "");
        System.out.println("bağlanıldı");
    }

    public void closeDB() throws SQLException {
        conn.close();
    }

    public void tableCreate(String str) throws SQLException {

        Statement stmt = conn.createStatement();

        try {
            stmt.executeUpdate(str);
            System.out.println("table başarılı bir şekilde oluşturuldu.");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("bu zaten önceden var açmana gerek yok");
        }

    }

    public void insertDB(String insertStr) throws SQLException {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(insertStr);
    }

    public String selectDB(String str) {
        str = "SELECT kullanıcıAdı FROM q";


        return str;
    }

    public int genKey() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.getGeneratedKeys();

        return rs.getInt(1);
    }

    public void deleteUserDB(String tablo,String silinenYer,String silinecek) throws SQLException {
        PreparedStatement st = conn.prepareStatement("DELETE FROM "+tablo+" WHERE "+silinenYer+" = ?");
        st.setString(1,silinecek);
        st.executeUpdate();

    }

}
