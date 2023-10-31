package teste;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controle.DAOmedico;
import controle.DAOpaciente;
import modelo.Medico;
import modelo.Paciente;

public class DAOpacienteTest {
	
	@Test
	public void listarTest() {
		DAOpaciente dao = new DAOpaciente();
		ArrayList<Paciente> paciente = dao.listar();
		assertTrue(!paciente.isEmpty());
	}

	@Test
	public void inserirTest() {
		Paciente p = new Paciente();
		p.setCpf((long) 12222222);
		p.setNome("Augusto");
		p.setEmail("augusto@gmail.com");
		p.setGenero("masc");
		p.setIdade(22);
		p.setMedico("Brunao");
		p.setDiagnostico("Doente");
		p.setPlanoSaude("Unimed");
		p.setNumeroPlano((long)122888);
		p.setValidade("04/01/2006");
		p.setCep((long)122888);
		p.setUf("SC");
		p.setCidade("Blumenau");
		p.setBairro("Velha");
		p.setRua("João Pessoa");
		p.setNumero(100);
		p.setComplemento("casa");
		
		DAOpaciente dao = new DAOpaciente();
		boolean mInserido = dao.inserir(p);
		assertEquals(true, mInserido);
	}
	
	@Test
	public void atualizarTest() {
		DAOpaciente dao = new DAOpaciente();
		Paciente p = new Paciente();
		p.setCpf((long) 12222222);
		p.setNome("Augusto");
		p.setEmail("augusto@gmail.com");
		p.setGenero("masc");
		p.setIdade(22);
		p.setMedico("Brunao");
		p.setDiagnostico("Doente");
		p.setPlanoSaude("Unimed");
		p.setNumeroPlano((long)122888);
		p.setValidade("04/01/2006");
		p.setCep((long)122888);
		p.setUf("SC");
		p.setCidade("Blumenau");
		p.setBairro("Velha");
		p.setRua("João Pessoa");
		p.setNumero(100);
		p.setComplemento("casa");
	    boolean exclusaoBemSucedida = dao.atualizar(p);
	    assertTrue(exclusaoBemSucedida);
	}
	
	@Test
	public void excluirTest() {
		DAOpaciente dao = new DAOpaciente();
	    long cpf = 12222222;
	    boolean exclusaoBemSucedida = dao.excluir(cpf);
	    assertTrue(exclusaoBemSucedida);
	}
}
