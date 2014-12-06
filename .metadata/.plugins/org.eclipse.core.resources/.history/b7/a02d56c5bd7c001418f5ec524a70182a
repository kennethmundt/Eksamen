package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import application.Animal;
import application.Booking;
import application.ControllerApp;
import application.Customer;
import application.InputValidater;
import application.Treatment;

import com.toedter.calendar.JDateChooser;

public class CreateBookingGui extends JPanel implements ActionListener
{
    private ControllerApp controllerApp = new ControllerApp();
    private InputValidater validate = new InputValidater();

    private JButton bookBtn;
    private JDateChooser dateChooserCal;
    private String dateString;
    private String time;
    private int animalId;
    private String treatmentId;
    private Date date;
    private Object dates;
    private JComboBox chooseTimeBox;
    private JComboBox chooseTreatmentBox;
    private JComboBox chooseAnimalBox;
    private Booking book;

    public CreateBookingGui(String phone)
    {
	setLayout(null);
	setSize(700, 900);

	JLabel welcomeLbl = new JLabel("Velkommen");
	welcomeLbl.setBounds(248, 35, 87, 16);
	add(welcomeLbl);

	Customer customer = controllerApp.readCustomer(phone);
	String name = customer.getName();

	JLabel nameLbl = new JLabel(name);
	nameLbl.setBounds(414, 35, 115, 16);
	add(nameLbl);

	JLabel chooseAnimalLbl = new JLabel("Vælg dyr");
	chooseAnimalLbl.setBounds(248, 89, 145, 16);
	add(chooseAnimalLbl);

	chooseAnimalBox = new JComboBox(controllerApp.getAnimal(customer));
	chooseAnimalBox.setSelectedIndex(-1);
	chooseAnimalBox.setBounds(412, 87, 282, 22);
	add(chooseAnimalBox);
	chooseAnimalBox.addActionListener(this);

	JLabel chooseTreatmentLbl = new JLabel("Vælg behandling");
	chooseTreatmentLbl.setBounds(248, 125, 145, 16);
	add(chooseTreatmentLbl);

	chooseTreatmentBox = new JComboBox(controllerApp.getTreatment());
	chooseTreatmentBox.setSelectedIndex(-1);
	chooseTreatmentBox.setBounds(412, 123, 282, 22);
	add(chooseTreatmentBox);
	chooseTreatmentBox.addActionListener(this);

	JLabel chooseDateLbl = new JLabel("Vælg dato");
	chooseDateLbl.setBounds(248, 164, 102, 16);
	add(chooseDateLbl);

	dateChooserCal = new JDateChooser();
	dateChooserCal.setBounds(412, 164, 282, 26);
	add(dateChooserCal);
	dateChooserCal.getDateEditor().setEnabled(false);
	
	JLabel chooseTimeLbl = new JLabel("Vælg tid");
	chooseTimeLbl.setBounds(248, 209, 145, 16);
	add(chooseTimeLbl);
	
	chooseTimeBox = new JComboBox(controllerApp.getTime());
	chooseTimeBox.setSelectedIndex(-1);
	chooseTimeBox.setBounds(412, 207, 282, 22);
	add(chooseTimeBox);
	chooseTimeBox.addActionListener(this);

	bookBtn = new JButton("Book");
	bookBtn.setBounds(625, 301, 69, 25);
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

	    boolean bookingNotValidated = validate.validateBooking(treatmentId, animalId, date, time);
	    
	    if (bookingNotValidated) 
	    {
		JOptionPane.showMessageDialog(null, "Udfyld venligst alle felter");
		return;
	    } 
	    controllerApp.create(treatmentId, animalId, dateString, time);
	    JOptionPane.showMessageDialog(null, "Bookning er nu oprettet");
	    
	}
	else if(e.getSource() == chooseAnimalBox)
	{
	    Animal animal = (Animal) chooseAnimalBox.getSelectedItem();
	    animalId = animal.getSpeciesId();
	}
	else if(e.getSource() == chooseTreatmentBox)
	{
	    Treatment treat = (Treatment) chooseTreatmentBox.getSelectedItem();
	    treatmentId = treat.getId();
	}
	else if(e.getSource() == chooseTimeBox)
	{
	    time = (String) chooseTimeBox.getSelectedItem();
	}
    }
}