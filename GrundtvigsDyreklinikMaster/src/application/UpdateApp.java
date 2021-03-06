/**
 * @author Kenneth, Jogvan, Tina, Elvis
 * Responsible for passing update parameters to the dataAccess layer
 */

package application;

import dataAccess.UpdateDb;

public class UpdateApp
{
    private UpdateDb updateDb = new UpdateDb();

    /**
     * Passing data from application Layer to dataAccess.
     * 
     * @param nameColumn
     * @param addressColumn
     * @param phoneColumn
     * @param mailColumn
     * @param customerId
     */
    public void saveChangesCustomer(String nameColumn, String addressColumn, String phoneColumn, String mailColumn, String customerId)
    {
	updateDb.updateCustomer(nameColumn, addressColumn, phoneColumn, mailColumn, customerId);
    }

    /**
     * Passing data from application to dataAccess
     * 
     * @param treatmentColumn
     * @param priceColumn
     * @param durationColumn
     * @param commentColumn
     * @param customerId
     */
    public void saveChangesTreatment(String treatmentColumn, String priceColumn, String durationColumn, String commentColumn, String customerId)
    {
	updateDb.updateTreatment(treatmentColumn, priceColumn, durationColumn, commentColumn, customerId);
    }
}