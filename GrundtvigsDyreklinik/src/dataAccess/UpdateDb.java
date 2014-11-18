package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDb
{
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ConnectionDb dBc = new ConnectionDb();

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

    public void deleteCustomer(String phone)
    {
	conn = dBc.connect();
	try
	{
	    preparedStatement = conn
		    .prepareStatement("DELETE FROM customers WHERE phone = "
			    + phone);
	    preparedStatement.executeUpdate();
	    preparedStatement.close();
	    conn.close();

	} catch (SQLException e)
	{
	    e.printStackTrace();
	}
    }
}
