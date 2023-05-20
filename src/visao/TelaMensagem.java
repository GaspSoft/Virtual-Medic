package visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class TelaMensagem extends JDialog {

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 * @param msg 
	 */
	public TelaMensagem(String msg) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblMsg = new JLabel(msg);
		lblMsg.setBounds(83, 62, 262, 147);
		getContentPane().add(lblMsg);
	}
}
