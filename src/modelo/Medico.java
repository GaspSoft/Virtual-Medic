package modelo;

public class Medico extends Pessoa {
	private	Integer id;
	private Integer crm;
	private String especificacao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCrm() {
		return crm;
	}
	public void setCrm(Integer crm) {
		this.crm = crm;
	}
	public String getEspecificacao() {
		return especificacao;
	}
	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}
	
	@Override
	public String toString() {
		return "Medico [id=" + id + ", crm=" + crm + ", especificacao=" + especificacao + "]";
	}
}
