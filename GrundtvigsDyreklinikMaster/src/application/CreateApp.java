/**
 * @author kenneth, Tina, Elvis og Jogvan
 * Responsible for creating objects of customers, animals, treatments and bookings
 */

package application;

import dataAccess.CreateDb;

public class CreateApp
{
    CreateDb createDb = new CreateDb();

    /**
     * Creates a new customer and passes this customer as a parameter to insert()
     * in the dataAccess layer.
     * @param name
     * @param address
     * @param phone
     * @param mail
     */
    public void create(String name, String address, String phone, String mail)
    {
	Customer customer = new Customer(name, address, phone, mail);

	createDb.insert(customer);
    }

    /**
     * Creates a new animal and passes it  
     * @param animalName
     * @param animalBirth
     * @param animal
     */
    public void create(String animalName, String animalBirth, int id)
    {
	Animal animal = new Animal(id, animalBirth, animalName);
	createDb.insert(animal);
    }
    
    public void create(String treatmentId, int animalId, String dateString, String time, int customerId)
    {
	int treatId = Integer.parseInt(treatmentId);
	String dateTime = dateString + " - " + time;
	Booking booking = new Booking(dateTime, animalId, treatId, customerId);
	createDb.insert(booking);
    }
    
    /**
     * Creates a new Treatment and and passes this Treatment as a parameter to insert()
     * @param treatmentName
     * @param price
     * @param duration
     * @param comment
     */
    public void createTreatment(String treatmentName, String price, String duration, String comment)
    {
	Treatment newTreatment= new Treatment(treatmentName, price, duration, comment);
	createDb.insert(newTreatment);
    }
}