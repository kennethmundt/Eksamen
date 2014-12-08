/**
 * Jogvan, Elvis, Kenneth
 */
package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDb
{
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ConnectionDb dBc = new ConnectionDb();

    /**
     * Updating a specific customer in the database
     * 
     * @param name
     * @param address
     * @param phone
     * @param mail
     * @param id
     */
    public void updateCustomer(String name, String address, String phone,
	    String mail, String id)
    {
	conn = dBc.connect();
	try
	{
	    preparedStatement = conn
		    .prepareStatement("UPDATE customers SET name = ?, address = ?, phone = ?, mail = ? WHERE idCustomer = "
			    + id);

	    preparedStatement.setString(1, name);
	    preparedStatement.setString(2, address);
	    preparedStatement.setString(3, phone);
	    preparedStatement.setString(4, mail);
	    preparedStatement.executeUpdate();
	    preparedStatement.close();
	    conn.close();

	} catch (SQLException e)
	{
	    e.printStackTrace();
	}
    }

    /**
     * Updating a specific treatment in the database
     * 
     * @param treatmentName
     * @param price
     * @param duration
     * @param comment
     * @param id
     */
    public void updateTreatment(String treatmentName, String price,
	    String duration, String comment, String id)
    {
	conn = dBc.connect();
	try
	{
	    preparedStatement = conn
		    .prepareStatement("UPDATE treatments SET treatmentName = ?, price = ?, duration = ?, comment = ? WHERE idTreatment = "
			    + id);

	    preparedStatement.setString(1, treatmentName);
	    preparedStatement.setString(2, price);
	    preparedStatement.setString(3, duration);
	    preparedStatement.setString(4, comment);
	    preparedStatement.executeUpdate();
	    preparedStatement.close();
	    conn.close();

	} catch (SQLException e)
	{
	    e.printStackTrace();
	}
    }

}