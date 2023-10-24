package visao.medico;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import controle.DAOmedico;
import controle.DAOpaciente;
import controle.DAOplanoSaude;
import controle.DAOpaciente;
import layoutPersonalizado.componentes.tables.TableActionCellEditor;
import layoutPersonalizado.componentes.tables.TableActionCellRender;
import layoutPersonalizado.componentes.tables.TableActionEvent;
import layoutPersonalizado.componentes.tables.TableCustom;
import modelo.Medico;
import modelo.Paciente;
import modelo.PlanoSaude;
import visao.TelaMensagem;
import visao.paciente.TelaEditarPaciente;
import visao.planoSaude.TelaDetalhesPlanoSaude;
import visao.planoSaude.TelaListaPlanoSaude;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import layoutPersonalizado.componentes.MeuBotao;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class TelaListaMedico extends javax.swing.JFrame {

	private Color corPadrao = new Color(24, 62, 159);
	private Color corPadraoBackground = new Color(255,255,255);
	private JTable jTable = new JTable();
	
	public TelaListaMedico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListaMedico.class.getResource("/img/favicon-32x32.png")));
		setTitle("Lista de Médicos");
		initComponents();
		getContentPane().setBackground(new Color(240, 240, 240));
		testData(jTable);
	}

	private void testData(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		atualizaJTable(model, table);
	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"CRM", "Nome", "Email"
				}
			));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		jTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		jTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); 
		jTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer); 

		JPanel panel = new JPanel();

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaListaMedico.class.getResource("/img/VirtualMedic200.png")));

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

		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setIcon(new ImageIcon(TelaListaMedico.class.getResource("/img/exitBranco.png")));
		btnVoltar.setText("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBackground(new Color(24, 62, 159));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaListaMedico.class.getResource("/img/gradienteMaior.png")));
		
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
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 522, Short.MAX_VALUE)
							.addComponent(btnPDF, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(13)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPDF, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
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
		
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = "";
				JFileChooser j = new JFileChooser();
				j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int x = j.showSaveDialog(btnPDF);
				if (x == JFileChooser.APPROVE_OPTION) {
					path = j.getSelectedFile().getPath();
				}
				
				Document doc = new Document();
				
				try {
					PdfWriter.getInstance(doc, new FileOutputStream(path + ".pdf"));
		
					doc.open();
					
					Paragraph para = new Paragraph("Médico");
					para.setAlignment(Element.ALIGN_CENTER);
	
	                doc.add(para);
	   				
					PdfPTable tbl = new PdfPTable(3);
					
					tbl.addCell("CRM");
					tbl.addCell("NOME");
					tbl.addCell("EMAIL");
					
					for (int i = 0; i < jTable.getRowCount(); i++) {
						String crm =  jTable.getValueAt(i, 0).toString();
						String nome =  jTable.getValueAt(i, 1).toString();
						String email =  jTable.getValueAt(i, 2).toString();
						
						tbl.addCell(crm);
						tbl.addCell(nome);
						tbl.addCell(email);
					}
					
					doc.add(tbl);
					
				} catch (FileNotFoundException | DocumentException ex) {
					Logger.getLogger(TelaListaPlanoSaude.class.getName()).log(Level.SEVERE, null, ex);
				}
				
				doc.close();
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuMedico telaMenuMedico = new TelaMenuMedico();
				telaMenuMedico.setVisible(true);
				telaMenuMedico.setExtendedState(MAXIMIZED_BOTH);
				dispose();
			}
		});
	}

	public static void atualizaJTable(DefaultTableModel modelo, JTable table) {
		DAOmedico m = new DAOmedico();
		ArrayList<Medico> listaMedicos = m.listar();
		for (Medico medico : listaMedicos) {
			modelo.addRow(new Object[] { medico.getCrm(), medico.getNome(), medico.getEmail() });
		}

		table = new JTable(modelo);
		modelo.fireTableDataChanged();
	}

	public static void main(String args[]) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaMedico frame = new TelaListaMedico();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
