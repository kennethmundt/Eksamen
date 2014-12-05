/**
 * @author Tina og Kenneth
 */

package presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import application.ControllerApp;
import application.InputValidater;

public class CreateCustomerGui extends JFrame implements ActionListener
{
    private ConfirmationDialogGui confirmationTime = new ConfirmationDialogGui();
    private ControllerApp controller = new ControllerApp();
    private InputValidater validater = new InputValidater();
    
    private JPanel customerPanel;
    private JPanel animalPanel;
    private JTextField nameTxt;
    private JTextField addressTxt;
    private JTextField mailTxt;
    private JTextField phoneTxt;
    private JTextField animalNameTxt;
    private JTextField ageTxt;
    private JComboBox animalCombo;
    private JButton createCustomerBtn;
    private JButton addAnimalBtn;
    private JButton okBtn;
    private JTextArea animalArea;
    private String animal;
    private String animalName;
    private String animalAge;
    private String name;
    private String address;
    private String phone;
    private String mail;
    private JLabel customerLbl;
    private int id;

    public CreateCustomerGui()
    {
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 656, 550);
	setResizable(false);
	setLocationRelativeTo(null);

	JPanel contentPaneCustomer = new JPanel();
	contentPaneCustomer.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPaneCustomer.setLayout(null);
	setContentPane(contentPaneCustomer);

	customerPanel = new JPanel();
	customerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
	customerPanel.setBounds(6, 6, 375, 504);
	contentPaneCustomer.add(customerPanel);
	customerPanel.setLayout(null);

	customerLbl = new JLabel("Opret kunde");
	customerLbl.setBounds(16, 17, 231, 25);
	customerPanel.add(customerLbl);

	JLabel nameLbl = new JLabel("Navn :");
	nameLbl.setBounds(16, 91, 61, 16);
	customerPanel.add(nameLbl);

	nameTxt = new JTextField(50);
	nameTxt.setBounds(82, 85, 263, 28);
	customerPanel.add(nameTxt);

	JLabel addressLbl = new JLabel("Adresse :");
	addressLbl.setBounds(16, 154, 61, 16);
	customerPanel.add(addressLbl);

	addressTxt = new JTextField();
	addressTxt.setBounds(82, 148, 263, 28);
	customerPanel.add(addressTxt);

	JLabel emailLbl = new JLabel("E-mail :");
	emailLbl.setBounds(16, 229, 61, 16);
	customerPanel.add(emailLbl);

	mailTxt = new JTextField();
	mailTxt.setBounds(82, 223, 263, 28);
	customerPanel.add(mailTxt);

	JLabel phoneLbl = new JLabel("Telefon :");
	phoneLbl.setBounds(16, 303, 61, 16);
	customerPanel.add(phoneLbl);

	phoneTxt = new JTextField();
	phoneTxt.setBounds(82, 297, 263, 28);
	customerPanel.add(phoneTxt);

	createCustomerBtn = new JButton("Opret");
	createCustomerBtn.setBounds(227, 444, 117, 29);
	customerPanel.add(createCustomerBtn);
	createCustomerBtn.addActionListener(this);

	animalPanel = new JPanel();
	animalPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
	animalPanel.setBounds(394, 6, 250, 504);
	contentPaneCustomer.add(animalPanel);
	animalPanel.setLayout(null);

	JLabel animalLbl = new JLabel("Tilføj dyr");
	animalLbl.setBounds(41, 16, 187, 22);
	animalPanel.add(animalLbl);

	animalCombo = new JComboBox(controller.getAnimal());
	animalCombo.setSelectedIndex(-1);
	animalCombo.setBounds(41, 82, 187, 22);
	animalPanel.add(animalCombo);
	animalCombo.addActionListener(this);

	JLabel animalNameLbl = new JLabel("Dyrenavn :");
	animalNameLbl.setBounds(44, 131, 104, 16);
	animalPanel.add(animalNameLbl);

	animalNameTxt = new JTextField();
	animalNameTxt.setBounds(41, 148, 187, 28);
	animalPanel.add(animalNameTxt);

	JLabel ageLbl = new JLabel("Dyrs fødselsdag:");
	ageLbl.setBounds(41, 188, 120, 22);
	animalPanel.add(ageLbl);

	ageTxt = new JTextField();
	ageTxt.setBounds(41, 212, 187, 28);
	animalPanel.add(ageTxt);

