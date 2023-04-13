package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastroMedico extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldCRM;
	private JTextField textFieldEspeci;
	private JTextField textFieldEmail;
	private JTextField textFieldCEP;
	private JTextField textFieldEstado;
	private JTextField textFieldCidade;
	private JTextField textFieldBairro;
	private JTextField textFieldRua;
	private JTextField textFieldComple;

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
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(41, 247, 46, 14);
		contentPane.add(lblRua);
		
		JLabel lblNum = new JLabel("Número:");
		lblNum.setBounds(41, 272, 46, 14);
		contentPane.add(lblNum);
		
		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(41, 147, 46, 14);
		contentPane.add(lblCEP);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(41, 172, 46, 14);
		contentPane.add(lblEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(41, 197, 46, 14);
		contentPane.add(lblCidade);
		
		textFieldEspeci = new JTextField();
		textFieldEspeci.setColumns(10);
		textFieldEspeci.setBounds(119, 94, 188, 20);
		contentPane.add(textFieldEspeci);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(119, 122, 188, 20);
		contentPane.add(textFieldEmail);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setColumns(10);
		textFieldCEP.setBounds(119, 147, 188, 20);
		contentPane.add(textFieldCEP);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(41, 222, 46, 14);
		contentPane.add(lblBairro);
		
		JLabel lblComple = new JLabel("Complemento:");
		lblComple.setBounds(41, 297, 76, 14);
		contentPane.add(lblComple);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setColumns(10);
		textFieldEstado.setBounds(119, 172, 188, 20);
		contentPane.add(textFieldEstado);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(119, 197, 188, 20);
		contentPane.add(textFieldCidade);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(119, 219, 188, 20);
		contentPane.add(textFieldBairro);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(119, 244, 188, 20);
		contentPane.add(textFieldRua);
		
		JTextField textFieldNum = new JTextField();
		textFieldNum.setColumns(10);
		textFieldNum.setBounds(119, 269, 188, 20);
		contentPane.add(textFieldNum);
		
		textFieldComple = new JTextField();
		textFieldComple.setColumns(10);
		textFieldComple.setBounds(119, 294, 188, 20);
		contentPane.add(textFieldComple);
	}

}
