package visao.paciente;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controle.DAOpaciente;
import controle.DAOpaciente;
import layoutPersonalizado.componentes.tables.TableActionCellEditor;
import layoutPersonalizado.componentes.tables.TableActionCellRender;
import layoutPersonalizado.componentes.tables.TableActionEvent;
import layoutPersonalizado.componentes.tables.TableCustom;
import modelo.Paciente;
import visao.TelaMensagem;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaListaPaciente extends javax.swing.JFrame {

	private Color corPadrao = new Color(24, 62, 159);
	private Color corPadraoBackground = new Color(255,255,255);
	private JTable jTable = new JTable();
	
    public TelaListaPaciente() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListaPaciente.class.getResource("/img/favicon-32x32.png")));
    	setTitle("Lista de Médicos");
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
	        		"CPF", "Nome", "Email"
	        	}
	        ));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		jTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		jTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); 
		jTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer); 
		
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
        
        MeuBotao btnVoltar = new MeuBotao();
        btnVoltar.setIcon(new ImageIcon(TelaListaPaciente.class.getResource("/img/exitBranco.png")));
        btnVoltar.setText("Voltar");
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnVoltar.setBackground(new Color(24, 62, 159));
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(TelaListaPaciente.class.getResource("/img/gradienteMaior.png")));
        
        JScrollPane scrollPane = new JScrollPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(10)
        					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
        							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)))
        					.addContainerGap())))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
        			.addGap(13)
        			.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        			.addContainerGap())
        );
  
        jTable.setForeground(Color.BLACK);
        jTable.setFillsViewportHeight(true);
        jTable.setBackground(new Color(224, 224, 224));
        scrollPane.setViewportView(jTable);
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
        
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaMenuPaciente telaMenuPaciente = new TelaMenuPaciente();
        		telaMenuPaciente.setVisible(true);
        		telaMenuPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
        		setVisible(false);
        	}
        });
    }
    
    public static void atualizaJTable(DefaultTableModel modelo, JTable table) {
    	DAOpaciente p = new DAOpaciente();
		ArrayList<Paciente> listaPacientes = p.listar();
		for (Paciente paciente : listaPacientes) {
			modelo.addRow(new Object[] { paciente.getCpf(), paciente.getNome(), paciente.getEmail() });
		}

		table = new JTable(modelo);
		modelo.fireTableDataChanged();
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
}
