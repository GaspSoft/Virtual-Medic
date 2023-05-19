package visao.planoSaude;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Color;
import java.awt.Font;
import layoutPersonalizado.componentes.MeuTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSucessoPlanoSaude extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaSucessoPlanoSaude dialog = new TelaSucessoPlanoSaude();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaSucessoPlanoSaude() {
		setTitle("Tela de Sucesso");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSucessoPlanoSaude.class.getResource("/img/favicon-32x32.png")));
		setBounds(100, 100, 450, 199);
		
		JPanel contentPanel_1 = new JPanel();
		contentPanel_1.setLayout(null);
		contentPanel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		MeuBotao btnExcluirPlanoSaude = new MeuBotao();
		btnExcluirPlanoSaude.setText("Continuar");
		btnExcluirPlanoSaude.setForeground(Color.WHITE);
		btnExcluirPlanoSaude.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluirPlanoSaude.setBackground(new Color(24, 62, 159));
		btnExcluirPlanoSaude.setBounds(120, 89, 193, 60);
		contentPanel_1.add(btnExcluirPlanoSaude);
		
		JLabel lblNewLabel = new JLabel("Sucesso");
		lblNewLabel.setForeground(new Color(84, 175, 230));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(110, 11, 203, 55);
		contentPanel_1.add(lblNewLabel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel_1, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(contentPanel_1, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		
		btnExcluirPlanoSaude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				TelaMenuPlanoSaude telaMenuPlanoSaude = new TelaMenuPlanoSaude();
				telaMenuPlanoSaude.setVisible(true);
				telaMenuPlanoSaude.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
	}

}
