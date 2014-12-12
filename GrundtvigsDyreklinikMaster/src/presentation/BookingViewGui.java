/**
 * Tina, Jogvan, Elvis og Kenneth
 * Shows all bookings
 */

package presentation;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import application.ControllerApp;

public class BookingViewGui extends JPanel
{
    private ControllerApp controller = new ControllerApp();
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    public BookingViewGui()
    {
	tableModel = controller.getBookingTableModel();
	JTable bookingTable = new JTable(tableModel);
	bookingTable.setPreferredScrollableViewportSize(new Dimension(800, 500));
	bookingTable.setFillsViewportHeight(true);

	scrollPane = new JScrollPane(bookingTable);
	add(scrollPane);
    }
}