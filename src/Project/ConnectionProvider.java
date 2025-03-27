package Project;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    public static Connection getCon()
    {
        final String DB_URL = "jdbc:mysql://localhost:3306/blood_bank_ms";
        final String USERNAME = "root";
        final String PASSWORD = "mysql";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            return con;

        }catch (Exception e){
            return null;
        }
    }
}