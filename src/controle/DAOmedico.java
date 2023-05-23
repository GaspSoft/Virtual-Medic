package controle;

import java.util.ArrayList;

import modelo.Medico;
import modelo.Paciente;

public class DAOmedico {

	private static ArrayList<Medico> listaMedico;
	private static DAOmedico instancia;

	public static DAOmedico getInstacia() {

		if (instancia == null) {
			instancia = new DAOmedico();
			listaMedico = new ArrayList<>();
		}

		return instancia;
	}

	// INSERT
	public boolean inserir(Medico m) {
		if (m != null) {
			listaMedico.add(m);
			return true;
		}
		return false;
	}

	// UPDATE
	public Boolean alterar(Medico m) {

		for (Medico medico : listaMedico) {
			if (medico.getCrm().equals(m.getCrm())) {

				
				medico.setCpf(m.getCpf());
				medico.setNome(m.getNome());
				medico.setEmail(m.getEmail());
				medico.setGenero(m.getGenero());
				medico.setIdade(m.getIdade());
				medico.setCep(m.getCep());
				medico.setUf(m.getUf());
				medico.setCidade(m.getCidade());
				medico.setBairro(m.getBairro());
				medico.setRua(m.getRua());
				medico.setNumero(m.getNumero());
				medico.setComplemento(m.getComplemento());
				medico.setCrm(m.getCrm());
				medico.setEspecificacao(m.getEspecificacao());

				return true;
			}
		}
		return false;

	}

	// DELETE
	public Boolean deletar(Medico m, Long crm) {
		for (Medico medico : listaMedico) {
			if (medico.getCpf().equals(crm)) {
				listaMedico.remove(medico);
				return true;
			}
		}
		return false;
	}

	// SELECT ALL
	public ArrayList<Medico> listaMedico() {
		return listaMedico;
	}
	
	// SELECT BY ID
		public Medico buscarPorCPF(Long crm) {
			for (Medico medico : listaMedico) {
				if (medico.getCrm().equals(crm)) {
					return medico;
				}
			}
			return null;
		}

}
