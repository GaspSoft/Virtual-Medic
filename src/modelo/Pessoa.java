package modelo;

public abstract class Pessoa extends Endereco {
	private Long cpf;
	private String nome;
	private String email;
	
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", email=" + email + "]";
	}
}

