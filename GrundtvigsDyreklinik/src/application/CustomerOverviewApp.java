package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import dataAccess.CreateCustomerDb;
import dataAccess.ReadCustomerDb;
import dataAccess.UpdateDb;

public class CustomerOverviewApp
{
    ReadCustomerDb read = new ReadCustomerDb();
    UpdateDb update = new UpdateDb();
    
    /**
     * @return Current tablemodel
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

    /**
     * Passing data from presentation to dataAccess via a call to updateCustomerDb()
     * @param nameColumn
     * @param addressColumn
     * @param phoneColumn
     * @param mailColumn
     * @param customerId
     */
    public void saveChanges(String nameColumn, String addressColumn, String phoneColumn, String mailColumn, String customerId)
    {
	update.updateCustomerDb(nameColumn, addressColumn, phoneColumn, mailColumn, customerId);
    }

    public Customer readCustomer(String phone)
    {
	Customer customer = read.readCustomer(phone);
	
	return customer;
    }
}