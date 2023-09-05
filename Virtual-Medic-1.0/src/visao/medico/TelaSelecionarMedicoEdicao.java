 package visao.medico;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.DAOmedico;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import layoutPersonalizado.componentes.MeuTextField;
import modelo.Medico;
import visao.TelaMensagem;
import visao.paciente.TelaEditarPaciente;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSelecionarMedicoEdicao extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Color corPadrao = new Color(24, 62, 159);
	private Color corPadraoBackground = new Color(255,255,255);
	private Color btnSucesso = new Color(92, 171, 109);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaSelecionarMedicoEdicao dialog = new TelaSelecionarMedicoEdicao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaSelecionarMedicoEdicao() {
		setTitle("Selecionar Médico para Edição");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSelecionarMedicoEdicao.class.getResource("/img/favicon-32x32.png")));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setModal(true);
		setBounds(100, 100, 450, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite o CRM:");
		lblNewLabel.setForeground(new Color(84, 175, 230));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(51, 18, 84, 14);
		contentPanel.add(lblNewLabel);
		
		MeuTextField txtCRM = new MeuTextField();
		txtCRM.setForeground(new Color(27, 156, 228));
		txtCRM.setBounds(39, 43, 349, 40);
		contentPanel.add(txtCRM);
		
		MeuBotao btnSelecionarMedico = new MeuBotao();
		
		btnSelecionarMedico.setIcon(new ImageIcon(TelaSelecionarMedicoEdicao.class.getResource("/img/userEdit.png")));
		btnSelecionarMedico.setText("Selecionar Médico");
		btnSelecionarMedico.setForeground(Color.WHITE);
		btnSelecionarMedico.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSelecionarMedico.setBackground(btnSucesso);
		btnSelecionarMedico.setBounds(39, 94, 169, 55);
		contentPanel.add(btnSelecionarMedico);
		
		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setIcon(new ImageIcon(TelaSelecionarMedicoEdicao.class.getResource("/img/exitBranco.png")));
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
		
		btnSelecionarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOmedico medicoDAO = new DAOmedico();
				Long crm = Long.parseLong(txtCRM.getText());
				Medico medicoEncontrado = medicoDAO.buscarPorCRM(crm);
				if (medicoEncontrado != null) {
					TelaEditarMedico telaEditarMedico = new TelaEditarMedico(medicoEncontrado);
					telaEditarMedico.setVisible(true);
					telaEditarMedico.setExtendedState(JFrame.MAXIMIZED_BOTH);
					
					dispose();
		        } else {
		            TelaMensagem telaMensagem = new TelaMensagem("CRM não encontrado!", "CRM não encontrado", corPadrao, corPadraoBackground);
		            telaMensagem.setLocationRelativeTo(null);
		            telaMensagem.setVisible(true);
		        }
			}
		});
	}
}
