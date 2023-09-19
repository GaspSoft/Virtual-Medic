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

public class TelaDetalhesPaciente extends JFrame {

	private JPanel contentPane;
	private MeuTextField txtCEP;
	private MeuTextField txtComplemento;
	private MeuTextField txtBairro;
	private MeuTextField txtCidade;
	private MeuTextField txtRua;
	private MeuTextField txtNumero;
	private MeuComboBox cboUF;
	//private JComboBox cboUF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDetalhesPaciente frame = new TelaDetalhesPaciente(null);
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
	public TelaDetalhesPaciente(Paciente paciente) {
		setTitle("Cadastro de paciente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDetalhesPaciente.class.getResource("/img/favicon-32x32.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 655, 970);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCEP.setForeground(new Color(84, 175, 230));
		lblCEP.setBackground(new Color(255, 255, 255));
        
        JLabel lblRua = new JLabel("Rua");
        lblRua.setForeground(new Color(84, 175, 230));
        lblRua.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        txtRua = new MeuTextField();
        txtRua.setEditable(false);
        txtRua.setText(paciente.getRua());
        txtRua.setForeground(new Color(27, 156, 228));
        
        JLabel lblBairro = new JLabel("Bairro");
        lblBairro.setForeground(new Color(84, 175, 230));
        lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        txtBairro = new MeuTextField();
        txtBairro.setEditable(false);
        txtBairro.setText(paciente.getBairro());
        txtBairro.setForeground(new Color(27, 156, 228));
        
        JLabel lblCidade = new JLabel("Cidade");
        lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCidade.setForeground(new Color(84, 175, 230));
        
        txtCidade = new MeuTextField();
        txtCidade.setForeground(new Color(27, 156, 228));
        txtCidade.setEditable(false);
        txtCidade.setText(paciente.getCidade());
        
        cboUF = new MeuComboBox();
        cboUF.setEditable(false);
        cboUF.setForeground(new Color(27, 156, 228));
		cboUF.setModel(new DefaultComboBoxModel(new String[] {"Estado", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		
		txtNumero = new MeuTextField();
		txtNumero.setEditable(false);
		txtNumero.setText(paciente.getNumero().toString());
		txtNumero.setForeground(new Color(27, 156, 228));
		
		JLabel lblNumero = new JLabel("Número");
		lblNumero.setForeground(new Color(84, 175, 230));
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtComplemento = new MeuTextField();
		txtComplemento.setEditable(false);
		txtComplemento.setText(paciente.getComplemento().toString());
		txtComplemento.setForeground(new Color(27, 156, 228));
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setForeground(new Color(84, 175, 230));
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		MeuTextField txtCPF = new MeuTextField();
		txtCPF.setEditable(false);
		txtCPF.setText(paciente.getCpf().toString());
		txtCPF.setForeground(new Color(27, 156, 228));
		
		txtCEP = new MeuTextField();
		txtCEP.setEditable(false);
		txtCEP.setText(paciente.getCep().toString());
		txtCEP.setForeground(new Color(27, 156, 228));
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setForeground(new Color(84, 175, 230));
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCPF.setBackground(Color.WHITE);
		
		MeuTextField txtNome = new MeuTextField();
		txtNome.setEditable(false);
		txtNome.setText(paciente.getNome());
		txtNome.setForeground(new Color(27, 156, 228));
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(84, 175, 230));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBackground(Color.WHITE);
		
		MeuTextField txtEmail = new MeuTextField();
		txtEmail.setEditable(false);
		txtEmail.setText(paciente.getEmail());
		txtEmail.setForeground(new Color(27, 156, 228));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(84, 175, 230));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBackground(Color.WHITE);
		
		MeuComboBox cboGenero = new MeuComboBox();
		cboGenero.setEditable(false);
		cboGenero.setModel(new DefaultComboBoxModel(new String[] {"Gênero", "Cisgênero", "Transgênero", "Não binário"}));
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
		
		DAOplanoSaude planoDAO = new DAOplanoSaude();
		ArrayList<PlanoSaude> listaPlanoSaude = planoDAO.listar();
		
		MeuComboBox cboPlanoSaude = new MeuComboBox();
		cboPlanoSaude.setEditable(false);
		cboPlanoSaude.addItem("Plano de Saúde");
		if(listaPlanoSaude.size() > 0 && listaPlanoSaude != null) {
			for (PlanoSaude planoSaude : listaPlanoSaude) {
				cboPlanoSaude.addItem((planoSaude));
			}
		}
		cboPlanoSaude.setForeground(new Color(27, 156, 228));
		
		MeuTextField txtNumeroPlano = new MeuTextField();
		txtNumeroPlano.setEditable(false);
		txtNumeroPlano.setText(paciente.getNumeroPlano().toString());
		txtNumeroPlano.setForeground(new Color(27, 156, 228));
		
		JLabel lblNmeroCarteirinha = new JLabel("Número Carteirinha");
		lblNmeroCarteirinha.setForeground(new Color(84, 175, 230));
		lblNmeroCarteirinha.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblValidade = new JLabel("Validade");
		lblValidade.setForeground(new Color(84, 175, 230));
		lblValidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		MeuTextField txtValidade = new MeuTextField();
		txtValidade.setEditable(false);
		txtValidade.setText(paciente.getValidade());
		txtValidade.setForeground(new Color(27, 156, 228));
		
		JPanel panelIdentificacao_1_1 = new JPanel();
		panelIdentificacao_1_1.setBackground(new Color(24, 62, 159));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Endereço");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 123, 122);
		panelTitulo.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(TelaDetalhesPaciente.class.getResource("/img/imgCadastro 1 (2).png")));
		
		JLabel lblNewLabel = new JLabel("Detalhes");
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
		
		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaDetalhesPaciente.class.getResource("/img/setaAzulEsquerda.png")));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBackground(new Color(24, 62, 159));
		
		DAOmedico medicoDAO = new DAOmedico();
		ArrayList<Medico> listaMedico = medicoDAO.listar();
		
		MeuComboBox cboMedico = new MeuComboBox();
		cboMedico.setEditable(false);
		cboMedico.addItem("Médico");
		if (listaMedico.size() > 0 && listaMedico != null) {
			for (Medico medico : listaMedico) {
				cboMedico.addItem((medico));
		}
		}
		cboMedico.setForeground(new Color(27, 156, 228));
		
		MeuTextField txtDiagnostico = new MeuTextField();
		txtDiagnostico.setEditable(false);
		txtDiagnostico.setForeground(new Color(27, 156, 228));
		txtDiagnostico.setText(paciente.getDiagnostico());
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
		
		JLabel lblDiagnstico = new JLabel("Diagnóstico");
		lblDiagnstico.setHorizontalAlignment(SwingConstants.LEFT);
		lblDiagnstico.setForeground(new Color(84, 175, 230));
		lblDiagnstico.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		MeuTextField txtIdade = new MeuTextField();
		txtIdade.setEditable(false);
		txtIdade.setText(paciente.getIdade().toString());
		txtIdade.setForeground(new Color(27, 156, 228));
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setForeground(new Color(84, 175, 230));
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdade.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panelTitulo, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
					.addGap(184)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panelIdentificacao, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addGap(349)
					.addComponent(lblCPF, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(207))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
					.addGap(29)
					.addComponent(txtCPF, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panelIdentificacao_1, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(cboMedico, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
					.addGap(32)
					.addComponent(txtDiagnostico, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panelIdentificacao_1_1, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblCEP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(589))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(txtCEP, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(cboUF, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(lblCidade, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(272)
					.addComponent(lblBairro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(270))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(txtCidade, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
					.addGap(21)
					.addComponent(txtBairro, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblRua, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(587))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(txtRua, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNumero, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(189)
					.addComponent(lblComplemento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(297))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(9)
					.addComponent(txtNumero, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(txtComplemento, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(274)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtIdade, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(cboGenero, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIdade, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
							.addGap(270))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(cboPlanoSaude, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblDiagnstico, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtValidade, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
									.addGap(10))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblValidade, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNmeroCarteirinha, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
									.addGap(74))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtNumeroPlano, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
									.addGap(3))))))
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
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(lblCPF))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmail)
						.addComponent(lblIdade))
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
						.addComponent(lblValidade))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(cboPlanoSaude, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValidade, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumeroPlano, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(lblDiagnstico)
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(cboMedico, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDiagnostico, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(panelIdentificacao_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblCEP)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboUF, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCidade)
						.addComponent(lblBairro))
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(lblRua)
					.addGap(11)
					.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNumero)
						.addComponent(lblComplemento))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListaPaciente telaListaPaciente = new TelaListaPaciente();
				telaListaPaciente.setVisible(true);
				telaListaPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
