package logica;

public class Ingrediente {
	
	private String nombre;
	private int costoAdicional;
	
	public Ingrediente (String nombreIngrediente, int elCostoAdicional){
		this.nombre = nombreIngrediente;
		this.costoAdicional = elCostoAdicional;
	}
	public String getNombre() {
	return nombre;
	}
	
	public int getCostoAdicional() {
	return costoAdicional;	
		
		
	}
}
