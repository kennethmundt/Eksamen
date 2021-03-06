/**
 * @author Tina og Elvis
 */

package presentation;

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

import application.AnimalArt;
import application.AnimalOverviewApp;
import application.CreateCustomerApp;

public class CreateCustomerGui extends JFrame implements ActionListener{

	ConfirmationDialogGui confirmationTime = new ConfirmationDialogGui();
	CreateCustomerApp createCustomer = new CreateCustomerApp();
	
	AnimalOverviewApp getAnimalList = new AnimalOverviewApp();
	
	
	private JPanel contentPaneCustomer;
	private JPanel customer_panel;
	private JTextField nameTxt;
	private JTextField addressTxt;
	private JTextField mailTxt;
	private JTextField phoneTxt;
	private JComboBox animalCombo;
	private JTextField animalNameTxt;
	private JTextField ageTxt;
	private JButton btnOpret;
	private JButton btnAddAnimal;
	private JPanel animal_panel;
	private JTextArea animalArea;
	private int animalId;
	private String animalArt;
	private String animalName;
	private String animalAge;
	private JButton btnOk;
		
	
	/**
	 * Create the frame.
	 */
	public CreateCustomerGui() {
				//Frame settings
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 650, 600);
				contentPaneCustomer = new JPanel();
				contentPaneCustomer.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPaneCustomer);
				contentPaneCustomer.setLayout(null);
				
				//Add customer
				customer_panel = new JPanel();
				customer_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				customer_panel.setBounds(6, 6, 375, 504);
				contentPaneCustomer.add(customer_panel);
				customer_panel.setLayout(null);
				
				JLabel customerLbl = new JLabel("Opret dig som kunde her");
				customerLbl.setBounds(16, 17, 231, 25);
				customer_panel.add(customerLbl);
				
				JLabel nameLbl = new JLabel("Navn :");
				nameLbl.setBounds(16, 91, 61, 16);
				customer_panel.add(nameLbl);
				
				nameTxt = new JTextField();
				nameTxt.setBounds(82, 85, 263, 28);
				customer_panel.add(nameTxt);
				nameTxt.setColumns(10);
				
				JLabel addressLbl = new JLabel("Adresse :");
				addressLbl.setBounds(16, 154, 61, 16);
				customer_panel.add(addressLbl);
				
				addressTxt = new JTextField();
				addressTxt.setBounds(82, 148, 263, 28);
				customer_panel.add(addressTxt);
				addressTxt.setColumns(10);
				
				JLabel emailLbl = new JLabel("E-mail :");
				emailLbl.setBounds(16, 229, 61, 16);
				customer_panel.add(emailLbl);
				
				mailTxt = new JTextField();
				mailTxt.setBounds(82, 223, 263, 28);
				customer_panel.add(mailTxt);
				mailTxt.setColumns(10);
				
				JLabel phoneLbl = new JLabel("Telefon :");
				phoneLbl.setBounds(16, 303, 61, 16);
				customer_panel.add(phoneLbl);
				
				phoneTxt = new JTextField();
				phoneTxt.setBounds(82, 297, 263, 28);
				customer_panel.add(phoneTxt);
				phoneTxt.setColumns(10);
				
				btnOpret = new JButton("Opret");
				btnOpret.setBounds(227, 444, 117, 29);
				customer_panel.add(btnOpret);
				btnOpret.addActionListener(this);
				
				
				//Animal panel
		        
		        //Add animal
				animal_panel = new JPanel();
				animal_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				animal_panel.setBounds(394, 6, 250, 504);
				contentPaneCustomer.add(animal_panel);
				animal_panel.setLayout(null);
				
				JLabel animalLbl = new JLabel("Tilføj dyr");
				animalLbl.setBounds(41, 16, 187, 22);
				animal_panel.add(animalLbl);
				
				
				animalCombo = new JComboBox(getAnimalList.readAnimal());
				animalCombo.setBounds(41, 82, 187, 22);
				animalCombo.addActionListener(this);
				animal_panel.add(animalCombo);
				
				JLabel animalNameLbl = new JLabel("Dyrenavn :");
				animalNameLbl.setBounds(44, 131, 104, 16);
				animal_panel.add(animalNameLbl);
				
				animalNameTxt = new JTextField();
				animalNameTxt.setBounds(41, 148, 187, 28);
				animal_panel.add(animalNameTxt);
				animalNameTxt.setColumns(10);
				
				
				JLabel ageLbl = new JLabel("Dyrs fødselsdag:");
				ageLbl.setBounds(41, 188, 120, 22);
				animal_panel.add(ageLbl);
				
				ageTxt = new JTextField();
				ageTxt.setBounds(41, 212, 187, 28);
				animal_panel.add(ageTxt);
				ageTxt.setColumns(10);
				
				
				btnAddAnimal = new JButton("Tilføj dyr");
				btnAddAnimal.setBounds(111, 404, 117, 29);
				btnAddAnimal.addActionListener(this);
				animal_panel.add(btnAddAnimal);
				
				
				//Make the panel grey, and no editable for the animal
				animal_panel.setBackground(new Color(0,0,0));
		        Color colorA = new Color(200,200,200,200);
		        animal_panel.setOpaque(true);
		        animal_panel.setBackground(colorA);
		        
		        //Make the button and JTextfields non-editable
		        btnAddAnimal.setEnabled(false);
		        animalCombo.setEditable(false);
		        animalCombo.setEnabled(false);
		        animalNameTxt.setEditable(false);  
		        
		        
		        //Add textArea to show animals
		        animalArea = new JTextArea();
		        animalArea.setBounds(41, 259, 178, 133);
		        animal_panel.add(animalArea);
		        animalArea.setEditable(false);
		        
		        //Ok button to close the JFrame
		        btnOk = new JButton("OK");
		        btnOk.setBounds(111, 452, 117, 29);
		        animal_panel.add(btnOk);
		        btnOk.setEnabled(false);
		        btnOk.addActionListener(this);      			
				
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//On button Opret
		if (e.getSource() == btnOpret) 
		{
			String name = nameTxt.getText();
			String address = addressTxt.getText();
			String phone = phoneTxt.getText();
			String mail = mailTxt.getText();
			
			createCustomer.createCustomer(name, address, phone, mail);
			
			//Dialog box is only showing in 2 sec.
	        confirmationTime.Confirmation("Kunden er oprettet, tilføj gerne en dyr. Dette vindue lukker ned om 2 sek.", "Velkommen");
	        
	        nameTxt.setText("");
			addressTxt.setText("");
			phoneTxt.setText("");
			mailTxt.setText("");
	        
	        //Make the panel grey, and no editable for the customer
	        customer_panel.setBackground(new Color(0,0,0));
	        Color colorCustomerPanel = new Color(200,200,200,200);
	        customer_panel.setOpaque(true);
	        customer_panel.setBackground(colorCustomerPanel);
	        
	        //Make the button and JTextfields non-editable
	        btnOpret.setVisible(false);
	        nameTxt.setEditable(false);
	        addressTxt.setEditable(false);
	        phoneTxt.setEditable(false);
	        mailTxt.setEditable(false);
	        
	      //Make the button and JTextfields editable
	        btnAddAnimal.setEnabled(true);
	        animalCombo.setEditable(true);
	        animalCombo.setEnabled(true);
	        animalNameTxt.setEditable(true);  
	        ageTxt.setEditable(true);
	        btnOk.setEnabled(true);
	        
	      //Make the panel grey, and editable for the animal
	        
	        animal_panel.setBackground(new Color(238,238,238));
	
		}
		//On button add animal
		else if(e.getSource() == btnAddAnimal)
		{
			animalName = animalNameTxt.getText();
			animalAge = ageTxt.getText();
			
			animalArea.append(animalArt + " " + animalName + " " + animalAge + "\n");
						
			createCustomer.createAnimal(animalName, animalAge, animalArt);
		
			animalNameTxt.setText("");
			ageTxt.setText("");
			
		}
		//On button Ok
		else if(e.getSource() == btnOk)
		{
			dispose();
			
		}
		//The JComboBox selection
		else 
			{
				
				JComboBox cb = (JComboBox)e.getSource();
				
				if(e.getSource() == cb)
				{
					AnimalArt animal = (AnimalArt) cb.getSelectedItem(); 
					animalArt = animal.getAnimalArtName();				
				}
				
				
			}
		
		
	}
}
