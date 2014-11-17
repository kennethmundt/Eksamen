package presentation;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import application.CustomerOverviewApp;

public class CustomerViewGui extends JPanel
{
    private CustomerOverviewApp customerOverviewApp = new CustomerOverviewApp();
    private JTable customerTable;
    private JButton OpretKundeBtn;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    public CustomerViewGui()
    {
	tableModel = customerOverviewApp.getTableModel();
	customerTable = new JTable(tableModel);
	customerTable.setPreferredScrollableViewportSize(new Dimension(750, 600));
	customerTable.setFillsViewportHeight(true);
	customerTable.getColumn("id").setWidth(0);
	customerTable.getColumn("id").setMinWidth(0);
	customerTable.getColumn("id").setMaxWidth(0);
	scrollPane = new JScrollPane(customerTable);
	add(scrollPane);

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
}