package modelo;

public class Medico extends Pessoa {
	
	private Integer id;
	private Integer crm;
	private String especificação;
	
	
	public Integer getCrm() {
		return crm;
	}
	public void setCrm(Integer crm) {
		this.crm = crm;
	}
	public String getEspecificação() {
		return especificação;
	}
	public void setEspecificação(String especificação) {
		this.especificação = especificação;
	}
	@Override
	public String toString() {
		return "Medico [id=" + id + ", crm=" + crm + ", especificação=" + especificação + "]";
	}
}
