package dataAccess;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb
{
    String user = "root";
    String password = "";
    String database = "dyreklinik";
    String url = "jdbc:mysql://localhost/";
    
    public Connection getConnection()
    {
   	 Connection conn;
   	 try
   	 {
   		 conn = (Connection) DriverManager.getConnection(url + database, user, password);
   		 return conn;
   		 
   	 } catch (Exception e)
   	 {
   		 e.printStackTrace();
   		 return null;
   	 }

    }
    
}
