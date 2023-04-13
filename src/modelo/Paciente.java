package modelo;

public class Paciente  {
	
	private Medico medico;
	private String Endereco;
	private String Diagnostico;
	
		
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getDiagnostico() {
		return Diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		Diagnostico = diagnostico;
	}
	@Override
	public String toString() {
		return "Paciente [medico=" + medico + ", Endereco=" + Endereco + ", Diagnostico=" + Diagnostico + "]";
	}
	
}
