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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.w3c.dom.CDATASection;

import application.AnimalDropDownApp;
import application.CreateCustomerApp;

public class CreateCustomerGui extends JFrame implements ActionListener
{

    ConfirmationDialogGui confirmationTime = new ConfirmationDialogGui();
    CreateCustomerApp createCustomer = new CreateCustomerApp();
    AnimalDropDownApp getAnimalList = new AnimalDropDownApp();

    private JPanel contentPaneCustomer;
    private JPanel customerPanel;
    private JTextField nameTxt;
    private JTextField addressTxt;
    private JTextField mailTxt;
    private JTextField phoneTxt;
    private JComboBox animalCombo;
    private JTextField animalNameTxt;
    private JTextField ageTxt;
    private JButton btnOpret;
    private JButton btnAddAnimal;
    private JPanel animalPanel;
    private JTextArea animalArea;
    private String animal;
    private String animalName;
    private String animalAge;
    private JButton btnOk;
    private JLabel customerLbl;
    private int id;

    /**
     * Create the frame.
     */
    public CreateCustomerGui()
    {
	// Frame settings
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 656, 550);
	setResizable(false);
	setLocationRelativeTo(null);
	contentPaneCustomer = new JPanel();
	contentPaneCustomer.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPaneCustomer.setLayout(null);
	setContentPane(contentPaneCustomer);
	

	// Add customer
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

	nameTxt = new JTextField();
	nameTxt.setBounds(82, 85, 263, 28);
	customerPanel.add(nameTxt);
	nameTxt.setColumns(10);

	JLabel addressLbl = new JLabel("Adresse :");
	addressLbl.setBounds(16, 154, 61, 16);
	customerPanel.add(addressLbl);

	addressTxt = new JTextField();
	addressTxt.setBounds(82, 148, 263, 28);
	customerPanel.add(addressTxt);
	addressTxt.setColumns(10);

	JLabel emailLbl = new JLabel("E-mail :");
	emailLbl.setBounds(16, 229, 61, 16);
	customerPanel.add(emailLbl);

	mailTxt = new JTextField();
	mailTxt.setBounds(82, 223, 263, 28);
	customerPanel.add(mailTxt);
	mailTxt.setColumns(10);

	JLabel phoneLbl = new JLabel("Telefon :");
	phoneLbl.setBounds(16, 303, 61, 16);
	customerPanel.add(phoneLbl);

	phoneTxt = new JTextField();
	phoneTxt.setBounds(82, 297, 263, 28);
	customerPanel.add(phoneTxt);
	phoneTxt.setColumns(10);

	btnOpret = new JButton("Opret");
	btnOpret.setBounds(227, 444, 117, 29);
	customerPanel.add(btnOpret);
	btnOpret.addActionListener(this);

	// Animal panel

	// Add animal
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
	animalCombo.addActionListener(this);
	animalPanel.add(animalCombo);

	JLabel animalNameLbl = new JLabel("Dyrenavn :");
	animalNameLbl.setBounds(44, 131, 104, 16);
	animalPanel.add(animalNameLbl);

	animalNameTxt = new JTextField();
	animalNameTxt.setBounds(41, 148, 187, 28);
	animalPanel.add(animalNameTxt);
	animalNameTxt.setColumns(10);

	JLabel ageLbl = new JLabel("Dyrs f�dselsdag:");
	ageLbl.setBounds(41, 188, 120, 22);
	animalPanel.add(ageLbl);

	ageTxt = new JTextField();
	ageTxt.setBounds(41, 212, 187, 28);
	animalPanel.add(ageTxt);
	ageTxt.setColumns(10);

	btnAddAnimal = new JButton("Tilf�j dyr");
	btnAddAnimal.setBounds(111, 404, 117, 29);
	btnAddAnimal.addActionListener(this);
	animalPanel.add(btnAddAnimal);

	// Make the panel grey, and no editable for the animal
	animalPanel.setBackground(new Color(0, 0, 0));
	Color colorA = new Color(200, 200, 200, 200);
	animalPanel.setOpaque(true);
	animalPanel.setBackground(colorA);

	// Make the button and JTextfields non-editable
	btnAddAnimal.setEnabled(false);
	animalCombo.setEditable(false);
	animalCombo.setEnabled(false);
	animalNameTxt.setEditable(false);

	// Add textArea to show animals
	animalArea = new JTextArea();
	animalArea.setBounds(41, 259, 178, 133);
	animalPanel.add(animalArea);
	animalArea.setEditable(false);

	// Ok button to close the JFrame
	btnOk = new JButton("OK");
	btnOk.setBounds(111, 452, 117, 29);
	animalPanel.add(btnOk);
	btnOk.setEnabled(false);
	btnOk.addActionListener(this);
	
	setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
	// On button Opret
	if (e.getSource() == btnOpret)
	{
	    String name = nameTxt.getText();
	    String address = addressTxt.getText();
	    String phone = phoneTxt.getText();
	    String mail = mailTxt.getText();

	    createCustomer.create(name, address, phone, mail);

	    // Dialog box is only showing in 2 sec.
	    confirmationTime
		    .Confirmation(
			    "Kunden er oprettet, tilf�j gerne en dyr. Dette vindue lukker ned om 2 sek.",
			    "Velkommen");

	    nameTxt.setText("");
	    addressTxt.setText("");
	    phoneTxt.setText("");
	    mailTxt.setText("");

	    // Make the panel grey, and no editable for the customer
	    customerPanel.setBackground(new Color(0, 0, 0, 64));
	    customerPanel.setOpaque(false);

	    // Make the button and JTextfields non-editable
	    btnOpret.setVisible(false);
	    nameTxt.setEditable(false);
	    addressTxt.setEditable(false);
	    phoneTxt.setEditable(false);
	    mailTxt.setEditable(false);
	    customerLbl.setVisible(false);

	    // Make the button and JTextfields editable
	    btnAddAnimal.setEnabled(true);
	    animalCombo.setEditable(true);
	    animalCombo.setEnabled(true);
	    animalNameTxt.setEditable(true);
	    ageTxt.setEditable(true);
	    btnOk.setEnabled(true);

	    // Make the panel grey, and editable for the animal

	    animalPanel.setBackground(new Color(238, 238, 238));

	}
	// On button add animal
	else if (e.getSource() == btnAddAnimal)
	{
	    animalName = animalNameTxt.getText();
	    animalAge = ageTxt.getText();

	    animalArea.append(animal + " " + animalName + " " + animalAge
		    + "\n");

	    createCustomer.create(animalName, animalAge, id);

	    animalNameTxt.setText("");
	    ageTxt.setText("");

	}
	// On button Ok
	else if (e.getSource() == btnOk)
	{
	    dispose();

	}
	// The JComboBox selection
	else
	{
	    JComboBox cb = (JComboBox) e.getSource();

	    if (e.getSource() == cb)
	    {
		animal = (String) cb.getSelectedItem();
		id = createCustomer.readAnimal(animal);
	    }
	}
    }
}
