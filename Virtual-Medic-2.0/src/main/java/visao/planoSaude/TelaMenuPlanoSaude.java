package visao.planoSaude;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import layoutPersonalizado.componentes.MeuBotao;
import visao.TelaInicialMenu;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaMenuPlanoSaude extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuPlanoSaude frame = new TelaMenuPlanoSaude();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public TelaMenuPlanoSaude() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMenuPlanoSaude.class.getResource("/img/favicon-32x32.png")));
		setTitle("Menu Plano de Saúde");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 635, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		MeuBotao btnListaPlanoSaude = new MeuBotao();
		btnListaPlanoSaude.setIcon(new ImageIcon(TelaMenuPlanoSaude.class.getResource("/img/userList.png")));
		btnListaPlanoSaude.setText("Acessar lista de plano");
		btnListaPlanoSaude.setForeground(Color.WHITE);
		btnListaPlanoSaude.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListaPlanoSaude.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnCadastrarPlanoSaude = new MeuBotao();
		btnCadastrarPlanoSaude.setIcon(new ImageIcon(TelaMenuPlanoSaude.class.getResource("/img/userCad.png")));
		btnCadastrarPlanoSaude.setText("Cadastrar novo plano");
		btnCadastrarPlanoSaude.setForeground(Color.WHITE);
		btnCadastrarPlanoSaude.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarPlanoSaude.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnEditarPlanoSaude = new MeuBotao();
		btnEditarPlanoSaude.setIcon(new ImageIcon(TelaMenuPlanoSaude.class.getResource("/img/userEdit.png")));
		btnEditarPlanoSaude.setText("Editar um plano");
		btnEditarPlanoSaude.setForeground(Color.WHITE);
		btnEditarPlanoSaude.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarPlanoSaude.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnExcluirPlanoSaude = new MeuBotao();
		btnExcluirPlanoSaude.setIcon(new ImageIcon(TelaMenuPlanoSaude.class.getResource("/img/userDelete.png")));
		btnExcluirPlanoSaude.setText("Excluir um plano");
		btnExcluirPlanoSaude.setForeground(Color.WHITE);
		btnExcluirPlanoSaude.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluirPlanoSaude.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setIcon(new ImageIcon(TelaMenuPlanoSaude.class.getResource("/img/exitBranco.png")));
		btnVoltar.setText("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBackground(new Color(24, 62, 159));
		
		JLabel lblNewLabel_1 = new JLabel("VIRTUAL");
		lblNewLabel_1.setForeground(new Color(24, 62, 159));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 44));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaMenuPlanoSaude.class.getResource("/img/VirtualMedic200.png")));
		
		JLabel lblNewLabel_1_1 = new JLabel("MEDIC");
		lblNewLabel_1_1.setForeground(new Color(27, 156, 228));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		
		JLabel lblNewLabel_2 = new JLabel("Bem vindo ao menu do plano de sáude");
		lblNewLabel_2.setForeground(new Color(84, 175, 230));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBackground(new Color(24, 62, 159));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaMenuPlanoSaude.class.getResource("/img/gradiente.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 619, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(btnListaPlanoSaude, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(53)
					.addComponent(btnCadastrarPlanoSaude, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(btnEditarPlanoSaude, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(53)
					.addComponent(btnExcluirPlanoSaude, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(441)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblNewLabel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblNewLabel_1_1)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 741, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnListaPlanoSaude, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastrarPlanoSaude, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditarPlanoSaude, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluirPlanoSaude, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnListaPlanoSaude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListaPlanoSaude telaListaPlanoSaude = new TelaListaPlanoSaude();
				telaListaPlanoSaude.setVisible(true);
				telaListaPlanoSaude.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		
		btnEditarPlanoSaude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSelecionarPlanosSaudeEdicao telaSelecionarPlanosSaudeEdicao = new TelaSelecionarPlanosSaudeEdicao();
				telaSelecionarPlanosSaudeEdicao.setLocationRelativeTo(null);
				telaSelecionarPlanosSaudeEdicao.setVisible(true);
			}
		});
		
		btnExcluirPlanoSaude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExcluirPlanoSaude telaExcluirPlanoSaude = new TelaExcluirPlanoSaude();
				telaExcluirPlanoSaude.setLocationRelativeTo(null);
				telaExcluirPlanoSaude.setVisible(true);
			}
		});
		
		btnCadastrarPlanoSaude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroPlanoSaude telaCadastroPlanoSaude = new TelaCadastroPlanoSaude();
				telaCadastroPlanoSaude.setVisible(true);
				telaCadastroPlanoSaude.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicialMenu telaMenuIncial = new TelaInicialMenu();
				telaMenuIncial.setVisible(true);
				telaMenuIncial.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
	}

}
