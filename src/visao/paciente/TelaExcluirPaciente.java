package visao.paciente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Color;
import java.awt.Font;
import layoutPersonalizado.componentes.MeuTextField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaExcluirPaciente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExcluirPaciente frame = new TelaExcluirPaciente();
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
	public TelaExcluirPaciente() {
		setResizable(false);
		setTitle("Selecionar paciente para edição");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaExcluirPaciente.class.getResource("/img/favicon-32x32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		MeuBotao btnExcluirPaciente = new MeuBotao();
		btnExcluirPaciente.setIcon(new ImageIcon(TelaExcluirPaciente.class.getResource("/img/userEdit.png")));
		btnExcluirPaciente.setText("Selecionar paciente");
		btnExcluirPaciente.setForeground(Color.WHITE);
		btnExcluirPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluirPaciente.setBackground(new Color(24, 62, 159));
		
		MeuTextField txtNome = new MeuTextField();
		txtNome.setForeground(new Color(27, 156, 228));
		
		JLabel lblNewLabel = new JLabel("Digite o CPF");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(84, 175, 230));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(128)
							.addComponent(btnExcluirPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnExcluirPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(95))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
