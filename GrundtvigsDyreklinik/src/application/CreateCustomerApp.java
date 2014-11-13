package application;

import java.util.ArrayList;

import dataAccess.CreateCustomerDb;

public class CreateCustomerApp 
{ 
    
    ArrayList<Animal> animalList = new ArrayList<Animal>();
    Customer customer;
    CreateCustomerDb ccdb = new CreateCustomerDb();
    
    
    public void createCustomer(String name, String address, String phone, String mail)
    {
	customer = new Customer(name, address, phone, mail);
	
	ccdb.insertCustomer(customer);
	System.out.println(customer);

    }
    
    public void createAnimal(String name, String age, String animal)
    {
	// TODO Auto-generated method stub

    }

}
