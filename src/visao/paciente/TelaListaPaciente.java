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


public class TelaListaPaciente extends javax.swing.JFrame {

    public TelaListaPaciente() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
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
        
    }

    private void testData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, 39});
    }


    private void initComponents() {

        tableScrollButton1 = new layoutPersonalizado.componentes.tables.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

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

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton1.setText("horizontal scroll");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(tableScrollButton1, GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
        				.addComponent(jButton1))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(tableScrollButton1, GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jButton1)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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

    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private layoutPersonalizado.componentes.tables.TableScrollButton tableScrollButton1;
    
    
}
