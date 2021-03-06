package application;

import dataAccess.UpdateDb;

public class UpdateApp
{
    UpdateDb update = new UpdateDb();
    
    /**
     * Passing data from presentation to dataAccess.
     * @param nameColumn
     * @param addressColumn
     * @param phoneColumn
     * @param mailColumn
     * @param customerId
     */
    public void saveChanges(String nameColumn, String addressColumn, String phoneColumn, String mailColumn, String customerId)
    {
	update.updateCustomer(nameColumn, addressColumn, phoneColumn, mailColumn, customerId);
    }
    
    public void deleteCustomer(String phone)
    {
	update.deleteCustomer(phone);
    }

}
