package visao.paciente;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import layoutPersonalizado.componentes.tables.TableActionCellEditor;
import layoutPersonalizado.componentes.tables.TableActionCellRender;
import layoutPersonalizado.componentes.tables.TableActionEvent;
import layoutPersonalizado.componentes.tables.TableCustom;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.ImageIcon;
import layoutPersonalizado.componentes.MeuBotao;


public class TelaListaPaciente extends javax.swing.JFrame {

    public TelaListaPaciente() {
        initComponents();
        getContentPane().setBackground(new Color(240, 240, 240));
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
            }

            @Override
            public void onDelete(int row) {
                if (jTable1.isEditing()) {
                	jTable1.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.removeRow(row);
            }

            @Override
            public void onView(int row) {
                System.out.println("View row : " + row);
            }
        };
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
        testData(jTable1);
        GroupLayout gl_tableScrollButton1 = new GroupLayout(tableScrollButton1);
        gl_tableScrollButton1.setHorizontalGroup(
        	gl_tableScrollButton1.createParallelGroup(Alignment.LEADING)
        		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
        );
        gl_tableScrollButton1.setVerticalGroup(
        	gl_tableScrollButton1.createParallelGroup(Alignment.LEADING)
        		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );
        tableScrollButton1.setLayout(gl_tableScrollButton1);
        
    }

    private void testData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
    }


    private void initComponents() {

        tableScrollButton1 = new layoutPersonalizado.componentes.tables.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Email", "Ações"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        }
        
        JPanel panel = new JPanel();
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(TelaListaPaciente.class.getResource("/img/VirtualMedic200.png")));
        
        JLabel lblNewLabel_1 = new JLabel("VIRTUAL");
        lblNewLabel_1.setForeground(new Color(24, 62, 159));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 60));
        
        JLabel lblNewLabel_1_1 = new JLabel("MEDIC");
        lblNewLabel_1_1.setForeground(new Color(27, 156, 228));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 45));
        
        JLabel lblNewLabel_2 = new JLabel("Bem vindo ao prontuário eletrônico");
        lblNewLabel_2.setForeground(new Color(84, 175, 230));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_2.setBackground(new Color(24, 62, 159));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(2)
        			.addComponent(lblNewLabel)
        			.addGap(18)
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_1)
        				.addComponent(lblNewLabel_1_1)
        				.addComponent(lblNewLabel_2))
        			.addContainerGap())
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(9)
        			.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
        			.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        		.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        panel.setLayout(gl_panel);
        
        MeuBotao btnSair = new MeuBotao();
        btnSair.setIcon(new ImageIcon(TelaListaPaciente.class.getResource("/img/exitBranco.png")));
        btnSair.setText("Voltar");
        btnSair.setForeground(Color.WHITE);
        btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnSair.setBackground(new Color(24, 62, 159));
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(TelaListaPaciente.class.getResource("/img/gradienteMaior.png")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(tableScrollButton1, GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
        				.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
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
        			.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(tableScrollButton1, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaPaciente frame = new TelaListaPaciente();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    	

    }
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private layoutPersonalizado.componentes.tables.TableScrollButton tableScrollButton1;
}
