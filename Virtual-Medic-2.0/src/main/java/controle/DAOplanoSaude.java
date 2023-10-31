package controle;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Blob;

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
				Blob foto = (Blob) rs.getBlob("foto");
				PlanoSaude pl = new PlanoSaude();
				pl.setId(id);
				pl.setNome(nome);
				pl.setFoto(foto);

				planoSaudes.add(pl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		c.fecharConexao();

		return planoSaudes;
	}

	@Override
	public boolean inserir(PlanoSaude pl, Integer tamanho, FileInputStream fis) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		int j = 0;
		StringBuilder query = new StringBuilder();

		query.append("INSERT INTO planoSaude (");

		// VALUES (?, ?, ?)
		int id = pl.getId();
		String nome = pl.getNome();

		if (id > 0) {
			query.append("id");
			j++;
		}
		if (nome != null) {
			query.append(", nome");
			j++;
		}

		if (fis != null && tamanho > 0) {
			query.append(", foto");
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

			if (id > 0) {

				ps.setInt(i, id);
				i++;
			}
			if (nome != null) {
				ps.setString(i, nome);
				i++;
			}

			if (fis != null && tamanho > 0) {
				ps.setBlob(i, fis, tamanho);
				i++;
			}

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