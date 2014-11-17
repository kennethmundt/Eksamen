package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Animal;
import application.Customer;


public class CreateCustomerDb  
{
	Connection conn = null;
	PreparedStatement prepareStatement = null;

	ConnectionDb dBc = new ConnectionDb();
	
	int customerId;
	
	/**
	 * Method that inserts new customers into the database.
	 * @param customer
	 * @author Jogvan, Elvis.
	 */
	public void insertCustomer(Customer customer) 
	{
		try
		{
			String insert = "INSERT INTO kunde VALUES(default, ?, ?, ?, ?)";
			
			conn = dBc.getConnection();
			prepareStatement = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

			prepareStatement.setString(1, customer.getName());
			prepareStatement.setString(2, customer.getAddress());
			prepareStatement.setString(3, customer.getTelephone());
			prepareStatement.setString(4, customer.getMail());

			prepareStatement.executeUpdate();
			
			ResultSet rs = prepareStatement.getGeneratedKeys();
			if(rs.next())
			{
				customerId = rs.getInt(1);
			}
		}

		catch (SQLException e)
		{
			System.err.println(e);
		}

		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
				} catch (SQLException e)
				
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Method that inserts new animal into the database, and makes a connection to its owner(Customer).
	 * @param animal
	 * @author Jogvan, Elvis.
	 */

	public void insertAnimal(Animal animal) 
	{
		try
		{			
			conn = dBc.getConnection();			
			prepareStatement = conn.prepareStatement("INSERT INTO dyr VALUES(default, ?, ?, ?, ?)");

			prepareStatement.setString(1, animal.getAnimalName());
			prepareStatement.setString(2, animal.getAnimalBirth());
			prepareStatement.setString(3, animal.getSpecies());
			prepareStatement.setInt(4,customerId);

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
				try
				{
					conn.close();
				} catch (SQLException e)
				
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
