/**
 * Jogvan, Elvis, Kenneth
 */
package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.Animal;
import application.Customer;
import application.Treatment;

public class ReadDb
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
	    preparedStatement = conn
		    .prepareStatement("SELECT * FROM customers");
	    result = preparedStatement.executeQuery();

	    while (result.next())
	    {
		String id = result.getString("idCustomer");
		String name = result.getString("name");
		String address = result.getString("address");
		String phone = result.getString("phone");
		String mail = result.getString("mail");

		customerList.add(new Customer(id, name, address, phone, mail));
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
	    preparedStatement = conn
		    .prepareStatement("SELECT * FROM customers WHERE phone = "
			    + phone);
	    result = preparedStatement.executeQuery();
	    while (result.next())
	    {
		String id = result.getString("idCustomer");
		String name = result.getString("name");
		String address = result.getString("address");
		String phoneNum = result.getString("phone");
		String mail = result.getString("mail");

		customer = new Customer(id, name, address, phoneNum, mail);
	    }

	} catch (SQLException e)
	{
	    e.printStackTrace();
	}
	return customer;
    }

    public List<String> readAnimal()
    {
	List<String> speciesList = new ArrayList<String>();

	try
	{
	    conn = dBc.connect();
	    preparedStatement = conn
		    .prepareStatement("SELECT * FROM dyreklinik.animalspecies");
	    result = preparedStatement.executeQuery();

	    while (result.next())
	    {
		String animal = result.getString("speciesName");

		speciesList.add(animal);
	    }
	    preparedStatement.close();
	    conn.close();
	} catch (SQLException e)
	{
	    System.err.println(e);
	}
	return speciesList;
    }

    public int readSpecies(String animal)
    {
	int id = 0;
	try
	{
	    conn = dBc.connect();
	    preparedStatement = conn
		    .prepareStatement("SELECT idAnimalSpecies FROM dyreklinik.animalspecies WHERE speciesName = '" + animal + "'");
	    result = preparedStatement.executeQuery();
	    while (result.next())
	    {
		id = result.getInt("idAnimalSpecies");
	    }
	
	} 
	catch (SQLException e)
	{
	    System.err.println(e);
	}
	return id;
    }
    
	public ArrayList<Treatment> readTreatment()
	{
		ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();

		try
		{
			conn = dBc.connect();
			preparedStatement = conn.prepareStatement("SELECT * FROM treatments");
			result = preparedStatement.executeQuery();

			while (result.next())
			{
				String id = result.getString("idTreatment");
				String treatmentName = result.getString("treatmentName");
				String price = result.getString("price");
				String duration = result.getString("duration");
				String comment = result.getString("comment");

				treatmentList.add(new Treatment(id, treatmentName, price, duration, comment));
			}
			preparedStatement.close();
			conn.close();

		} catch (SQLException e)
		{
			System.err.println(e);
		}
		return treatmentList;
	}
	
	public Treatment readTreatment(String name)
	{		
		Treatment treatment = null;
		try
		{
			conn = dBc.connect();
			preparedStatement = conn.prepareStatement("SELECT * FROM treatments WHERE treatmentName = '" + name +"'");
			result = preparedStatement.executeQuery();
			while (result.next())
			{
				String id = result.getString("idTreatment");
				String treatmentName = result.getString("treatmentName");
				String price = result.getString("price");
				String duration = result.getString("duration");
				String comment = result.getString("comment");

				treatment = new Treatment(id, treatmentName, price, duration, comment);
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return treatment;
	}
}