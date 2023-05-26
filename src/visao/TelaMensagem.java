package visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaMensagem extends JDialog {

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 * @param msg 
	 */
	public TelaMensagem(String msg, String titulo, Color corComponentes, Color corBackground) {
		getContentPane().setBackground(corBackground);
		setTitle(titulo);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMensagem.class.getResource("/img/favicon-32x32.png")));
		setBounds(100, 100, 450, 221);
		
		JLabel lblMsg = new JLabel(msg);
		lblMsg.setForeground(corComponentes);
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		MeuBotao btnContinuar = new MeuBotao();
		btnContinuar.setText("Continuar");
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setBackground(corComponentes);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblMsg, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(109)
					.addComponent(btnContinuar, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblMsg, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnContinuar, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		getContentPane().setLayout(groupLayout);
		
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
