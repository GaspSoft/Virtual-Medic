package visao.medico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import controle.DAOmedico;
import modelo.Medico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastroMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtCRM;
	private JTextField txtEspeci;
	private JTextField txtEmail;
	private JTable table;
	private DefaultTableModel modelo;
	private DAOmedico dao;
	private JTextField txtCEP;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JComboBox cboUF;

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
		setTitle("Cadastro Médico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(94, 163, 189));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Source Code Pro", Font.BOLD, 14));

		JLabel lblCRM = new JLabel("CRM:");
		lblCRM.setFont(new Font("Source Code Pro", Font.BOLD, 14));

		JLabel lblEspeci = new JLabel("Especialidade:");
		lblEspeci.setFont(new Font("Source Code Pro", Font.BOLD, 14));

		txtNome = new JTextField();
		txtNome.setColumns(10);

		txtCPF = new JTextField();
		txtCPF.setColumns(10);

		txtCRM = new JTextField();
		txtCRM.setColumns(10);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Source Code Pro", Font.BOLD, 14));

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Source Code Pro", Font.BOLD, 14));

		txtEspeci = new JTextField();
		txtEspeci.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		JScrollPane tabelaMedico = new JScrollPane();

		JButton btnCadastar = new JButton("Cadastrar");
		btnCadastar.setForeground(new Color(255, 0, 0));
		btnCadastar.setBackground(new Color(0, 0, 0));
		btnCadastar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOmedico medicoDao = new DAOmedico();
				ArrayList<Medico> listaMedico = medicoDao.listaMedico();
				Medico m = new Medico();

				String nome = txtNome.getText();
				String cpf = txtCPF.getText();
				String crm = txtCRM.getText();
				String especialidade = txtEspeci.getText();
				String email = txtEmail.getText();

				m.setCpf(Long.valueOf(cpf));
				m.setNome(nome);
				m.setCrm(Integer.valueOf(crm));
				m.setEmail(email);
				m.setEspecificacao(especialidade);

				DAOmedico dao = DAOmedico.getInstacia();
				Boolean inserir = dao.inserir(m);
				if (inserir == true) {
					JOptionPane.showMessageDialog(null, "Sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro!");
				}

				atualizaJTable(modelo, table, tabelaMedico);
			}
		});

		modelo = new DefaultTableModel();
		modelo.addColumn("CPF");
		modelo.addColumn("Nome");
		modelo.addColumn("CRM");
		modelo.addColumn("Especialidade");
		modelo.addColumn("Email");

		DAOmedico m = DAOmedico.getInstacia();
		ArrayList<Medico> listaMedicos = m.listaMedico();
		for (Medico medico : listaMedicos) {
			modelo.addRow(new Object[] { medico.getCpf(), medico.getNome(), medico.getCrm(), medico.getEspecificacao(),
					medico.getEmail() });
		}

		atualizaJTable(modelo, table, tabelaMedico);
		
		txtCEP = new JTextField();
		txtCEP.setBackground(new Color(255, 128, 64));
		txtCEP.setForeground(new Color(255, 0, 0));
		txtCEP.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblEmail_1_1 = new JLabel("UF");
		lblEmail_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblEmail_1_1_1 = new JLabel("Cidade:");
		lblEmail_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblEmail_1_1_2 = new JLabel("Bairro");
		lblEmail_1_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JComboBox cboUF = new JComboBox();
		cboUF.setModel(new DefaultComboBoxModel(new String[] {"Estado", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES ", "GO ", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		
		JLabel lblEmail_1_1_2_1 = new JLabel("Rua");
		lblEmail_1_1_2_1.setFont(new Font("Dialog", Font.BOLD, 14));
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		
		JLabel lblEmail_1_1_2_1_1 = new JLabel("Numero");
		lblEmail_1_1_2_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnBuscarCEP = new JButton("Buscar");
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
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabelaMedico, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(214)
					.addComponent(btnCadastar, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
					.addGap(239))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEmail_1_1_2_1_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblEmail_1_1_2_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEmail_1_1_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblEmail_1_1_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblEmail_1_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblCPF, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblCRM, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblEspeci)
														.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
													.addGap(19))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
													.addGap(36)))))))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
											.addComponent(txtCRM, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
											.addComponent(txtCPF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
											.addComponent(txtEspeci, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
											.addComponent(txtEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
											.addComponent(txtCEP, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
											.addComponent(txtCidade, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnBuscarCEP)
										.addGap(92)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(cboUF, 0, 0, Short.MAX_VALUE)
									.addGap(278))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCPF))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(53)
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCRM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCRM))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEspeci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEspeci))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEmail)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscarCEP))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboUF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail_1_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail_1_1_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail_1_1_2_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail_1_1_2_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
							.addComponent(btnCadastar))
						.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabelaMedico, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	public static void atualizaJTable(DefaultTableModel modelo, JTable table, JScrollPane tabelaMedico) {
		DAOmedico m = DAOmedico.getInstacia();
		ArrayList<Medico> listaMedicos = m.listaMedico();
		for (Medico medico : listaMedicos) {
			modelo.addRow(new Object[] { medico.getCpf(), medico.getNome(), medico.getCrm(), medico.getEspecificacao(),
					medico.getEmail() });
		}

		table = new JTable(modelo);
		tabelaMedico.setViewportView(table);
		modelo.fireTableDataChanged();
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
						//lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));
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
