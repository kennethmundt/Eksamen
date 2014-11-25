/**
 * @author Kenneth, Jogvan, Elvis
 */
package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import dataAccess.CreateDb;
import dataAccess.ReadDb;
import dataAccess.UpdateDb;

public class OverviewApp
{
    ReadDb read = new ReadDb();
    
    /**
     * @return Current tablemodel for customers
     */
    public DefaultTableModel getTableModel()
    {
	List<Customer> customerList = new ArrayList<Customer>(read.readCustomer());

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
	Customer customer = read.readCustomer(phone);
	
	return customer;
    }
    
    /**
     * @return Current tablemodel for treatments
     */
    public DefaultTableModel getTreatmentTableModel()
	{
		List<Treatment> treatmentList = new ArrayList<Treatment>(read.readTreatment());

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
		Treatment treatment = read.readTreatment(treatmentName);

		return treatment;
	}
}