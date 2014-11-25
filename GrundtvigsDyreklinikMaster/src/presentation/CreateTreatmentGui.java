/**
 * @author Jogvan, Elvis
 */
package presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import application.ControllerApp;
import application.CreateApp;

public class CreateTreatmentGui extends JFrame implements ActionListener,
	ValidateData
{
    ConfirmationDialogGui confirmationTime = new ConfirmationDialogGui();
    ControllerApp controllerApp = new ControllerApp();
    
    private JPanel treatmentPanel;
    private JTextField treatmentNameTxt;
    private JTextField priceTxt;
    private JTextField durationTxt;
    private JTextField commentTxt;
    private JButton createTreatmentBtn;
    private JLabel TreatmentLbl;

    public CreateTreatmentGui()
    {
	// Set up JFrame
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 520, 550);
	setResizable(false);
	setLocationRelativeTo(null);

	// Set up create treatment panel
	JPanel contentPaneCustomer = new JPanel();
	contentPaneCustomer.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPaneCustomer.setLayout(null);
	setContentPane(contentPaneCustomer);

	treatmentPanel = new JPanel();
	treatmentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
	treatmentPanel.setBounds(6, 6, 500, 504);
	contentPaneCustomer.add(treatmentPanel);
	treatmentPanel.setLayout(null);

	TreatmentLbl = new JLabel("Opret Behandling");
	TreatmentLbl.setBounds(16, 17, 400, 25);
	treatmentPanel.add(TreatmentLbl);

	JLabel treatmentLbl = new JLabel("Behandling :");
	treatmentLbl.setBounds(16, 91, 120, 16);
	treatmentPanel.add(treatmentLbl);

	treatmentNameTxt = new JTextField(50);
	treatmentNameTxt.setBounds(112, 85, 263, 28);
	treatmentPanel.add(treatmentNameTxt);

	JLabel priceLbl = new JLabel("Pris :");
	priceLbl.setBounds(16, 154, 120, 16);
	treatmentPanel.add(priceLbl);

	priceTxt = new JTextField();
	priceTxt.setBounds(112, 148, 263, 28);
	treatmentPanel.add(priceTxt);

	JLabel durationLbl = new JLabel("Varighed(min) :");
	durationLbl.setBounds(16, 229, 120, 16);
	treatmentPanel.add(durationLbl);

	durationTxt = new JTextField();
	durationTxt.setBounds(112, 223, 263, 28);
	treatmentPanel.add(durationTxt);

	JLabel commentLbl = new JLabel("Kommentar :");
	commentLbl.setBounds(16, 303, 120, 16);
	treatmentPanel.add(commentLbl);

	commentTxt = new JTextField();
	commentTxt.setBounds(112, 297, 263, 28);
	treatmentPanel.add(commentTxt);

	createTreatmentBtn = new JButton("Opret");
	createTreatmentBtn.setBounds(227, 444, 117, 29);
	treatmentPanel.add(createTreatmentBtn);
	createTreatmentBtn.addActionListener(this);

	setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
	if (e.getSource() == createTreatmentBtn)
	{
	    String treatmentName = treatmentNameTxt.getText();
	    String price = priceTxt.getText();
	    String duration = durationTxt.getText();
	    String comment = commentTxt.getText();

	    boolean inputIsValidated = validateInput(price, duration);
	    if (inputIsValidated && treatmentName.isEmpty())
	    {
		controllerApp.createTreatment(treatmentName, price, duration,
			comment);

		// Dialog box is only showing in 2 sec.
		confirmationTime.confirmation("Behandlingen er oprettet",
			"Velkommen");

		treatmentNameTxt.setText("");
		priceTxt.setText("");
		commentTxt.setText("");
		durationTxt.setText("");

		dispose();
	    }
	}

    }

    public boolean validateInput(String... strings)
    {
	// Regular ekspressions that only allows digits.
	String priceFormat = "\\d+";
	String durationFormat = "\\d+";

	String price = strings[0];
	String duration = strings[1];

	if (!price.matches(priceFormat))
	{
	    JOptionPane.showMessageDialog(null, "Fejl i indtastning af pris");
	    priceTxt.setText("");
	    priceTxt.requestFocus();
	    return false;
	}

	if (!duration.matches(durationFormat))
	{
	    JOptionPane
		    .showMessageDialog(null, "Fejl i indtastning af varihed");
	    durationTxt.setText("");
	    durationTxt.requestFocus();
	    return false;
	}
	return true;
    }
}
