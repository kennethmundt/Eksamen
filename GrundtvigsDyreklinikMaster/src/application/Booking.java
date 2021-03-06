/**
 * @author kenneth, Tina, Elvis og Jogvan
 * "Blueprint" of how to create a booking.
 */

package application;

public class Booking
{
    private String dateTime;
    private int animalId;
    private int treatmentId;
    private String customerName;
    private String customerPhone;
    private String animalName;
    private String species;
    private String treatmentName;
    private int customerId;

    public Booking(String dateTime, int animalId, int treatmentId, int customerId)
    {
	this.dateTime = dateTime;
	this.animalId = animalId;
	this.treatmentId = treatmentId;
	this.customerId = customerId;
    }

    public Booking(String customerName, String customerPhone, String animalName, String species, String dateTime, String treatmentName) 
    {
	this.customerName = customerName;
	this.customerPhone = customerPhone;
	this.animalName = animalName;
	this.species = species;
	this.dateTime = dateTime;
	this.treatmentName = treatmentName;
    }

    public String getCustomerName() 
    {
	return customerName;
    }

    public void setCustomerName(String customerName) 
    {
	this.customerName = customerName;
    }

    public String getCustomerPhone() 
    {
	return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) 
    {
	this.customerPhone = customerPhone;
    }

    public String getAnimalName()
    {
	return animalName;
    }

    public void setAnimalName(String animalName) 
    {
	this.animalName = animalName;
    }

    public String getSpecies() 
    {
	return species;
    }

    public void setSpecies(String species) 
    {
	this.species = species;
    }
    
    public void setCustomerId(int customerId)
    {
	this.customerId = customerId;
    }
    
    public int getCustomerId()
    {
	return customerId;
    }

    public String getTreatmentName()
    {
	return treatmentName;
    }

    public void setTreatmentName(String treatmentName)
    {
	this.treatmentName = treatmentName;
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