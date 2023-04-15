package visao.paciente;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import layoutPersonalizado.componentes.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class TelaCadastroPaciente extends JFrame {

	private JPanel contentPane;
	private MeuTextField txtCEP;
	private MeuTextField txtComplemento;
	private MeuTextField txtBairro;
	private MeuTextField txtCidade;
	private MeuTextField txtRua;
	//private JComboBox cboUF;

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
		setTitle("Cadastro de paciente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroPaciente.class.getResource("/img/favicon-32x32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(30, 179, 46, 14);
		lblCEP.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCEP.setForeground(new Color(84, 175, 230));
		lblCEP.setBackground(new Color(255, 255, 255));
		
		txtCEP = new MeuTextField();
		txtCEP.setForeground(new Color(27, 156, 228));
		txtCEP.setBounds(86, 169, 95, 39);
        
        MeuBotao btnBuscar = new MeuBotao();
        btnBuscar.setBounds(215, 175, 95, 33);
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setBackground(new Color(24, 62, 159));
		btnBuscar.setText("Buscar");
        
        JLabel lblRua = new JLabel("Rua");
        lblRua.setBounds(30, 223, 46, 14);
        lblRua.setForeground(new Color(84, 175, 230));
        lblRua.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        MeuTextField txtRua = new MeuTextField();
        txtRua.setForeground(new Color(27, 156, 228));
        txtRua.setBounds(86, 213, 154, 39);
        
        JLabel lblBairro = new JLabel("Bairro");
        lblBairro.setBounds(30, 272, 46, 14);
        lblBairro.setForeground(new Color(84, 175, 230));
        lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        MeuTextField txtBairro = new MeuTextField();
        txtBairro.setForeground(new Color(27, 156, 228));
        txtBairro.setBounds(86, 263, 154, 39);
        
        JLabel lblCidade = new JLabel("Cidade");
        lblCidade.setBounds(30, 317, 46, 14);
        lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCidade.setForeground(new Color(84, 175, 230));
        
        MeuTextField txtCidade = new MeuTextField();
        txtCidade.setBounds(86, 307, 91, 39);
        
        MeuComboBox meuComboBox = new MeuComboBox();
        meuComboBox.setForeground(new Color(27, 156, 228));
        meuComboBox.setBounds(86, 357, 118, 39);
		meuComboBox.setModel(new DefaultComboBoxModel(new String[] {"Estado", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		
		MeuBotao btnLimpa = new MeuBotao();
		btnLimpa.setBounds(41, 429, 95, 49);
		btnLimpa.setText("Limpar");
		btnLimpa.setForeground(Color.WHITE);
		btnLimpa.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnCadastrar = new MeuBotao();
		btnCadastrar.setBounds(294, 429, 186, 49);
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(24, 62, 159));
		
		//Métodos de ações
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(txtCEP.getText().equals("")) {
        			JOptionPane.showMessageDialog(null, "CEP não digitado");
        			txtCEP.requestFocus();
        		} else {
        			buscaCEP();
        		}
        	}
        });
		
		MeuTextField txtNumero = new MeuTextField();
		txtNumero.setForeground(new Color(27, 156, 228));
		txtNumero.setBounds(419, 308, 186, 39);
		
		JLabel lblNumero = new JLabel("Número");
		lblNumero.setBounds(419, 288, 44, 14);
		lblNumero.setForeground(new Color(84, 175, 230));
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		MeuTextField txtComple = new MeuTextField();
		txtComple.setForeground(new Color(27, 156, 228));
		txtComple.setBounds(419, 353, 186, 39);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(369, 363, 44, 14);
		lblComplemento.setForeground(new Color(84, 175, 230));
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		MeuTextField txtCPF = new MeuTextField();
		txtCPF.setForeground(new Color(27, 156, 228));
		txtCPF.setBounds(365, 169, 154, 39);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(41, 143, 20, 14);
		lblCPF.setForeground(new Color(84, 175, 230));
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCPF.setBackground(Color.WHITE);
		
		MeuTextField txtNome = new MeuTextField();
		txtNome.setForeground(new Color(27, 156, 228));
		txtNome.setBounds(259, 247, 154, 39);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(208, 143, 32, 14);
		lblNome.setForeground(new Color(84, 175, 230));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBackground(Color.WHITE);
		
		MeuTextField txtEmail = new MeuTextField();
		txtEmail.setForeground(new Color(27, 156, 228));
		txtEmail.setBounds(451, 247, 154, 39);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(545, 163, 44, 14);
		lblEmail.setForeground(new Color(84, 175, 230));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		contentPane.add(btnLimpa);
		contentPane.add(btnCadastrar);
		contentPane.add(txtCPF);
		contentPane.add(lblCPF);
		contentPane.add(lblNome);
		contentPane.add(txtNome);
		contentPane.add(lblRua);
		contentPane.add(txtRua);
		contentPane.add(lblBairro);
		contentPane.add(txtBairro);
		contentPane.add(lblCidade);
		contentPane.add(txtCidade);
		contentPane.add(meuComboBox);
		contentPane.add(lblCEP);
		contentPane.add(txtCEP);
		contentPane.add(btnBuscar);
		contentPane.add(lblComplemento);
		contentPane.add(txtNumero);
		contentPane.add(lblNumero);
		contentPane.add(txtComple);
		contentPane.add(txtEmail);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setForeground(new Color(27, 156, 228));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel.setBounds(115, 26, 148, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/img/imgCadastro 1.png")));
		lblNewLabel_1.setBounds(30, 11, 75, 75);
		contentPane.add(lblNewLabel_1);
		
		MeuComboBox meuComboBox_1 = new MeuComboBox();
		meuComboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Plano de Saúde"}));
		meuComboBox_1.setForeground(new Color(27, 156, 228));
		meuComboBox_1.setBounds(439, 37, 138, 39);
		contentPane.add(meuComboBox_1);
	}
	
	private void buscaCEP() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCEP.getText();
		System.out.println(cep);
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep="+ cep +"&formato=xml");
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
				/*if (element.getQualifiedName().equals("uf")) {
					cboUF.setSelectedItem(element.getText());
				} */
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				/*if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));
					} else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
					}
				} */
			}
			txtRua.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
