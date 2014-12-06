/**
 * @author Kenneth, Jogvan, Elvis
 */

package application;

import dataAccess.UpdateDb;

public class UpdateApp
{
    UpdateDb updateDb = new UpdateDb();

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
	updateDb.updateCustomer(nameColumn, addressColumn, phoneColumn, mailColumn, customerId);
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
	updateDb.updateTreatment(treatmentColumn, priceColumn, durationColumn, commentColumn, customerId);
    }
}