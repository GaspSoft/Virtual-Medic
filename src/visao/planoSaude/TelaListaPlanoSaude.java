package visao.planoSaude;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controle.DAOmedico;
import controle.DAOplanoSaude;
import layoutPersonalizado.componentes.MeuBotao;
import layoutPersonalizado.componentes.tables.TableActionCellEditor;
import layoutPersonalizado.componentes.tables.TableActionCellRender;
import layoutPersonalizado.componentes.tables.TableActionEvent;
import layoutPersonalizado.componentes.tables.TableCustom;
import modelo.Medico;
import modelo.PlanoSaude;
import visao.paciente.TelaListaPaciente;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.awt.event.ActionEvent;

public class TelaListaPlanoSaude extends javax.swing.JFrame {

	public TelaListaPlanoSaude() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaListaPaciente.class.getResource("/img/favicon-32x32.png")));
		setTitle("Lista de Planos de Saúde");
		initComponents();
		getContentPane().setBackground(new Color(240, 240, 240));
		TableCustom.apply(jScrollPanes, TableCustom.TableType.MULTI_LINE);
		TableActionEvent event = new TableActionEvent() {
			@Override
			public void onEdit(int row) {
				System.out.println("Edit row : " + row);
			}

			@Override
			public void onDelete(int row) {
				if (jTables.isEditing()) {
					jTables.getCellEditor().stopCellEditing();
				}
				DefaultTableModel model = (DefaultTableModel) jTables.getModel();
				model.removeRow(row);
			}

			@Override
			public void onView(int row) {
				System.out.println("View row : " + row);
			}
		};
		jTables.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender());
		jTables.getColumnModel().getColumn(2).setCellEditor(new TableActionCellEditor(event));
		testData(jTables);
		GroupLayout gl_tableScrollButtons = new GroupLayout(tableScrollButtons);
		gl_tableScrollButtons.setHorizontalGroup(gl_tableScrollButtons.createParallelGroup(Alignment.LEADING)
				.addComponent(jScrollPanes, GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE));
		gl_tableScrollButtons.setVerticalGroup(gl_tableScrollButtons.createParallelGroup(Alignment.LEADING)
				.addComponent(jScrollPanes, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE));
		tableScrollButtons.setLayout(gl_tableScrollButtons);

	}

	private void testData(JTable table) {
		DAOplanoSaude planoDao = new DAOplanoSaude();
		ArrayList<PlanoSaude> listaPlanoSaude = planoDao.listaPlanoSaude();
		PlanoSaude ps1 = new PlanoSaude();
		PlanoSaude ps2 = new PlanoSaude();
		PlanoSaude ps3 = new PlanoSaude();
		PlanoSaude ps4 = new PlanoSaude();
		PlanoSaude ps5 = new PlanoSaude();
		PlanoSaude ps6 = new PlanoSaude();
		PlanoSaude ps7 = new PlanoSaude();
		PlanoSaude ps8 = new PlanoSaude();
		PlanoSaude ps9 = new PlanoSaude();
		PlanoSaude ps10 = new PlanoSaude();
		
		
		ps1.setNome("Unimed");
		ps1.setId(gerarID());
		listaPlanoSaude.add(ps1);
		
		ps2.setNome("Bradesco Saúde");
		ps2.setId(gerarID());
		listaPlanoSaude.add(ps2);
		
		ps3.setNome("Amil");
		ps3.setId(gerarID());
		listaPlanoSaude.add(ps3);
		
		ps4.setNome("NotreDame Intermédica");
		ps4.setId(gerarID());
		listaPlanoSaude.add(ps4);
		
		ps5.setNome("Porto Seguro");
		ps5.setId(gerarID());
		listaPlanoSaude.add(ps5);
		
		ps6.setNome("Prevent Senior");
		ps6.setId(gerarID());
		listaPlanoSaude.add(ps6);
		
		ps7.setNome("SulAmérica Saúde");
		ps7.setId(gerarID());
		listaPlanoSaude.add(ps7);
		
		ps8.setNome("Assim Saúde");
		ps8.setId(gerarID());
		listaPlanoSaude.add(ps8);
		
		ps9.setNome("GreenLine Sistema de Saúde");
		ps9.setId(gerarID());
		listaPlanoSaude.add(ps9);
		
		ps10.setNome("Hapvida");
		ps10.setId(gerarID());
		listaPlanoSaude.add(ps10);
	
		DefaultTableModel lista = (DefaultTableModel) table.getModel();
		
		lista.addRow(new Object[]{gerarID(), "Unimed", 18, 39});
		lista.addRow(new Object[]{gerarID(), "Bradesco Saúde", 18, 39});
		lista.addRow(new Object[]{gerarID(), "Amil", 18, 39});
		lista.addRow(new Object[]{gerarID(), "NotreDame Intermédica", 18, 39});
		lista.addRow(new Object[]{gerarID(), "Porto Seguro", 18, 39});
		lista.addRow(new Object[]{gerarID(), "SulAmérica Saúde", 18, 39});
		lista.addRow(new Object[]{gerarID(), "Prevent Senior", 18, 39});
		lista.addRow(new Object[]{gerarID(), "Assim Saúde", 18, 39});
		lista.addRow(new Object[]{gerarID(), "GreenLine Sistema de Saúde", 18, 39});
		lista.addRow(new Object[]{gerarID(), "Hapvida Saúde", 18, 39});
		
		atualizaJTable(lista, table);
	}

	private void initComponents() {

		tableScrollButtons = new layoutPersonalizado.componentes.tables.TableScrollButton();
		jScrollPanes = new javax.swing.JScrollPane();
		jTables = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTables.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Nome", "Ações" }) {
			boolean[] canEdit = new boolean[] { false, false, true };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		jScrollPanes.setViewportView(jTables);
		if (jTables.getColumnModel().getColumnCount() > 0) {
			jTables.getColumnModel().getColumn(0).setPreferredWidth(50);
			jTables.getColumnModel().getColumn(1).setPreferredWidth(250);
		}

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

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(tableScrollButtons, GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 1, Short.MAX_VALUE).addComponent(
										lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
				.addGap(13).addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(tableScrollButtons, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE).addContainerGap()));
		getContentPane().setLayout(layout);

		pack();
		setLocationRelativeTo(null);
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMenuPlanoSaude TelaMenuPlanoSaude = new TelaMenuPlanoSaude();
				TelaMenuPlanoSaude.setVisible(true);
			}
		});
	}
	
	public static void atualizaJTable(DefaultTableModel lista, JTable table) {
		DAOplanoSaude ps = DAOplanoSaude.getInstacia();
		ArrayList<PlanoSaude> listaPlanoSaude = ps.listaPlanoSaude();
		for (PlanoSaude plano : listaPlanoSaude) {
			lista.addRow(new Object[] { plano.getId(), plano.getNome()});
		}

		table = new JTable(lista);
		lista.fireTableDataChanged();
	}
	
	public static Integer gerarID () { 
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

	private javax.swing.JScrollPane jScrollPanes;
	private javax.swing.JTable jTables;
	private layoutPersonalizado.componentes.tables.TableScrollButton tableScrollButtons;
}
