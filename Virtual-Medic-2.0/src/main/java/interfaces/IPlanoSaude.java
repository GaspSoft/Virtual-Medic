package interfaces;

import java.io.FileInputStream;

import modelo.PlanoSaude;

public interface IPlanoSaude {
	public boolean inserir(PlanoSaude pl, int tamanho, FileInputStream fis);
	public boolean excluir(Integer id);
	public boolean atualizar(PlanoSaude pl);
	public PlanoSaude buscarPorId(Integer id);
}
