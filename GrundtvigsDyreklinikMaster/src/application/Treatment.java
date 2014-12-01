/**
 * @author Elvis og Jogvan
 */


package application;

public class Treatment
{
    private String id;
    String treatmentName;
    String price;
    String duration;
    String comment;
    
    public Treatment(String id, String treatmentName, String price, String duration, String comment)
    {
	this.id = id;
	this.treatmentName = treatmentName;
	this.price = price;
	this.duration = duration;
	this.comment = comment;
    }

    public Treatment(String treatmentName, String price, String duration, String comment)
    {
	this.treatmentName = treatmentName;
	this.price = price;
	this.duration = duration;
	this.comment = comment;
    }

    public String getId()
    {
	return id;
    }

    public String getTreatmentName()
    {
	return treatmentName;
    }

    public String getPrice()
    {
	return price;
    }

    public String getDuration()
    {
	return duration;
    }

    public String getComment()
    {
	return comment;
    }

    public void setId(String id)
    {
	this.id = id;
    }

    public void setTreatmentName(String treatmentName)
    {
	this.treatmentName = treatmentName;
    }

    public void setPrice(String price)
    {
	this.price = price;
    }

    public void setDuration(String duration)
    {
	this.duration = duration;
    }

    public void setComment(String comment)
    {
	this.comment = comment;
    }

    @Override
    public String toString()
    {
	return treatmentName + " " + duration + " min" + " " + price + " kr";
    }
}
