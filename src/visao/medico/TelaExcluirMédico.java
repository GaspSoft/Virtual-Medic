package visao.medico;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.DAOmedico;

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

public class TelaExcluirMédico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Color corSucesso = new Color(0,139,139);
	private Color corSucessoBackground = new Color(64,224,208);
	private Color corErro = new Color(178,34,34);
	private Color corErroBackground = new Color(250,128,114);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaExcluirMédico dialog = new TelaExcluirMédico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaExcluirMédico() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setModal(true);
		setTitle("Excluir Médico");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaExcluirMédico.class.getResource("/img/favicon-32x32.png")));
		setBounds(100, 100, 450, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		MeuBotao btnExcluirMedico = new MeuBotao();
		btnExcluirMedico.setIcon(new ImageIcon(TelaExcluirMédico.class.getResource("/img/userDelete.png")));
		btnExcluirMedico.setText("Excluir médico");
		btnExcluirMedico.setForeground(Color.WHITE);
		btnExcluirMedico.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluirMedico.setBackground(new Color(24, 62, 159));
		btnExcluirMedico.setBounds(42, 93, 147, 55);
		contentPanel.add(btnExcluirMedico);
		
		MeuTextField txtCRM = new MeuTextField();
		txtCRM.setForeground(new Color(27, 156, 228));
		txtCRM.setBounds(42, 43, 349, 40);
		contentPanel.add(txtCRM);
		
		JLabel lblNewLabel = new JLabel("Digite o CRM:");
		lblNewLabel.setForeground(new Color(84, 175, 230));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(55, 18, 98, 14);
		contentPanel.add(lblNewLabel);
		
		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setIcon(new ImageIcon(TelaExcluirMédico.class.getResource("/img/exitBranco.png")));
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
		
		btnExcluirMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOmedico medicoDAO = DAOmedico.getInstacia();
				Long crm = Long.parseLong(txtCRM.getText());
				
				Boolean excluir = medicoDAO.deletar(null, crm);
				if (excluir) {
					TelaMensagem telaSucesso = new TelaMensagem("Médico excluído com sucesso!", "Médico exluído", corSucesso, corSucessoBackground);
					telaSucesso.setVisible(true);
				} else {
					TelaMensagem telaSucesso = new TelaMensagem("Não foi possível excluir o médico!", "Erro ao excluir paciente", corErro, corErroBackground);
					telaSucesso.setVisible(true);
				}
				dispose();
			}
		});
	}
}
