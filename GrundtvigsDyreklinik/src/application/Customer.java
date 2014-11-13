package application;

public class Customer
{
    private String name;
    private String address;   
    private String phone;
    private String mail;
    
    public Customer(String name, String address, String phone, String mail)
    {
	this.name = name;
	this.address = address;
	this.phone = phone;
	this.mail = mail;
    }
    
    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getMail()
    {
        return mail;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    @Override
    public String toString()
    {
	return "Customer [name=" + name + ", address=" + address + ", mail="
		+ mail + ", phone=" + phone + "]";
    }
}
