package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
public class Restaurante
{
    public  String cargarInformacionRestaurante (String direccion1, String direccion2, String direccion3)
    {
    	
    	String menu= "";
    	String combos="";
    	String ingredientes="";
    	
        try  {
        	BufferedReader bf1 = new BufferedReader (new FileReader(direccion1));
        	
        	String temp = "";
        	String bfRead;
        	int contador=1;
        	while ((bfRead = bf1.readLine() )!= null) {
        		
        		temp=temp+contador+". "+bfRead+"\n";
        		contador +=1;
        		
        		
        		
        		
        		
        	}
        	menu = temp;
        }catch (Exception e) {
        	System.err.println("No hay menu");
        	
        }
        
        try  {
        	BufferedReader bf2 = new BufferedReader (new FileReader(direccion2));
        	
        	String temp = "";
        	String bfRead;
        	
        	int contador=1;
        	while ((bfRead = bf2.readLine() )!= null) {
        		
        		temp=temp+contador+". "+bfRead+"\n";
        		contador +=1;
        		
        		
        		
        		
        		
        	}
        	combos = temp;
        }catch (Exception e) {
        	System.err.println("No hay menu");
        	
        }
        
        
        try  {
        	BufferedReader bf3 = new BufferedReader (new FileReader(direccion3));
        	
        	String temp = "";
        	String bfRead;
        	int contador=1;
        	
        	while ((bfRead = bf3.readLine() )!= null) {
        		
        		temp=temp+contador+". "+bfRead+"\n";
        		contador +=1;
        		
        		
        		
        		
        		
        	}
        	ingredientes = temp;
        }catch (Exception e) {
        	System.err.println("No hay menu");
        	
        }
        
        
        return "Menu principal"+"\n"+menu+"INGREDIENTES ADICIONALES"+"\n"+combos+"COMBOS"+"\n"+ingredientes;
    }
}
