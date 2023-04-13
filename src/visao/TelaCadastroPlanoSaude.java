package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class TelaCadastroPlanoSaude extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPlanoSaude frame = new TelaCadastroPlanoSaude();
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
	public TelaCadastroPlanoSaude() {
		setTitle("Tela de Cadastro Plano de Saúde");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paciente:");
		lblNewLabel.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		lblNewLabel.setBounds(65, 145, 90, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(187, 135, 245, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Plano de Saúde");
		lblNewLabel_1.setFont(new Font("Source Code Pro", Font.BOLD, 15));
		lblNewLabel_1.setBounds(65, 36, 338, 38);
		contentPane.add(lblNewLabel_1);
	}
}
