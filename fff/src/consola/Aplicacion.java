package consola;


import java.util.InputMismatchException;
import java.util.Scanner;

import logica.Restaurante;
import logica.Restaurante.*;


public class Aplicacion {
	
	public static void mostrarMenu() {
		Restaurante mcdonalds = new Restaurante ();
		String menu = mcdonalds.cargarInformacionRestaurante("C:\\Users\\orcar\\Desktop\\fff\\src\\data\\menu.txt","C:\\Users\\orcar\\Desktop\\fff\\src\\data\\ingredientes.txt","C:\\Users\\orcar\\Desktop\\fff\\src\\data\\combos.txt");
		System.out.println(menu);
		
	}
	
	public static void ejecutarOpcion()
	{
		Scanner sn = new Scanner(System.in);
	    boolean salir = false;
	    int opcionSeleccionada; 
		
	    while (!salir) {
	    	System.out.println("BIENVENIDO A HABURGUESAS MARIO PUCCINI"+"\n");
	        System.out.println("1. Mostrar el Menu");
	        System.out.println("2.Hacer pedido");
	        System.out.println("3.Consultar Pedido con ID");
	        System.out.println("4. Salir");

	        try {

	            System.out.println("Escribe una de las opciones");
	            opcionSeleccionada = sn.nextInt();

	            switch (opcionSeleccionada) {
	                case 1:
	                    System.out.println("1. Mostrar el Menu");
	                    Aplicacion.mostrarMenu(); 
	                    break;
	                case 2:
	                    System.out.println("2.Hacer pedido");
	                    
	                    
	                    
	                    
	                    
	                    
	                    break;
	                case 3:
	                    System.out.println("3.Consultar Pedido con ID");
	                    break;
	                case 4:
	                	System.out.println("4.Salir");
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
		
		Aplicacion.ejecutarOpcion();
		
		
    }
	
	
	
	
	
	
	
	






	
	
	
	
	
	
	
	

}