	addAnimalBtn = new JButton("Tilføj dyr");
	addAnimalBtn.setBounds(111, 404, 117, 29);
	animalPanel.add(addAnimalBtn);
	addAnimalBtn.addActionListener(this);

	addAnimalBtn.setEnabled(false);
	animalCombo.setEditable(false);
	animalCombo.setEnabled(false);
	animalNameTxt.setEditable(false);
	ageTxt.setEditable(false);

	animalArea = new JTextArea();
	animalArea.setBounds(41, 259, 178, 133);
	animalPanel.add(animalArea);
	animalArea.setEditable(false);

	okBtn = new JButton("OK");
	okBtn.setBounds(111, 452, 117, 29);
	animalPanel.add(okBtn);
	okBtn.setEnabled(false);
	okBtn.addActionListener(this);

	setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
	if (e.getSource() == createCustomerBtn)
	{
	    name = nameTxt.getText();
	    address = addressTxt.getText();
	    phone = phoneTxt.getText();
	    mail = mailTxt.getText();
	    
	    boolean nameNotValidated = validater.checkForEmptyString(name);
	    if (nameNotValidated)
	    {
		JOptionPane.showMessageDialog(null, "Navnefeltet må ikke være tomt");
		nameTxt.requestFocus();
		return;
	    }
	    
	    boolean addressNotValidated = validater.checkForEmptyString(address);
	    if (addressNotValidated)
	    {
		JOptionPane.showMessageDialog(null, "Addressefeltet må ikke være tomt");
		addressTxt.requestFocus();
		return;
	    }
	    
	    boolean mailNotValidated = validater.validateMail(mail);
	    if (mailNotValidated)
	    {
		JOptionPane.showMessageDialog(null, "Fejl i indtastning af email-adresse");
		mailTxt.setText("");
		mailTxt.requestFocus();
		return;
	    }
	    
	    boolean phoneNotValidated = validater.validatePhone(phone);
	    if (phoneNotValidated)
	    {
		JOptionPane.showMessageDialog(null, "Fejl i indtastning af telefonnr.");
		phoneTxt.setText("");
		phoneTxt.requestFocus();
		return;
	    }
	   
	    controller.create(name, address, phone, mail);

	    confirmationTime.confirmation("Kunden er oprettet, tilføj gerne en dyr. Dette vindue lukker ned om 2 sek.", "Velkommen");

	    nameTxt.setText("");
	    addressTxt.setText("");
	    phoneTxt.setText("");
	    mailTxt.setText("");

	    switchToAnimalPnl();

	} 
	else if (e.getSource() == addAnimalBtn)
	{
	    animalName = animalNameTxt.getText();
	    animalAge = ageTxt.getText();
	    
	    boolean isAnimalComboEmpty = validater.isComboBoxEmpty(animalCombo.getSelectedItem());
	    if (isAnimalComboEmpty)
	    {
		JOptionPane.showMessageDialog(null, "Du skal vælge et dyr.");
		return;
	    }
	    
	    boolean animalNameNotValidated = validater.checkForEmptyString(animalName);
	    if (animalNameNotValidated)
	    {
		JOptionPane.showMessageDialog(null, "NavneFeltet må ikke være tomt");
		animalNameTxt.requestFocus();
		return;
	    }

//	    boolean animalAgeNotValidated = validater.validateAge(animalAge);
//	    if (animalAgeNotValidated)
//	    {
//		//do something
//		//return;
//	    }

	    animalArea.append(animal + " " + animalName + " " + animalAge + "\n");

	    controller.create(animalName, animalAge, id);

	    animalNameTxt.setText("");
	    ageTxt.setText("");
	} 
	else if (e.getSource() == okBtn)
	{
	    dispose();
	} 
	else if (e.getSource() == animalCombo)
	{
	    animal = (String) animalCombo.getSelectedItem();
	    id = controller.readAnimal(animal);
	}
    }

    public void switchToAnimalPnl()
    {
	createCustomerBtn.setVisible(false);
	nameTxt.setEditable(false);
	addressTxt.setEditable(false);
	phoneTxt.setEditable(false);
	mailTxt.setEditable(false);
	customerLbl.setVisible(false);

	addAnimalBtn.setEnabled(true);
	animalCombo.setEnabled(true);
	animalNameTxt.setEditable(true);
	ageTxt.setEditable(true);
	okBtn.setEnabled(true);
    }
}
