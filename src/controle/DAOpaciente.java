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
	public boolean alterar(Paciente paciente) {
		for (Paciente p : listaPaciente) {
			if (p.getCpf().equals(paciente.getCpf())) {
				p.setNome(paciente.getNome());
				p.setEmail(paciente.getEmail());
				p.setIdade(paciente.getIdade());
				p.setGenero(paciente.getGenero());
				p.setCep(paciente.getCep());
				p.setUf(paciente.getUf());
				p.setCidade(paciente.getCidade());
				p.setBairro(paciente.getBairro());
				p.setRua(paciente.getRua());
				p.setNumero(paciente.getNumero());
				p.setComplemento(paciente.getComplemento());
				p.setMedico(paciente.getMedico());
				p.setDiagnostico(paciente.getDiagnostico());
				p.setNumeroPlano(paciente.getNumeroPlano());
				p.setValidade(paciente.getValidade());
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
