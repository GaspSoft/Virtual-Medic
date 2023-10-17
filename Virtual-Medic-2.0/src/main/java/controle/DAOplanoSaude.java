package controle;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.IPlanoSaude;
import modelo.PlanoSaude;

public class DAOplanoSaude implements IPlanoSaude {
	
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

	@Override
	public boolean inserir(PlanoSaude pl, int tamanho, FileInputStream fis) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO planoSaude (id, nome, foto) VALUES (?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, pl.getId());
			ps.setString(2, pl.getNome());
			ps.setBlob(3, fis, tamanho);


			ps.executeUpdate();

			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean excluir(Integer id) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM planoSaude WHERE id = ?";

		try {

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);

			ps.executeUpdate();

			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean atualizar(PlanoSaude pl) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();
		String query = "UPDATE planoSaude SET nome = ? WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, pl.getNome());
			ps.setInt(2, pl.getId());
			
			ps.executeUpdate();
			c.fecharConexao();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public PlanoSaude buscarPorId(Integer id) {
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
	    
	    String query = "SELECT * FROM planoSaude WHERE id = ?";
	    
	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, id);
	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
				String nome = rs.getString("nome");
				
	            PlanoSaude pl = new PlanoSaude();
	            pl.setNome(nome);
	            pl.setId(id);
	            
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