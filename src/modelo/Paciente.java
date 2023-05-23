package modelo;

import java.time.LocalDate;

public class Paciente extends Pessoa {
	
	private String medico;
	private String Diagnostico;
	private String planoSaude;
	private Long numeroPlano;
	private String validade;
	
		
	
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
	public String getDiagnostico() {
		return Diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		Diagnostico = diagnostico;
	}
	public String getPlanoSaude() {
		return planoSaude;
	}
	public void setPlanoSaude(String planoSaude) {
		this.planoSaude = planoSaude;
	}
	public Long getNumeroPlano() {
		return numeroPlano;
	}
	public void setNumeroPlano(Long numeroPlano) {
		this.numeroPlano = numeroPlano;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	
	
	@Override
	public String toString() {
		return "Paciente [medico=" + medico + ", Diagnostico=" + Diagnostico + ", numeroPlano=" + numeroPlano
				+ ", validade=" + validade + "]";
	}
	
}
