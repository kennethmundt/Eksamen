package dataAccess;

import java.sql.Connection;
import application.Customer;
import application.Animal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateCustomerDb  
{
	Connection conn = null;
	PreparedStatement prepareStatement = null;

	ConnectionDb dBc = new ConnectionDb();

	public void insertCustomer(Customer c) throws SQLException
	{
		try
		{
			conn = dBc.getConnection();
			prepareStatement = conn.prepareStatement("INSERT INTO kunde VALUES(default, ?, ?, ?, ?)");

			prepareStatement.setString(1, c.getName());
			prepareStatement.setString(2, c.getAddress());
			prepareStatement.setString(3, c.getPhone());
			prepareStatement.setString(4, c.getMail());

			prepareStatement.executeUpdate();
		}

		catch (SQLException e)
		{
			System.err.println(e);
		}

		finally
		{
			if(conn != null)
			{
				conn.close();
			}
		}
	}


	public void insertAnimal(Animal a) throws SQLException
	{
		int customerId = returnLast();
		try
		{
			conn = dBc.getConnection();
			prepareStatement = conn.prepareStatement("INSERT INTO dyr VALUES(default, ?, ?, ?, ?)");

			prepareStatement.setString(1, a.getAnimalName());
			prepareStatement.setString(2, a.getAnimalBirth());
			prepareStatement.setString(3, a.getAnimal());
			prepareStatement.setInt(4, customerId);

			prepareStatement.executeUpdate();
		}

		catch (SQLException e)
		{
			System.err.println(e);
		}

		finally
		{
			if(conn != null)
			{
				conn.close();
			}
		}
	}



	public int returnLast() throws SQLException
	{
		int customerId = 0;
		try
		{
			conn = dBc.getConnection();
			prepareStatement = conn.prepareStatement("SELECT * FROM kunde ORDER BY idkunde DESC LIMIT 1");
			ResultSet result = prepareStatement.executeQuery();
			while(result.next())
			{
				customerId = result.getInt("idkunde");
			}
		}

		catch (SQLException e)
		{
			System.err.println(e);
		}

		return customerId;
	}
}
