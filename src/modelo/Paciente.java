package modelo;

import java.time.LocalDate;

public class Paciente extends Pessoa {
	
	private String medico;
	private String Diagnostico;
	private Long numeroPlano;
	private LocalDate validade;
		
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
	public Long getNumeroPlano() {
		return numeroPlano;
	}
	public void setNumeroPlano(Long numeroPlano) {
		this.numeroPlano = numeroPlano;
	}
	public LocalDate getValidade() {
		return validade;
	}
	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
	@Override
	public String toString() {
		return "Paciente [medico=" + medico + ", Diagnostico=" + Diagnostico + ", numeroPlano=" + numeroPlano
				+ ", validade=" + validade + "]";
	}
	
}
