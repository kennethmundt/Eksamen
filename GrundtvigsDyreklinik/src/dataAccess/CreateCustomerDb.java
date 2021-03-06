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

    public void insert(Customer customer)
    {
	try
	{
	    String insert = "INSERT INTO customers VALUES(default, ?, ?, ?, ?)";

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

    public void insert(Animal animal)
    {
	try
	{
	    conn = dBc.connect();
	    preparedStatement = conn.prepareStatement("INSERT INTO animals VALUES(default, ?, ?, ?, ?)");
	   
	    preparedStatement.setString(1, animal.getAnimalBirth());
	    preparedStatement.setString(2, animal.getAnimalName());
	    preparedStatement.setInt(3, animal.getSpeciesId());
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
}