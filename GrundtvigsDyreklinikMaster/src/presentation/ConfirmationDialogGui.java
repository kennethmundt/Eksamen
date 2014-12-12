/**
 * Borrowed from StackOverflow
 * Create a dialog that automatically disappears after set time.
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

    /**
     * Creates and show a dialog that disappear after 2 sec.  
     * @param paneText
     * @param dialogText
     */
    public void confirmation(String paneText, String dialogText) //Borrowed from the web.
    {
	pane = new JOptionPane(paneText);
	dialog = pane.createDialog(dialogText);

	Timer timer = new Timer(2000, new ActionListener()
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