package logica;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	
	public ProductoAjustado (ProductoMenu base) {
		this.base = base;
		agregados = new ArrayList<Ingrediente>();
		eliminados = new ArrayList<Ingrediente>();
	}
	
	public String getNombre() {
		return base.getNombre();
	}
	public int getPrecio() {
		int total=base.getPrecio();
		for (int i = 0; i < agregados.size(); i++) {
			Ingrediente ingrediente = agregados.get(i);
			total+=ingrediente.getCostoAdicional();
		}
		
		return total;
	}
	public String generarTextoFactura() {
		String str = base.generarTextoFactura();
		for (int i = 0; i < agregados.size(); i++) {
			Ingrediente item = agregados.get(i);
			str += " +"+item.getNombre()+""+item.getCostoAdicional();
		}
		
		for (int i = 0; i < eliminados.size(); i++) {
			Ingrediente item = eliminados.get(i);
			str += " -"+item.getNombre()+"";
		}
		return str;
	}
	
	public void agregarIngrediente(Ingrediente ingrediente) {
		agregados.add(ingrediente);
	}
	public void eliminarIngrediente(Ingrediente ingrediente) {
		eliminados.add(ingrediente);
	}
}
