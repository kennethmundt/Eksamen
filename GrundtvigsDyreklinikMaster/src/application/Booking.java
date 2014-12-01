package application;

public class Booking
{
    private String dateTime;
    private int animalId;
    private int treatmentId;
    
    public Booking(String dateTime, int animalId, int treatmentId)
    {
	this.dateTime = dateTime;
	this.animalId = animalId;
	this.treatmentId = treatmentId;
    }

    public String getDateTime()
    {
        return dateTime;
    }

    public int getAnimalId()
    {
        return animalId;
    }

    public int getTreatmentId()
    {
        return treatmentId;
    }

    public void setDateTime(String dateTime)
    {
        this.dateTime = dateTime;
    }

    public void setAnimalId(int animalId)
    {
        this.animalId = animalId;
    }

    public void setTreatmentId(int treatmentId)
    {
        this.treatmentId = treatmentId;
    }

    @Override
    public String toString()
    {
	return "Booking [dataTime=" + dateTime + ", animalId=" + animalId + ", treatmentId=" + treatmentId + "]";
    }
}