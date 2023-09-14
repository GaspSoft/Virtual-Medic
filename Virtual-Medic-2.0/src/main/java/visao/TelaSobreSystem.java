package visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Desktop;

import layoutPersonalizado.componentes.MeuBotao;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.awt.Cursor;

public class TelaSobreSystem extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaSobreSystem dialog = new TelaSobreSystem();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaSobreSystem() {
		setAutoRequestFocus(false);
		setTitle("Sobre o sistema");
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSobreSystem.class.getResource("/img/favicon-32x32.png")));
		setBounds(100, 100, 490, 333);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Versão");
		lblNewLabel_1.setForeground(new Color(24, 62, 159));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(10, 11, 143, 34);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Virtual Medic - Versão 1.0");
		lblNewLabel_2_1.setForeground(new Color(84, 175, 230));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2_1.setBackground(new Color(24, 62, 159));
		lblNewLabel_2_1.setBounds(10, 56, 306, 26);
		contentPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Autores");
		lblNewLabel_1_1.setForeground(new Color(24, 62, 159));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1_1.setBounds(10, 106, 143, 34);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pedro G., Bárbara N., Vitor S.");
		lblNewLabel_2.setForeground(new Color(84, 175, 230));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBackground(new Color(24, 62, 159));
		lblNewLabel_2.setBounds(10, 151, 348, 26);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("WEB Service");
		lblNewLabel_1_1_1.setForeground(new Color(24, 62, 159));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1_1_1.setBounds(10, 206, 181, 34);
		contentPanel.add(lblNewLabel_1_1_1);
		
		JLabel lblLinkWeb = new JLabel("republicavirtual.com.br");
		lblLinkWeb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinkWeb.setForeground(new Color(84, 175, 230));
		lblLinkWeb.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLinkWeb.setBackground(new Color(24, 62, 159));
		lblLinkWeb.setBounds(10, 251, 279, 26);
		contentPanel.add(lblLinkWeb);
		
		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setIcon(new ImageIcon(TelaSobreSystem.class.getResource("/img/exitBranco.png")));
		btnVoltar.setText("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBackground(new Color(24, 62, 159));
		btnVoltar.setBounds(349, 253, 124, 39);
		contentPanel.add(btnVoltar);
		
		lblLinkWeb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://www.republicavirtual.com.br");
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
