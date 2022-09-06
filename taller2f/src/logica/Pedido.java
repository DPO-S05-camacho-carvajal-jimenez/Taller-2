package logica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pedido  {
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList <Producto> itemsPedido;


	public Pedido (String nombreCliente, String direccionCliente) {
		idPedido= (int) Math.floor(Math.random()*20+1);
		itemsPedido= new ArrayList<>();
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;


	}
	public void agregarProducto(Producto nuevoItem) {
		itemsPedido.add(nuevoItem);

	}

	private int precioNetoPedido() {
		int precioFinal = 0;
		for (int i = 0; i < itemsPedido.size(); i++) {
			Producto item = itemsPedido.get(i);
			precioFinal += item.getPrecio();
		}
		return precioFinal;
	}


	private int precioTotalPedido() {
		double precioTotal= precioNetoPedido()*1.19;
		return (int)precioTotal;

	}

	private int precioIVAPedido() {
		double precioTotal= precioNetoPedido()*0.19;
		return (int)precioTotal;

	}
	public void guardarFactura (File archivo) {
		FileWriter fw;
		try {
			
			fw = new FileWriter(archivo);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(generarTextoFactura());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





	}


	public String generarTextoFactura() {
		
		String str = "Pedido: "+ getIdPedido();
		str+= "\n"+"cliente: "+nombreCliente;
		str+= "\n"+"direccion: "+direccionCliente;
		
		for (int i = 0; i < itemsPedido.size(); i++) {
			Producto item = itemsPedido.get(i);
			str += "\n"+item.generarTextoFactura();
			
		}
		str += "\n"+"Precio neto: "+ precioNetoPedido();
		str += "\n"+"Precio IVA: "+precioIVAPedido();
		str += "\n"+"Precio total: "+ precioTotalPedido();
		return str;
	}

	public int getIdPedido () {		
		return idPedido;		
	}


}
