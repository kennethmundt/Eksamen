package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Customer;

public class ReadCustomerDb
{
    ConnectionDb dBc = new ConnectionDb();
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;

    public ArrayList<Customer> readCustomer()
    {
	ArrayList<Customer> customerList = new ArrayList<Customer>();

	try
	{
	    conn = dBc.connect();
	    preparedStatement = conn.prepareStatement("SELECT * FROM kunde");
	    result = preparedStatement.executeQuery();

	    while (result.next())
	    {
		String id = result.getString("idkunde");
		String name = result.getString("navn");
		String address = result.getString("adresse");
		String mobil = result.getString("mobil");
		String mail = result.getString("email");

		customerList.add(new Customer(id, name, address, mobil, mail));
	    }
	    preparedStatement.close();
	    conn.close();
	} catch (SQLException e)
	{
	    System.err.println(e);
	}
	return customerList;
    }

    public Customer readCustomer(String phone)
    {
	Customer customer = null;
	try
	{
	    conn = dBc.connect();
	    preparedStatement = conn.prepareStatement("SELECT * FROM kunde WHERE mobil = "+ phone);
	    result = preparedStatement.executeQuery();
	    while (result.next())
	    {
		String id = result.getString("idkunde");
		String name = result.getString("navn");
		String address = result.getString("adresse");
		String mobil = result.getString("mobil");
		String mail = result.getString("email");

		customer = new Customer(id, name, address, mobil, mail);
	    }

	} catch (SQLException e)
	{
	    e.printStackTrace();
	}

	return customer;
    }

}