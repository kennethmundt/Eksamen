/**
 * @author kenneth, Jogvan, Elvis og Tina
 * Delete from the database.
 */

package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDb
{
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    private ConnectionDb dBc = new ConnectionDb();
    
    /**
     * Deletes a specific customer in the database
     * @param phone
     */
    public void deleteCustomer(String phone)
    {
	conn = dBc.connect();
	try
	{
	    preparedStatement = conn.prepareStatement("DELETE FROM customers WHERE phone = " + phone);
	    preparedStatement.executeUpdate();
	    preparedStatement.close();
	    conn.close();
	} 
	catch (SQLException e)
	{
	    e.printStackTrace();
	}
    }

    /**
     * Deletes a specific treatment in the database
     * @param treatmentName
     */
    public void deleteTreatment(String treatmentName)
    {
	conn = dBc.connect();
	try
	{
	    preparedStatement = conn.prepareStatement("DELETE FROM treatments WHERE treatmentName = '" + treatmentName + "'");
	    preparedStatement.executeUpdate();
	    preparedStatement.close();
	    conn.close();

	} 
	catch (SQLException e)
	{
	    e.printStackTrace();
	}
    }
}