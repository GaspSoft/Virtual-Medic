package visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

public class TelaCadastroPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCEP;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtRua;
	private JComboBox cboUF;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPaciente frame = new TelaCadastroPaciente();
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
	public TelaCadastroPaciente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroPaciente.class.getResource("/img/VirtualMedic.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CEP:");
		lblNewLabel.setBounds(85, 154, 46, 14);
		contentPane.add(lblNewLabel);

		txtCEP = new JTextField();
		txtCEP.setBounds(130, 151, 176, 20);
		contentPane.add(txtCEP);
		txtCEP.setColumns(10);

		JButton btnBuscarCEP = new JButton("Buscar");
		btnBuscarCEP.setBounds(403, 150, 89, 23);
		contentPane.add(btnBuscarCEP);

		JLabel lblNewLabel_1_1 = new JLabel("Complemento:");
		lblNewLabel_1_1.setBounds(85, 221, 106, 14);
		contentPane.add(lblNewLabel_1_1);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(201, 220, 281, 20);
		contentPane.add(txtComplemento);

		JLabel lblNewLabel_1_1_1 = new JLabel("Bairro:");
		lblNewLabel_1_1_1.setBounds(85, 261, 106, 14);
		contentPane.add(lblNewLabel_1_1_1);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(201, 258, 281, 20);
		contentPane.add(txtBairro);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(201, 289, 281, 20);
		contentPane.add(txtCidade);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Cidade:");
		lblNewLabel_1_1_1_1.setBounds(85, 292, 106, 14);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Estado");
		lblNewLabel_1_1_1_1_1.setBounds(85, 328, 106, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		cboUF = new JComboBox();
		cboUF.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS",
						"MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUF.setBounds(201, 320, 105, 22);
		contentPane.add(cboUF);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(77, 376, 89, 23);
		contentPane.add(btnLimpar);

		JLabel lblNewLabel_2 = new JLabel("Rua");
		lblNewLabel_2.setBounds(85, 196, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(172, 190, 176, 20);
		contentPane.add(txtRua);

		btnBuscarCEP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCEP.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o CEP");
					txtCEP.requestFocus();
				} else {
					// buscar CEP
					buscarCEP();
				}
			}
		});

		/* Uso da biblioteca Atxy2k para validação do campo txtCEP */
		RestrictedTextField validar = new RestrictedTextField(txtCEP);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(325, 154, 20, 20);
		contentPane.add(lblStatus);
		validar.setOnlyNums(true);
		validar.setLimit(8);
	}
	
	private void buscarCEP() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCEP.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboUF.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));
					} else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
					}
				}
			}
			txtRua.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
