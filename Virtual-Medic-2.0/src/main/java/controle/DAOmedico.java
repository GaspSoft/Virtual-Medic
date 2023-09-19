package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Medico;
import modelo.Paciente;

public class DAOmedico {

	public ArrayList<Medico> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		ArrayList<Medico> medicos = new ArrayList<Medico>();

		String query = "SELECT * FROM medicos";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String genero = rs.getString("genero");
				int idade = rs.getInt("idade");
				long crm = rs.getLong("crm");
				String especificacao = rs.getString("especificacao");
				long cep = rs.getLong("cep");
				String uf = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				int numero = rs.getInt("numero");
				String complemento = rs.getString("complemento");

				Medico m = new Medico();
				m.setCpf(cpf);
				m.setNome(nome);
				m.setEmail(email);
				m.setGenero(genero);
				m.setIdade(idade);
				m.setCrm(crm);
				m.setEspecificacao(especificacao);
				m.setCep(cep);
				m.setUf(uf);
				m.setCidade(cidade);
				m.setBairro(bairro);
				m.setRua(rua);
				m.setNumero(numero);
				m.setComplemento(complemento);
				medicos.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		c.fecharConexao();

		return medicos;
	}

	public boolean inserir(Medico m) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO medicos (cpf, nome, email, genero, idade, crm, especificacao, cep, estado, cidade, bairro, rua, numero, complemento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, m.getCpf());
			ps.setString(2, m.getNome());
			ps.setString(3, m.getEmail());
			ps.setString(4, m.getGenero());
			ps.setInt(5, m.getIdade());
			ps.setLong(6, m.getCrm());
			ps.setString(7, m.getEspecificacao());
			ps.setLong(8, m.getCep());
			ps.setString(9, m.getUf());
			ps.setString(10, m.getCidade());
			ps.setString(11, m.getBairro());
			ps.setString(12, m.getRua());
			ps.setInt(13, m.getNumero());
			ps.setString(14, m.getComplemento());

			ps.executeUpdate();

			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean excluir(Long crm) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM medicos WHERE crm = ?";

		try {

			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, crm);

			ps.executeUpdate();

			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean atualizar(Medico m) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();
		String query = "UPDATE medicos SET cpf = ?, nome = ?, email = ?, genero = ?, idade = ?, crm = ?, especificacao = ?, cep = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, numero = ?, complemento = ? WHERE crm = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setLong(1, m.getCpf());
			ps.setString(2, m.getNome());
			ps.setString(3, m.getEmail());
			ps.setString(4, m.getGenero());
			ps.setInt(5, m.getIdade());
			ps.setLong(6, m.getCrm());
			ps.setString(7, m.getEspecificacao());
			ps.setLong(8, m.getCep());
			ps.setString(9, m.getUf());
			ps.setString(10, m.getCidade());
			ps.setString(11, m.getBairro());
			ps.setString(12, m.getRua());
			ps.setInt(13, m.getNumero());
			ps.setString(14, m.getComplemento());
			
			ps.executeUpdate();
			c.fecharConexao();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public Medico buscarPorCRM(Long crm) {
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
	    
	    String query = "SELECT * FROM medicos WHERE crm = ?";
	    
	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setLong(1, crm);
	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            long cpf = rs.getLong("cpf");
	            String nome = rs.getString("nome");
	            String email = rs.getString("email");
	            String genero = rs.getString("genero");
	            int idade = rs.getInt("idade");
	            String especificacao = rs.getString("especificacao");
	            long cep = rs.getLong("cep");
	            String uf = rs.getString("estado");
	            String cidade = rs.getString("cidade");
	            String bairro = rs.getString("bairro");
	            String rua = rs.getString("rua");
	            int numero = rs.getInt("numero");
	            String complemento = rs.getString("complemento");

	            Medico m = new Medico();
	            m.setCpf(cpf);
	            m.setNome(nome);
	            m.setEmail(email);
	            m.setGenero(genero);
	            m.setIdade(idade);
	            m.setCrm(crm);
	            m.setEspecificacao(especificacao);
	            m.setCep(cep);
	            m.setUf(uf);
	            m.setCidade(cidade);
	            m.setBairro(bairro);
	            m.setRua(rua);
	            m.setNumero(numero);
	            m.setComplemento(complemento);
	            
	            c.fecharConexao();
	            
	            return m;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    c.fecharConexao();
	    
	    return null;
	}

}
