/**
 * @author Kenneth, Tina, Jogvan og Elvis
 * Passes delete parameters to the dataAccess layer
 */

package application;

import dataAccess.DeleteDb;

public class DeleteApp
{
    private DeleteDb deleteDb = new DeleteDb();
    
    /**
     * Passing data from presentation to dataAccess
     * @param phone
     */
    public void deleteCustomer(String phone)
    {
	deleteDb.deleteCustomer(phone);
    }

    /**
     * Passing data from presentation to dataAccess
     * @param treatmentName
     */
    public void deleteTreatment(String treatmentName)
    {
	deleteDb.deleteTreatment(treatmentName);
    }
}
