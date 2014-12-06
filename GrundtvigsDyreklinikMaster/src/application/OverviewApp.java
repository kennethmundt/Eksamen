/**
 * @author Kenneth, Jogvan, Elvis
 */
package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import dataAccess.ReadDb;

public class OverviewApp
{
    ReadDb readDb = new ReadDb();
    
    /**
     * @return Current tablemodel for customers
     */
    public DefaultTableModel getTableModel()
    {
	List<Customer> customerList = new ArrayList<Customer>(readDb.readCustomer());

	String[] columns = { "id", "Navn", "Adresse", "Telefon", "Mail" };
	DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

	for (int i = 0; i < customerList.size(); ++i)
	{
	    String id = customerList.get(i).getId();
	    String name = customerList.get(i).getName();
	    String address = customerList.get(i).getAddress();
	    String phone = customerList.get(i).getPhone();
	    String mail = customerList.get(i).getMail();

	    Object[] data = { id, name, address, phone, mail };

	    tableModel.addRow(data);
	}
	return tableModel;
    }

    public Customer readCustomer(String phone)
    {
	Customer customer = readDb.readCustomer(phone);
	
	return customer;
    }
    
    /**
     * @return Current tablemodel for treatments
     */
    public DefaultTableModel getTreatmentTableModel()
	{
		List<Treatment> treatmentList = new ArrayList<Treatment>(readDb.readTreatment());

		String[] columns = { "id", "Behandling", "Pris", "Varighed", "Kommentar" };
		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

		for (int i = 0; i < treatmentList.size(); ++i)
		{
			String id = treatmentList.get(i).getId();
			String treatment = treatmentList.get(i).getTreatmentName();
			String price = treatmentList.get(i).getPrice();
			String duration = treatmentList.get(i).getDuration();
			String comment = treatmentList.get(i).getComment();

			Object[] data = { id, treatment, price, duration, comment };

			tableModel.addRow(data);
		}
		return tableModel;
	}
    
    public Treatment readTreatment(String treatmentName)
    {
	Treatment treatment = readDb.readTreatment(treatmentName);

	return treatment;
    }

    public DefaultTableModel getBookingTableModel()
    {
	List<Booking> bookingList = new ArrayList<Booking>(readDb.readBooking());

	String[] columns = { "Navn", "Telefon", "Dato", "Dyrenavn", "Art", "Behandling" };
	DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

	for (int i = 0; i < bookingList.size(); ++i)
	{
	    String customerName = bookingList.get(i).getCustomerName();
	    String customerPhone = bookingList.get(i).getCustomerPhone();
	    String date = bookingList.get(i).getDateTime();
	    String animalName = bookingList.get(i).getAnimalName();
	    String species = bookingList.get(i).getSpecies();
	    String treatmentName = bookingList.get(i).getTreatmentName();

	    Object[] data = { customerName, customerPhone, date, animalName, species, treatmentName };

	    tableModel.addRow(data);
	}
	return tableModel;
    }
}