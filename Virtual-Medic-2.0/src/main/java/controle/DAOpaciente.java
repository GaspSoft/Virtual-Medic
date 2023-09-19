package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Paciente;

public class DAOpaciente {
	
	public ArrayList<Paciente> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

		String query = "SELECT * FROM pacientes";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String genero = rs.getString("genero");
				int idade = rs.getInt("idade");
				String medico = rs.getString("medico");
				String diagnostico = rs.getString("diagnostico");
				String planoSaude = rs.getString("planoSaude");
				long numeroPlano = rs.getLong("numeroPlano");
				String validade = rs.getString("validade");
				long cep = rs.getLong("cep");
				String uf = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				int numero = rs.getInt("numero");
				String complemento = rs.getString("complemento");

				Paciente p = new Paciente();
				p.setCpf(cpf);
				p.setNome(nome);
				p.setEmail(email);
				p.setGenero(genero);
				p.setIdade(idade);
				p.setMedico(medico);
				p.setDiagnostico(diagnostico);
				p.setPlanoSaude(planoSaude);
				p.setNumeroPlano(numeroPlano);
				p.setValidade(validade);
				p.setCep(cep);
				p.setUf(uf);
				p.setCidade(cidade);
				p.setBairro(bairro);
				p.setRua(rua);
				p.setNumero(numero);
				p.setComplemento(complemento);
				pacientes.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		c.fecharConexao();

		return pacientes;
	}

	public boolean inserir(Paciente p) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO pacientes (cpf, nome, email, genero, idade, medico, diagnostico, planoSaude, numeroPlano, validade, cep, estado, cidade, bairro, rua, numero, complemento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, p.getCpf());
			ps.setString(2, p.getNome());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getGenero());
			ps.setInt(5, p.getIdade());
			ps.setString(6, p.getMedico());
			ps.setString(7, p.getDiagnostico());
			ps.setString(8, p.getPlanoSaude());
			ps.setLong(9, p.getNumeroPlano());
			ps.setString(10, p.getValidade());
			ps.setLong(11, p.getCep());
			ps.setString(12, p.getUf());
			ps.setString(13, p.getCidade());
			ps.setString(14, p.getBairro());
			ps.setString(15, p.getRua());
			ps.setInt(16, p.getNumero());
			ps.setString(17, p.getComplemento());

			ps.executeUpdate();

			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean excluir(Long cpf) { // Altere o método para receber um Long como parâmetro
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();

	    String query = "DELETE FROM pacientes WHERE cpf = ?";

	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setLong(1, cpf); // Use o CPF recebido como parâmetro

	        int rowsDeleted = ps.executeUpdate();

	        c.fecharConexao();

	        return rowsDeleted > 0; // Verifique se pelo menos uma linha foi excluída com sucesso.
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
	public boolean atualizar(Paciente p) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();
		String query = "UPDATE paciente SET cpf = ?, nome = ?, email = ?, genero = ?, idade = ?, medico = ?, diagnostico = ?, planoSaude = ?, numeroPlano = ?, validade = ?, cep = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, numero = ?, complemento = ? WHERE cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setLong(1, p.getCpf());
			ps.setString(2, p.getNome());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getGenero());
			ps.setInt(5, p.getIdade());
			ps.setString(6, p.getMedico());
			ps.setString(7, p.getDiagnostico());
			ps.setString(8, p.getPlanoSaude());
			ps.setLong(9, p.getNumeroPlano());
			ps.setString(10, p.getValidade());
			ps.setLong(11, p.getCep());
			ps.setString(12, p.getUf());
			ps.setString(13, p.getCidade());
			ps.setString(14, p.getBairro());
			ps.setString(15, p.getRua());
			ps.setInt(16, p.getNumero());
			ps.setString(17, p.getComplemento());
			
			ps.executeUpdate();
			c.fecharConexao();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public Paciente buscarPorCPF(Long cpf) {
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
	    
	    String query = "SELECT * FROM paciente WHERE cpf = ?";
	    
	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setLong(1, cpf);
	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String genero = rs.getString("genero");
				int idade = rs.getInt("idade");
				String medico = rs.getString("medico");
				String diagnostico = rs.getString("diagnostico");
				String planoSaude = rs.getString("planoSaude");
				long numeroPlano = rs.getLong("numeroPlano");
				String validade = rs.getString("validade");
				long cep = rs.getLong("cep");
				String uf = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				int numero = rs.getInt("numero");
				String complemento = rs.getString("complemento");

	            Paciente p = new Paciente();
	            p.setCpf(cpf);
				p.setNome(nome);
				p.setEmail(email);
				p.setGenero(genero);
				p.setIdade(idade);
				p.setMedico(medico);
				p.setDiagnostico(diagnostico);
				p.setPlanoSaude(planoSaude);
				p.setNumeroPlano(numeroPlano);
				p.setValidade(validade);
				p.setCep(cep);
				p.setUf(uf);
				p.setCidade(cidade);
				p.setBairro(bairro);
				p.setRua(rua);
				p.setNumero(numero);
				p.setComplemento(complemento);
	            
	            c.fecharConexao();
	            
	            return p;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    c.fecharConexao();
	    
	    return null;
	}

}
