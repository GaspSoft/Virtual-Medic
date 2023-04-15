package visao.paciente;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import layoutPersonalizado.componentes.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaCadastroPaciente extends JFrame {

	private JPanel contentPane;
	private MeuTextField txtCEP;
	private MeuTextField txtComplemento;
	private MeuTextField txtBairro;
	private MeuTextField txtCidade;
	private MeuTextField txtRua;
	//private JComboBox cboUF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPaciente frame = new TelaCadastroPaciente();
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
	public TelaCadastroPaciente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroPaciente.class.getResource("/img/favicon-32x32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CEP:");
		lblNewLabel.setBounds(30, 159, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtCEP = new MeuTextField();
		txtCEP.setBounds(86, 149, 186, 39);
        contentPane.add(txtCEP);
        
        MeuBotao botao = new MeuBotao();
		botao.setForeground(new Color(255, 255, 255));
		botao.setBackground(new Color(0, 0, 255));
		botao.setText("Buscar");
        botao.setBounds(271, 152, 95, 33);
        contentPane.add(botao);
        
        JLabel lblRua = new JLabel("Rua");
        lblRua.setBounds(30, 203, 46, 14);
        contentPane.add(lblRua);
        
        MeuTextField txtRua = new MeuTextField();
        txtRua.setBounds(86, 193, 186, 39);
        contentPane.add(txtRua);
        
        JLabel lblBairro = new JLabel("Bairro");
        lblBairro.setBounds(30, 252, 46, 14);
        contentPane.add(lblBairro);
        
        MeuTextField txtBairro = new MeuTextField();
        txtBairro.setBounds(86, 243, 186, 39);
        contentPane.add(txtBairro);
        
        JLabel lblCidade = new JLabel("Cidade");
        lblCidade.setBounds(30, 297, 46, 14);
        contentPane.add(lblCidade);
        
        MeuTextField txtCidade = new MeuTextField();
        txtCidade.setBounds(86, 287, 186, 39);
        contentPane.add(txtCidade);
        
 
  
        //Métodos de ações
        botao.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(txtCEP.getText().equals("")) {
        			JOptionPane.showMessageDialog(null, "CEP não digitado");
        			txtCEP.requestFocus();
        		} else {
        			buscaCEP();
        		}
        	}
        });
	}
	
	private void buscaCEP() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCEP.getText();
		System.out.println(cep);
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep="+ cep +"&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				/*if (element.getQualifiedName().equals("uf")) {
					cboUF.setSelectedItem(element.getText());
				} */
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				/*if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));
					} else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
					}
				} */
			}
			txtRua.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
