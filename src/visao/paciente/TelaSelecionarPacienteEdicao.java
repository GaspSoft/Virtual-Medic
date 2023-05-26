package visao.paciente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.DAOpaciente;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import layoutPersonalizado.componentes.MeuTextField;
import modelo.Paciente;
import visao.TelaMensagem;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSelecionarPacienteEdicao extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Color corPadrao = new Color(24, 62, 159);
	private Color corPadraoBackground = new Color(255,255,255);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaSelecionarPacienteEdicao dialog = new TelaSelecionarPacienteEdicao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaSelecionarPacienteEdicao() {
		setTitle("Selecionar paciente para edição");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSelecionarPacienteEdicao.class.getResource("/img/favicon-32x32.png")));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setModal(true);
		setBounds(100, 100, 450, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite o CPF:");
		lblNewLabel.setForeground(new Color(84, 175, 230));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(51, 18, 84, 14);
		contentPanel.add(lblNewLabel);
		
		MeuTextField txtCPF = new MeuTextField();
		txtCPF.setForeground(new Color(27, 156, 228));
		txtCPF.setBounds(39, 43, 349, 40);
		contentPanel.add(txtCPF);
		
		MeuBotao btnSelecionarPaciente = new MeuBotao();
		btnSelecionarPaciente.setIcon(new ImageIcon(TelaSelecionarPacienteEdicao.class.getResource("/img/userEdit.png")));
		btnSelecionarPaciente.setText("Selecionar paciente");
		btnSelecionarPaciente.setForeground(Color.WHITE);
		btnSelecionarPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSelecionarPaciente.setBackground(new Color(24, 62, 159));
		btnSelecionarPaciente.setBounds(39, 94, 169, 55);
		contentPanel.add(btnSelecionarPaciente);
		
		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setIcon(new ImageIcon(TelaSelecionarPacienteEdicao.class.getResource("/img/exitBranco.png")));
		btnVoltar.setText("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBackground(new Color(24, 62, 159));
		btnVoltar.setBounds(267, 105, 121, 34);
		contentPanel.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnSelecionarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOpaciente pacienteDAO = new DAOpaciente();
				Long cpf = Long.parseLong(txtCPF.getText());
				Paciente pacienteEncontrada = pacienteDAO.buscarPorCPF(cpf);
				if (pacienteEncontrada != null) {
					TelaEditarPaciente telaEditarPaciente = new TelaEditarPaciente(pacienteEncontrada);
					telaEditarPaciente.setVisible(true);
					telaEditarPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
					
					dispose();
		        } else {
		            TelaMensagem telaMensagem = new TelaMensagem("CPF não encontrado!", "CPF não encontrado", corPadrao, corPadraoBackground);
		            telaMensagem.setLocationRelativeTo(null);
		            telaMensagem.setVisible(true);
		        }
			}
		});
	}
}
