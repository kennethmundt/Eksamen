package presentation;

import java.sql.SQLException;

import application.CreateCustomerApp;
import application.Customer;
import dataAccess.CreateCustomerDb;

public class Main
{
    	public static void main(String[] args) throws SQLException
    	{
    		CreateCustomerApp kms = new CreateCustomerApp();
//    		Animal an = new Animal("Elvis", "2004-11-21", "kat");
//    		kms.insertAnimal(an);
    		//ReadCustomerDb kmg = new ReadCustomerDb();
//    		Customer c = new Customer("Niels Dahl", "Arres�gade 1", "22345678", "hej@kkdsop.ft");
    		kms.createCustomer("John madsen", "Arres�gade 1", "22345678", "hej@kkdsop.ft");
//    		kms.setKunde("Hans Jensen", "Jagtvej 44", "87654321", "wd@wrf.fk");
//    		kms.insertAnimal("Fido2", "2004-11-21", "hund",3);
    		//String test = kmg.getSidsteKunde(4);
    		//System.out.print(test);
    		/*ReadCustomerDb rd = new ReadCustomerDb();
    		ArrayList<Customer> ca = new ArrayList<Customer>();
    		ca = rd.readCustomer();
    		System.out.println(ca);*/
    		CreateCustomerDb midz = new CreateCustomerDb();
    		
//    		midz.insertAnimal(an);
    	}
}