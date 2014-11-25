package application;

import javax.swing.table.DefaultTableModel;

public class Controller
{
    UpdateApp updateApp = new UpdateApp();
    OverviewApp customerOverviewApp = new OverviewApp();
    CreateApp createCustomer = new CreateApp();
    AnimalDropDownApp readAnimal = new AnimalDropDownApp();

    /**
     * Passing data from presentation to controller.
     * 
     * @param nameColumn
     * @param addressColumn
     * @param phoneColumn
     * @param mailColumn
     * @param customerId
     */

    // Reads values from CustomerViewGui and send it to UpdateApp class
    public void saveChanges(String nameColumn, String addressColumn,
	    String phoneColumn, String mailColumn, String customerId)
    {
	updateApp.saveChanges(nameColumn, addressColumn, phoneColumn,
		mailColumn, customerId);

    }

    // Reads values from CustomerViewGui and send it to UpdateApp class
    public void deleteCustomer(String phone)
    {
	updateApp.deleteCustomer(phone);
    }

    // Reads values from CustomerOverViewApp class and send values to the
    // CustomerViewGui JTable
    public DefaultTableModel getTableModel()
    {
	DefaultTableModel data = customerOverviewApp.getTableModel();

	return data;
    }

    public Customer readCustomer(String phone)
    {

	return customerOverviewApp.readCustomer(phone);
    }

    // Get values from CreateCustomerGui and send to the CreateCustomerApp
    public void create(String name, String address, String phone, String mail)
    {
	createCustomer.create(name, address, phone, mail);

    }

    // Get Animal from CreateCustomerGui and send to CustomerOverviewApp
    public void create(String animalName, String animalBirth, int id)
    {
	createCustomer.create(animalName, animalBirth, id);

    }

    // Get animal from AnimalDropDown and send to CreateCustomerGui
    public int readAnimal(String animal)
    {
	return createCustomer.readAnimal(animal);

    }

    // Get animal from AnimalDropDown and send to CreateCustomerGui
    public Object[] getAnimal()
    {
	return readAnimal.readAnimal();

    }

}
