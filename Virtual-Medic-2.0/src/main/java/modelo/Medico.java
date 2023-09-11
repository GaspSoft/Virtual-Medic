package modelo;

public class Medico extends Pessoa {
	
	private Long crm;
	private String especificacao;
	
	
	public Long getCrm() {
		return crm;
	}
	public void setCrm(Long crm) {
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
		return getNome();
	}
}