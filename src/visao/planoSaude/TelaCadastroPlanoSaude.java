package visao.planoSaude;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.DAOmedico;
import controle.DAOplanoSaude;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.awt.BorderLayout;
import java.awt.Color;
import layoutPersonalizado.componentes.MeuBotao;
import layoutPersonalizado.componentes.MeuTextField;
import modelo.Medico;
import modelo.PlanoSaude;
import visao.TelaInicialMenu;
import visao.planoSaude.TelaListaPlanoSaude;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroPlanoSaude extends JFrame {
	private PlanoSaude planoSelecionado;
	private JPanel contentPane;
	
	private ArrayList<PlanoSaude> listaPlanoSaude = new ArrayList<PlanoSaude>();
	
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
		setTitle("Cadastro do Plano de Saúde");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 652, 416);
		contentPane = 
				new JPanel();
		getContentPane().add(contentPane, BorderLayout.NORTH);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaCadastroPlanoSaude.class.getResource("/img/imgCadastro 1.png")));
		lblNewLabel_1.setBounds(0, 0, 123, 122);
		panelTitulo.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Cadastrar");
		lblNewLabel.setForeground(new Color(27, 156, 228));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(123, 0, 212, 122);
		panelTitulo.add(lblNewLabel);
		
		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setIcon(new ImageIcon(TelaCadastroPlanoSaude.class.getResource("/img/setaAzulEsquerda.png")));
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBackground(new Color(24, 62, 159));
		
		JLabel lblNome = new JLabel("Nome do Plano:");
		lblNome.setForeground(new Color(84, 175, 230));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBackground(Color.WHITE);
		
		MeuTextField txtNome = new MeuTextField();
		txtNome.setForeground(new Color(27, 156, 228));
		
		JPanel panelIdentificacao = new JPanel();
		panelIdentificacao.setBackground(new Color(24, 62, 159));
		
		JLabel lblNewLabel_2 = new JLabel("Cadastramento do Plano de Saúde");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panelIdentificacao = new GroupLayout(panelIdentificacao);
		gl_panelIdentificacao.setHorizontalGroup(
			gl_panelIdentificacao.createParallelGroup(Alignment.LEADING)
				.addGap(0, 591, Short.MAX_VALUE)
				.addGroup(gl_panelIdentificacao.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(357, Short.MAX_VALUE))
		);
		gl_panelIdentificacao.setVerticalGroup(
			gl_panelIdentificacao.createParallelGroup(Alignment.LEADING)
				.addGap(0, 24, Short.MAX_VALUE)
				.addGroup(gl_panelIdentificacao.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelIdentificacao.setLayout(gl_panelIdentificacao);
		
		MeuBotao btnCadastrar = new MeuBotao();
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(24, 62, 159));
		
		MeuBotao btnLimpa = new MeuBotao();
		btnLimpa.setText("Limpar");
		btnLimpa.setForeground(Color.WHITE);
		btnLimpa.setBackground(new Color(24, 62, 159));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(0)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(panelTitulo, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(481)
									.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
											.addGap(454))
										.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE)))
								.addComponent(panelIdentificacao, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE))))
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLimpa, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(228, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelTitulo, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(panelIdentificacao, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
						.addComponent(btnLimpa, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
					.addGap(626))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMenuPlanoSaude TelaMenuPlanoSaude = new TelaMenuPlanoSaude();
				TelaMenuPlanoSaude.setVisible(true);
			}
		});
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlanoSaude ps = new PlanoSaude();

				String nome = txtNome.getText();
				
				ps.setId(gerarID());
				ps.setNome(nome);
				
				DAOplanoSaude dao = DAOplanoSaude.getInstacia();
				Boolean inserir = dao.inserir(ps);
				if (inserir == true) {
					JOptionPane.showMessageDialog(null, "Sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro!");
				}
			}
		});
		
	}
	
	public static Integer gerarID () { 
		Random rand = new Random();
		int num = rand.nextInt(1000) + 10;
		
		return num;
	}

}
