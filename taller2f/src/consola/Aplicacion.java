package consola;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import logica.ProductoMenu;
import logica.Restaurante;
import logica.Restaurante.*;

import java.util.ArrayList;

import logica.Bebida;
import logica.Combo;
import logica.Ingrediente;
import logica.Pedido;
import logica
.Producto;
import logica.ProductoAjustado;
public class Aplicacion {
	
	private Restaurante restaurant ;
	
	
	public void mostrarMenu() {
		
		ArrayList<ProductoMenu> menuInicial = restaurant.getMenuBase();
		for (int i = 0; i < menuInicial.size(); i++) {
			ProductoMenu producto = menuInicial.get(i);
			System.out.println(i+". "+producto.getNombre()+" "+producto.getPrecio()+" "+" Calorias: "+producto.getCalorias());
		}
		
		ArrayList<Combo> combosInicial = restaurant.getCombos();
		for (int i = 0; i < combosInicial.size(); i++) {
			Combo combo = combosInicial.get(i);
			System.out.println(i+". "+combo.getNombre()+" "+combo.getPrecio());
			
		}
		ArrayList<Ingrediente> ingredienteInicial = restaurant.getIngredientes();
		for (int i = 0; i < ingredienteInicial.size(); i++) {
			Ingrediente ingrediente = ingredienteInicial.get(i);
			System.out.println(i+". "+ingrediente.getNombre()+" "+ingrediente.getCostoAdicional()+" Calorias: "+ingrediente.getCalorias());
		
		}
		ArrayList<Bebida> bebidaInicial = restaurant.getBebidas();
		for (int i = 0; i < bebidaInicial.size(); i++) {
			Bebida bebida = bebidaInicial.get(i);
			System.out.println(i+". "+bebida.getNombre()+" "+bebida.getPrecio());
		
		}
		
	}
	
	public void agregarElemento(Scanner sn) {
		
		System.out.println("1.Menu");
        System.out.println("2.Combo");
        System.out.println("3. Bebidas");
        int opcionSeleccionada = sn.nextInt();
        switch (opcionSeleccionada) {
        case 1:
        	
        	System.out.println("Ingrese el numero del item que desea: ");
        	int numElemento = sn.nextInt();
        	ProductoMenu base = restaurant.getMenuBase().get(numElemento);
        	ProductoAjustado producFinal= new ProductoAjustado(base);
        	System.out.println("Desea adicionar ingrediente:");
        	System.out.println("1. si 2. no");
        	int opcionAgregar = sn.nextInt();
        	
        	while (opcionAgregar==1){
        		System.out.println("ingrese el numero del ingrediente: ");
        		int numIngrediente = sn.nextInt();
        		Ingrediente ingrediente = restaurant.getIngredientes().get(numIngrediente);
        		producFinal.agregarIngrediente(ingrediente);
        		System.out.println("desea agregar otro? ");
        		System.out.println("1. si 2. no");
        		int agregarUnoMas = sn.nextInt();
        		if (agregarUnoMas==2){
        			opcionAgregar = 2;	
        			
        		}
        	
        		
        	}
        	
       
        	
        	System.out.println("desea eliminar ingrediente");
        	System.out.println("1. si 2. no");
        	int opcionEliminar = sn.nextInt();
        	while (opcionEliminar==1){
        		System.out.println("ingrese el numero del ingrediente: ");
        		int numIngrediente = sn.nextInt();
        		Ingrediente ingrediente = restaurant.getIngredientes().get(numIngrediente);
        		producFinal.eliminarIngrediente(ingrediente);
        		System.out.println("desea eliminar otro? ");
        		System.out.println("1. si 2. no");
        		int eliminarUnoMas = sn.nextInt();
        		if (eliminarUnoMas==2){
        			opcionEliminar = 2;	
        			
        		}
        		
        	}
        	System.out.println("desea adicionar otro item al pedido");
        	System.out.println("1. si 2. no");
        	int opAgregarOtroCoso = sn.nextInt();
        	while (opAgregarOtroCoso==1){
        		agregarElemento(sn);
        		opAgregarOtroCoso=2;
        		
        	}
        	
        	
        	
        	restaurant.agregarProductoPedido(producFinal);
        	
        	
        	break;
        case 2:
        	System.out.println("ingrese el numero del item que desea");
        	int numCombo = sn.nextInt();
        	Combo combo = restaurant.getCombos().get(numCombo);
        	System.out.println("desea adicionar otra Item al pedido");
        	System.out.println("1. si 2. no");
        	int opAgregarOtroCombo = sn.nextInt();
        	while (opAgregarOtroCombo==1){
        		agregarElemento(sn);
        		opAgregarOtroCombo=2;
        		
        	}
        	restaurant.agregarProductoPedido(combo);
        	
        	
        	break;
        case 3: 
        	System.out.println("ingrese el numero del item que desea");
        	int numBebida = sn.nextInt();
        	Bebida beb = restaurant.getBebidas().get(numBebida);
        	System.out.println("desea adicionar otra Item al pedido");
        	System.out.println("1. si 2. no");
        	int opAgregarOtraBebida = sn.nextInt();
        	while (opAgregarOtraBebida==1){
        		agregarElemento(sn);
        		opAgregarOtraBebida=2;
        		
        	}
        	restaurant.agregarProductoPedido(beb);
        }
	}
	
	
	
	
	

