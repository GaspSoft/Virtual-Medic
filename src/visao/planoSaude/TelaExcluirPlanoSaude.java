package visao.planoSaude;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.DAOplanoSaude;

import java.awt.Toolkit;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Color;
import java.awt.Font;
import layoutPersonalizado.componentes.MeuTextField;
import modelo.PlanoSaude;

import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaExcluirPlanoSaude extends JDialog {;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaExcluirPlanoSaude dialog = new TelaExcluirPlanoSaude();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public TelaExcluirPlanoSaude() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setModal(true);
		setTitle("Excluir Plano de Saúde");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaExcluirPlanoSaude.class.getResource("/img/favicon-32x32.png")));
		setBounds(100, 100, 450, 197);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		MeuBotao btnExcluirPlanoSaude = new MeuBotao();
		btnExcluirPlanoSaude.setBounds(42, 94, 167, 55);
		btnExcluirPlanoSaude.setText("Excluir plano de saúde:");
		btnExcluirPlanoSaude.setForeground(Color.WHITE);
		btnExcluirPlanoSaude.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluirPlanoSaude.setBackground(new Color(24, 62, 159));
		contentPanel.add(btnExcluirPlanoSaude);
		
		MeuTextField txtNome = new MeuTextField();
		txtNome.setBounds(42, 43, 349, 40);
		txtNome.setForeground(new Color(27, 156, 228));
		contentPanel.add(txtNome);
		
		JLabel lblNewLabel = new JLabel("Digite o ID:");
		lblNewLabel.setBounds(52, 18, 66, 14);
		lblNewLabel.setForeground(new Color(84, 175, 230));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPanel.add(lblNewLabel);
		
		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setIcon(new ImageIcon(TelaExcluirPlanoSaude.class.getResource("/img/exitBranco.png")));
		btnVoltar.setText("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBackground(new Color(24, 62, 159));
		btnVoltar.setBounds(270, 105, 121, 34);
		contentPanel.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMenuPlanoSaude TelaMenuPlanoSaude = new TelaMenuPlanoSaude();
				TelaMenuPlanoSaude.setVisible(true);
			}
		});
		
		btnExcluirPlanoSaude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	public static void buscarEditar (Integer Num) {
		
		DAOplanoSaude ps = DAOplanoSaude.getInstacia();
		ArrayList<PlanoSaude> listaPlanoSaude = ps.listaPlanoSaude();
		
		for (PlanoSaude planosaude : listaPlanoSaude) {

			if (planosaude.getId() == Num) {
				planosaude.remove(listaPlanoSaude);
			}
		}
	}
}
