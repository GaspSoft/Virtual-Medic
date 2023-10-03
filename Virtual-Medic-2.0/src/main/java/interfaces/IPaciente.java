package interfaces;

import modelo.Paciente;

public interface IPaciente {
	public boolean inserir(Paciente p);
	public boolean excluir(Long cpf);
	public boolean atualizar(Paciente p);
	public Paciente buscarPorCPF(Long cpf);
}
