/**
 * @author Kenneth
 * Creates a new customer and n animals
 */

package application;

import java.util.ArrayList;

import dataAccess.CreateCustomerDb;

public class CreateCustomerApp
{
    ArrayList<Animal> animalList = new ArrayList<Animal>();
    CreateCustomerDb ccdb = new CreateCustomerDb();

    /**
     * Creates a new customer and passes this customer as a parameter to insertCustomer()
     * in the dataAccess layer.
     * @param name
     * @param address
     * @param phone
     * @param mail
     */
    public void createCustomer(String name, String address, String phone, String mail)
    {
	Customer customer = new Customer(name, address, phone, mail);

	ccdb.insertCustomer(customer);
    }

    /**
     * Creates a new animal and passes it  
     * @param animalName
     * @param animalAge
     * @param animal
     */
    public void createAnimal(String animalName, String animalAge, String animal)
    {
	Animal newAnimal = new Animal(animalName, animalAge, animal);
    }
}
