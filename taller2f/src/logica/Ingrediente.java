package logica;

public class Ingrediente {
	
	private String nombre;
	private int costoAdicional;
	private int calorias;
	
	public Ingrediente (String nombreIngrediente, int elCostoAdicional, int caloriasI){
		this.nombre = nombreIngrediente;
		this.costoAdicional = elCostoAdicional;
		this.calorias= caloriasI;
	}
	public String getNombre() {
	return nombre;
	}
	
	public int getCostoAdicional() {
	return costoAdicional;	
		
		
	}
	public int getCalorias() {
		return calorias;	
			
			
		}
	
}
