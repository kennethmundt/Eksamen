package presentation;

import java.awt.Dimension;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
	customerTable.getColumn("id").setMaxWidth(0) ;
	
	scrollPane = new JScrollPane(customerTable);
	add(scrollPane);

	// Registers changes in the JTable and write changes to the database
	customerTable.getModel().addTableModelListener(new TableModelListener()
	{
	    @Override
	    public void tableChanged(TableModelEvent e)
	    {
//		String midz = customerTable.getColumnName(0);

		int row = e.getFirstRow();
		int column = e.getColumn();
		TableModel model = (TableModel)e.getSource();
		
		Object id = customerTable.getValueAt(row, 0);
		
		Object data = model.getValueAt(row, column);
		
//		model = CustomerTable.getModel();
//		customerOverviewApp.saveChanges(model);

		customerOverviewApp.saveChanges(id, data, row, column);
	    }
	});
    }
}