package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.IMedico;
import modelo.Medico;
import modelo.Paciente;

public class DAOmedico implements IMedico {

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
		} finally {
			c.fecharConexao();
		}

		return medicos;
	}

	@Override
	public boolean inserir(Medico m) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();
		
		int j = 0;
		StringBuilder query = new StringBuilder();

		query.append("INSERT INTO medicos (");

		long cpf = m.getCpf();
		String nome = m.getNome();
		String email = m.getEmail();
		String genero = m.getGenero();
		int idade = m.getIdade();
		long crm = m.getCrm();
		String especificacao = m.getEspecificacao();
		long cep = m.getCep();
		String uf = m.getUf();
		String cidade = m.getCidade();
		String bairro = m.getBairro();
		String rua = m.getRua();
		int numero = m.getNumero();
		String complemento = m.getComplemento();

		if (cpf > 0) {
			query.append("cpf");
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
		
		if (crm > 0) {
			query.append(", crm");
			j++;
		}
		
		if (especificacao != null) {
			query.append(", especificacao");
			j++;
		}
		
		if (cep > 0) {
			query.append(", cep");
			j++;
		}
		
		if (uf != null) {
			query.append(", estado");
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

		query.append(");");
		System.out.println(query);

		int i = 1;
		try {
			PreparedStatement ps = con.prepareStatement(query.toString());

			if (cpf > 0) {
				ps.setLong(i, cpf);
				i++;
			}
			
			if (nome != null) {
				ps.setString(i, nome);
				i++;
			}
			
			if (email != null) {
				ps.setString(i, email);
				i++;
			}
			
			if (genero != null) {
				ps.setString(i, genero);
				i++;
			}
			
			if (idade > 0) {
				ps.setInt(i, idade);
				i++;
			}
			
			if (crm > 0) {
				ps.setLong(i, crm);
				i++;
			}
			
			if (especificacao != null) {
				ps.setString(i, especificacao);
				i++;
			}
			
			if (cep > 0) {
				ps.setLong(i, cep);
				i++;
			}
			
			if (uf != null) {
				ps.setString(i, uf);
				i++;
			}
			
			if (cidade != null) {
				ps.setString(i, cidade);
				i++;
			}
			
			if (bairro != null) {
				ps.setString(i, bairro);
				i++;
			}
			
			if (rua != null) {
				ps.setString(i, rua);
				i++;
			}
			
			if (numero > 0) {
				ps.setInt(i, numero);
				i++;
			}
			
			if (complemento != null) {
				ps.setString(i, complemento);
				i++;
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
	public boolean excluir(Long crm) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM medicos WHERE crm = ?";

		try {

			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, crm);

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
			ps.setLong(15, m.getCrm());
			
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
	         	            
	            return m;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
			c.fecharConexao();
		}
	    
	    return null;
	}

}
