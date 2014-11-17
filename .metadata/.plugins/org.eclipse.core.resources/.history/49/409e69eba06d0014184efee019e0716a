package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import application.Customer;
import application.Animal;

public class ReadCustomerDb
{
    Connection conn = null;
    PreparedStatement prepareStatement = null;
    ResultSet result = null;

    ConnectionDb dBc = new ConnectionDb();

    ArrayList<Customer> customerList;

    public ArrayList<Customer> readCustomer()
    {
	customerList = new ArrayList<Customer>();

	try
	{
	    connect();
	    prepareStatement = conn.prepareStatement("SELECT * FROM kunde");
	    result = prepareStatement.executeQuery();

	    while (result.next())
	    {
		String id = result.getString("idkunde");
		String name = result.getString("navn");
		String address = result.getString("adresse");
		String mobil = result.getString("mobil");
		String mail = result.getString("email");

		customerList.add(new Customer(id, name, address, mobil, mail));
	    }
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
	return customerList;
    }

    public void updateCustomerDb(String idNum, String newData, int row, int column)
    {
	connect();
	try
	{
	    prepareStatement = conn.prepareStatement("UPDATE kunde SET navn = ?, adresse = ?, mobil = ?, email = ? WHERE idkunde = " + idNum);
	    prepareStatement.setString(row, newData);
	} catch (SQLException e)
	{
	    e.printStackTrace();
	}
    }
    
    public void connect()
    {
	conn = dBc.getConnection();
    }
    
}