package interfaces;

import modelo.PlanoSaude;

public interface IPlanoSaude {
	public boolean inserir(PlanoSaude pl);
	public boolean excluir(Integer id);
	public boolean atualizar(PlanoSaude pl);
	public PlanoSaude buscarPorId(Integer id);
}
