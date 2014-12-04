/**
 * Jogvan, Elvis, Kenneth
 */
package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import application.Animal;
import application.Booking;
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
	    preparedStatement = conn.prepareStatement("SELECT * FROM customers WHERE phone = " + phone);
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
	    preparedStatement = conn.prepareStatement("SELECT * FROM dyreklinik.animalspecies");
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
    
    public List<Animal> readAnimal(Customer customer)
    {
	List<Animal> animalInfoList = new ArrayList<Animal>();
	
	String id = customer.getId();
	
	try
	{
	    conn = dBc.connect();
	    preparedStatement = conn
		    .prepareStatement("SELECT * FROM animals WHERE animals.fk_idCustomer = " + id);
	    result = preparedStatement.executeQuery();

	    while (result.next())
	    {
		
	    int animalId = result.getInt("idAnimal");
		String animalName = result.getString("animalName");
		String birthDay = result.getString("birthday");
		
		Animal animal = new Animal(animalId, animalName, birthDay);
		animalInfoList.add(animal);
	    }
	    preparedStatement.close();
	    conn.close();
	} 
	catch (SQLException e)
	{
	    System.err.println(e);
	}
	return animalInfoList;
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
    
    public int readSpecies(String animal, String customerId) 
    {
	int id = 0;
	try
	{
	    conn = dBc.connect();
	    preparedStatement = conn
		    .prepareStatement("SELECT idAnimal FROM dyreklinik.animals WHERE animalName = '" + animal + "' AND fk_idCustomer = '" + customerId + "'");
	    result = preparedStatement.executeQuery();
	    while (result.next())
	    {
		id = result.getInt("idAnimal");
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

    public ArrayList<String> readTime()
    {
	ArrayList<String> timeList = new ArrayList<String>();

	try
	{
	    conn = dBc.connect();
	    preparedStatement = conn.prepareStatement("SELECT * FROM timetable");
	    result = preparedStatement.executeQuery();

	    while (result.next())
	    {
		String time = result.getString("time");
		String min = result.getString("min");

		String timeMin = time + " :" + min;

		timeList.add(timeMin);

	    }
	    preparedStatement.close();
	    conn.close();

	} catch (SQLException e)
	{
	    System.err.println(e);
	}
	return timeList;
    }
    
    public String getPassword(String username)
    {
	String password = "";
	
	try
	{
	    conn = dBc.connect();
	    String query = "SELECT password FROM employeeaccounts WHERE username = ?";
	    preparedStatement = conn.prepareStatement(query);
	    preparedStatement.setString(1, username);
	    result = preparedStatement.executeQuery();

	    while (result.next())
	    {
		password = result.getString("password");
	    }
	    
	    preparedStatement.close();
	    conn.close();
	} catch (SQLException e)
	{
	    System.err.println(e);
	}
	return password;
    }

    public ArrayList<Booking> readBooking()
    {
	ArrayList<Booking> bookingList = new ArrayList<Booking>();

	try
	{
	    conn = dBc.connect();
	    preparedStatement = conn.prepareStatement("SELECT customers.name, customers.phone, bookings.dateTime, animals.animalName, animalspecies.speciesName, treatments.treatmentName FROM bookings JOIN animals ON bookings.fk_idAnimal = animals.idAnimal JOIN treatments ON bookings.fk_idTreatment = treatments.idTreatment	JOIN customers ON animals.fk_idCustomer = customers.idCustomer JOIN animalspecies ON animals.fk_idAnimalSpecies = animalspecies.idAnimalSpecies");
		result = preparedStatement.executeQuery();

	    while (result.next())
	    {
		String customerName = result.getString("name");
		String customerPhone = result.getString("phone");
		String animalName = result.getString("animalName");
		String species = result.getString("speciesName");
		String dateTime = result.getString("dateTime");
		String treatmentName = result.getString("treatmentName");

		bookingList.add(new Booking(customerName, customerPhone, animalName, species, dateTime, treatmentName));
	    }
	    preparedStatement.close();
	    conn.close();

	} catch (SQLException e)
	{
	    System.err.println(e);
	}
	return bookingList;
    }

    public boolean getPhone(String phone)
    {
	String phoneNum = "";
	
	try
	{
	    conn = dBc.connect();
	    preparedStatement = conn.prepareStatement("SELECT * FROM customers WHERE phone = ?");
	    preparedStatement.setString(1, phone);
	    result = preparedStatement.executeQuery();

	    while (result.next())
	    {
		phoneNum = result.getString("phone");
	    }
	}
	catch (SQLException e)
	{
	    e.printStackTrace();
	}
	return phoneNum.equals(phoneNum);
    }
}