/**
 * @author Kenneth
 * Creates a new customer and n animals
 */

package application;

import java.util.ArrayList;

import dataAccess.CreateCustomerDb;
import dataAccess.ReadDb;

public class CreateCustomerApp
{
    CreateCustomerDb ccdb = new CreateCustomerDb();
    ReadDb read = new ReadDb();

    /**
     * Creates a new customer and passes this customer as a parameter to insertCustomer()
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

    public int readAnimal(String animal)
    {
	return read.readSpecies(animal);
    }
    
    
}
