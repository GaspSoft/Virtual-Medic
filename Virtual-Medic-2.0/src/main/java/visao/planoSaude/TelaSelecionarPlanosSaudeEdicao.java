package visao.planoSaude;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.DAOplanoSaude;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import layoutPersonalizado.componentes.MeuTextField;
import modelo.Paciente;
import modelo.PlanoSaude;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class TelaSelecionarPlanosSaudeEdicao extends JDialog {
	
	private Color btnSucesso = new Color(92, 171, 109);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaSelecionarPlanosSaudeEdicao dialog = new TelaSelecionarPlanosSaudeEdicao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaSelecionarPlanosSaudeEdicao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSelecionarPlanosSaudeEdicao.class.getResource("/img/favicon-32x32.png")));
		setTitle("Selecionar Plano de Saúde");
		setBounds(100, 100, 450, 211);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel contentPanel = new JPanel();
			contentPanel.setLayout(null);
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			
			JLabel lblDigiteOId = new JLabel("Digite o ID:");
			lblDigiteOId.setForeground(new Color(84, 175, 230));
			lblDigiteOId.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblDigiteOId.setBounds(39, 18, 66, 14);
			contentPanel.add(lblDigiteOId);
			
			MeuTextField txtID = new MeuTextField();
			txtID.setForeground(new Color(27, 156, 228));
			txtID.setBounds(39, 43, 349, 40);
			contentPanel.add(txtID);
				
			MeuBotao btSelecionarPlanoDeSaude = new MeuBotao();
			btSelecionarPlanoDeSaude.setText("Selecionar plano de saúde");
			btSelecionarPlanoDeSaude.setForeground(Color.WHITE);
			btSelecionarPlanoDeSaude.setFont(new Font("Tahoma", Font.BOLD, 11));
			btSelecionarPlanoDeSaude.setBackground(btnSucesso);
			btSelecionarPlanoDeSaude.setBounds(49, 102, 195, 55);
			contentPanel.add(btSelecionarPlanoDeSaude);
				
			MeuBotao btnVoltar = new MeuBotao();
			btnVoltar.setIcon(new ImageIcon(TelaExcluirPlanoSaude.class.getResource("/img/exitBranco.png")));
			btnVoltar.setText("Voltar");
			btnVoltar.setForeground(Color.WHITE);
			btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnVoltar.setBackground(new Color(24, 62, 159));
			btnVoltar.setBounds(267, 113, 121, 34);
			contentPanel.add(btnVoltar);
			
			JLabel lblNewLabel_3 = new JLabel("*");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_3.setForeground(Color.RED);
			lblNewLabel_3.setBounds(104, 18, 6, 14);
			contentPanel.add(lblNewLabel_3);
			
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			btSelecionarPlanoDeSaude.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					DAOplanoSaude planoDAO = new DAOplanoSaude();
					Integer Id = Integer.parseInt(txtID.getText());
					PlanoSaude planoEncontrado = planoDAO.buscarPorId(Id);
					
					dispose();
					TelaEditarPlanoSaude telaEditarPlanoSaude = new TelaEditarPlanoSaude(planoEncontrado);
					telaEditarPlanoSaude.setVisible(true);
					telaEditarPlanoSaude.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}
			});			
		}
	}

}
