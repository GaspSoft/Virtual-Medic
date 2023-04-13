package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.PlanoSaude;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TelaCadastroPlanoSaude extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField textField;
	private PlanoSaude planoSelecionado;
	
	private ArrayList<PlanoSaude> listaPlanoSaude = new ArrayList<PlanoSaude>();
	private JTable table;
	private JScrollPane scrollPane;
	
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
		setTitle("Tela de Cadastro Plano de Saúde");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(28, 32, 46, 22);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(84, 35, 154, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(28, 81, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(84, 80, 154, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(10, 283, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(planoSelecionado != null) {
					listaPlanoSaude.remove(planoSelecionado);
					atualizarJTable();
					limparCampos();
				}
			}
		});
		btnExcluir.setBounds(120, 283, 89, 23);
		contentPane.add(btnExcluir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 38, 362, 140);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
