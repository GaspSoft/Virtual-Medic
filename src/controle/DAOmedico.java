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
	
	// SELECT ALL
	public ArrayList<Medico> listaMedico() {
		return listaMedico;
	}

	
}