	public void ejecutarAplicacion()
	{
		restaurant = new Restaurante();
		Scanner sn = new Scanner(System.in);
	    boolean salir = false;
	    int opcionSeleccionada; 
		
	    while (!salir) {
	    	System.out.println("BIENVENIDO A HABURGUESAS DEPO"+"\n");
	        System.out.println("1. Mostrar el Menu");
	        System.out.println("2.Iniciar pedido");
	        System.out.println("3.Agregar elemento a pedido");
	        System.out.println("4.Cerrar un pedido y guardar la factura");
	        System.out.println("5. Consultar la información de un pedido dado su id");
	        System.out.println("6. Salir");

	        try {

	            System.out.println("Escribe una de las opciones");
	            opcionSeleccionada = sn.nextInt();

	            switch (opcionSeleccionada) {
	                case 1:
	                    System.out.println("1. Mostrar el Menu");
	                    mostrarMenu();
	                    break;
	                case 2:
	                	sn.nextLine();
	                    System.out.println("2.Iniciar pedido");
	                    System.out.println("Ingrese su nombre: ");
	                    String nombre=sn.nextLine();
	                    System.out.println("Ingrese su dirección: ");
	                    String direccion=sn.nextLine();
	                    restaurant.iniciarPedido(nombre, direccion);
	                 
	                    
	                    break;
	                case 3:
	                    System.out.println("3.Agregar elemento a pedido");
	                   
	                    agregarElemento(sn);
	                    
	                    break;
	                    
	                case 4:
	                    System.out.println("4.Cerrar un pedido y guardar la factura");
	                    restaurant.cerrarYGuardarPedido();
	                   
	              
	                    
	                    break; 
	                 
	                case 5:
	                    System.out.println("5. Consultar la información de un pedido dado su id");
	                    System.out.println(" ingrese el id");
	                    
	                    int id = sn.nextInt();
	                    Pedido pedido = restaurant.getPedidosId(id);
	                   
	                    System.out.println(pedido.generarTextoFactura());
	                    
	                    break; 
	                  
	                    
	                    
	                    
	                case 6:
	                	System.out.println("6.Salir");
	                    salir = true;
	                    break;
	                default:
	                    System.out.println("Solo números entre 1 y 4");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Debes insertar un número");
	            sn.next();
	        }
	    }
	}
	
	
	
	public static void main(String[] args) throws Exception
    {
		
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.ejecutarAplicacion();
		
		
		
    }
	
	
	
	
	
	
	
	






	
	
	
	
	
	
	
	

}
