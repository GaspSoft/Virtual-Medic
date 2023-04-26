package controle;

import java.util.ArrayList;

import modelo.Medico;

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
	
	//UPDATE
		public Boolean alterar(Medico m, String cpf) {

				for(Medico medico : listaMedico) {
					if (medico.getCpf().equals(cpf) ) {
						
						//Classe Pessoa
						medico.setCpf(m.getCpf());
						medico.setNome(m.getNome());
						medico.setEmail(m.getEmail());
						medico.setGenero(m.getGenero());
						medico.setIdade(m.getIdade());
						
						//Classe Endereço
						medico.setCep(m.getCep());
						medico.setUf(m.getUf());
						medico.setCidade(m.getCidade());
						medico.setBairro(m.getBairro());
						medico.setRua(m.getRua());
						medico.setNumero(m.getNumero());
						medico.setComplemento(m.getComplemento());
						
						//Classe medico
						medico.setCrm(m.getCrm());
						medico.setEspecificacao(m.getEspecificacao());
			
				return true;
			}
		}
		return false;

		}
		
		//DELETE
		public Boolean deletar(Medico m, String cpf) {
			for (Medico medico : listaMedico) {
				if (medico.getCpf().equals(cpf) ){
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

	
}
