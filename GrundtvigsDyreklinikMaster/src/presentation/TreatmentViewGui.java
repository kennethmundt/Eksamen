/**
 * @author Elvis og Jogvan
 */

package presentation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


import application.OverviewApp;
import application.Treatment;
import application.UpdateApp;

public class TreatmentViewGui extends JPanel implements ActionListener
{
	private OverviewApp overviewApp = new OverviewApp();
	private UpdateApp updateApp = new UpdateApp();
	private ConfirmationDialogGui confirmationTime = new ConfirmationDialogGui();

	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JButton createTreatmentBtn;
	private JButton deleteTreatmentBtn;

	public TreatmentViewGui()
	{
		tableModel = overviewApp.getTreatmentTableModel();
		JTable treatmentTable = new JTable(tableModel);
		treatmentTable.setPreferredScrollableViewportSize(new Dimension(800, 500));
		treatmentTable.setFillsViewportHeight(true);
		treatmentTable.getColumn("id").setWidth(0);
		treatmentTable.getColumn("id").setMinWidth(0);
		treatmentTable.getColumn("id").setMaxWidth(0);
		scrollPane = new JScrollPane(treatmentTable);
		createTreatmentBtn = new JButton("Opret Behandling");
		deleteTreatmentBtn = new JButton("Slet Behandling");

		// Add components to panel
		add(scrollPane);
		add(deleteTreatmentBtn);
		add(createTreatmentBtn);

		// add actionlisteners
		createTreatmentBtn.addActionListener(this);
		deleteTreatmentBtn.addActionListener(this);

		// Add tableModellistener
		// Registers changes in treatmentTable and pass changes to
		// aplicationLayer
		treatmentTable.getModel().addTableModelListener(new TableModelListener()
		{
			@Override
			public void tableChanged(TableModelEvent e)
			{
				int row = e.getFirstRow();
				String treatmentId = (String) treatmentTable.getValueAt(row, 0);
				String teatmentColumn = (String) treatmentTable.getValueAt(row, 1);
				String priceColumn = (String) treatmentTable.getValueAt(row, 2);
				String durationColumn = (String) treatmentTable.getValueAt(row, 3);
				String commentColumn = (String) treatmentTable.getValueAt(row, 4);

				updateApp.saveChangesTreatment(teatmentColumn, priceColumn, durationColumn,commentColumn, treatmentId);

			}
		});
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		String treatmentName;
		if (e.getSource() == createTreatmentBtn)
		{
			new CreateTreatmentGui();
		} else if (e.getSource() == deleteTreatmentBtn)
		{
			treatmentName = JOptionPane.showInputDialog("Indtast navn p� behandling du �nsker at slette.");
			Treatment treatment = overviewApp.readTreatment(treatmentName);

			if (JOptionPane.showConfirmDialog(null, treatment.toString(),
					"Slet denne behandling?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				updateApp.deleteTreatment(treatmentName);
				confirmationTime.confirmation("Behandlingen er Slettet","Velkommen");

			}
		}
	}
}