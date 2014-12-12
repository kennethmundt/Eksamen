/**
 * @author Jogvan, Elvis, Kenneth
 */
package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Animal;
import application.Booking;
import application.Customer;
import application.Treatment;

public class CreateDb
{
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    private ConnectionDb dBc = new ConnectionDb();
    private int customerId;

    /**
     * Adding a new customer to the database
     * @param customer
     */
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

    /**
     * Adding a new animal to the database
     * @param animal
     */

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

    /**
     * Adding a new treatment to the database
     * @param treatment
     */
    public void insert(Treatment treatment)
    {
	try
	{
	    conn = dBc.connect();
	    preparedStatement = conn.prepareStatement("INSERT INTO treatments VALUES(default, ?, ?, ?, ?)");

	    preparedStatement.setString(1, treatment.getTreatmentName());
	    preparedStatement.setString(2, treatment.getPrice());
	    preparedStatement.setString(3, treatment.getDuration());
	    preparedStatement.setString(4, treatment.getComment());
	    preparedStatement.executeUpdate();
	    preparedStatement.close();
	    conn.close();
	}
	catch (SQLException e)
	{
	    System.err.println(e);
	}
    }

    public void insert(Booking booking)
    {
	try
	{
	    conn = dBc.connect();
	    preparedStatement = conn.prepareStatement("INSERT INTO bookings VALUES(default, ?, ?, ?, ?)");
	    preparedStatement.setString(1, booking.getDateTime());
	    preparedStatement.setInt(2, booking.getTreatmentId());
	    preparedStatement.setInt(3, booking.getAnimalId());
	    preparedStatement.setInt(4, booking.getCustomerId());
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