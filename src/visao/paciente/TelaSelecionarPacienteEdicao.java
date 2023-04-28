 package visao.paciente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import layoutPersonalizado.componentes.MeuTextField;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class TelaSelecionarPacienteEdicao extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaSelecionarPacienteEdicao dialog = new TelaSelecionarPacienteEdicao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaSelecionarPacienteEdicao() {
		setTitle("Selecionar paciente para edição");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSelecionarPacienteEdicao.class.getResource("/img/favicon-32x32.png")));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setModal(true);
		setBounds(100, 100, 450, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite o CPF");
		lblNewLabel.setForeground(new Color(84, 175, 230));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(39, 11, 66, 14);
		contentPanel.add(lblNewLabel);
		
		MeuTextField txtNome = new MeuTextField();
		txtNome.setForeground(new Color(27, 156, 228));
		txtNome.setBounds(39, 43, 349, 40);
		contentPanel.add(txtNome);
		
		MeuBotao btnExcluirPaciente = new MeuBotao();
		btnExcluirPaciente.setIcon(new ImageIcon(TelaSelecionarPacienteEdicao.class.getResource("/img/userEdit.png")));
		btnExcluirPaciente.setText("Selecionar paciente");
		btnExcluirPaciente.setForeground(Color.WHITE);
		btnExcluirPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluirPaciente.setBackground(new Color(24, 62, 159));
		btnExcluirPaciente.setBounds(124, 101, 169, 55);
		contentPanel.add(btnExcluirPaciente);
	}
}
