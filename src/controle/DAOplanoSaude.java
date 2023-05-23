package controle;

import java.util.ArrayList;

import modelo.Paciente;
import modelo.PlanoSaude;

public class DAOplanoSaude {
	
	private static ArrayList<PlanoSaude> listaPlanoSaude;
	private static DAOplanoSaude instanciaPlanoSaude;
	
	public static DAOplanoSaude getInstacia() {
			
			if (instanciaPlanoSaude == null) {
				instanciaPlanoSaude = new DAOplanoSaude();
				listaPlanoSaude = new ArrayList<>();
			}
			
		return instanciaPlanoSaude;
	}
	
	// INSERT
	public boolean inserir(PlanoSaude planoSaude) {
		if (planoSaude != null) {
			listaPlanoSaude.add(planoSaude);
			return true;
		}
		return false;
	}
	
	// UPDATE
	public Boolean alterar(PlanoSaude pa) {
		for (PlanoSaude planoSaude : listaPlanoSaude) {
			if (planoSaude.getId() == pa.getId()) {
				planoSaude.setNome(pa.getNome());
				return true;
			}
		}
		return false;
	}
	
	// DELETE
	public boolean deletar(PlanoSaude planoDeletar, int id) {

		for (PlanoSaude planosaude : listaPlanoSaude) {
			if (planosaude.getId() == id) {
				listaPlanoSaude.remove(planosaude);
				return true;
			}

		}
		return false;
	}
	
	// SELECT ALL
	public PlanoSaude buscarID(Integer id) {
		for (PlanoSaude planosaude : listaPlanoSaude) {
			if (planosaude.getId() == id) {
				return planosaude;
			}
		}
		return null;
	}
	
	public ArrayList<PlanoSaude> listaPlanoSaude() {
		return listaPlanoSaude;
	}
}
