/**
 * @author kenneth og Tina
 */

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

import application.CreateCustomerApp;
import application.Customer;
import application.CustomerOverviewApp;
import application.UpdateApp;

public class CustomerViewGui extends JPanel implements ActionListener
{
    private CustomerOverviewApp customerOverviewApp = new CustomerOverviewApp();
    private CreateCustomerApp createCustomerApp = new CreateCustomerApp();
    private UpdateApp updateApp = new UpdateApp();
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JButton opretKundeBtn;
    private JButton sletKundeBtn;

    public CustomerViewGui()
    {
	tableModel = customerOverviewApp.getTableModel();
	JTable customerTable = new JTable(tableModel);
	customerTable.setPreferredScrollableViewportSize(new Dimension(800, 500));
	customerTable.setFillsViewportHeight(true);
	customerTable.getColumn("id").setWidth(0);
	customerTable.getColumn("id").setMinWidth(0);
	customerTable.getColumn("id").setMaxWidth(0);
	scrollPane = new JScrollPane(customerTable);
	opretKundeBtn = new JButton("Opret Kunde");
	sletKundeBtn = new JButton("Slet Kunde");

	// Add components to panel
	add(scrollPane);
	add(sletKundeBtn);
	add(opretKundeBtn);

	// add actionlisteners
	opretKundeBtn.addActionListener(this);
	sletKundeBtn.addActionListener(this);

	// Add tableModellistener
	// Registers changes in customerTable and pass changes to
	// aplicationLayer
	customerTable.getModel().addTableModelListener(new TableModelListener()
	{
	    @Override
	    public void tableChanged(TableModelEvent e)
	    {
		int row = e.getFirstRow();
		String customerId = (String) customerTable.getValueAt(row, 0);
		String nameColumn = (String) customerTable.getValueAt(row, 1);
		String addressColumn = (String) customerTable
			.getValueAt(row, 2);
		String phoneColumn = (String) customerTable.getValueAt(row, 3);
		String mailColumn = (String) customerTable.getValueAt(row, 4);

		// customerOverviewApp.saveChanges(nameColumn, addressColumn,
		// phoneColumn, mailColumn, customerId);
		updateApp.saveChanges(nameColumn, addressColumn, phoneColumn,
			mailColumn, customerId);

	    }
	});
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
	String phone;
	if (e.getSource() == opretKundeBtn)
	{
	    new CreateCustomerGui();
	} else if (e.getSource() == sletKundeBtn)
	{
	    phone = JOptionPane.showInputDialog("Indtast telefonnr. p� kunden du �nsker at slette.");
	    Customer customer = customerOverviewApp.readCustomer(phone);

	    if (JOptionPane.showConfirmDialog(null, customer.toString(),
		    "Slet denne kunde?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	    {
		updateApp.deleteCustomer(phone);
		JOptionPane.showMessageDialog(null, "Kunden er slettet", "",
			JOptionPane.INFORMATION_MESSAGE);
	    }
	}
    }
}