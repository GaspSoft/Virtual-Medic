package modelo;

import java.util.ArrayList;

public class PlanoSaude {
	private int id;
	private String nome;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return nome;
	}
	public void remove(ArrayList<PlanoSaude> listaPlanoSaude) {
		// TODO Auto-generated method stub
		
	}
}
