package enums;

public enum GeneroEnum {
	
	MASCULINO("Masculino"),
	FEMININO("Feminino"),
	OUTROS("Outros");
	
	private String genero;
	GeneroEnum(String genero){
		this.genero = genero;
	}
	
	public String getGenero() {
		return this.genero;
	}
}
