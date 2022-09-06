package logica;

public class ProductoMenu  implements Producto{
	private String nombre;
	
	private int precioBase;
	
	private int calorias;

	public ProductoMenu(String nombreProducto, int elprecioBase, int caloriasM ) {
	
	this.nombre = nombreProducto;
	this.precioBase = elprecioBase;
	this.calorias = caloriasM;
	
	}
	public String getNombre() {
		return nombre;
		
	}
	public int getPrecio() {
		return precioBase;
		
	}
	public int getCalorias() {
		return calorias;
	}
	
	public String generarTextoFactura() {
	 String factura = "item: "+ nombre+ " "+ precioBase;
	 return factura;
		
	}
	
	
	
}
