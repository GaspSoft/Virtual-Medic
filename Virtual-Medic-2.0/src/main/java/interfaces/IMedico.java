package interfaces;

import modelo.Medico;

public interface IMedico {
	public boolean inserir(Medico m);
	public boolean excluir(Long crm);
	public boolean atualizar(Medico m);
	public Medico buscarPorCRM(Long crm);
}
