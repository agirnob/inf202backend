package com.company;



import java.sql.*;


public class DBManager {

    public static Connection getConn() {
        return conn;
    }

    private static Connection conn;


    public void connectDB() throws Exception {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:~/test", "", "");
        System.out.println("bağlanıldı");
    }

    public void closeDB() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e){
            throw e;
        }
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

    public void deleteUserDB (String tablo,String silinenYer,String silinecek) throws SQLException {
        PreparedStatement st = conn.prepareStatement("DELETE FROM " + tablo + " WHERE " + silinenYer + " = ?");
        st.setString(1, silinecek);
        st.executeUpdate();
    }}

