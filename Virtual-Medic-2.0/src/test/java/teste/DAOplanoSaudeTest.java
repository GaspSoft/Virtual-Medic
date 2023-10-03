package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import controle.DAOplanoSaude;
import modelo.PlanoSaude;

public class DAOplanoSaudeTest {
	
	@Test 
	public void inserirPlanoSaudeTest() {
		PlanoSaude pl = new PlanoSaude();
		
		pl.setId(2);
		pl.setNome("Unimed - PR");
		DAOplanoSaude dao = new DAOplanoSaude();
		boolean plInserido = dao.inserir(pl);
		assertEquals(true, plInserido);
	}
}
