package application;

import dataAccess.ReadDb;


public class DropDownApp
{
    ReadDb readDb = new ReadDb();
    
    public Object[] readAnimal()
    {
	Object[] animal = readDb.readAnimal().toArray();

	return animal;
    }

    public Object[] readAnimal(Customer customer)
    {
	Object[] animal = readDb.readAnimal(customer).toArray();

	return animal;
    }

    public Object[] readTreatment()
    {
	Object[] treatment = readDb.readTreatment().toArray();
	return treatment;
    }

    public Object[] readTime()
    {
	Object[] timeList = readDb.readTime().toArray();
	return timeList;
    }

}
