package visao.paciente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Color;
import java.awt.Font;
import layoutPersonalizado.componentes.MeuTextField;
import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;

public class TelaExcluirPaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaExcluirPaciente dialog = new TelaExcluirPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaExcluirPaciente() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setModal(true);
		setTitle("Excluir paciente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaExcluirPaciente.class.getResource("/img/favicon-32x32.png")));
		setBounds(100, 100, 450, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		MeuBotao btnExcluirPaciente = new MeuBotao();
		btnExcluirPaciente.setIcon(new ImageIcon(TelaExcluirPaciente.class.getResource("/img/userDelete.png")));
		btnExcluirPaciente.setText("Excluir paciente");
		btnExcluirPaciente.setForeground(Color.WHITE);
		btnExcluirPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluirPaciente.setBackground(new Color(24, 62, 159));
		btnExcluirPaciente.setBounds(127, 101, 147, 55);
		contentPanel.add(btnExcluirPaciente);
		
		MeuTextField txtNome = new MeuTextField();
		txtNome.setForeground(new Color(27, 156, 228));
		txtNome.setBounds(42, 43, 349, 40);
		contentPanel.add(txtNome);
		
		JLabel lblNewLabel = new JLabel("Digite o CPF");
		lblNewLabel.setForeground(new Color(84, 175, 230));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(42, 11, 66, 14);
		contentPanel.add(lblNewLabel);
	}
}
