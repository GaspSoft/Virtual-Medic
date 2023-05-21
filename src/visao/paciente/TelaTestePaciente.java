package visao.paciente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import layoutPersonalizado.componentes.MeuTextField;
import modelo.Paciente;

import java.awt.Color;

public class TelaTestePaciente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTestePaciente frame = new TelaTestePaciente(null);
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
	public TelaTestePaciente(Paciente paciente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MeuTextField txtNome = new MeuTextField();
		txtNome.setText(paciente.getNome());
		txtNome.setForeground(new Color(27, 156, 228));
		txtNome.setBounds(41, 32, 349, 40);
		contentPane.add(txtNome);
		
		MeuTextField txtEmail = new MeuTextField();
		txtEmail.setForeground(new Color(27, 156, 228));
		txtEmail.setBounds(41, 96, 349, 40);
		contentPane.add(txtEmail);
		
		
	}
}
