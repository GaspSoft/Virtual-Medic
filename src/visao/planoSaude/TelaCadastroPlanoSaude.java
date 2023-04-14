package visao.planoSaude;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.DAOmedico;
import controle.DAOplanoSaude;
import modelo.Medico;
import modelo.PlanoSaude;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;

public class TelaCadastroPlanoSaude extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private PlanoSaude planoSelecionado;
	private JScrollPane scrollPane;
	private DAOplanoSaude dao;
	private DefaultTableModel modelo;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPlanoSaude frame = new TelaCadastroPlanoSaude();
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
	public TelaCadastroPlanoSaude() {
		setTitle("Plano de Saúde");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 352);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(28, 57, 58, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(85, 56, 219, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JScrollPane tabelaPlanoSaude = new JScrollPane();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOplanoSaude planosaudeDao = new DAOplanoSaude();
				ArrayList<PlanoSaude> listaPlanoSaude = planosaudeDao.listaPlanoSaude();
				PlanoSaude ps = new PlanoSaude();

				String nome = txtNome.getText();

				ps.setNome(nome);

				DAOplanoSaude dao = DAOplanoSaude.getInstacia();
				Boolean inserir = dao.inserir(ps);
				if (inserir == true) {
					JOptionPane.showMessageDialog(null, "Sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro!");
				}

				atualizaJTable(modelo, table, tabelaPlanoSaude);
			}
		});
		
		btnCadastrar.setBounds(10, 283, 100, 23);
		contentPane.add(btnCadastrar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Nome");

		DAOplanoSaude ps = DAOplanoSaude.getInstacia();
		ArrayList<PlanoSaude> listaPlanoSaude = ps.listaPlanoSaude();
		for (PlanoSaude plano : listaPlanoSaude) {
			modelo.addRow(new Object[] { plano.getNome() });
		}

		atualizaJTable(modelo, table, tabelaPlanoSaude);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(planoSelecionado != null) {
					listaPlanoSaude.remove(planoSelecionado);
					//atualizarJTable();
					//limparCampos();
				}
			}
		});
		btnExcluir.setBounds(120, 283, 100, 23);
		contentPane.add(btnExcluir);
		
		tabelaPlanoSaude.setBounds(32, 136, 363, 126);
		contentPane.add(tabelaPlanoSaude);
	}
	
	public static void atualizaJTable(DefaultTableModel modelo, JTable table, JScrollPane tabelaPlanoSaude) {
		DAOplanoSaude ps = DAOplanoSaude.getInstacia();
		ArrayList<PlanoSaude> listaPlanoSaude = ps.listaPlanoSaude();
		for (PlanoSaude planos : listaPlanoSaude) {
			modelo.addRow(new Object[] { planos.getNome() });
		}

		table = new JTable(modelo);
		tabelaPlanoSaude.setViewportView(table);
		modelo.fireTableDataChanged();
	}
}
