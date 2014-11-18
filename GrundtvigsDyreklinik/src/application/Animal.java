/**
 * @author Kenneth
 * Contains all info needed to create an animal
 */

package application;

public class Animal
{
    private int speciesId;
    private String animalName;
    private String animalBirth;

    public Animal(int speciesId, String animalName, String animalBirth)
    {
	this.speciesId = speciesId;
	this.animalName = animalName;
	this.animalBirth = animalBirth;
    }

    public int getSpeciesId()
    {
	return speciesId;
    }

    public String getAnimalName()
    {
	return animalName;
    }

    public String getAnimalBirth()
    {
	return animalBirth;
    }

    public void setSpeciesId(int speciesId)
    {
	this.speciesId = speciesId;
    }

    public void setAnimalName(String animalName)
    {
	this.animalName = animalName;
    }

    public void setAnimalBirth(String animalBirth)
    {
	this.animalBirth = animalBirth;
    }

    @Override
    public String toString()
    {
	return "Animal [speciesId=" + speciesId + ", animalName=" + animalName
		+ ", animalBirth=" + animalBirth + "]";
    }
}