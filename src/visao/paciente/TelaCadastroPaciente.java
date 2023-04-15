package visao.paciente;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import layoutPersonalizado.componentes.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParseException;
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
		setBounds(100, 100, 655, 907);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(30, 508, 46, 14);
		lblCEP.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCEP.setForeground(new Color(84, 175, 230));
		lblCEP.setBackground(new Color(255, 255, 255));
		
		txtCEP = new MeuTextField();
		txtCEP.setForeground(new Color(27, 156, 228));
		txtCEP.setBounds(30, 533, 475, 39);
        
        MeuBotao btnBuscar = new MeuBotao();
        btnBuscar.setBounds(515, 533, 95, 39);
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setBackground(new Color(24, 62, 159));
		btnBuscar.setText("Buscar");
        
        JLabel lblRua = new JLabel("Rua");
        lblRua.setBounds(234, 658, 46, 14);
        lblRua.setForeground(new Color(84, 175, 230));
        lblRua.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        MeuTextField txtRua = new MeuTextField();
        txtRua.setForeground(new Color(27, 156, 228));
        txtRua.setBounds(234, 683, 270, 39);
        
        JLabel lblBairro = new JLabel("Bairro");
        lblBairro.setBounds(30, 658, 46, 14);
        lblBairro.setForeground(new Color(84, 175, 230));
        lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        MeuTextField txtBairro = new MeuTextField();
        txtBairro.setForeground(new Color(27, 156, 228));
        txtBairro.setBounds(30, 683, 194, 39);
        
        JLabel lblCidade = new JLabel("Cidade");
        lblCidade.setBounds(30, 583, 46, 14);
        lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCidade.setForeground(new Color(84, 175, 230));
        
        MeuTextField txtCidade = new MeuTextField();
        txtCidade.setBounds(30, 608, 302, 39);
        
        MeuComboBox meuComboBox = new MeuComboBox();
        meuComboBox.setForeground(new Color(27, 156, 228));
        meuComboBox.setBounds(347, 608, 157, 40);
		meuComboBox.setModel(new DefaultComboBoxModel(new String[] {"Estado", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		
		MeuBotao btnLimpa = new MeuBotao();
		btnLimpa.setBounds(234, 808, 95, 49);
		btnLimpa.setText("Limpar");
		btnLimpa.setForeground(Color.WHITE);
		btnLimpa.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnCadastrar = new MeuBotao();
		btnCadastrar.setBounds(30, 808, 190, 49);
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
		txtNumero.setBounds(30, 758, 213, 39);
		
		JLabel lblNumero = new JLabel("Número");
		lblNumero.setBounds(30, 733, 44, 14);
		lblNumero.setForeground(new Color(84, 175, 230));
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		MeuTextField txtComple = new MeuTextField();
		txtComple.setForeground(new Color(27, 156, 228));
		txtComple.setBounds(259, 758, 245, 39);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(259, 733, 82, 14);
		lblComplemento.setForeground(new Color(84, 175, 230));
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		MeuTextField txtCPF = new MeuTextField();
		txtCPF.setForeground(new Color(27, 156, 228));
		txtCPF.setBounds(400, 188, 210, 40);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(400, 163, 20, 14);
		lblCPF.setForeground(new Color(84, 175, 230));
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCPF.setBackground(Color.WHITE);
		
		MeuTextField txtNome = new MeuTextField();
		txtNome.setForeground(new Color(27, 156, 228));
		txtNome.setBounds(30, 188, 360, 40);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(30, 163, 32, 14);
		lblNome.setForeground(new Color(84, 175, 230));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBackground(Color.WHITE);
		
		MeuTextField txtEmail = new MeuTextField();
		txtEmail.setForeground(new Color(27, 156, 228));
		txtEmail.setBounds(30, 262, 360, 39);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(30, 239, 44, 14);
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
		lblNewLabel.setBounds(95, 26, 148, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/img/imgCadastro 1.png")));
		lblNewLabel_1.setBounds(10, 11, 75, 75);
		contentPane.add(lblNewLabel_1);
		
		MeuComboBox cboGenero = new MeuComboBox();
		cboGenero.setModel(new DefaultComboBoxModel(new String[] {"Gênero"}));
		cboGenero.setForeground(new Color(27, 156, 228));
		cboGenero.setBounds(400, 262, 210, 40);
		contentPane.add(cboGenero);
		
		JPanel panelIdentificacao = new JPanel();
		panelIdentificacao.setBackground(new Color(24, 62, 159));
		panelIdentificacao.setBounds(10, 120, 615, 24);
		contentPane.add(panelIdentificacao);
		panelIdentificacao.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Identificação");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 0, 80, 25);
		panelIdentificacao.add(lblNewLabel_2);
		
		JPanel panelIdentificacao_1 = new JPanel();
		panelIdentificacao_1.setLayout(null);
		panelIdentificacao_1.setBackground(new Color(24, 62, 159));
		panelIdentificacao_1.setBounds(12, 312, 615, 24);
		contentPane.add(panelIdentificacao_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Convênio");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(10, 0, 80, 25);
		panelIdentificacao_1.add(lblNewLabel_2_1);
		
		MeuComboBox cboPlanoSaude = new MeuComboBox();
		cboPlanoSaude.setModel(new DefaultComboBoxModel(new String[] {"Plano de saúde"}));
		cboPlanoSaude.setForeground(new Color(27, 156, 228));
		cboPlanoSaude.setBounds(30, 347, 210, 40);
		contentPane.add(cboPlanoSaude);
		
		MeuTextField txtNumeroPlano = new MeuTextField();
		txtNumeroPlano.setForeground(new Color(27, 156, 228));
		txtNumeroPlano.setBounds(30, 423, 302, 40);
		contentPane.add(txtNumeroPlano);
		
		JLabel lblNmeroCarteirinha = new JLabel("Número Carteirinha");
		lblNmeroCarteirinha.setForeground(new Color(84, 175, 230));
		lblNmeroCarteirinha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNmeroCarteirinha.setBounds(30, 398, 110, 14);
		contentPane.add(lblNmeroCarteirinha);
		
		JLabel lblValidade = new JLabel("Validade");
		lblValidade.setForeground(new Color(84, 175, 230));
		lblValidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValidade.setBounds(347, 398, 54, 14);
		contentPane.add(lblValidade);
		
		MeuTextField txtValidade = new MeuTextField();
		txtValidade.setForeground(new Color(27, 156, 228));
		txtValidade.setBounds(342, 423, 268, 40);
		contentPane.add(txtValidade);
		
		JPanel panelIdentificacao_1_1 = new JPanel();
		panelIdentificacao_1_1.setLayout(null);
		panelIdentificacao_1_1.setBackground(new Color(24, 62, 159));
		panelIdentificacao_1_1.setBounds(10, 473, 615, 24);
		contentPane.add(panelIdentificacao_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Endereço");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1.setBounds(10, 0, 80, 25);
		panelIdentificacao_1_1.add(lblNewLabel_2_1_1);
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
