package application;

public class AnimalArt 
{
	private int idAnimalArt;
	private String animalArtName;
	
	
	public AnimalArt(int idAnimalArt, String animalName)
	{
		this.idAnimalArt = idAnimalArt;
		this.animalArtName = animalName;
	}
	public int getIdAnimalArt() {
		return idAnimalArt;
	}


	public void setIdAnimalArt(int idAnimalArt) {
		this.idAnimalArt = idAnimalArt;
	}


	public String getAnimalArtName() {
		return animalArtName;
	}


	public void setAnimalArtName(String animalArtName) {
		this.animalArtName = animalArtName;
	}
	@Override
	public String toString()
	{
		return animalArtName;
	}
	
	
}
