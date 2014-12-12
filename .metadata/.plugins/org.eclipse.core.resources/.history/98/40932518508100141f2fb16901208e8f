package presentation;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import application.ControllerApp;

public class BookingViewGui extends JPanel
{
    ControllerApp controller = new ControllerApp();
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    public BookingViewGui()
    {
	tableModel = controller.getBookingTableModel();
	JTable bookingTable = new JTable(tableModel);
	bookingTable.setPreferredScrollableViewportSize(new Dimension(800, 500));
	bookingTable.setFillsViewportHeight(true);

	scrollPane = new JScrollPane(bookingTable);

	// Add components to panel
	add(scrollPane);

	// Add tableModellistener
	// Registers changes in customerTable and pass changes to
	// aplicationLayer

    }
}
