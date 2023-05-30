package visao.paciente;

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
import javax.swing.SwingConstants;

public class TelaCadastroPaciente extends JFrame {

	private JPanel contentPane;
	private MeuJFormatedTextField txtCEP;
	private MeuTextField txtComplemento;
	private MeuTextField txtBairro;
	private MeuTextField txtCidade;
	private MeuTextField txtRua;
	private MeuTextField txtNumero;
	private MeuComboBox cboUF;
	private Color corPadrao = new Color(24, 62, 159);
	private Color corPadraoBackground = new Color(255,255,255);
	private Color corSucesso = new Color(0,139,139);
	private Color corSucessoBackground = new Color(64,224,208);
	private Color corErro = new Color(178,34,34);
	private Color corErroBackground = new Color(250,128,114);
	private Color btnSucesso = new Color(92, 171, 109);
	private Color btnLimpar = new Color(186, 75, 71);
	// private JComboBox cboUF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPaciente frame = new TelaCadastroPaciente();
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
	public TelaCadastroPaciente() {
		setTitle("Cadastro de paciente");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaCadastroPaciente.class.getResource("/img/favicon-32x32.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 655, 1023);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCEP.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCEP.setForeground(new Color(84, 175, 230));
		lblCEP.setBackground(new Color(255, 255, 255));

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRua.setForeground(new Color(84, 175, 230));
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 11));

