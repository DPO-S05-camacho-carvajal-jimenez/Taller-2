package logica;

public class Pedido  {
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	
	
	public Pedido (String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		
			
	}
	public int getIdPedido (int idPedido) {		
		return idPedido;		
	}
	

}
