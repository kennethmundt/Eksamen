package presentation;

/**
 * @author Tina og Elvis
 */

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

import application.AnimalDropDownApp;
import application.CreateCustomerApp;

public class CreateCustomerGui extends JFrame implements ActionListener, ValidateData
{
    ConfirmationDialogGui confirmationTime = new ConfirmationDialogGui();
    CreateCustomerApp createCustomer = new CreateCustomerApp();
    AnimalDropDownApp getAnimalList = new AnimalDropDownApp();

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
    private JLabel customerLbl;
    private int id;

    String name;
    String address;
    String phone;
    String mail;

    public CreateCustomerGui()
    {
	// Set up JFrame
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 656, 550);
	setResizable(false);
	setLocationRelativeTo(null);

	// Set up create customer panel
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

	// Set up add animal panel
	animalPanel = new JPanel();
	animalPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
	animalPanel.setBounds(394, 6, 250, 504);
	contentPaneCustomer.add(animalPanel);
	animalPanel.setLayout(null);

	JLabel animalLbl = new JLabel("Tilf�j dyr");
	animalLbl.setBounds(41, 16, 187, 22);
	animalPanel.add(animalLbl);

	animalCombo = new JComboBox(getAnimalList.readAnimal());
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

	JLabel ageLbl = new JLabel("Dyrs f�dselsdag:");
	ageLbl.setBounds(41, 188, 120, 22);
	animalPanel.add(ageLbl);

	ageTxt = new JTextField();
	ageTxt.setBounds(41, 212, 187, 28);
	animalPanel.add(ageTxt);

	addAnimalBtn = new JButton("Tilf�j dyr");
	addAnimalBtn.setBounds(111, 404, 117, 29);
	animalPanel.add(addAnimalBtn);
	addAnimalBtn.addActionListener(this);

	// Make the buttons and JTextfields non-editable
	addAnimalBtn.setEnabled(false);
	animalCombo.setEditable(false);
	animalCombo.setEnabled(false);
	animalNameTxt.setEditable(false);
	ageTxt.setEditable(false);

	// Add textArea to show animals
	animalArea = new JTextArea();
	animalArea.setBounds(41, 259, 178, 133);
	animalPanel.add(animalArea);
	animalArea.setEditable(false);

	// Ok button to close the JFrame
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

	    boolean isInputValidated = validateInput(mail, phone);
	    if (isInputValidated)
	    {
		createCustomer.create(name, address, phone, mail);

		// Dialog box is only showing in 2 sec.
		confirmationTime
			.confirmation(
				"Kunden er oprettet, tilf�j gerne en dyr. Dette vindue lukker ned om 2 sek.",
				"Velkommen");

		nameTxt.setText("");
		addressTxt.setText("");
		phoneTxt.setText("");
		mailTxt.setText("");

		// Make the button and JTextfields non-editable
		createCustomerBtn.setVisible(false);
		nameTxt.setEditable(false);
		addressTxt.setEditable(false);
		phoneTxt.setEditable(false);
		mailTxt.setEditable(false);
		customerLbl.setVisible(false);

		// Make the button and JTextfields editable
		addAnimalBtn.setEnabled(true);
		animalCombo.setEnabled(true);
		animalNameTxt.setEditable(true);
		ageTxt.setEditable(true);
		okBtn.setEnabled(true);
	    }
	    
	} else if (e.getSource() == addAnimalBtn)
	{
	    animalName = animalNameTxt.getText();
	    animalAge = ageTxt.getText();

	    animalArea.append(animal + " " + animalName + " " + animalAge
		    + "\n");

	    createCustomer.create(animalName, animalAge, id);

	    animalNameTxt.setText("");
	    ageTxt.setText("");

	} else if (e.getSource() == okBtn)
	{
	    dispose();
	} else
	{
	    JComboBox cb = (JComboBox) e.getSource();

	    if (e.getSource() == cb)
	    {
		animal = (String) cb.getSelectedItem();
		id = createCustomer.readAnimal(animal);
	    }
	}
    }

    @Override
    public boolean validateInput(String... var)
    {
	String phoneFormat = "\\d{8}"; // Regular expression that allows a
				       // sequence of 8 digits.
	String mailFormat = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; // Fancy
										  // regex									  // tutorialspoint.com
	if (!mail.matches(mailFormat))
	{
	    JOptionPane.showMessageDialog(null,
		    "Fejl i indtastning af email-adresse");
	    mailTxt.setText("");
	    mailTxt.requestFocus();
	    return false;
	}

	if (!phone.matches(phoneFormat))
	{
	    JOptionPane.showMessageDialog(null,
		    "Fejl i indtastning af telefonnr.");
	    phoneTxt.setText("");
	    phoneTxt.requestFocus();
	    return false;
	}
	return true;
    }
}
