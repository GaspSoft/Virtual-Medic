package visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.JLabel;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class TelaSocialMidia extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaSocialMidia dialog = new TelaSocialMidia();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaSocialMidia() {
		setAutoRequestFocus(false);
		setResizable(false);
		setTitle("Redes sociais");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSocialMidia.class.getResource("/img/favicon-32x32.png")));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 323);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon(TelaSocialMidia.class.getResource("/img/barbaraImg.png")));
		lblNewLabel_1_1.setBounds(10, 198, 60, 60);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(TelaSocialMidia.class.getResource("/img/vitorImg.png")));
		lblNewLabel_1.setBounds(10, 109, 60, 60);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaSocialMidia.class.getResource("/img/godriImg.png")));
		lblNewLabel.setBounds(10, 19, 60, 60);
		getContentPane().add(lblNewLabel);
		
		JLabel lblInstaGodri = new JLabel("New label");
		lblInstaGodri.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInstaGodri.setIcon(new ImageIcon(TelaSocialMidia.class.getResource("/img/logoInsta.png")));
		lblInstaGodri.setBounds(100, 19, 60, 60);
		getContentPane().add(lblInstaGodri);
		
		JLabel lblInstaVitor = new JLabel("New label");
		lblInstaVitor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInstaVitor.setIcon(new ImageIcon(TelaSocialMidia.class.getResource("/img/logoInsta.png")));
		lblInstaVitor.setBounds(100, 109, 60, 60);
		getContentPane().add(lblInstaVitor);
		
		JLabel lblInstaBarbara = new JLabel("New label");
		lblInstaBarbara.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInstaBarbara.setIcon(new ImageIcon(TelaSocialMidia.class.getResource("/img/logoInsta.png")));
		lblInstaBarbara.setBounds(100, 198, 60, 60);
		getContentPane().add(lblInstaBarbara);
		
		JLabel lblGitBarbara = new JLabel("New label");
		lblGitBarbara.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGitBarbara.setIcon(new ImageIcon(TelaSocialMidia.class.getResource("/img/logoGithub.png")));
		lblGitBarbara.setBounds(190, 198, 60, 60);
		getContentPane().add(lblGitBarbara);
		
		JLabel lblGitVitor = new JLabel("New label");
		lblGitVitor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGitVitor.setIcon(new ImageIcon(TelaSocialMidia.class.getResource("/img/logoGithub.png")));
		lblGitVitor.setBounds(190, 109, 60, 60);
		getContentPane().add(lblGitVitor);
		
		JLabel lblGitGodri = new JLabel("New label");
		lblGitGodri.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGitGodri.setIcon(new ImageIcon(TelaSocialMidia.class.getResource("/img/logoGithub.png")));
		lblGitGodri.setBounds(190, 19, 60, 60);
		getContentPane().add(lblGitGodri);
		
		JLabel lblLinkedinGodri = new JLabel("New label");
		lblLinkedinGodri.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinkedinGodri.setIcon(new ImageIcon(TelaSocialMidia.class.getResource("/img/logoLinkedin.png")));
		lblLinkedinGodri.setBounds(280, 19, 60, 60);
		getContentPane().add(lblLinkedinGodri);
		
		JLabel lblLinkedinVitor = new JLabel("New label");
		lblLinkedinVitor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinkedinVitor.setIcon(new ImageIcon(TelaSocialMidia.class.getResource("/img/logoLinkedin.png")));
		lblLinkedinVitor.setBounds(280, 109, 60, 60);
		getContentPane().add(lblLinkedinVitor);
		
		JLabel lblLinkedinBarbara = new JLabel("New label");
		lblLinkedinBarbara.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinkedinBarbara.setIcon(new ImageIcon(TelaSocialMidia.class.getResource("/img/logoLinkedin.png")));
		lblLinkedinBarbara.setBounds(280, 198, 60, 60);
		getContentPane().add(lblLinkedinBarbara);
		
		MeuBotao btnSair = new MeuBotao();
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setIcon(new ImageIcon(TelaSocialMidia.class.getResource("/img/exitBranco.png")));
		btnSair.setText("Voltar");
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(new Color(24, 62, 159));
		btnSair.setBounds(373, 6, 94, 272);
		getContentPane().add(btnSair);
		
		lblGitGodri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://github.com/pedrogodri");
			}
		});
		
		lblGitVitor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://github.com/VitorSchiphorst");
			}
		});
		
		lblGitBarbara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://github.com/BahNasc");
			}
		});
		
		lblLinkedinGodri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://www.linkedin.com/in/pedro-henrique-godri/");
			}
		});
		
		lblLinkedinVitor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://www.linkedin.com/in/vitor-hugo-schiphorst-3a0708260/");
			}
		});
		
		lblLinkedinBarbara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://www.linkedin.com/in/b%C3%A1rbara-do-nascimento-746029263/");
			}
		});
		
		lblInstaBarbara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://www.instagram.com/bah.nasc/");
			}
		});
		
		lblInstaGodri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://www.instagram.com/pedro_godri/");
			}
		});
		
		lblInstaVitor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://www.instagram.com/vitor_schiphorst/");
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
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
