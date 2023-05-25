package visao.paciente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.DAOpaciente;

import java.awt.Toolkit;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Color;
import java.awt.Font;
import layoutPersonalizado.componentes.MeuTextField;
import visao.TelaMensagem;

import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaExcluirPaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaExcluirPaciente dialog = new TelaExcluirPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaExcluirPaciente() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setModal(true);
		setTitle("Excluir paciente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaExcluirPaciente.class.getResource("/img/favicon-32x32.png")));
		setBounds(100, 100, 450, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		MeuBotao btnExcluirPaciente = new MeuBotao();
		
		btnExcluirPaciente.setIcon(new ImageIcon(TelaExcluirPaciente.class.getResource("/img/userDelete.png")));
		btnExcluirPaciente.setText("Excluir paciente");
		btnExcluirPaciente.setForeground(Color.WHITE);
		btnExcluirPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluirPaciente.setBackground(new Color(24, 62, 159));
		btnExcluirPaciente.setBounds(42, 93, 147, 55);
		contentPanel.add(btnExcluirPaciente);
		
		MeuTextField txtCPF = new MeuTextField();
		txtCPF.setForeground(new Color(27, 156, 228));
		txtCPF.setBounds(42, 43, 349, 40);
		contentPanel.add(txtCPF);
		
		JLabel lblNewLabel = new JLabel("Digite o CPF:");
		lblNewLabel.setForeground(new Color(84, 175, 230));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(55, 18, 98, 14);
		contentPanel.add(lblNewLabel);
		
		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setIcon(new ImageIcon(TelaExcluirPaciente.class.getResource("/img/exitBranco.png")));
		btnVoltar.setText("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBackground(new Color(24, 62, 159));
		btnVoltar.setBounds(270, 104, 121, 34);
		contentPanel.add(btnVoltar);
		
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnExcluirPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOpaciente pacienteDAO = DAOpaciente.getInstacia();
				Long cpf = Long.parseLong(txtCPF.getText());
				
				Boolean inserir = pacienteDAO.deletar(null, cpf);
				if (inserir) {
					TelaMensagem telaSucesso = new TelaMensagem("Paciente excluído com sucesso!");
					telaSucesso.setVisible(true);
				} else {
					TelaMensagem telaSucesso = new TelaMensagem("Não foi possível excluir o paciente!");
					telaSucesso.setVisible(true);
				}
				dispose();
			}
		});
	}
}
