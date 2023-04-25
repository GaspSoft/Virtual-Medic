package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRedesSociais extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRedesSociais frame = new TelaRedesSociais();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaRedesSociais() {
		setAutoRequestFocus(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaRedesSociais.class.getResource("/img/favicon-32x32.png")));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setTitle("Redes Socias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 487, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaRedesSociais.class.getResource("/img/godriImg.png")));
		lblNewLabel.setBounds(10, 30, 60, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(TelaRedesSociais.class.getResource("/img/vitorImg.png")));
		lblNewLabel_1.setBounds(10, 120, 60, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon(TelaRedesSociais.class.getResource("/img/barbaraImg.png")));
		lblNewLabel_1_1.setBounds(10, 209, 60, 60);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblGitGodri = new JLabel("New label");
		lblGitGodri.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGitGodri.setIcon(new ImageIcon(TelaRedesSociais.class.getResource("/img/logoGithub.png")));
		lblGitGodri.setBounds(190, 30, 60, 60);
		contentPane.add(lblGitGodri);
		
		JLabel lblGitVitor = new JLabel("New label");
		lblGitVitor.setIcon(new ImageIcon(TelaRedesSociais.class.getResource("/img/logoGithub.png")));
		lblGitVitor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGitVitor.setBounds(190, 120, 60, 60);
		contentPane.add(lblGitVitor);
		
		JLabel lblGitBarbara = new JLabel("New label");
		lblGitBarbara.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGitBarbara.setIcon(new ImageIcon(TelaRedesSociais.class.getResource("/img/logoGithub.png")));
		lblGitBarbara.setBounds(190, 209, 60, 60);
		contentPane.add(lblGitBarbara);
		
		JLabel lblLinkedinBarbara = new JLabel("New label");
		lblLinkedinBarbara.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinkedinBarbara.setIcon(new ImageIcon(TelaRedesSociais.class.getResource("/img/logoLinkedin.png")));
		lblLinkedinBarbara.setBounds(280, 209, 60, 60);
		contentPane.add(lblLinkedinBarbara);
		
		JLabel lblLinkedinGodri = new JLabel("New label");
		lblLinkedinGodri.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinkedinGodri.setIcon(new ImageIcon(TelaRedesSociais.class.getResource("/img/logoLinkedin.png")));
		lblLinkedinGodri.setBounds(280, 30, 60, 60);
		contentPane.add(lblLinkedinGodri);
		
		JLabel lblLinkedinVitor = new JLabel("New label");
		lblLinkedinVitor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinkedinVitor.setIcon(new ImageIcon(TelaRedesSociais.class.getResource("/img/logoLinkedin.png")));
		lblLinkedinVitor.setBounds(280, 120, 60, 60);
		contentPane.add(lblLinkedinVitor);
		
		JLabel lblInstaGodri = new JLabel("New label");
		lblInstaGodri.setIcon(new ImageIcon(TelaRedesSociais.class.getResource("/img/logoInsta.png")));
		lblInstaGodri.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInstaGodri.setBounds(100, 30, 60, 60);
		contentPane.add(lblInstaGodri);
		
		JLabel lblInstaVitor = new JLabel("New label");
		lblInstaVitor.setIcon(new ImageIcon(TelaRedesSociais.class.getResource("/img/logoInsta.png")));
		lblInstaVitor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInstaVitor.setBounds(100, 120, 60, 60);
		contentPane.add(lblInstaVitor);
		
		JLabel lblInstaBarbara = new JLabel("New label");
		lblInstaBarbara.setIcon(new ImageIcon(TelaRedesSociais.class.getResource("/img/logoInsta.png")));
		lblInstaBarbara.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInstaBarbara.setBounds(100, 209, 60, 60);
		contentPane.add(lblInstaBarbara);
		
		MeuBotao btnSair = new MeuBotao();
		btnSair.setIcon(new ImageIcon(TelaRedesSociais.class.getResource("/img/exitBranco.png")));
		btnSair.setText("Voltar");
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(new Color(24, 62, 159));
		btnSair.setBounds(367, 11, 94, 272);
		contentPane.add(btnSair);
		
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
