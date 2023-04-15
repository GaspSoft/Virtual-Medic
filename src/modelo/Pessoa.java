package modelo;

import java.time.LocalDate;

public abstract class Pessoa extends Endereco {
	private Long cpf;
	private String nome;
	private String email;
	private String genero;
	private LocalDate idade;
	
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
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public LocalDate getIdade() {
		return idade;
	}
	public void setIdade(LocalDate idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", genero=" + genero + ", idade=" + idade
				+ "]";
	}
}

