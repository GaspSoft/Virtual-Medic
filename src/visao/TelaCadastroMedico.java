package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroMedico extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldCRM;
	private JTextField textFieldEspeci;
	private JTextField textFieldEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroMedico frame = new TelaCadastroMedico();
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
	public TelaCadastroMedico() {
		setTitle("Cadastro Médico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(41, 22, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCRM = new JLabel("CRM:");
		lblCRM.setBounds(41, 72, 46, 14);
		contentPane.add(lblCRM);
		
		JLabel lblEspeci = new JLabel("Especialidade:");
		lblEspeci.setBounds(41, 97, 86, 14);
		contentPane.add(lblEspeci);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(119, 19, 188, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(119, 44, 188, 20);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldCRM = new JTextField();
		textFieldCRM.setBounds(119, 69, 188, 20);
		contentPane.add(textFieldCRM);
		textFieldCRM.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(41, 47, 46, 14);
		contentPane.add(lblCPF);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(41, 122, 46, 14);
		contentPane.add(lblEmail);
		
		textFieldEspeci = new JTextField();
		textFieldEspeci.setColumns(10);
		textFieldEspeci.setBounds(119, 94, 188, 20);
		contentPane.add(textFieldEspeci);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(119, 122, 188, 20);
		contentPane.add(textFieldEmail);
		
		JButton btnCadastar = new JButton("Cadastrar");
		btnCadastar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastar.setBounds(152, 178, 89, 23);
		contentPane.add(btnCadastar);
	}
}
