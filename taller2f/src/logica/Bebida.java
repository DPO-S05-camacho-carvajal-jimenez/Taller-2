package logica;

public class Bebida implements Producto {
	private String nombre;
	private int costo;
	
	public Bebida (String nombreBebida, int precioBaseBebida){
		this.nombre = nombreBebida;
		this.costo = precioBaseBebida;
	}
	public String getNombre() {
	return nombre;
	}
	
	public int getPrecio() {
	return costo;	
		
	}
	public String generarTextoFactura() {
		 String factura = "item: "+ nombre+ " "+ costo;
		 return factura;
			
		}
		

}
