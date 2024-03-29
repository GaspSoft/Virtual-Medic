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
import visao.TelaMensagem;
import visao.planoSaude.TelaListaPlanoSaude;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaDetalhesPlanoSaude extends JFrame {
	private static TelaDetalhesPlanoSaude frame;
	private JPanel contentPane;

	private ArrayList<PlanoSaude> listaPlanoSaude = new ArrayList<PlanoSaude>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TelaDetalhesPlanoSaude(null);
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
	public TelaDetalhesPlanoSaude(PlanoSaude planoEncontrado) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaDetalhesPlanoSaude.class.getResource("/img/favicon-32x32.png")));
		setTitle("Detalhes do Plano de Saúde");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 652, 320);
		contentPane = new JPanel();
		getContentPane().add(contentPane, BorderLayout.CENTER);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaDetalhesPlanoSaude.class.getResource("/img/imgCadastro 1.png")));
		lblNewLabel_1.setBounds(0, 0, 123, 122);
		panelTitulo.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Detalhes");
		lblNewLabel.setForeground(new Color(27, 156, 228));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(123, 0, 212, 122);
		panelTitulo.add(lblNewLabel);

		MeuBotao btnVoltar = new MeuBotao();
		btnVoltar.setIcon(new ImageIcon(TelaDetalhesPlanoSaude.class.getResource("/img/setaAzulEsquerda.png")));
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBackground(new Color(24, 62, 159));

		JLabel lblNome = new JLabel("Nome do Plano:");
		lblNome.setForeground(new Color(84, 175, 230));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBackground(Color.WHITE);

		MeuTextField txtNome = new MeuTextField();
		txtNome.setEditable(false);
		txtNome.setForeground(new Color(27, 156, 228));
		txtNome.setText(planoEncontrado.getNome());

		JPanel panelIdentificacao = new JPanel();
		panelIdentificacao.setBackground(new Color(24, 62, 159));

		JLabel lblNewLabel_2 = new JLabel("Detalhes do Plano de Saúde");
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
											.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
											.addGap(454))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
											.addGap(35))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panelIdentificacao, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
									.addGap(21)))))
					.addGap(3))
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
					.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListaPlanoSaude telaListaPlanoSaude = new TelaListaPlanoSaude();
				telaListaPlanoSaude.setVisible(true);
				telaListaPlanoSaude.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

	}

}
