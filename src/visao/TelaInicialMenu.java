package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import layoutPersonalizado.componentes.MeuBotao;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaInicialMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicialMenu frame = new TelaInicialMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicialMenu() {
		setTitle("Menu inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInicialMenu.class.getResource("/img/VirtualMedic200.png")));
		
		JLabel lblNewLabel_1 = new JLabel("VIRTUAL");
		lblNewLabel_1.setForeground(new Color(24, 62, 159));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 60));
		
		JLabel lblNewLabel_1_1 = new JLabel("MEDIC");
		lblNewLabel_1_1.setForeground(new Color(27, 156, 228));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 45));
		
		JLabel lblNewLabel_2 = new JLabel("Bem vindo ao prontuário eletrônico");
		lblNewLabel_2.setForeground(new Color(84, 175, 230));
		lblNewLabel_2.setBackground(new Color(24, 62, 159));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		MeuBotao btnMenuPaciente = new MeuBotao();
		btnMenuPaciente.setIcon(new ImageIcon(TelaInicialMenu.class.getResource("/img/paciente.png")));
		btnMenuPaciente.setText("Acessar menu paciente");
		btnMenuPaciente.setForeground(Color.WHITE);
		btnMenuPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMenuPaciente.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnMenuMedico = new MeuBotao();
		btnMenuMedico.setIcon(new ImageIcon(TelaInicialMenu.class.getResource("/img/medico.png")));
		btnMenuMedico.setText("Acessar menu médico");
		btnMenuMedico.setForeground(Color.WHITE);
		btnMenuMedico.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMenuMedico.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnMenuPlanoSaude = new MeuBotao();
		btnMenuPlanoSaude.setIcon(new ImageIcon(TelaInicialMenu.class.getResource("/img/planoSaude.png")));
		btnMenuPlanoSaude.setText("Acessar menu plano de saúde");
		btnMenuPlanoSaude.setForeground(Color.WHITE);
		btnMenuPlanoSaude.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMenuPlanoSaude.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnSair = new MeuBotao();
		btnSair.setIcon(new ImageIcon(TelaInicialMenu.class.getResource("/img/exitBranco.png")));
		btnSair.setText("Sair");
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnRedesSociais = new MeuBotao();
		btnRedesSociais.setText("Acessar redes sociais");
		btnRedesSociais.setForeground(Color.WHITE);
		btnRedesSociais.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRedesSociais.setBackground(new Color(24, 62, 159));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(2)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(106))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
							.addGap(219))
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
					.addGap(8))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(btnMenuPaciente, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
							.addGap(57)
							.addComponent(btnMenuMedico, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(btnMenuPlanoSaude, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
							.addGap(57)
							.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)))
					.addGap(1))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(446, Short.MAX_VALUE)
					.addComponent(btnRedesSociais, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnMenuPaciente, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMenuMedico, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnMenuPlanoSaude, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(btnRedesSociais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
