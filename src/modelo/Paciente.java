package modelo;

public class Paciente extends Pessoa {
	private Integer id;
	private PlanoSaude planoSaude;
	private Medico medico;
	private String profissao;
	private String diagnostico;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}
	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", planoSaude=" + planoSaude + ", medico=" + medico + ", profissao=" + profissao
				+ ", diagnostico=" + diagnostico + "]";
	}
}
