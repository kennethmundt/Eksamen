package presentation;

import java.sql.SQLException;

import application.Animal;
import application.CreateCustomerApp;
import dataAccess.CreateCustomerDb;

public class mainTest 
{
	public static void main(String[] args) throws SQLException
	{
		CreateCustomerApp kms = new CreateCustomerApp();
//		Animal an = new Animal("Fido2", "2004-11-21", "hund");
//		kms.insertAnimal(an);
		//ReadCustomerDb kmg = new ReadCustomerDb();
		//Customer c = new Customer("Niels Dahl", "Arresøgade 1", "22345678", "hej@kkdsop.ft");
		kms.createCustomer(c);
		kms.setKunde("Hans Jensen", "Jagtvej 44", "87654321", "wd@wrf.fk");
//		kms.insertAnimal("Fido2", "2004-11-21", "hund",3);
		//String test = kmg.getSidsteKunde(4);
		//System.out.print(test);
		/*ReadCustomerDb rd = new ReadCustomerDb();
		ArrayList<Customer> ca = new ArrayList<Customer>();
		ca = rd.readCustomer();
		System.out.println(ca);*/
	}
}
