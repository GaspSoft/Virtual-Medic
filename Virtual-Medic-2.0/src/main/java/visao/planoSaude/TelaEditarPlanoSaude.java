package visao.planoSaude;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.DAOmedico;
import controle.DAOpaciente;
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
import modelo.Paciente;
import modelo.PlanoSaude;
import visao.TelaInicialMenu;
import visao.TelaMensagem;
import visao.planoSaude.TelaListaPlanoSaude;
import visao.planoSaude.TelaSelecionarPlanosSaudeEdicao;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class TelaEditarPlanoSaude extends JFrame {
	
	private JPanel contentPane;
	private ArrayList<PlanoSaude> listaPlanoSaude = new ArrayList<PlanoSaude>();
	private Color corPadrao = new Color(24, 62, 159);
	private Color corPadraoBackground = new Color(255,255,255);
	private Color corSucesso = new Color(0,139,139);
	private Color corSucessoBackground = new Color(64,224,208);
	private Color corErro = new Color(178,34,34);
	private Color corErroBackground = new Color(250,128,114);
	private Color btnSucesso = new Color(92, 171, 109);
	private Color btnLimpar = new Color(186, 75, 71);
	
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
	 * @param planoEncontrado 
	 */
	public TelaEditarPlanoSaude(PlanoSaude planoEncontrado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroPlanoSaude.class.getResource("/img/favicon-32x32.png")));
		setTitle("Cadastro do Plano de Saúde");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 652, 416);
		contentPane = 
				new JPanel();
		getContentPane().add(contentPane, BorderLayout.CENTER);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaCadastroPlanoSaude.class.getResource("/img/imgCadastro 1.png")));
		lblNewLabel_1.setBounds(0, 0, 123, 122);
		panelTitulo.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Alterar");
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
		
		MeuTextField txtEdicao = new MeuTextField();
		txtEdicao.setForeground(new Color(27, 156, 228));
		txtEdicao.setText(planoEncontrado.getNome());
		
		JPanel panelIdentificacao = new JPanel();
		panelIdentificacao.setBackground(new Color(24, 62, 159));
		
		JLabel lblNewLabel_2 = new JLabel("Editar do Plano de Saúde");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panelIdentificacao = new GroupLayout(panelIdentificacao);
		gl_panelIdentificacao.setHorizontalGroup(
			gl_panelIdentificacao.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdentificacao.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
					.addGap(357))
		);
		gl_panelIdentificacao.setVerticalGroup(
			gl_panelIdentificacao.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdentificacao.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
					.addGap(0))
		);
		panelIdentificacao.setLayout(gl_panelIdentificacao);
		
		MeuBotao btnAlterar = new MeuBotao();
		btnAlterar.setText("Editar");
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setBackground(btnSucesso);
		
		MeuBotao btnLimpa = new MeuBotao();
		btnLimpa.setText("Limpar");
		btnLimpa.setForeground(Color.WHITE);
		btnLimpa.setBackground(btnLimpar);
		btnLimpa.setBackground(new Color(24, 62, 159));
		
		JLabel lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(Color.RED);

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
									.addPreferredGap(ComponentPlacement.RELATED, 481, Short.MAX_VALUE)
									.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addGap(21))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panelIdentificacao, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
									.addGap(21))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNome)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(txtEdicao, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
											.addGap(35)))))))
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLimpa, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addGap(228))
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtEdicao, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
						.addComponent(btnLimpa, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMenuPlanoSaude TelaMenuPlanoSaude = new TelaMenuPlanoSaude();
				TelaMenuPlanoSaude.setVisible(true);
				TelaMenuPlanoSaude.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOplanoSaude daoPlanoSaude = new DAOplanoSaude();
				String nome = txtEdicao.getText();
		        PlanoSaude planoSaude = new PlanoSaude();
		        
		        planoSaude.setNome(nome);
		        planoSaude.setId(planoEncontrado.getId());

		        boolean sucesso = daoPlanoSaude.atualizar(planoSaude);

		        if (sucesso) {
		            TelaMensagem telaSucesso = new TelaMensagem("Dados atualizados com sucesso!", "Dados Atualizados", corSucesso, corSucessoBackground);
		            telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
		        } else {
		            // Realize as ações de erro, como exibir uma mensagem de erro
		            TelaMensagem telaSucesso = new TelaMensagem("Falha ao atualizar os dados do paciente!", "Falha ao Atualizar", corErro, corErroBackground);
		            telaSucesso.setLocationRelativeTo(null);
					telaSucesso.setVisible(true);
		        }
			}
		});
		
		btnLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEdicao.setText(null);
			}
		});
	}
}
