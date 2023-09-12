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

	// UPDATE
	public Boolean alterar(Paciente p) {
		for (Paciente paciente : listaPaciente) {
			if (paciente.getCpf().equals(paciente.getCpf())) {
				
				paciente.setCpf(p.getCpf());
				paciente.setNome(p.getNome());
				paciente.setEmail(p.getEmail());
				paciente.setIdade(p.getIdade());
				paciente.setGenero(p.getGenero());
				paciente.setCep(p.getCep());
				paciente.setUf(p.getUf());
				paciente.setCidade(p.getCidade());
				paciente.setBairro(p.getBairro());
				paciente.setRua(p.getRua());
				paciente.setNumero(p.getNumero());
				paciente.setComplemento(p.getComplemento());
				paciente.setMedico(p.getMedico());
				paciente.setDiagnostico(p.getDiagnostico());
				paciente.setNumeroPlano(p.getNumeroPlano());
				paciente.setValidade(p.getValidade());
				
				return true;
			}
		}
		return false;
	}
	// DELETE
	public Boolean deletar(Paciente p, Long cpf) {
		for (Paciente paciente : listaPaciente) {
			if (paciente.getCpf() == cpf) {
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

	// SELECT BY ID
	public Paciente buscarPorCPF(Long cpf) {
		for (Paciente paciente : listaPaciente) {
			if (paciente.getCpf().equals(cpf)) {
				return paciente;
			}
		}
		return null; // Retorna null se a pessoa não for encontrada
	}

}