		txtRua = new MeuTextField();
		txtRua.setForeground(new Color(27, 156, 228));

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setForeground(new Color(84, 175, 230));
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));

		txtBairro = new MeuTextField();
		txtBairro.setForeground(new Color(27, 156, 228));

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setForeground(new Color(84, 175, 230));

		txtCidade = new MeuTextField();

		cboUF = new MeuComboBox();
		cboUF.setForeground(new Color(27, 156, 228));
		cboUF.setModel(new DefaultComboBoxModel(
				new String[] { "Estado", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG",
						"PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

		txtNumero = new MeuTextField();
		txtNumero.setForeground(new Color(27, 156, 228));

		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setHorizontalAlignment(SwingConstants.RIGHT);
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

		MeuTextField txtEmail = new MeuTextField();
		txtEmail.setForeground(new Color(27, 156, 228));

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(new Color(84, 175, 230));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBackground(Color.WHITE);

		MeuComboBox cboGenero = new MeuComboBox();
		cboGenero.setModel(
				new DefaultComboBoxModel(new String[] { "Gênero", "Cisgênero", "Transgênero", "Não binário" }));
		cboGenero.setForeground(new Color(27, 156, 228));

		JPanel panelIdentificacao = new JPanel();
		panelIdentificacao.setBackground(new Color(24, 62, 159));

		JLabel lblNewLabel_2 = new JLabel("Identificação");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));

		JPanel panelIdentificacao_1 = new JPanel();
		panelIdentificacao_1.setBackground(new Color(24, 62, 159));

		JLabel lblNewLabel_2_1 = new JLabel("Convênio");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		DAOplanoSaude planoDAO = DAOplanoSaude.getInstacia();
		ArrayList<PlanoSaude> listaPlanoSaude = planoDAO.listaPlanoSaude();

		MeuComboBox cboPlanoSaude = new MeuComboBox();
		cboPlanoSaude.addItem("Plano de Saúde");
		if (listaPlanoSaude.size() > 0 && listaPlanoSaude != null) {
			for (PlanoSaude planoSaude : listaPlanoSaude) {
				cboPlanoSaude.addItem((planoSaude));
			}
		}
		cboPlanoSaude.setForeground(new Color(27, 156, 228));

		MeuJFormatedTextField txtNumeroPlano = new MeuJFormatedTextField();
		txtNumeroPlano.setForeground(new Color(27, 156, 228));

		JLabel lblNmeroCarteirinha = new JLabel("Número Carteirinha:");
		lblNmeroCarteirinha.setForeground(new Color(84, 175, 230));
		lblNmeroCarteirinha.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValidade.setForeground(new Color(84, 175, 230));
		lblValidade.setFont(new Font("Tahoma", Font.BOLD, 11));

		MeuJFormatedTextField txtValidade = new MeuJFormatedTextField();
		txtValidade.setForeground(new Color(27, 156, 228));

		JPanel panelIdentificacao_1_1 = new JPanel();
		panelIdentificacao_1_1.setBackground(new Color(24, 62, 159));

		JLabel lblNewLabel_2_1_1 = new JLabel("Endereço");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		MeuBotao btnCadastrar = new MeuBotao();
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(btnSucesso);

		MeuBotao btnLimpa = new MeuBotao();
		btnLimpa.setText("Limpar");
		btnLimpa.setForeground(Color.WHITE);
		btnLimpa.setBackground(btnLimpar);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 123, 122);
		panelTitulo.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/img/imgCadastro 1 (2).png")));

		JLabel lblNewLabel = new JLabel("Cadastrar");
		lblNewLabel.setBounds(123, 0, 212, 122);
		panelTitulo.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(27, 156, 228));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		GroupLayout gl_panelIdentificacao_1 = new GroupLayout(panelIdentificacao_1);
		gl_panelIdentificacao_1.setHorizontalGroup(gl_panelIdentificacao_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdentificacao_1.createSequentialGroup().addGap(10).addComponent(lblNewLabel_2_1,
						GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)));
		gl_panelIdentificacao_1.setVerticalGroup(gl_panelIdentificacao_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE));
		panelIdentificacao_1.setLayout(gl_panelIdentificacao_1);
		GroupLayout gl_panelIdentificacao = new GroupLayout(panelIdentificacao);
		gl_panelIdentificacao.setHorizontalGroup(gl_panelIdentificacao.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdentificacao.createSequentialGroup().addGap(10).addComponent(lblNewLabel_2,
						GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)));
		gl_panelIdentificacao.setVerticalGroup(gl_panelIdentificacao.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE));
		panelIdentificacao.setLayout(gl_panelIdentificacao);

		txtCEP = new MeuJFormatedTextField();

		MeuBotao btnBuscar = new MeuBotao();
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setText("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(24, 62, 159));

		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/img/setaAzulEsquerda.png")));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBackground(new Color(24, 62, 159));

		DAOmedico medicoDAO = DAOmedico.getInstacia();
		ArrayList<Medico> listaMedico = medicoDAO.listaMedico();

		MeuComboBox cboMedico = new MeuComboBox();
		cboMedico.addItem("Médico");
		if (listaMedico.size() > 0 && listaMedico != null) {
			for (Medico medico : listaMedico) {
				cboMedico.addItem((medico));
			}
		}

		if (listaPlanoSaude.size() > 0 && listaPlanoSaude != null) {
			for (PlanoSaude planoSaude : listaPlanoSaude) {
				cboPlanoSaude.addItem((planoSaude));
			}
		}
		cboMedico.setForeground(new Color(27, 156, 228));

		MeuTextField txtDiagnostico = new MeuTextField();
		txtDiagnostico.setForeground(new Color(27, 156, 228));
		GroupLayout gl_panelIdentificacao_1_1 = new GroupLayout(panelIdentificacao_1_1);
		gl_panelIdentificacao_1_1.setHorizontalGroup(gl_panelIdentificacao_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdentificacao_1_1.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(519, Short.MAX_VALUE)));
		gl_panelIdentificacao_1_1.setVerticalGroup(gl_panelIdentificacao_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdentificacao_1_1.createSequentialGroup()
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelIdentificacao_1_1.setLayout(gl_panelIdentificacao_1_1);

		// Uso da biblioteca Atxy2k para validação
		RestrictedTextField validarCEP = new RestrictedTextField(txtCEP);
		validarCEP.setOnlyNums(true);
		validarCEP.setLimit(8);

		RestrictedTextField validarCPF = new RestrictedTextField(txtCPF);

		JLabel lblDiagnstico = new JLabel("Diagnóstico:");
		lblDiagnstico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiagnstico.setForeground(new Color(84, 175, 230));
		lblDiagnstico.setFont(new Font("Tahoma", Font.BOLD, 11));

		MeuTextField txtIdade = new MeuTextField();
		txtIdade.setForeground(new Color(27, 156, 228));

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setForeground(new Color(84, 175, 230));
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdade.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_1 = new JLabel("*");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_2 = new JLabel("*");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_2.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_3 = new JLabel("*");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_4 = new JLabel("*");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_4.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_5 = new JLabel("*");
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_5.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_6 = new JLabel("*");
		lblNewLabel_3_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_6.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_7 = new JLabel("*");
		lblNewLabel_3_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_7.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_8 = new JLabel("*");
		lblNewLabel_3_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_8.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_9 = new JLabel("*");
		lblNewLabel_3_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_9.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_10 = new JLabel("*");
		lblNewLabel_3_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_10.setForeground(Color.RED);
		
		JLabel lblNewLabel_3_11 = new JLabel("*");
		lblNewLabel_3_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_11.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panelTitulo, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
					.addGap(184)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panelIdentificacao, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNome)
					.addGap(4)
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCPF, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(lblNewLabel_3_1, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
					.addGap(29)
					.addComponent(txtCPF, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panelIdentificacao_1, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(cboMedico, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addGap(32)
					.addComponent(txtDiagnostico, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panelIdentificacao_1_1, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCEP, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_7, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(txtCEP, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
					.addGap(16)
					.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(cboUF, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_8, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
					.addGap(6)
					.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(lblNewLabel_3_9, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(txtCidade, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
					.addGap(21)
					.addComponent(txtBairro, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRua, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_10, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(txtRua, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_11, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblComplemento, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addGap(297))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(9)
					.addComponent(txtNumero, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(txtComplemento, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLimpa, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(cboPlanoSaude, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(txtValidade, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblValidade, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3_4, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtNumeroPlano, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
							.addGap(3))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNmeroCarteirinha)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3_5, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3_2, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
							.addGap(5)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtIdade, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(cboGenero, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIdade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3_3, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDiagnstico, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3_6, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
					.addContainerGap())
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
					.addGap(80)
					.addComponent(panelIdentificacao, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNome)
							.addComponent(lblNewLabel_3))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCPF)
							.addComponent(lblNewLabel_3_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEmail)
							.addComponent(lblNewLabel_3_2))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblIdade)
							.addComponent(lblNewLabel_3_3)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cboGenero, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panelIdentificacao_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNmeroCarteirinha)
						.addComponent(lblValidade)
						.addComponent(lblNewLabel_3_4)
						.addComponent(lblNewLabel_3_5))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(cboPlanoSaude, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValidade, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumeroPlano, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiagnstico)
						.addComponent(lblNewLabel_3_6))
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(cboMedico, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDiagnostico, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(panelIdentificacao_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCEP)
						.addComponent(lblNewLabel_3_7))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboUF, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblBairro)
							.addComponent(lblNewLabel_3_9))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCidade)
							.addComponent(lblNewLabel_3_8)))
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRua)
						.addComponent(lblNewLabel_3_10))
					.addGap(11)
					.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNumero)
							.addComponent(lblNewLabel_3_11))
						.addComponent(lblComplemento))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLimpa, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		validarCPF.setOnlyNums(true);
		validarCPF.setLimit(11);

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCEP.getText().equals("")) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o CEP!", "Informe o CEP", corPadrao, corPadraoBackground);
					telaSucesso.setVisible(true);
					txtCEP.requestFocus();
				} else {
					buscaCEP();
				}
			}
		});

		btnLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCPF.setText("");
				txtNome.setText("");
				txtEmail.setText("");
				txtIdade.setText("");
				txtDiagnostico.setText("");
				txtNumeroPlano.setText("");
				txtValidade.setText("");
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
				Paciente p = new Paciente();

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
				} else if (cboMedico.getSelectedItem().toString().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o Médico!", "Informe o Médico", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					cboMedico.requestFocus();
				} else if (txtDiagnostico.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o Diagnóstico!", "Informe o Diagnóstico", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtDiagnostico.requestFocus();
				} else if (cboPlanoSaude.getSelectedItem().toString().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o Médico!", "Informe o Médico",corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					cboPlanoSaude.requestFocus();
				} else if (txtNumeroPlano.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o Número do Plano!", "Informe o Número do Plano", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtNumeroPlano.requestFocus();
				} else if (txtValidade.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe a Validade!", "Informe a Validade",corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtValidade.requestFocus();
					String validade = txtValidade.getText();
				} else if(txtCEP.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o CEP!", "Informe o CEP", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtCEP.requestFocus();
				} else if(cboUF.getSelectedItem().toString().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o UF!", "Informe o UF",corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					cboUF.requestFocus();
				} else if(txtCidade.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe a Cidade!", "Informe a Cidade",corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtCidade.requestFocus();
				} else if(txtBairro.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe o Bairro!", "Informe o Bairro", corPadrao, corPadraoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
					txtBairro.requestFocus();
				} else if(txtRua.getText().isEmpty()) {
					TelaMensagem telaSucesso = new TelaMensagem("Informe a Rua!", "Informe a Rua",corPadrao, corPadraoBackground);
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
				String medico = cboMedico.getSelectedItem().toString();
				String diagnostico = txtDiagnostico.getText();
				String planoSaude = cboPlanoSaude.getSelectedItem().toString();
				Long numeroPlano = Long.parseLong(txtNumeroPlano.getText());
				String validade = txtValidade.getText();
				String cep = txtCEP.getText();
				String uf = cboUF.getSelectedItem().toString();
				String cidade = txtCidade.getText();
				String bairro = txtBairro.getText();
				String rua = txtRua.getText();
				Integer numero = Integer.valueOf(txtNumero.getText());
				Integer complemento = Integer.valueOf(txtComplemento.getText());

				p.setCpf(cpf);
				p.setNome(nome);
				p.setEmail(email);
				p.setIdade(idade);
				p.setGenero(genero);
				p.setMedico(medico);
				p.setDiagnostico(diagnostico);
				p.setPlanoSaude(planoSaude);
				p.setNumeroPlano(numeroPlano);
				p.setValidade(validade);
				p.setCep(cep);
				p.setUf(uf);
				p.setCidade(cidade);
				p.setBairro(bairro);
				p.setRua(rua);
				p.setNumero(numero);
				p.setComplemento(complemento);

				DAOpaciente daoPaciente = DAOpaciente.getInstacia();
				Boolean inserir = daoPaciente.inserir(p);
				if (inserir) {
					TelaMensagem telaSucesso = new TelaMensagem(nome + ", cadastrado com sucesso!", "Cadastro paciente concluído", corSucesso, corSucessoBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
				} else {
					TelaMensagem telaSucesso = new TelaMensagem("Não foi possível cadastrar o paciente!", "Erro no cadastro do paciente", corErro, corErroBackground);
					telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
				}
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMenuPaciente telaMenuPaciente = new TelaMenuPaciente();
				telaMenuPaciente.setVisible(true);
				telaMenuPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
			}
			txtRua.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
