package visao.paciente;

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
import visao.TelaInicialMenu;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenuPaciente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuPaciente frame = new TelaMenuPaciente();
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
	public TelaMenuPaciente() {
		setTitle("Menu Paciente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMenuPaciente.class.getResource("/img/favicon-32x32.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 635, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		MeuBotao btnListaPaciente = new MeuBotao();
		btnListaPaciente.setIcon(new ImageIcon(TelaMenuPaciente.class.getResource("/img/userList.png")));
		btnListaPaciente.setText("Acessar lista de pacientes");
		btnListaPaciente.setForeground(Color.WHITE);
		btnListaPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListaPaciente.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnCadastrarPaciente = new MeuBotao();
		btnCadastrarPaciente.setIcon(new ImageIcon(TelaMenuPaciente.class.getResource("/img/userCad.png")));
		btnCadastrarPaciente.setText("Cadastrar novo paciente");
		btnCadastrarPaciente.setForeground(Color.WHITE);
		btnCadastrarPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarPaciente.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnEditarPaciente = new MeuBotao();
		btnEditarPaciente.setIcon(new ImageIcon(TelaMenuPaciente.class.getResource("/img/userEdit.png")));
		btnEditarPaciente.setText("Editar um paciente");
		btnEditarPaciente.setForeground(Color.WHITE);
		btnEditarPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarPaciente.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnExcluirPaciente = new MeuBotao();
		btnExcluirPaciente.setIcon(new ImageIcon(TelaMenuPaciente.class.getResource("/img/userDelete.png")));
		btnExcluirPaciente.setText("Excluir um paciente");
		btnExcluirPaciente.setForeground(Color.WHITE);
		btnExcluirPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluirPaciente.setBackground(new Color(24, 62, 159));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaMenuPaciente.class.getResource("/img/VirtualMedic200.png")));
		
		JLabel lblNewLabel_1 = new JLabel("VIRTUAL");
		lblNewLabel_1.setForeground(new Color(24, 62, 159));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 44));
		
		JLabel lblNewLabel_1_1 = new JLabel("MEDIC");
		lblNewLabel_1_1.setForeground(new Color(27, 156, 228));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		
		JLabel lblNewLabel_2 = new JLabel("Bem vindo ao menu do paciente");
		lblNewLabel_2.setForeground(new Color(84, 175, 230));
		lblNewLabel_2.setBackground(new Color(24, 62, 159));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setIcon(new ImageIcon(TelaMenuPaciente.class.getResource("/img/exitBranco.png")));
		btnVoltar.setText("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBackground(new Color(24, 62, 159));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaMenuPaciente.class.getResource("/img/gradiente.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(btnListaPaciente, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(53)
					.addComponent(btnCadastrarPaciente, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(btnEditarPaciente, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(53)
					.addComponent(btnExcluirPaciente, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
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
						.addComponent(btnListaPaciente, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastrarPaciente, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditarPaciente, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluirPaciente, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicialMenu telaMenuIncial = new TelaInicialMenu();
				telaMenuIncial.setVisible(true);
				telaMenuIncial.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		
		btnCadastrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPaciente telaCadastroPaciente = new TelaCadastroPaciente();
				telaCadastroPaciente.setVisible(true);
				telaCadastroPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		
		btnExcluirPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExcluirPaciente telaExcluirPaciente = new TelaExcluirPaciente();
				telaExcluirPaciente.setVisible(true);
			}
		});
		
		btnEditarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSelecionarPacienteEdicao telaSelecionarPacienteEdicao = new TelaSelecionarPacienteEdicao();
				telaSelecionarPacienteEdicao.setVisible(true);
			}
		});
	}
}
