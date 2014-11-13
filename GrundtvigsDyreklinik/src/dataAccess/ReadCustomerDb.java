package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Customer;
import application.Animal;

public class ReadCustomerDb 
{
	Connection conn = null;
	PreparedStatement prepareStatement = null;
	ResultSet result = null;

	ConnectionDb dBc = new ConnectionDb();

	ArrayList<Customer> customerList;

	public ArrayList<Customer> readCustomer() throws SQLException
	{
		customerList = new ArrayList<Customer>();
		
		try
		{
			conn = dBc.getConnection();
			prepareStatement = conn.prepareStatement("SELECT * FROM kunde");
			result = prepareStatement.executeQuery();

			while(result.next())
			{    
				String name = result.getString("navn");
				String address = result.getString("adresse");
				String mobil = result.getString("mobil");
				String mail = result.getString("email");
				
				customerList.add(new Customer(name, address, mobil, mail));
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
				conn.close();
			}
		}
		return customerList;

	}
}