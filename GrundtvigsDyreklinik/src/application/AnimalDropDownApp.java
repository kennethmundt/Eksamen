package application;

import java.util.ArrayList;
import java.util.List;

import dataAccess.ReadDb;

public class AnimalDropDownApp
{
    ReadDb read = new ReadDb();

    public Object[] readAnimal()
    {
	List<String> speciesList = new ArrayList<String>(read.readAnimal());

	Object[] animal = speciesList.toArray();

	return animal;
    }
}
