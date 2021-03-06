/**
 * @author Tina
 */

package presentation;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainGui extends JFrame
{
    private JPanel contentPane;
    private JPanel customerOverviewPnl;
    private JTabbedPane tabbedPane;

    public MainGui()
    {
	//Setting up the JFrame
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(900, 700);
	setLocationRelativeTo(null);
	setResizable(false);
	contentPane = new JPanel();
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);

	//Instantiate tabbedPane and add it to the contentpane.
	tabbedPane = new JTabbedPane();
	contentPane.add(tabbedPane, BorderLayout.CENTER);

	//The different tabs
	customerOverviewPnl = new CustomerViewGui();
	
	//Add tabs to the tabbedPane
	tabbedPane.addTab("Kundeoversigt", new ImageIcon("image/addMeIcon.png"), customerOverviewPnl, null); //Icon vises ikke
	
	setVisible(true);
    }
}