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
        } catch (Exception e) {
            throw e;
        }
    }

    public void tableCreate(String str) throws SQLException {

        Statement stmt = conn.createStatement();

        try {
            stmt.executeUpdate(str);
            System.out.println("table başarılı bir şekilde oluşturuldu.");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
    public void tableDrop(String str) throws SQLException{
        Statement stmt = conn.createStatement();
        try {
            stmt.executeUpdate(str);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void insertDB(String insertStr) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(insertStr);
        System.out.println("inserted");
    }

    public void deleteUserDB(String tablo, String silinenYer, String silinecek) throws SQLException {
        Statement stmt = DBManager.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tablo + " WHERE " + silinenYer + " = " + "'" + silinecek + "'");
        System.out.println("çalışmıyor");
        if (rs.next()) {
            System.out.println("çalışıyor");
            rs.deleteRow();
        }
    }
}

