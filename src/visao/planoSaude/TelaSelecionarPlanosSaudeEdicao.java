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
import java.awt.Font;
import java.awt.Color;
import layoutPersonalizado.componentes.MeuTextField;
import modelo.PlanoSaude;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaSelecionarPlanosSaudeEdicao extends JDialog {

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
			
			MeuTextField txtNome = new MeuTextField();
			txtNome.setForeground(new Color(27, 156, 228));
			txtNome.setBounds(39, 43, 349, 40);
			contentPanel.add(txtNome);
				
			MeuBotao btSelecionarPlanoDeSaude = new MeuBotao();
			btSelecionarPlanoDeSaude.setText("Selecionar plano de saúde");
			btSelecionarPlanoDeSaude.setForeground(Color.WHITE);
			btSelecionarPlanoDeSaude.setFont(new Font("Tahoma", Font.BOLD, 11));
			btSelecionarPlanoDeSaude.setBackground(new Color(24, 62, 159));
			btSelecionarPlanoDeSaude.setBounds(49, 102, 195, 55);
			contentPanel.add(btSelecionarPlanoDeSaude);
				
			MeuBotao btnVoltar = new MeuBotao();
			btnVoltar.setIcon(new ImageIcon(TelaExcluirPlanoSaude.class.getResource("/img/exitBranco.png")));
			btnVoltar.setText("Voltar");
			btnVoltar.setForeground(Color.WHITE);
			btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnVoltar.setBackground(new Color(24, 62, 159));
			btnVoltar.setBounds(292, 113, 121, 34);
			contentPanel.add(btnVoltar);
			
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			btSelecionarPlanoDeSaude.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					DAOplanoSaude ps = DAOplanoSaude.getInstacia();
					ArrayList<PlanoSaude> listaPlanoSaude = ps.listaPlanoSaude();
					int Num = Integer.parseInt(txtNome.getText());
					
					listaPlanoSaude.buscarEditar(Num);
					
					dispose();
					TelaEditarPlanoSaude telaEditarPlanoSaude = new TelaEditarPlanoSaude();
					telaEditarPlanoSaude.setVisible(true);
					telaEditarPlanoSaude.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}
			});

			
			
		}
	}
	
	public Integer buscarEditar (int Num) {
		
		DAOplanoSaude ps = DAOplanoSaude.getInstacia();
		ArrayList<PlanoSaude> listaPlanoSaude = ps.listaPlanoSaude();
		
		Integer acharID = null;
		String acharPlano = "";
		
		for (PlanoSaude planosaude : listaPlanoSaude) {

			if (planosaude.getId() == Num) {
				acharID = planosaude.getId();
				acharPlano = planosaude.getNome();
			}
		}
		return null;
		
	}

}
