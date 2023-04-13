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
	
	// SELECT ALL
	public ArrayList<Paciente> listalPaciente() {
		return listaPaciente;
	}
	
}
