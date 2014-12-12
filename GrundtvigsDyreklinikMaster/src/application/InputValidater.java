/**
 * @author Kenneth, Tina, Jogvan og Elvis
 * Validates input from Gui classes.
 */

package application;

import java.util.Date;

import javax.swing.JOptionPane;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class InputValidater
{
    /**
     * @param treatmentId
     * @param animalId
     * @param date
     * @param time
     * @return true if treatmentId, date and time == null, and animalId == 0.
     */
    public boolean validateBooking(String treatmentId, int animalId, Date date, String time)
    {
	if (treatmentId == null || animalId == 0 || date == null || time == null)
	{
	    return true;
	}
	return false;
    }
    
    /**
     * @param param
     * @return true if parameter is empty.
     */
    public boolean checkForEmptyString(String param)
    {
	if (param.isEmpty())
	{
	    return true;
	}
	return false;
    }

    /**
     * 
     * @param mail
     * @return true if parameter doesn't match mailformat. Must match (yourmail@something.something).
     */
    public boolean validateMail(String mail)
    {
	String mailFormat = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; // Fancy regex from tutorialspoint.com

	if (!mail.matches(mailFormat))
	{
	    return true;
	}
	return false;
    }

    /**
     * @param phone
     * @return true if parameter doesn't match phone format. Must contain 8 digits.
     */
    public boolean validatePhone(String phone)
    {
	String phoneFormat = "\\d{8}"; // Regular expression that allows a sequence of 8 digits.

	if (!phone.matches(phoneFormat))
	{
	    return true;
	}
	return false;
    }
    
    /**
     * 
     * @param selectedItem
     * @return true if comboBox is empty.
     */
    public boolean isComboBoxEmpty(Object selectedItem)
    {
	if (selectedItem == null)
	{
	    return true;
	}
	return false;
    }

    /**
     * 
     * @param isDigit
     * @return true if parameter doesn't match digitFormat. Parameter must be a number.
     */
    public boolean validatedigits(String isDigit)
    {
	String digitFormat = "\\d+";
	
	if (!isDigit.matches(digitFormat))
	{
	    return true;
	}
	return false;
    }

    /**
     * 
     * @param input
     * @return true if param is more than 250 characters.
     */
    public boolean validateInputLength(String input)
    {
	int maxInputLength = 250;
	int inputLength = input.length();
	
	if (inputLength > maxInputLength)
	{
	    return true;
	}
	return false;
    }

    /**
     * 
     * @param passwordInput
     * @param hashedPassword
     * @return true if parameters don't match.
     */
    public boolean validateLogin(String passwordInput, String hashedPassword)
    {
	StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

	if (hashedPassword.length() == 0) // if username is not in database
	{
	    return true;
	}
	else 
	{
	    if (passwordEncryptor.checkPassword(passwordInput, hashedPassword))
	    {
		return false;
	    }
	    return true;
	}
    }
}
