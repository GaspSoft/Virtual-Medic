package controle;

import java.util.ArrayList;

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
	public boolean inserir(PlanoSaude ps) {
		if (ps != null) {
			listaPlanoSaude.add(ps);
			return true;
		}
		return false;
	}
	
	// UPDATE
	public boolean alterar(PlanoSaude planoAlterar, int id) {

		for (PlanoSaude planosaude : listaPlanoSaude) {

			if (planosaude.getId() == id) {
				planosaude.setNome(planoAlterar.getNome());
					
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
	public ArrayList<PlanoSaude> listaPlanoSaude() {
		return listaPlanoSaude;
	}
	
}
