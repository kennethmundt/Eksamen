/**
 * @author Kenneth, Jogvan and Elvis
 * Creates a new customer, animals and treatments
 */

package application;

import java.util.ArrayList;

import dataAccess.CreateDb;
import dataAccess.ReadDb;

public class CreateApp
{
    CreateDb ccdb = new CreateDb();
    ReadDb read = new ReadDb();

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
	
	ccdb.insert(customer);
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
	ccdb.insert(animal);
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
		ccdb.insert(newTreatment);
	}

    public int readAnimal(String animal)
    {
	return read.readSpecies(animal);
    }
    
    
}
