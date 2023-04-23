package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class TelaSobreSistema extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobreSistema frame = new TelaSobreSistema();
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
	public TelaSobreSistema() {
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSobreSistema.class.getResource("/img/favicon-32x32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Pedro G., Bárbara N., Vitor S.");
		lblNewLabel_2.setForeground(new Color(84, 175, 230));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBackground(new Color(24, 62, 159));
		lblNewLabel_2.setBounds(10, 170, 348, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Virtual Medic - Versão 1.0");
		lblNewLabel_2_1.setForeground(new Color(84, 175, 230));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2_1.setBackground(new Color(24, 62, 159));
		lblNewLabel_2_1.setBounds(10, 75, 306, 26);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Versão");
		lblNewLabel_1.setForeground(new Color(24, 62, 159));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(10, 30, 143, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Autores");
		lblNewLabel_1_1.setForeground(new Color(24, 62, 159));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1_1.setBounds(10, 125, 143, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("WEB Service");
		lblNewLabel_1_1_1.setForeground(new Color(24, 62, 159));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1_1_1.setBounds(10, 225, 181, 34);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Pedro G., Bárbara N., Vitor S.");
		lblNewLabel_2_2.setForeground(new Color(84, 175, 230));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2_2.setBackground(new Color(24, 62, 159));
		lblNewLabel_2_2.setBounds(10, 270, 348, 26);
		contentPane.add(lblNewLabel_2_2);
	}
}
