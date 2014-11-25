package presentation;

/**
 * @author Elvis og Jogvan
 */


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import application.CreateApp;

public class CreateTreatmentGui extends JFrame implements ActionListener
{
	ConfirmationDialogGui confirmationTime = new ConfirmationDialogGui();
	CreateApp createTreatment = new CreateApp();

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
		setBounds(100, 100, 656, 550);
		setResizable(false);
		setLocationRelativeTo(null);

		// Set up create customer panel
		JPanel contentPaneCustomer = new JPanel();
		contentPaneCustomer.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneCustomer.setLayout(null);
		setContentPane(contentPaneCustomer);

		treatmentPanel = new JPanel();
		treatmentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		treatmentPanel.setBounds(6, 6, 375, 504);
		contentPaneCustomer.add(treatmentPanel);
		treatmentPanel.setLayout(null);

		TreatmentLbl = new JLabel("Opret Behandling");
		TreatmentLbl.setBounds(16, 17, 231, 25);
		treatmentPanel.add(TreatmentLbl);

		JLabel treatmentLbl = new JLabel("Behandling :");
		treatmentLbl.setBounds(16, 91, 61, 16);
		treatmentPanel.add(treatmentLbl);

		treatmentNameTxt = new JTextField(50);
		treatmentNameTxt.setBounds(82, 85, 263, 28);
		treatmentPanel.add(treatmentNameTxt);

		JLabel priceLbl = new JLabel("Pris :");
		priceLbl.setBounds(16, 154, 61, 16);
		treatmentPanel.add(priceLbl);

		priceTxt = new JTextField();
		priceTxt.setBounds(82, 148, 263, 28);
		treatmentPanel.add(priceTxt);

		JLabel durationLbl = new JLabel("Varighed :");
		durationLbl.setBounds(16, 229, 61, 16);
		treatmentPanel.add(durationLbl);

		durationTxt = new JTextField();
		durationTxt.setBounds(82, 223, 263, 28);
		treatmentPanel.add(durationTxt);

		JLabel commentLbl = new JLabel("Kommentar :");
		commentLbl.setBounds(16, 303, 61, 16);
		treatmentPanel.add(commentLbl);

		commentTxt = new JTextField();
		commentTxt.setBounds(82, 297, 263, 28);
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
			String duration = commentTxt.getText();
			String comment = durationTxt.getText();

			if (treatmentName.length() != 0 && price.length() != 0
					&& duration.length() != 0 && comment.length() != 0)
			{
				createTreatment.createTreatment(treatmentName, price, duration, comment);

				// Dialog box is only showing in 2 sec.
				confirmationTime.confirmation("Behandlingen er oprettet","Velkommen");
			}

			treatmentNameTxt.setText("");
			priceTxt.setText("");
			commentTxt.setText("");
			durationTxt.setText("");
			
			dispose();
		} 
	
	}
}
