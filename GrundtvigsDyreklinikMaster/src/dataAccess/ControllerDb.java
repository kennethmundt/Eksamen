/**
 * @author Tina
 */

package dataAccess;

import java.util.ArrayList;
import java.util.List;

import application.Animal;
import application.Booking;
import application.Customer;
import application.Treatment;

public class ControllerDb 
{
    ReadDb readDb = new ReadDb();
    CreateDb createDb = new CreateDb();
    UpdateDb updateDb = new UpdateDb();
    DeleteDb deleteDb = new DeleteDb();
    
    //Read from Database and fill arrayList and send to to the AnimalDropDownApp class
    public List<String> readAnimal() 
    {
	List<String> speciesList = new ArrayList<String>(readDb.readAnimal());
	return speciesList;
    }
    
    public List<Animal> readAnimal(Customer customer)
    {
	List<Animal> animalInfoList = new ArrayList<Animal>(readDb.readAnimal(customer));
	
	return animalInfoList;
    }
    
    //Send Customer to the CreateDb
    public void insert(Customer customer) 
    {
	createDb.insert(customer);
    }
    
    //Send Animal to the CreateDb
    public void insert(Animal animal) 
    {
	createDb.insert(animal);
    }
    
    //Send Treatment to the CreateDb
    public void insert(Treatment treatment) 
    {
	createDb.insert(treatment);
    }
    
    public void insert(Booking booking)
    {
	createDb.insert(booking);
    }
    
    //Send animalSpecies to the ReadDb
    public int readSpecies(String animal) 
    {
	return readDb.readSpecies(animal);
    }
    
    public int readSpecies(String animal, String customerId) 
    {
	return readDb.readSpecies(animal, customerId);
    }
    
    //Reads in the ReadDb and send to the OverviewApp
    public List<Customer> readCustomer() 
    {
	List<Customer> customerList = new ArrayList<Customer>(readDb.readCustomer());
	return customerList;
    }
    
    //Take the variable phone and send to ReadDb
    public Customer readCustomer(String phone) 
    {
	return readDb.readCustomer(phone);
    }
    
    //Read from ReadDb and Return to OverviewApp
    public List<Treatment> readTreatment() 
    {
	List<Treatment> treatmentList = new ArrayList<Treatment>(readDb.readTreatment());
	return treatmentList;
    }
    
    public List<String> readTime()
    {
	List<String> timeList = new ArrayList<String>(readDb.readTime());
	
	return timeList;
    }
    
    public List<Booking> readBooking()
    {
	List<Booking> bookingList = new ArrayList<Booking>(readDb.readBooking());
	
	return bookingList;
    }
    
    //
    public Treatment readTreatment(String treatmentName) 
    {
	return readDb.readTreatment(treatmentName);
    }

    public void updateCustomer(String nameColumn, String addressColumn, String phoneColumn, String mailColumn, String customerId)
    {
	updateDb.updateCustomer(nameColumn, addressColumn, phoneColumn, mailColumn, customerId);
    }

    public void updateTreatment(String treatmentColumn, String priceColumn, String durationColumn, String commentColumn, String customerId)
    {
	updateDb.updateTreatment(treatmentColumn, priceColumn, durationColumn, commentColumn, customerId);
    }

    public void deleteCustomer(String phone)
    {
	deleteDb.deleteCustomer(phone);
    }

    public void deleteTreatment(String treatmentName)
    {
	deleteDb.deleteTreatment(treatmentName);
    }

    public String getPassword(String username)
    {
	return readDb.getPassword(username);
    }
}