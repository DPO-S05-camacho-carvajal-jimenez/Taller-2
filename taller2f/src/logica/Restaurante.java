package logica;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import consola.Aplicacion;




public class Restaurante
{

	private ArrayList<Bebida> bebidas;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Combo> combos;
	private ArrayList<ProductoMenu> menuBase;
	private Pedido pedidoEnCurso;
	private HashMap <Integer,Pedido> pedidos;

	public Restaurante() {
		ingredientes = new ArrayList<Ingrediente>();
		combos = new ArrayList<Combo>();
		menuBase = new ArrayList<ProductoMenu>();
		pedidos = new HashMap<Integer,Pedido>();
		bebidas = new ArrayList<Bebida>();

		File archivoIngredientes = new File ("C:\\Users\\orcar\\Nueva carpeta\\taller2f\\src\\data\\ingredientes.txt");
		File archivoMenu = new File ("C:\\Users\\orcar\\Nueva carpeta\\taller2f\\src\\data\\menuu.txt");
		File archivoCombos = new File ("C:\\Users\\orcar\\Nueva carpeta\\taller2f\\src\\data\\combos.txt");
		File archivoBebidas = new File ("C:\\Users\\orcar\\Nueva carpeta\\taller2f\\src\\data\\bebidas.txt");
		
		cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos,archivoBebidas);
	}

	private void cargarIngredientes (File archivoIngredientes) {

		try  {
			BufferedReader bf1 = new BufferedReader (new FileReader(archivoIngredientes));


			String bfRead;

			while ((bfRead = bf1.readLine() )!= null) {
				String[]  partes = bfRead.split(";");
				String nombre = partes[0];
				String precio = partes[1];

				Ingrediente ingrediente= new Ingrediente(nombre,Integer.valueOf(precio));

				ingredientes.add(ingrediente);


			}

		}catch (Exception e) {
			System.err.println("No hay ingredientes");

		}



	}



	private void cargarMenu (File archivoMenu) {

		try  {
			BufferedReader bf1 = new BufferedReader (new FileReader(archivoMenu));


			String bfRead;

			while ((bfRead = bf1.readLine() )!= null) {
				String[]  partes = bfRead.split(";");
				String nombre = partes[0];
				String precio = partes[1];

				ProductoMenu producto= new ProductoMenu(nombre,Integer.valueOf(precio));

				menuBase.add(producto);


			}

		}catch (Exception e) {
			System.err.println("No hay productos");

		}



	}



	private void cargarCombos (File archivoCombos) {

		try  {
			BufferedReader bf1 = new BufferedReader (new FileReader(archivoCombos));


			String bfRead;

			while ((bfRead = bf1.readLine() )!= null) {
				String[]  partes = bfRead.split(";");
				String nombre = partes[0];
				String descuento = partes[1];
				String producto1 = partes [2];
				String producto2 = partes [3];
				String producto3 = partes [4];

				Combo combo= new Combo(nombre,Double.parseDouble(descuento.substring(0, descuento.length()-1)));
				ProductoMenu producto = getProductoPorNombre(producto1);
				combo.agregarItemACombo(producto);
				producto = getProductoPorNombre(producto2);
				combo.agregarItemACombo(producto);
				producto = getProductoPorNombre(producto3);
				combo.agregarItemACombo(producto);

				combos.add(combo);



			}

		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("No hay combos");

		}



	}

	private ProductoMenu getProductoPorNombre(String nombre) {
		for (int i = 0; i < menuBase.size(); i++) {
			ProductoMenu producto = menuBase.get(i);
			if (producto.getNombre().equals(nombre)) {
				return producto;
			}
		}
		return null;
	}





	public void cargarInformacionRestaurante (File archivoIngredientes, File archivoMenu, File archivoCombos, File archivoBebidas)
	{


		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		CargarBebidas(archivoBebidas);



	}
	private void CargarBebidas(File archivoBebidas) {
		try  {
			BufferedReader bf1 = new BufferedReader (new FileReader(archivoBebidas));


			String bfRead;

			while ((bfRead = bf1.readLine() )!= null) {
				String[]  partes = bfRead.split(";");
				String nombre = partes[0];
				String precio = partes[1];

				Bebida bebida= new Bebida(nombre,Integer.valueOf(precio));

				bebidas.add(bebida);


			}

		}catch (Exception e) {
			System.err.println("No hay Bebidas");

		}

		
	}

	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		Pedido pedido = new Pedido(nombreCliente,direccionCliente);
		pedidoEnCurso=pedido;
		

	}
	
	public void cerrarYGuardarPedido () {
		File archivo= new File("C:\\Users\\orcar\\Nueva carpeta\\taller2f\\src\\facturas"+"\\"+"factura_"+pedidoEnCurso.getIdPedido()+".txt");
		pedidoEnCurso.guardarFactura(archivo);
		
		pedidos.put(pedidoEnCurso.getIdPedido(), pedidoEnCurso);
		pedidoEnCurso=null;
	}
	
	
	public  Pedido getPedidosId (int id){
		return pedidos.get(id);
		
	}
	
	
	
	
	public void agregarProductoPedido(Producto producto) {
		pedidoEnCurso.agregarProducto(producto);
	}
	

	public ArrayList<ProductoMenu> getMenuBase() {
		// TODO Auto-generated method stub
		return menuBase;
	}

	public ArrayList<Combo> getCombos() {
		// TODO Auto-generated method stub
		return combos;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		// TODO Auto-generated method stub
		return ingredientes;
	}
	
	public ArrayList<Bebida> getBebidas() {
		// TODO Auto-generated method stub
		return bebidas;
	}


}













