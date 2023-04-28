package controle;

import java.util.ArrayList;

import modelo.Paciente;

public class DAOpaciente {
	
	private static ArrayList<Paciente> listaPaciente;
	private static DAOpaciente instanciaPaciente;
	
	public static DAOpaciente getInstacia() {
			
			if (instanciaPaciente == null) {
				instanciaPaciente = new DAOpaciente();
				listaPaciente = new ArrayList<>();
			}
			
		return instanciaPaciente;
	}
	
	// INSERT
	public boolean inserir(Paciente p) {
		if (p != null) {
			listaPaciente.add(p);
			return true;
		}
		return false;
	}
	
	//UPDATE
			public Boolean alterar(Paciente p, String cpf) {

					for(Paciente paciente : listaPaciente) {
						if (paciente.getCpf().equals(cpf) ) {
							
							//Classe Pessoa
							paciente.setCpf(p.getCpf());
							paciente.setNome(p.getNome());
							paciente.setEmail(p.getEmail());
							paciente.setGenero(p.getGenero());
							paciente.setIdade(p.getIdade());
							
							//Classe Endereço
							paciente.setCep(p.getCep());
							paciente.setUf(p.getUf());
							paciente.setCidade(p.getCidade());
							paciente.setBairro(p.getBairro());
							paciente.setRua(p.getRua());
							paciente.setNumero(p.getNumero());
							paciente.setComplemento(p.getComplemento());
							
							//Classe paciente
							paciente.setMedico(p.getMedico());
							paciente.setDiagnostico(cpf);
							paciente.setNumeroPlano(p.getNumeroPlano());
							paciente.setValidade(p.getValidade());
				
					return true;
				}
			}
			return false;

			}
			
			//DELETE
			public Boolean deletar(Paciente p, String cpf) {
				for (Paciente paciente : listaPaciente) {
					if (paciente.getCpf().equals(cpf) ){
						listaPaciente.remove(paciente);
						return true;
					}
				}
				return false;
			}
	
	// SELECT ALL
	public ArrayList<Paciente> listalPaciente() {
		return listaPaciente;
	}
	
}
