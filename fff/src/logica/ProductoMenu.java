package logica;

public class ProductoMenu  implements Producto{
	private String nombre;
	
	private int precioBase;

	public ProductoMenu(String nombreProducto, int elprecioBase ) {
	
	this.nombre = nombreProducto;
	this.precioBase = elprecioBase;
	
	}
	public String getNombre() {
		return nombre;
		
	}
	public int getPrecio() {
		return precioBase;
		
	}
	
	public String generarTextoFactura() {
	 String factura = "item: "+ nombre+ " "+ precioBase;
	 return factura;
		
	}
	
	
	
}
