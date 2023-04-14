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
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabelaMedico, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(214)
					.addComponent(btnCadastar, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
					.addGap(239))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCPF, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCRM, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEspeci)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
							.addGap(19))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(36)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
						.addComponent(txtCRM, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
						.addComponent(txtCPF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
						.addComponent(txtEspeci, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
						.addComponent(txtEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
					.addGap(163))
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
					.addPreferredGap(ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
					.addComponent(btnCadastar)
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
}
