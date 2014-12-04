package application;

import dataAccess.ControllerDb;

public class DropDownApp
{
ControllerDb controllerDb = new ControllerDb();
    
    public Object[] readAnimal()
    {
	Object[] animal = controllerDb.readAnimal().toArray();

	return animal;
    }

    public Object[] readAnimal(Customer customer)
    {
	Object[] animal = controllerDb.readAnimal(customer).toArray();

	return animal;
    }

    public Object[] readTreatment()
    {
	Object[] treatment = controllerDb.readTreatment().toArray();
	return treatment;
    }

    public Object[] readTime()
    {
	Object[] time = controllerDb.readTime().toArray();
	return time;
    }

}
