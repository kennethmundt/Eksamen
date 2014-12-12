/**
 * @author Jogvan og Elvis
 */

package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb
{
    private String user = "kennethmundt";
    private String password = "dreamteam";
    private String database = "dyreklinik";
    private String url = "jdbc:mysql://localhost/";

    /**
     * @return database connection
     */
    public Connection connect()
    {
	try
	{
	    Connection conn = (Connection) DriverManager.getConnection(url + database, user, password);
	    return conn;
	} 
	catch (Exception e)
	{
	    e.printStackTrace();
	    return null;
	}
    }
}
