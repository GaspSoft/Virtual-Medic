package teste;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controle.DAOplanoSaude;
import modelo.PlanoSaude;

public class DAOplanoSaudeTest {

	@Test
	public void listarTest() {
		DAOplanoSaude dao = new DAOplanoSaude();
		ArrayList<PlanoSaude> planos = dao.listar();
		assertTrue(!planos.isEmpty());
	}

	@Test
	public void inserirTest() {
		PlanoSaude pl = new PlanoSaude();
		pl.setId(5);
		pl.setNome("Unimed - RJ");
		pl.setFoto(null);
		DAOplanoSaude dao = new DAOplanoSaude();
		boolean plInserido = dao.inserir(pl, null, null);
		assertEquals(true, plInserido);
	}
	
	@Test
	public void atualizarTest() {
		DAOplanoSaude dao = new DAOplanoSaude();
	    PlanoSaude pl = new PlanoSaude();
	    pl.setId(1);
	    pl.setNome("SUS");
	    boolean exclusaoBemSucedida = dao.atualizar(pl);
	    assertTrue(exclusaoBemSucedida);
	}
	
	@Test
	public void excluirTest() {
		DAOplanoSaude dao = new DAOplanoSaude();
	    int id = 4;
	    boolean exclusaoBemSucedida = dao.excluir(id);
	    assertTrue(exclusaoBemSucedida);
	}
}
