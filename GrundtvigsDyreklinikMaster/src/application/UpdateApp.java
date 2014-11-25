/**
 * @author Kenneth, Jogvan, Elvis
 */
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
    
    /**
     * Passing data from presentation to dataAccess
     * @param treatmentColumn
     * @param priceColumn
     * @param durationColumn
     * @param commentColumn
     * @param customerId
     */
    
    public void saveChangesTreatment(String treatmentColumn, String priceColumn, String durationColumn, String commentColumn, String customerId)
	{
		update.updateTreatment(treatmentColumn, priceColumn, durationColumn, commentColumn, customerId);
	}
    
    /**
     * Passing data from presentation to dataAccess
     * @param phone
     */
    public void deleteCustomer(String phone)
    {
	update.deleteCustomer(phone);
    }
    
    /**
     * Passing data from presentation to dataAccess
     * @param treatmentName
     */
    public void deleteTreatment(String treatmentName)
	{
		update.deleteTreatment(treatmentName);
	}

}