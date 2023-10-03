package teste;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import controle.DAOmedico;
import modelo.Medico;


	public class DAOmedicoTest {

		@Test
		public void listarTest() {
			DAOmedico dao = new DAOmedico();
			ArrayList<Medico> medico = dao.listar();
			assertTrue(!medico.isEmpty());
		}

		@Test
		public void inserirTest() {
			Medico m = new Medico();
			m.setCpf((long) 12222222);
			m.setNome("Augusto");
			m.setEmail("augusto@gmail.com");
			m.setGenero("masc");
			m.setIdade(22);
			m.setCrm((long) 1234567);
			m.setEspecificacao("cardiologista");
			m.setCep((long)122888);
			m.setUf("SC");
			m.setCidade("Blumenau");
			m.setBairro("Velha");
			m.setRua("João Pessoa");
			m.setNumero(100);
			m.setComplemento("casa");
			
			DAOmedico dao = new DAOmedico();
			boolean mInserido = dao.inserir(m);
			assertEquals(true, mInserido);
		}
		
		@Test
		public void atualizarTest() {
			DAOmedico dao = new DAOmedico();
		    Medico m = new Medico();
		    m.setCpf((long) 13333333);
			m.setNome("Marcelo");
			m.setEmail("marcelo@gmail.com");
			m.setGenero("masc");
			m.setIdade(24);
			m.setCrm((long) 2345678);
			m.setEspecificacao("infectologista");
			m.setCep((long)122333);
			m.setUf("SC");
			m.setCidade("Itajaí");
			m.setBairro("Monte Raso");
			m.setRua("Iguaruta melin");
			m.setNumero(150);
			m.setComplemento("apartamento");
		    boolean exclusaoBemSucedida = dao.atualizar(m);
		    assertTrue(exclusaoBemSucedida);
		}
		
		@Test
		public void excluirTest() {
			DAOmedico dao = new DAOmedico();
		    long crm = 1234567;
		    boolean exclusaoBemSucedida = dao.excluir(crm);
		    assertTrue(exclusaoBemSucedida);
		}
	}


