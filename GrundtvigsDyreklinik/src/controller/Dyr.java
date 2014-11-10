package controller;

public class Dyr
{
    private String art;
    private String navn;
    private String alder;
    
    public Dyr(String art, String navn, String alder)
    {
	this.art = art;
	this.navn = navn;
	this.alder = alder;
    }
    
    public String getArt()
    {
        return art;
    }
    
    public void setArt(String art)
    {
        this.art = art;
    }
    
    public String getNavn()
    {
        return navn;
    }
    
    public void setNavn(String navn)
    {
        this.navn = navn;
    }
    
    public String getAlder()
    {
        return alder;
    }
    
    public void setAlder(String alder)
    {
        this.alder = alder;
    }
    
    @Override
    public String toString()
    {
	return "Dyr [art=" + art + ", navn=" + navn + ", alder=" + alder + "]";
    }
}
