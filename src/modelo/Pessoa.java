package modelo;

import java.util.Date;

import enums.GeneroEnum;

public abstract class Pessoa extends Endereco {

	private Long cpf;
	private String nome;
	private String email;
	private Date dataNascimento;
	private GeneroEnum genero;
	
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public GeneroEnum getGenero() {
		return genero;
	}
	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return "cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", dataNascimento="
				+ dataNascimento + ", genero=" + genero;
	}
}
