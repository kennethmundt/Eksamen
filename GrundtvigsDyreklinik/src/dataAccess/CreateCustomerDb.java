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
    PreparedStatement preparedStatement = null;
    ConnectionDb dBc = new ConnectionDb();
    int customerId;

    public void insertCustomer(Customer customer)
    {
	try
	{
	    String insert = "INSERT INTO kunde VALUES(default, ?, ?, ?, ?)";

	    conn = dBc.connect();
	    preparedStatement = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

	    preparedStatement.setString(1, customer.getName());
	    preparedStatement.setString(2, customer.getAddress());
	    preparedStatement.setString(3, customer.getPhone());
	    preparedStatement.setString(4, customer.getMail());
	    preparedStatement.executeUpdate();

	    ResultSet rs = preparedStatement.getGeneratedKeys();
	    
	    if (rs.next())
	    {
		customerId = rs.getInt(1);
	    }
	    preparedStatement.close();
	    conn.close();
	}
	catch (SQLException e)
	{
	    System.err.println(e);
	}
    }

    public void insertAnimal(Animal a)
    {
	try
	{
	    conn = dBc.connect();
	    preparedStatement = conn.prepareStatement("INSERT INTO dyr VALUES(default, ?, ?, ?, ?)");

	    preparedStatement.setString(1, a.getAnimalName());
	    preparedStatement.setString(2, a.getAnimalBirth());
	    preparedStatement.setString(3, a.getAnimal());
	    preparedStatement.setInt(4, customerId);
	    preparedStatement.executeUpdate();
	    preparedStatement.close();
	    conn.close();
	}
	catch (SQLException e)
	{
	    System.err.println(e);
	}
    }
    
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
}