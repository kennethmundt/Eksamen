package application;

import java.util.ArrayList;

import dataAccess.ReadAnimalDb;

public class AnimalOverviewApp 
{
	ReadAnimalDb readAnimal = new ReadAnimalDb();
	
	public Object[] readAnimal()
	{
		ArrayList<AnimalArt> getAnimalList = new ArrayList<AnimalArt>(readAnimal.readAnimal());
		
		Object[] animal = getAnimalList.toArray();
		
		
		return animal;
		
		
		
	}
}
