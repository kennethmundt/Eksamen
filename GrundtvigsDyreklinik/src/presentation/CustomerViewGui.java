package presentation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import application.Customer;
import application.CustomerOverviewApp;

public class CustomerViewGui extends JPanel implements ActionListener
{
    private CustomerOverviewApp customerOverviewApp = new CustomerOverviewApp();
    private JTable customerTable;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    JButton opretKundeBtn;
    JButton sletKundeBtn;
    
    public CustomerViewGui()
    {
	tableModel = customerOverviewApp.getTableModel();
	customerTable = new JTable(tableModel);
	customerTable.setPreferredScrollableViewportSize(new Dimension(800, 500));
	customerTable.setFillsViewportHeight(true);
	customerTable.getColumn("id").setWidth(0);
	customerTable.getColumn("id").setMinWidth(0);
	customerTable.getColumn("id").setMaxWidth(0);
	scrollPane = new JScrollPane(customerTable);
	opretKundeBtn = new JButton("Opret Kunde");
	sletKundeBtn = new JButton("Slet Kunde");

	//Add components to panel
	add(scrollPane);
	add(sletKundeBtn);
	add(opretKundeBtn);
	
	//add actionlisteners
	opretKundeBtn.addActionListener(this);
	sletKundeBtn.addActionListener(this);
	
	//Add tableModel listener
	// Registers changes in customerTable and updates the database
	customerTable.getModel().addTableModelListener(new TableModelListener()
	{
	    @Override
	    public void tableChanged(TableModelEvent e)
	    {
		int row = e.getFirstRow();
		String customerId = (String) customerTable.getValueAt(row, 0);
		String nameColumn = (String) customerTable.getValueAt(row, 1);
		String addressColumn = (String) customerTable.getValueAt(row, 2);
		String phoneColumn = (String) customerTable.getValueAt(row, 3);
		String mailColumn = (String) customerTable.getValueAt(row, 4);

		customerOverviewApp.saveChanges(nameColumn, addressColumn, phoneColumn, mailColumn, customerId);
	    }
	});
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
	if (e.getSource() == opretKundeBtn)
	{
	    System.out.println("Elvis har en midz");
	}
	else if (e.getSource() == sletKundeBtn) 
	{
	    String phone = JOptionPane.showInputDialog("Indtast telefonnr. p� kunden du �nsker at slette.");
	    Customer customer = customerOverviewApp.readCustomer(phone);
	    
//	    int result = JOptionPane.showConfirmDialog(null, customer.toString(), "Slet denne kunde?", result);
	    if (JOptionPane.showConfirmDialog(null, customer.toString(), "Slet denne kunde?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	    {
		
		JOptionPane.showMessageDialog(null, "Kunden er slettet", "", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
    }
}