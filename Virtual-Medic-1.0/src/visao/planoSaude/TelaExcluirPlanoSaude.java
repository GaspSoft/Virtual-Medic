package visao.planoSaude;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.DAOplanoSaude;

import java.awt.Toolkit;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Color;
import java.awt.Font;
import layoutPersonalizado.componentes.MeuTextField;
import modelo.PlanoSaude;
import visao.TelaMensagem;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaExcluirPlanoSaude extends JDialog {;
	
    public ArrayList<PlanoSaude> listaPlanoSaude = new ArrayList<PlanoSaude>();
	private Integer buscarExcluir;
	private final JPanel contentPanel = new JPanel();
	private Color btnLimpar = new Color(186, 75, 71);
	private Color corSucesso = new Color(0,139,139);
	private Color corSucessoBackground = new Color(64,224,208);
	private Color corErro = new Color(178,34,34);
	private Color corErroBackground = new Color(250,128,114);

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
		btnExcluirPlanoSaude.setBackground(btnLimpar);
		contentPanel.add(btnExcluirPlanoSaude);
		
		MeuTextField txtID = new MeuTextField();
		txtID.setBounds(42, 43, 349, 40);
		txtID.setForeground(new Color(27, 156, 228));
		contentPanel.add(txtID);
		
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
		
		JLabel lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(117, 18, 6, 14);
		contentPanel.add(lblNewLabel_3);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnExcluirPlanoSaude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOplanoSaude daoPlanoSaude = DAOplanoSaude.getInstacia();
				Integer Num = Integer.parseInt(txtID.getText());
				
				Boolean excluir = daoPlanoSaude.deletar(null, Num);
				dispose();
				TelaMenuPlanoSaude TelaMenuPlanoSaude = new TelaMenuPlanoSaude();
				TelaMenuPlanoSaude.setVisible(true);
				TelaMenuPlanoSaude.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
				if (excluir) {
					TelaMensagem telaSucesso = new TelaMensagem("Paciente excluído com sucesso!", "Paciente excluído", corSucesso, corSucessoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					dispose();
					telaSucesso.setAlwaysOnTop(true);
				} else {
					TelaMensagem telaSucesso = new TelaMensagem("Não foi possível excluir o paciente!", "Erro ao excluir paciente", corErro, corErroBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					dispose();
					telaSucesso.setAlwaysOnTop(true);
				}
			}
		});
	}
}
