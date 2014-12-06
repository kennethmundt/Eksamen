package application;

import dataAccess.DeleteDb;

public class DeleteApp
{
    DeleteDb deleteDb = new DeleteDb();
    
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
