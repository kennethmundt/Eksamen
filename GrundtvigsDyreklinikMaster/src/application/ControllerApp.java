package application;

import javax.swing.table.DefaultTableModel;

public class ControllerApp
{
    UpdateApp updateApp = new UpdateApp();
    DeleteApp deleteApp = new DeleteApp();
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
	deleteApp.deleteCustomer(phone);
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
 // Reads values from CustomerOverViewApp class and send values to the
    // TreatmentViewGui JTable
    public DefaultTableModel getTreatmentTableModel()
    {
	DefaultTableModel data = customerOverviewApp.getTreatmentTableModel();

	return data;
    }
    //Get variabel treatmentName, price, duration and comment from the CreateTreatmentGui
    public void createTreatment(String treatmentName, String price, String duration, String comment)
	{
		createCustomer.createTreatment(treatmentName, price, duration, comment);
		
	}
    //If JTable in TreatmentViewGui is change then save changes
    public void saveChangesTreatment(String treatmentColumn, String priceColumn, String durationColumn, String commentColumn, String customerId)
	{
		updateApp.saveChangesTreatment(treatmentColumn, priceColumn, durationColumn, commentColumn, customerId);
	}
    //Take the variable from JTable and send to OverviewApp
    public Treatment readTreatment(String treatmentName)
	{
		return customerOverviewApp.readTreatment(treatmentName);
	}
    //Delete treatment from JTable
    public void deleteTreatment(String treatmentName)
	{
		deleteApp.deleteTreatment(treatmentName);
	}

}
