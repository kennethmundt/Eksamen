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

import application.CustomerOverviewApp;

public class CustomerViewGui extends JPanel
{
    private CustomerOverviewApp overviewApp = new CustomerOverviewApp();
    private JTable CustomerTable;
    private JButton OpretKundeBtn;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    public CustomerViewGui()
    {
	tableModel = overviewApp.getTableModel();
	CustomerTable = new JTable(tableModel);
	CustomerTable.setPreferredScrollableViewportSize(new Dimension(750, 600));
	CustomerTable.setFillsViewportHeight(true);

	scrollPane = new JScrollPane(CustomerTable);
	add(scrollPane);

	// Registers changes in the JTable and write changes to the database
	CustomerTable.getModel().addTableModelListener(new TableModelListener()
	{
	    @Override
	    public void tableChanged(TableModelEvent e)
	    {
		try
		{
		    writeToFile(); //-------------------------- start her --------------------
		} catch (FileNotFoundException fnfe)
		{
		    
		}
	    }
	});
    }

}

// package View;
//
// import java.util.ArrayList;
//
// import javax.swing.JPanel;
// import javax.swing.JTable;
// import javax.swing.JScrollPane;
// import javax.swing.table.DefaultTableModel;
// import javax.swing.JButton;
//
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
//
//
// @SuppressWarnings("serial")
// public class CustomerViewGui extends JPanel implements ActionListener {
//
// private DefaultTableModel model;
// readDB db = new readDB();
//
//
// /**
// * Create the panel.
// * @throws Exception
// */
// public CustomerViewGui() throws Exception
// {
//
//
// table = new JTable(model);
// scrollPane.setViewportView(table);
// scrollPane.setViewportView(table);
// table.setModel(new TableModel(kundeList));
// table.setAutoCreateRowSorter(true);
//
//
// panel.add(scrollPane);
//
// btnOpretKunde = new JButton("Opret kunde");
// btnOpretKunde.setBounds(586, 396, 117, 29);
// panel.add(btnOpretKunde);
//
// btnOpretKunde.addActionListener(this);
//
//
// }
// public void actionPerformed(ActionEvent e)
// {
// if(e.getSource() == btnOpretKunde)
// {
// CreateCustomerGui frameCustomer = new CreateCustomerGui();
// frameCustomer.setVisible(true);
//
//
// }
//
//
// }
// }

