package visao.planoSaude;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controle.DAOplanoSaude;
import layoutPersonalizado.componentes.MeuBotao;
import layoutPersonalizado.componentes.MeuTextField;
import modelo.PlanoSaude;
import visao.TelaMensagem;

public class TelaCadastroPlanoSaude extends JFrame {
	
	private PlanoSaude planoSelecionado;
	private static TelaCadastroPlanoSaude frame;
	private JPanel contentPane;
	private Color corPadrao = new Color(24, 62, 159);
	private Color corPadraoBackground = new Color(255,255,255);
	private Color corSucesso = new Color(0,139,139);
	private Color corSucessoBackground = new Color(64,224,208);
	private Color corErro = new Color(178,34,34);
	private Color corErroBackground = new Color(250,128,114);
	private Color btnSucesso = new Color(92, 171, 109);
	private Color btnLimpar = new Color(186, 75, 71);
	private JLabel lblFoto = new JLabel("");
	
	// Instanciar objeto para o fluxo de bytes
	private FileInputStream fis;
	
	//Variável global para armazenar o tamanho da img(bytes)
	private int tamanho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TelaCadastroPlanoSaude();
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
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaCadastroPlanoSaude.class.getResource("/img/favicon-32x32.png")));
		setTitle("Cadastro do Plano de Saúde");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 652, 673);
		contentPane = new JPanel();
		getContentPane().add(contentPane, BorderLayout.CENTER);

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
		gl_panelIdentificacao.setHorizontalGroup(gl_panelIdentificacao.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdentificacao.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE).addGap(357)));
		gl_panelIdentificacao.setVerticalGroup(gl_panelIdentificacao.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIdentificacao.createSequentialGroup()
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE).addGap(0)));
		panelIdentificacao.setLayout(gl_panelIdentificacao);

		MeuBotao btnCadastrar = new MeuBotao();
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(btnSucesso);

		MeuBotao btnLimpa = new MeuBotao();
		btnLimpa.setText("Limpar");
		btnLimpa.setForeground(Color.WHITE);
		btnLimpa.setBackground(btnLimpar);
		
		JLabel lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(Color.RED);
		
		MeuBotao btnCarregarFoto = new MeuBotao();
		
		btnCarregarFoto.setText("Carregar foto do plano");
		btnCarregarFoto.setForeground(Color.WHITE);
		btnCarregarFoto.setBackground(new Color(24, 62, 159));
		
		
		lblFoto.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblFoto.setIcon(new ImageIcon(TelaCadastroPlanoSaude.class.getResource("/img/foto.png")));
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
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
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNome)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_3))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnLimpa, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnCarregarFoto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
												.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))
											.addGap(35))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panelIdentificacao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(21)))))
					.addGap(3))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(238)
					.addComponent(lblFoto, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addGap(198))
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
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCarregarFoto, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
						.addComponent(btnLimpa, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		// Voltar para a TelaMenuPlanoSaude
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMenuPlanoSaude telaMenuPlanoSaude = new TelaMenuPlanoSaude();
				telaMenuPlanoSaude.setVisible(true);
				telaMenuPlanoSaude.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		
		// Cadastramento de Plano de Saúde
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					PlanoSaude ps = new PlanoSaude();
				
					if(txtNome.getText().isEmpty()) {
						TelaMensagem telaSucesso = new TelaMensagem("Informe o Nome!", "Informe o Nome", corPadrao, corPadraoBackground);
						telaSucesso.setLocationRelativeTo(null);
						telaSucesso.setVisible(true);
						txtNome.requestFocus();
					} else {
				
					String nome = txtNome.getText();

					ps.setNome(nome);

					DAOplanoSaude dao = new DAOplanoSaude();
					Boolean inserir = dao.inserir(ps, tamanho, fis);
					if (inserir) {
						TelaMensagem telaSucesso = new TelaMensagem(nome + " foi cadastrado com Sucesso!", "Cadastro realizado", corSucesso, corSucessoBackground);
						telaSucesso.setVisible(true);
						telaSucesso.setLocationRelativeTo(null);
					} else {
						TelaMensagem telaSucesso = new TelaMensagem("Não foi possível cadastrar o Plano de Saúde!", "Erro ao Cadastrar", corErro, corErroBackground);
						telaSucesso.setVisible(true);
						telaSucesso.setLocationRelativeTo(null);
					}
				}
			}
		});
		
		btnCarregarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarFoto();
			}
		});
		
		// Botão de Limpar
		btnLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText(null);
			}
		});

	}
	
	private void carregarFoto() {
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Selecionar arquivo");
		jfc.setFileFilter(new FileNameExtensionFilter(
				"Arquivo de imagens"
			  + " (*.PNG,*JPG,*JPEG","png","jpg","jpeg"));
		int resultado = jfc.showOpenDialog(this);
		if(resultado == JFileChooser.APPROVE_OPTION) {
			try {
				fis = new FileInputStream(jfc.getSelectedFile());
				tamanho = (int) jfc.getSelectedFile().length();
				Image foto = ImageIO.read(jfc.getSelectedFile())
						.getScaledInstance(lblFoto.getWidth(), 
										   lblFoto.getHeight(), 
										   Image.SCALE_SMOOTH);
				lblFoto.setIcon(new ImageIcon(foto));
				lblFoto.updateUI();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
