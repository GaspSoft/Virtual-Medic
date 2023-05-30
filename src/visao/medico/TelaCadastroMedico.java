package visao.medico;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import layoutPersonalizado.componentes.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
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
import net.miginfocom.swing.MigLayout;
import visao.TelaMensagem;
import controle.*;
import modelo.*;
import javax.swing.JTextArea;

public class TelaCadastroMedico extends JFrame {

	private JPanel contentPane;
	private MeuTextField txtCEP;
	private MeuTextField txtComplemento;
	private MeuTextField txtBairro;
	private MeuTextField txtCidade;
	private MeuTextField txtRua;
	private MeuComboBox cboUF;
	private Color corPadrao = new Color(24, 62, 159);
	private Color corPadraoBackground = new Color(255,255,255);
	private Color corSucesso = new Color(0,139,139);
	private Color corSucessoBackground = new Color(64,224,208);
	private Color corErro = new Color(178,34,34);
	private Color corErroBackground = new Color(250,128,114);
	//private JComboBox cboUF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroMedico frame = new TelaCadastroMedico();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		setTitle("Cadastro de Médico");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroMedico.class.getResource("/img/favicon-32x32.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 933);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCEP.setForeground(new Color(84, 175, 230));
		lblCEP.setBackground(new Color(255, 255, 255));
        
        JLabel lblRua = new JLabel("Rua:");
        lblRua.setForeground(new Color(84, 175, 230));
        lblRua.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        MeuTextField txtRua = new MeuTextField();
        txtRua.setForeground(new Color(27, 156, 228));
        
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setForeground(new Color(84, 175, 230));
        lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        MeuTextField txtBairro = new MeuTextField();
        txtBairro.setForeground(new Color(27, 156, 228));
        
        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCidade.setForeground(new Color(84, 175, 230));
        
        MeuTextField txtCidade = new MeuTextField();
        
