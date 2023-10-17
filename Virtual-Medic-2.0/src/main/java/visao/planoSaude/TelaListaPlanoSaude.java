package visao.planoSaude;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controle.DAOplanoSaude;
import layoutPersonalizado.componentes.MeuBotao;
import layoutPersonalizado.componentes.tables.TableCustom;
import layoutPersonalizado.componentes.tables.TableScrollButton;
import modelo.PlanoSaude;
import visao.TelaMensagem;
import visao.paciente.TelaListaPaciente;

public class TelaListaPlanoSaude extends javax.swing.JFrame {

	private DefaultTableModel model = new DefaultTableModel();
	private Color corPadrao = new Color(24, 62, 159);
	private Color corPadraoBackground = new Color(255, 255, 255);
	private Color corSucesso = new Color(0, 139, 139);
	private Color corSucessoBackground = new Color(64, 224, 208);
	private Color corErro = new Color(178, 34, 34);
	private Color corErroBackground = new Color(250, 128, 114);
	private JTable jTable = new JTable();

	public TelaListaPlanoSaude() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaListaPaciente.class.getResource("/img/favicon-32x32.png")));
		setTitle("Lista de Planos de Saúde");
		initComponents();
		getContentPane().setBackground(new Color(240, 240, 240));
		testData(jTable);

	}

	private void testData(JTable table) {
		DefaultTableModel lista = (DefaultTableModel) table.getModel();
		atualizaJTable(lista, table);
	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome"
				}
			));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		jTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		jTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); 
  
		JPanel panel = new JPanel();

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaListaPlanoSaude.class.getResource("/img/VirtualMedic200.png")));

		JLabel lblNewLabel_1 = new JLabel("VIRTUAL");
		lblNewLabel_1.setForeground(new Color(24, 62, 159));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 60));

		JLabel lblNewLabel_1_1 = new JLabel("MEDIC");
		lblNewLabel_1_1.setForeground(new Color(27, 156, 228));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 45));

		JLabel lblNewLabel_2 = new JLabel("Bem vindo à central de Planos de Saúde");
		lblNewLabel_2.setForeground(new Color(84, 175, 230));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setBackground(new Color(24, 62, 159));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel.createSequentialGroup().addGap(2)
						.addComponent(lblNewLabel).addGap(18).addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1).addComponent(lblNewLabel_1_1).addComponent(lblNewLabel_2))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(9)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE));
		panel.setLayout(gl_panel);

		MeuBotao btnSair = new MeuBotao();
		btnSair.setIcon(new ImageIcon(TelaListaPlanoSaude.class.getResource("/img/exitBranco.png")));
		btnSair.setText("Voltar");
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBackground(new Color(24, 62, 159));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaListaPlanoSaude.class.getResource("/img/gradienteMaior.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		MeuBotao btnPDF = new MeuBotao();
		btnPDF.setText("PDF");
		btnPDF.setForeground(Color.WHITE);
		btnPDF.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPDF.setBackground(new Color(128, 0, 0));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 522, Short.MAX_VALUE)
							.addComponent(btnPDF, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
					.addGap(13)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPDF, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
					.addContainerGap())
		);
		jTable.setFillsViewportHeight(true);
		jTable.setForeground(new Color(0, 0, 0));
		jTable.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(jTable);
		getContentPane().setLayout(layout);

		pack();
		setLocationRelativeTo(null);

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMenuPlanoSaude TelaMenuPlanoSaude = new TelaMenuPlanoSaude();
				TelaMenuPlanoSaude.setVisible(true);
				TelaMenuPlanoSaude.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = "";
				JFileChooser j = new JFileChooser();
				j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int x = j.showSaveDialog(btnPDF);
				if (x == JFileChooser.APPROVE_OPTION) {
					path = j.getSelectedFile().getPath();
				}
			}
		});
	}

	public static void atualizaJTable(DefaultTableModel lista, JTable table) {
		DAOplanoSaude ps = new DAOplanoSaude();
		ArrayList<PlanoSaude> listaPlanoSaude = ps.listar();
		lista.getDataVector().removeAllElements();

		for (PlanoSaude plano : listaPlanoSaude) {
			lista.addRow(new Object[] { plano.getId(), plano.getNome(), });
		}
		
		table = new JTable(lista);
		lista.fireTableDataChanged();
	}

	public static Integer gerarID() {
		Random rand = new Random();
		int num = rand.nextInt(1000) + 10;

		return num;
	}

	public static void main(String args[]) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaPlanoSaude frame = new TelaListaPlanoSaude();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
