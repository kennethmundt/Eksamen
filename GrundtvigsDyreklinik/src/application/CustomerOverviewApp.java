package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dataAccess.ReadCustomerDb;

public class CustomerOverviewApp
{
    ReadCustomerDb read = new ReadCustomerDb();
    DefaultTableModel tableModel;
    List<Customer> customerList;

    public DefaultTableModel getTableModel()
    {
	customerList = new ArrayList<Customer>(read.readCustomer());
	
	String[] columns = {"id", "Navn", "Adresse", "Telefon", "Mail"};
	tableModel = new DefaultTableModel(columns, 0);
	
	for (int i = 0; i < customerList.size(); ++i)
	{
	    String id = customerList.get(i).getId();
	    String name = customerList.get(i).getName();
	    String address = customerList.get(i).getAddress();
	    String phone = customerList.get(i).getPhone();
	    String mail = customerList.get(i).getMail();
	    
	    Object[] data = {id, name, address, phone, mail};
	    
	    tableModel.addRow(data);
	}		
	return tableModel;
    }

    public void saveChanges(Object id, Object data, int row, int column)
    {
	String idNum = (String) id;
	String newData = (String) data;
	
	read.updateCustomerDb(idNum, newData, row, column);
    }

}