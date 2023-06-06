package modelo;

public abstract class Endereco {
	private Long cep;
	private String uf;
	private String cidade;
	private String bairro;
	private String rua;
	private Integer numero;
	private Integer complemento;
	
	public Long getCep() {
		return cep;
	}
	public void setCep(Long cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getComplemento() {
		return complemento;
	}
	public void setComplemento(Integer complemento) {
		this.complemento = complemento;
	}
	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", uf=" + uf + ", cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua
				+ ", numero=" + numero + ", complemento=" + complemento + "]";
	}
}