        MeuComboBox cboUF = new MeuComboBox();
        cboUF.setForeground(new Color(27, 156, 228));
		cboUF.setModel(new DefaultComboBoxModel(new String[] {"Estado", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		
		MeuTextField txtNumero = new MeuTextField();
		txtNumero.setForeground(new Color(27, 156, 228));
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setForeground(new Color(84, 175, 230));
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtComplemento = new MeuTextField();
		txtComplemento.setForeground(new Color(27, 156, 228));
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setForeground(new Color(84, 175, 230));
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		MeuTextField txtCPF = new MeuTextField();
		txtCPF.setForeground(new Color(27, 156, 228));
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setForeground(new Color(84, 175, 230));
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCPF.setBackground(Color.WHITE);
		
		MeuTextField txtNome = new MeuTextField();

		txtNome.setForeground(new Color(27, 156, 228));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(84, 175, 230));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBackground(Color.WHITE);
		
		MeuTextField txtIdade = new MeuTextField();
		txtIdade.setForeground(new Color(27, 156, 228));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(84, 175, 230));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBackground(Color.WHITE);
		
		MeuComboBox cboGenero = new MeuComboBox();
		cboGenero.setModel(new DefaultComboBoxModel(new String[] {"Gênero", "Cisgênero", "Transgênero", "Não binário"}));
		cboGenero.setForeground(new Color(27, 156, 228));
		
		JPanel panelIdentificacao = new JPanel();
		panelIdentificacao.setBackground(new Color(24, 62, 159));
		
		JLabel lblNewLabel_2 = new JLabel("Identificação:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		JPanel panelIdentificacao_1 = new JPanel();
		panelIdentificacao_1.setBackground(new Color(24, 62, 159));
		
		JLabel lblNewLabel_2_1 = new JLabel("Convênio:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		DAOplanoSaude planoDAO = DAOplanoSaude.getInstacia();
		ArrayList<PlanoSaude> listaPlanoSaude = planoDAO.listaPlanoSaude();
		
		JLabel lblNmeroCarteirinha = new JLabel("CRM:");
		lblNmeroCarteirinha.setForeground(new Color(84, 175, 230));
		lblNmeroCarteirinha.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblValidade = new JLabel("Especialidade:");
		lblValidade.setForeground(new Color(84, 175, 230));
		lblValidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panelIdentificacao_1_1 = new JPanel();
		panelIdentificacao_1_1.setBackground(new Color(24, 62, 159));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Endereço:");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		MeuBotao btnCadastrar = new MeuBotao();
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnLimpa = new MeuBotao();
		btnLimpa.setText("Limpar");
		btnLimpa.setForeground(Color.WHITE);
		btnLimpa.setBackground(new Color(24, 62, 159));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 123, 122);
		panelTitulo.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(TelaCadastroMedico.class.getResource("/img/imgCadastro 1 (2).png")));
		
		JLabel lblNewLabel = new JLabel("Cadastrar");
		lblNewLabel.setBounds(123, 0, 212, 122);
		panelTitulo.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(27, 156, 228));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		GroupLayout gl_panelIdentificacao_1 = new GroupLayout(panelIdentificacao_1);
		gl_panelIdentificacao_1.setHorizontalGroup(
			gl_panelIdentificacao_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdentificacao_1.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelIdentificacao_1.setVerticalGroup(
			gl_panelIdentificacao_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		);
		panelIdentificacao_1.setLayout(gl_panelIdentificacao_1);
		GroupLayout gl_panelIdentificacao = new GroupLayout(panelIdentificacao);
		gl_panelIdentificacao.setHorizontalGroup(
			gl_panelIdentificacao.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdentificacao.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelIdentificacao.setVerticalGroup(
			gl_panelIdentificacao.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		);
		panelIdentificacao.setLayout(gl_panelIdentificacao);
		
		txtCEP = new MeuTextField();
		
		MeuBotao btnBuscar = new MeuBotao();
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setText("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaCadastroMedico.class.getResource("/img/setaAzulEsquerda.png")));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBackground(new Color(24, 62, 159));		
		
		MeuTextField txtEspecialidade = new MeuTextField();
		txtEspecialidade.setForeground(new Color(27, 156, 228));
		GroupLayout gl_panelIdentificacao_1_1 = new GroupLayout(panelIdentificacao_1_1);
		gl_panelIdentificacao_1_1.setHorizontalGroup(
			gl_panelIdentificacao_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdentificacao_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(519, Short.MAX_VALUE))
		);
		gl_panelIdentificacao_1_1.setVerticalGroup(
			gl_panelIdentificacao_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdentificacao_1_1.createSequentialGroup()
					.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelIdentificacao_1_1.setLayout(gl_panelIdentificacao_1_1);
		
		
		// Uso da biblioteca Atxy2k para validação
		RestrictedTextField validarCEP = new RestrictedTextField(txtCEP);
		validarCEP.setOnlyNums(true);
		validarCEP.setLimit(8);
		
		RestrictedTextField validarCPF = new RestrictedTextField(txtCPF);
		
		MeuTextField txtCRM = new MeuTextField();
		txtCRM.setForeground(new Color(27, 156, 228));
		
		MeuTextField txtEmail = new MeuTextField();
		txtEmail.setForeground(new Color(27, 156, 228));
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setForeground(new Color(84, 175, 230));
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdade.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_3_1 = new JLabel("*");
		lblNewLabel_3_1.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_4 = new JLabel("*");
		lblNewLabel_3_4.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_5 = new JLabel("*");
		lblNewLabel_3_5.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_6 = new JLabel("*");
		lblNewLabel_3_6.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_7 = new JLabel("*");
		lblNewLabel_3_7.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_8 = new JLabel("*");
		lblNewLabel_3_8.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_9 = new JLabel("*");
		lblNewLabel_3_9.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_10 = new JLabel("*");
		lblNewLabel_3_10.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("*");
		lblNewLabel_3_1_1.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("*");
		lblNewLabel_3_1_2.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("*");
		lblNewLabel_3_1_3.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_1_4 = new JLabel("*");
		lblNewLabel_3_1_4.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panelTitulo, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
					.addGap(184)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(4))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panelIdentificacao, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
					.addGap(4))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_1_1, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCPF)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_1, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(9)
					.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(txtCPF, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
					.addGap(16))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtIdade, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblEmail)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3_1_3, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
							.addGap(348)))
					.addComponent(cboGenero, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
					.addGap(14))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
					.addGap(14))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panelIdentificacao_1, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
					.addGap(4))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblValidade)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_4, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNmeroCarteirinha)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_5, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(txtEspecialidade, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
					.addGap(22)
					.addComponent(txtCRM, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addGap(4))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panelIdentificacao_1_1, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
					.addGap(4))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(txtCEP, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
					.addGap(6)
					.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(cboUF, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
					.addGap(14))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblCidade)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_9, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblBairro)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_6, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(9)
					.addComponent(txtCidade, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addGap(15)
					.addComponent(txtBairro, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
					.addGap(11))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(txtRua, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNumero)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_7, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblComplemento)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_1_4, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(9)
					.addComponent(txtNumero, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(txtComplemento, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
					.addGap(4))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(224)
					.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLimpa, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addGap(223))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblRua)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_8, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(598, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblCEP)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_10, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(599, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblIdade)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_1_2, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(587, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelTitulo, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addComponent(panelIdentificacao, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(lblNewLabel_3_1_1)
						.addComponent(lblNewLabel_3_1)
						.addComponent(lblCPF))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdade)
						.addComponent(lblNewLabel_3_1_2))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail)
								.addComponent(lblNewLabel_3_1_3)))
						.addComponent(cboGenero, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panelIdentificacao_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblValidade)
							.addComponent(lblNewLabel_3_4))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNmeroCarteirinha)
							.addComponent(lblNewLabel_3_5)))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtEspecialidade, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCRM, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(panelIdentificacao_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCEP)
						.addComponent(lblNewLabel_3_10))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboUF, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3_6, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblBairro))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCidade)
							.addComponent(lblNewLabel_3_9)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRua)
						.addComponent(lblNewLabel_3_8))
					.addGap(11)
					.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblComplemento)
							.addComponent(lblNewLabel_3_1_4))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNumero)
							.addComponent(lblNewLabel_3_7)))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLimpa, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		validarCPF.setOnlyNums(true);
		validarCPF.setLimit(11);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCEP.getText().equals("")) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o CEP!", "Informe o CEP", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtCEP.requestFocus();
				} else {
					buscaCEP();
				}
			}
		});
		
		btnLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtCPF.setText("");
				txtEmail.setText("");
				txtIdade.setText("");
				txtCRM.setText("");
				txtEspecialidade.setText("");
				txtCEP.setText("");
				txtCidade.setText("");
				txtBairro.setText("");
				txtRua.setText("");
				txtNumero.setText("");
				txtComplemento.setText("");
			}
		});
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medico m = new Medico();
				
				if(txtCPF.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o CPF!", "Informe o CPF", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtCPF.requestFocus();
				} else if(txtNome.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o Nome!", "Informe o Nome", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtNome.requestFocus();
				} else if(txtEmail.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o Email!", "Informe o Email", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtEmail.requestFocus();
				} else if(txtIdade.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe a Idade!", "Informe a Idade", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtIdade.requestFocus();
				} else if(cboGenero.getSelectedItem().toString().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o Gênero!", "Informe o Gênero", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					cboGenero.requestFocus();
				} else if(txtCRM.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o CRM!", "Informe o CRM", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					cboGenero.requestFocus();
				} else if(txtEspecialidade.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe a Especialidade!", "Informe a Especialidade", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					cboGenero.requestFocus();
				} else if(txtCEP.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o CEP!", "Informe o CEP", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtCEP.requestFocus();
				} else if(cboUF.getSelectedItem().toString().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o UF!", "Informe o UF", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					cboUF.requestFocus();
				} else if(txtCidade.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe a Cidade!", "Informe a Cidade", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtCidade.requestFocus();
				} else if(txtBairro.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o Bairro!", "Informe o Bairro", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtBairro.requestFocus();
				} else if(txtRua.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe a Rua!", "Informe a Rua", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtRua.requestFocus();
				} else if(txtNumero.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o Número da residência!", "Informe o Número da residência", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtNumero.requestFocus();
				}
				
				Long cpf = Long.parseLong(txtCPF.getText());
				String nome = txtNome.getText();
				String email = txtEmail.getText();
				Integer idade = Integer.valueOf(txtIdade.getText());
				String genero = cboGenero.getSelectedItem().toString();
				Long crm = Long.parseLong(txtCRM.getText());
				String especialidade = txtEspecialidade.getText();
				String cep = txtCEP.getText();
				String uf = cboUF.getSelectedItem().toString();
				String cidade = txtCidade.getText();
				String bairro = txtBairro.getText();
				String rua = txtRua.getText();
				Integer numero = Integer.valueOf(txtNumero.getText());
				Integer complemento = Integer.valueOf(txtComplemento.getText());
				
				m.setCpf(cpf);
				m.setNome(nome);
				m.setEmail(email);
				m.setIdade(idade);
				m.setGenero(genero);
				m.setCrm(crm);
				m.setEspecificacao(especialidade);
				m.setCep(cep);
				m.setUf(uf);
				m.setCidade(cidade);
				m.setBairro(bairro);
				m.setRua(rua);
				m.setNumero(numero);
				m.setComplemento(complemento);
				
				DAOmedico daoMedico = DAOmedico.getInstacia();
				Boolean inserir = daoMedico.inserir(m);
				if (inserir) {
					TelaMensagem telaSucesso = new TelaMensagem(nome + " cadastrado com sucesso!", "Cadastro realizado", corSucesso, corSucessoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
				} else {
					TelaMensagem telaSucesso = new TelaMensagem("Não foi possível cadastrar o médico!", "Erro ao cadastrar", corErro, corErroBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
				}
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMenuMedico telaMenuMedico = new TelaMenuMedico();
				telaMenuMedico.setVisible(true);
				telaMenuMedico.setExtendedState(MAXIMIZED_BOTH);
			}
		});
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
				if (element.getQualifiedName().equals("uf")) {
					cboUF.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
			}
			txtRua.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
