import java.awt.PageAttributes;
import java.io.File;
import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

import org.jasypt.exceptions.PasswordAlreadyCleanedException;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

public class Encrypt
{

    public static void main(String[] args)
    {
//	String myMessage = "midz";
//	String checkMessage = "midz";
//
//	StandardStringDigester digester = new StandardStringDigester();
//	digester.setAlgorithm("SHA-256");   // optionally set the algorithm
//	digester.setIterations(50000);  // increase security by performing 50000 hashing iterations
//	String digest = digester.digest(myMessage);
//	String digest2 = digester.digest(checkMessage);
//	
//	if (digester.matches(digest, digest2))
//	{
//	    System.out.println("Du har en midz");
//	}
//	else 
//	{
//	    System.out.println("pis os");
//	}
//	
	
	
	
	
	
//	Scanner scanner = new Scanner(new File("TextFiles/password.txt"));
//	
//	String encryptedPassword = scanner.next();
//	String inputPassword = "rigfriogflot1";
	
//	StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
//	String encryptedPassword = passwordEncryptor.encryptPassword(userPassword);
//	
//	if (passwordEncryptor.checkPassword(inputPassword, encryptedPassword)) 
//	{
//	  // correct!
//	    System.out.println(encryptedPassword);
//	    System.out.println("wihuuuuu");
//	} else {
//	  // bad login!
//	    System.out.println("DOH!");
//	}	
	
//	---------------------------------------------------------------------------------
	//To encrypt a password from userInput.
	
	//StrongPasswordEncryptor passwordEncryptor = new PasswordEncryptor();
	// String password = userInput
	// String encryptedPassword = passwordEncryptor.encryptPassword(password);
	//Insert encryptedPassword into database.
	
	
	// to "decrypt" you do this.
	
	//StrongPasswordEncryptor passwordEncryptor = new PasswordEncryptor();
	//String userInput = Det brugeren indtaster
	
	//passwordEncryptor.checkPassword(userInput, encryptedPassword) Denne returner true eller false.
	
//	--------------------------------------------------------------------------------------
	
//	String passwordT = "KennethErAwesome";
//	String encryptedPassword = passwordEncryptor.encryptPassword(passwordT);
//	
//	System.out.println(encryptedPassword);
	
    }

}
