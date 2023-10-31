package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.IPaciente;
import modelo.Paciente;

public class DAOpaciente implements IPaciente {
	
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
		} finally {
			c.fecharConexao();
		}

		return pacientes;
	}

	@Override
	public boolean inserir(Paciente p) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();
		
		int j = 0;
		StringBuilder query = new StringBuilder();

		query.append("INSERT INTO planoSaude (");

		long cpf = p.getCpf();
		String nome = p.getNome();
		String email = p.getEmail();
		String genero = p.getGenero();
		int idade = p.getIdade();
		String medico = p.getMedico();
		String diagnostico = p.getDiagnostico();
		String planoSaude = p.getPlanoSaude();
		long numeroPlano = p.getNumeroPlano();
		String validade = p.getValidade();
		long cep = p.getCep();
		String uf = p.getUf();
		String cidade = p.getCidade();
		String bairro = p.getBairro();
		String rua = p.getRua();
		int numero = p.getNumero();
		String complemento = p.getComplemento();

		if (cpf > 0) {
			query.append("id");
			j++;
		}
		
		if (nome != null) {
			query.append(", nome");
			j++;
		}
		
		if (email != null) {
			query.append(", email");
			j++;
		}
		
		if (genero != null) {
			query.append(", genero");
			j++;
		}
		
		if (idade > 0) {
			query.append(", idade");
			j++;
		}
		
		if (medico != null) {
			query.append(", medico");
			j++;
		}
		
		if (diagnostico != null) {
			query.append(", diagnostico");
			j++;
		}
		
		if (planoSaude != null) {
			query.append(", PlanoSaude");
			j++;
		}
		
		if (numeroPlano > 0) {
			query.append(", numeroPlano");
			j++;
		}
		
		if (validade != null) {
			query.append(", validade");
			j++;
		}
		
		if (cep > 0) {
			query.append(", cp");
			j++;
		}
		
		if (uf != null) {
			query.append(", uf");
			j++;
		}
		
		if (cidade != null) {
			query.append(", cidade");
			j++;
		}
		
		if (bairro != null) {
			query.append(", bairro");
			j++;
		}
		
		if (rua != null) {
			query.append(", rua");
			j++;
		}
		
		if (numero > 0) {
			query.append(", numero");
			j++;
		}
		
		if (complemento != null) {
			query.append(", complemento");
			j++;
		}


		query.append(") VALUES (");
		for (int k = 0; k < j; k++) {
			query.append("?");
			if (k != (j - 1)) {
				query.append(",");
			}
		}

		query.append(")");

		int i = 1;
		try {
			PreparedStatement ps = con.prepareStatement(query.toString());

			if (cpf > 0) {
				ps.setLong(i, cpf);
				j++;
			}
			
			if (nome != null) {
				ps.setString(i, nome);
				j++;
			}
			
			if (email != null) {
				ps.setString(i, email);
				j++;
			}
			
			if (genero != null) {
				ps.setString(i, genero);
				j++;
			}
			
			if (idade > 0) {
				ps.setInt(i, idade);
				j++;
			}
			
			if (medico != null) {
				ps.setString(i, medico);
				j++;
			}
			
			if (diagnostico != null) {
				ps.setString(i, diagnostico);
				j++;
			}
			
			if (planoSaude != null) {
				ps.setString(i, planoSaude);
				j++;
			}
			
			if (numeroPlano > 0) {
				ps.setLong(i, numeroPlano);
				j++;
			}
			
			if (validade != null) {
				ps.setString(i, validade);
				j++;
			}
			
			if (cep > 0) {
				ps.setLong(i, cep);
				j++;
			}
			
			if (uf != null) {
				ps.setString(i, uf);
				j++;
			}
			
			if (cidade != null) {
				ps.setString(i, cidade);
				j++;
			}
			
			if (bairro != null) {
				ps.setString(i, bairro);
				j++;
			}
			
			if (rua != null) {
				ps.setString(i, rua);
				j++;
			}
			
			if (numero > 0) {
				ps.setInt(i, numero);
				j++;
			}
			
			if (complemento != null) {
				ps.setString(i, complemento);
				j++;
			}
			
			ps.executeUpdate();
	
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}
		
		return false;
	}

	@Override
	public boolean excluir(Long cpf) { // Altere o método para receber um Long como parâmetro
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();

	    String query = "DELETE FROM pacientes WHERE cpf = ?";

	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setLong(1, cpf); // Use o CPF recebido como parâmetro

	        int rowsDeleted = ps.executeUpdate();

	        return rowsDeleted > 0; // Verifique se pelo menos uma linha foi excluída com sucesso.
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
			c.fecharConexao();
		}
	    
	    return false;
	}

	@Override
	public boolean atualizar(Paciente p) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();
		String query = "UPDATE pacientes SET cpf = ?, nome = ?, email = ?, genero = ?, medico = ?, diagnostico = ?, planoSaude = ?, numeroPlano = ?, validade = ?, idade = ?, cep = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, numero = ?, complemento = ? WHERE cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setLong(1, p.getCpf());
			ps.setString(2, p.getNome());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getGenero());
			ps.setString(5, p.getMedico());
			ps.setString(6, p.getDiagnostico());
			ps.setString(7, p.getPlanoSaude());
			ps.setLong(8, p.getNumeroPlano());
			ps.setString(9, p.getValidade());
			ps.setInt(10, p.getIdade());
			ps.setLong(11, p.getCep());
			ps.setString(12, p.getUf());
			ps.setString(13, p.getCidade());
			ps.setString(14, p.getBairro());
			ps.setString(15, p.getRua());
			ps.setInt(16, p.getNumero());
			ps.setString(17, p.getComplemento());
			ps.setLong(18, p.getCpf());
			
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;

	}

	@Override
	public Paciente buscarPorCPF(Long cpf) {
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
	    
	    String query = "SELECT * FROM pacientes WHERE cpf = ?";
	    
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
	    } finally {
			c.fecharConexao();
		}
	    
	    return null;
	}

}
