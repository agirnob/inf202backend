package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
        public void tableCreate(String str) throws SQLException{

                Statement stmt = conn.createStatement();

                try {
                        stmt.executeUpdate(str);
                        System.out.println("table başarılı bir şekilde oluşturuldu.");
                }catch (Exception e){
                        System.out.println("bu zaten önceden var açmana gerek yok");
                }

        }
        public void insertDB(String str){}
        public String selectDB(String str){return str;}

}
