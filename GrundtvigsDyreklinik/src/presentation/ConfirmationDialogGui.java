/**
 * Tina
 */

package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ConfirmationDialogGui
{
    private JOptionPane pane;
    private JDialog dialog;

    public void confirmation(String paneText, String dialogText)
    {
	pane = new JOptionPane(paneText);
	dialog = pane.createDialog(dialogText);

	Timer timer = new Timer(1000, new ActionListener()
	{
	    public void actionPerformed(final ActionEvent e)
	    {
		dialog.setVisible(false);
	    }
	});
	timer.setRepeats(false);
	timer.start();
	dialog.setVisible(true);
	dialog.dispose();

    }

}
