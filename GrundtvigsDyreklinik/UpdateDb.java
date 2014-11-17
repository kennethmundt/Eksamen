package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDb
{
	Connection conn = null;
	PreparedStatement preparedStatement = null;
	ConnectionDb dBc = new ConnectionDb();

	public void updateCustomerDb(String value1, String value2, String value3, String value4, String idValue)
	{
		conn = dBc.connect();
		try
		{
			preparedStatement = conn.prepareStatement("UPDATE kunde SET navn = ?, adresse = ?, mobil = ?, email = ? WHERE idkunde = "+ idValue);

			preparedStatement.setString(1, value1);
			preparedStatement.setString(2, value2);
			preparedStatement.setString(3, value3);
			preparedStatement.setString(4, value4);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			conn.close();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteCustomerDb(String value)
	{
		conn = dBc.connect();
		try
		{
			preparedStatement = conn.prepareStatement("DELETE FROM kunde WHERE mobil = '"+value+"'");
			preparedStatement.executeUpdate();
			preparedStatement.close();
			conn.close();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
