package logica;

import java.util.ArrayList;

public class Combo implements Producto {
	
	private double descuento;
	private String nombreCombo;
	private ArrayList<Producto> itemsCombo;
	
	
	
	public Combo(String nombre, double desc) { 
		this.itemsCombo = new ArrayList<>();
		this.nombreCombo= nombre;
		this.descuento= desc;
		// TODO Auto-generated constructor stub
	}
	
	
	public void agregarItemACombo(Producto itemCombo ) {
		itemsCombo.add(itemCombo);
		
	}
	public String getNombre() {
		return nombreCombo;
		
	}
	public int getPrecio() {
		int precioFinal = 0;
		for (int i = 0; i < itemsCombo.size(); i++) {
			Producto item = itemsCombo.get(i);
			precioFinal += item.getPrecio();
		}
		return precioFinal*(int) descuento/100;
	}
	public String generarTextoFactura() {
		 String factura = "item: "+ nombreCombo+ " "+ getPrecio();
		 return factura;
			
		}
	
	
}
