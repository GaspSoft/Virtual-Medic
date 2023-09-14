package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Paciente;
import modelo.PlanoSaude;

public class DAOplanoSaude {
	
	public ArrayList<PlanoSaude> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		ArrayList<PlanoSaude> planoSaudes = new ArrayList<PlanoSaude>();

		String query = "SELECT * FROM planoSaude";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");

				PlanoSaude pl = new PlanoSaude();
				pl.setId(id);
				pl.setNome(nome);
				
				planoSaudes.add(pl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		c.fecharConexao();

		return planoSaudes;
	}

	public boolean inserir(PlanoSaude pl) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO planoSaude (id, nome) VALUES (?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, pl.getId());
			ps.setString(2, pl.getNome());


			ps.executeUpdate();

			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean excluir(PlanoSaude pl) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM planoSaude WHERE id = ?";

		try {

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, pl.getId());

			ps.executeUpdate();

			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean atualizar(PlanoSaude pl) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();
		String query = "UPDATE planoSaude SET nome = ? WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, pl.getId());
			ps.setString(2, pl.getNome());
			
			ps.executeUpdate();
			c.fecharConexao();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public PlanoSaude buscarPorCPF(int id) {
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
	    
	    String query = "SELECT * FROM planoSaude WHERE id = ?";
	    
	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setLong(1, id);
	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
				String nome = rs.getString("nome");

	            PlanoSaude pl = new PlanoSaude();
	            pl.setNome(nome);

	            
	            c.fecharConexao();
	            
	            return pl;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    c.fecharConexao();
	    
	    return null;
	}
}
