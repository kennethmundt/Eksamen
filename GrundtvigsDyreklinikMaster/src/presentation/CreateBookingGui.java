package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import application.Animal;
import application.ControllerApp;
import application.Customer;
import application.Treatment;

import com.toedter.calendar.JDateChooser;

public class CreateBookingGui extends JPanel implements ActionListener
{
    private ControllerApp controllerApp = new ControllerApp();

    private JButton bookBtn;
    private JDateChooser dateChooserCal;
    private String dateString;
    private String time;
    private int animalId;
    private String treatmentId;
    private Date date;
    private JComboBox chooseTimeBox;
    private JComboBox chooseTreatmentBox;
    private JComboBox chooseAnimalBox;

    public CreateBookingGui(String phone)
    {
	setLayout(null);

	JLabel welcomeLbl = new JLabel("Velkommen");
	welcomeLbl.setBounds(113, 35, 67, 16);
	add(welcomeLbl);

	Customer customer = controllerApp.readCustomer(phone);
	String name = customer.getName();

	JLabel nameLbl = new JLabel(name);
	nameLbl.setBounds(215, 35, 65, 16);
	add(nameLbl);

	JLabel chooseAnimalLbl = new JLabel("V�lg dyr");
	chooseAnimalLbl.setBounds(35, 89, 51, 16);
	add(chooseAnimalLbl);

	chooseAnimalBox = new JComboBox(controllerApp.getAnimal(customer));
	chooseAnimalBox.setBounds(215, 86, 282, 22);
	add(chooseAnimalBox);
	chooseAnimalBox.addActionListener(this);

	JLabel chooseTreatmentLbl = new JLabel("V�lg behandling");
	chooseTreatmentLbl.setBounds(35, 146, 95, 16);
	add(chooseTreatmentLbl);

	chooseTreatmentBox = new JComboBox(controllerApp.getTreatment());
	chooseTreatmentBox.setBounds(215, 143, 282, 22);
	add(chooseTreatmentBox);
	chooseTreatmentBox.addActionListener(this);

	JLabel chooseDateLbl = new JLabel("V�lg dato");
	chooseDateLbl.setBounds(35, 205, 58, 16);
	add(chooseDateLbl);

	dateChooserCal = new JDateChooser();
	dateChooserCal.setBounds(215, 200, 282, 26);
	add(dateChooserCal);

	JLabel chooseTimeLbl = new JLabel("V�lg tid");
	chooseTimeLbl.setBounds(35, 264, 47, 16);
	add(chooseTimeLbl);

	chooseTimeBox = new JComboBox(controllerApp.getTime());
	chooseTimeBox.setBounds(215, 261, 282, 22);
	add(chooseTimeBox);
	chooseTimeBox.addActionListener(this);

	bookBtn = new JButton("Book");
	bookBtn.setBounds(438, 348, 59, 25);
	add(bookBtn);
	bookBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
	if (e.getSource() == bookBtn)
	{
	    date = dateChooserCal.getDate();
	    dateString = String.format("%1$td-%1$tm-%1$tY", date); //Crazy shit fra nettet (Jogvan er skyldig)

	    controllerApp.create(treatmentId, animalId, dateString, time);
	}
	else if (e.getSource() == chooseTimeBox)  // Test
	{
	    time = (String) chooseTimeBox.getSelectedItem();
	}
	else if (e.getSource() == chooseTreatmentBox) // Test
	{
	    Treatment treat = (Treatment) chooseTreatmentBox.getSelectedItem();
	    treatmentId = treat.getId();
	}
	else if (e.getSource() == chooseAnimalBox) 
	{
	    Animal animal = (Animal) chooseAnimalBox.getSelectedItem();
	    animalId = animal.getSpeciesId();
	}
    }
}
