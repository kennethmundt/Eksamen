package application;

import java.util.ArrayList;

import dataAccess.CreateCustomerDb;

public class CreateCustomerApp 
{ 
    ArrayList<Animal> animalList = new ArrayList<Animal>();
    CreateCustomerDb ccdb = new CreateCustomerDb();
    
    public void createCustomer(String name, String address, String phone, String mail)
    {
	Customer customer = new Customer(name, address, phone, mail);
	
	ccdb.insertCustomer(customer);
    }
    
    public void createAnimal(String animalName, String animalAge, String animal)
    {
	Animal newAnimal = new Animal(animalName, animalAge, animal);
    }

}
