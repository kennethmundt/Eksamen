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
    
    public void insertCustomer(Customer customer)
    {
	try
	{
	    conn = dBc.getConnection();
	    prepareStatement = conn
		    .prepareStatement("INSERT INTO kunde VALUES(default, ?, ?, ?, ?)");

	    prepareStatement.setString(1, customer.getName());
	    prepareStatement.setString(2, customer.getAddress());
	    prepareStatement.setString(3, customer.getPhone());
	    prepareStatement.setString(4, customer.getMail());
	    int i = prepareStatement.executeUpdate();
	    System.out.println(i);
	}

	catch (SQLException e)
	{
	    System.err.println(e);
	}

	finally
	{
	    if (conn != null)
	    {
		try
		{
		    conn.close();
		} catch (SQLException e)
		{
		    e.printStackTrace();
		}
	    }
	}
    }

    public void insertAnimal(Animal a)
    {
	int customerId = 0;
	customerId = returnLastCustomer();

	try
	{
	    conn = dBc.getConnection();
	    prepareStatement = conn
		    .prepareStatement("INSERT INTO dyr VALUES(default, ?, ?, ?, ?)");

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
	    if (conn != null)
	    {
		try
		{
		    conn.close();
		} catch (SQLException e)

		{
		    e.printStackTrace();
		}
	    }
	}
    }

    public int returnLastCustomer()
    {
	int customerId = 0;
	
	try
	{
	    conn = dBc.getConnection();
	    prepareStatement = conn
		    .prepareStatement("SELECT * FROM kunde ORDER BY idkunde DESC LIMIT 1");
	    ResultSet result = prepareStatement.executeQuery();
	    
	    while (result.next())
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