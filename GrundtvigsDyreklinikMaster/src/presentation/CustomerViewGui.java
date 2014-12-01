/**
 * @author kenneth og Tina
 */

package presentation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle.Control;

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

import application.ControllerApp;
import application.CreateApp;
import application.Customer;
import application.OverviewApp;
import application.UpdateApp;

public class CustomerViewGui extends JPanel implements ActionListener
{
    ControllerApp controller = new ControllerApp();
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JButton createCustomerBtn;
    private JButton deleteCustomerBtn;

    public CustomerViewGui()
    {
	tableModel = controller.getTableModel();
	JTable customerTable = new JTable(tableModel);
	customerTable.setPreferredScrollableViewportSize(new Dimension(800, 500));
	customerTable.setFillsViewportHeight(true);
	customerTable.getColumn("id").setWidth(0);
	customerTable.getColumn("id").setMinWidth(0);
	customerTable.getColumn("id").setMaxWidth(0);
	scrollPane = new JScrollPane(customerTable);
	createCustomerBtn = new JButton("Opret Kunde");
	deleteCustomerBtn = new JButton("Slet Kunde");

	// Add components to panel
	add(scrollPane);
	add(deleteCustomerBtn);
	add(createCustomerBtn);

	// add actionlisteners
	createCustomerBtn.addActionListener(this);
	deleteCustomerBtn.addActionListener(this);

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
		String addressColumn = (String) customerTable.getValueAt(row, 2);
		String phoneColumn = (String) customerTable.getValueAt(row, 3);
		String mailColumn = (String) customerTable.getValueAt(row, 4);

		// customerOverviewApp.saveChanges(nameColumn, addressColumn,
		// phoneColumn, mailColumn, customerId);
		controller.saveChanges(nameColumn, addressColumn, phoneColumn, mailColumn, customerId);
	    }
	});
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
	String phone;
	if (e.getSource() == createCustomerBtn)
	{
	    new CreateCustomerGui();
	} else if (e.getSource() == deleteCustomerBtn)
	{
	    phone = JOptionPane.showInputDialog("Indtast telefonnr. på kunden du ønsker at slette.");
	    Customer customer = controller.readCustomer(phone);

	    if (JOptionPane.showConfirmDialog(null, customer.toString(), "Slet denne kunde?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	    {
		controller.deleteCustomer(phone);
		JOptionPane.showMessageDialog(null, "Kunden er slettet", "", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
    }
}