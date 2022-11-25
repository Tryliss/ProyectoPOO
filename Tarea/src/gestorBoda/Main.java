package gestorBoda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<Comensal> comensales= new ArrayList<Comensal>();
	private static Asignador boda_1;
	private static ArrayList<Mesa>boda_2;
	//Debug
	public static void mostrarMesas(ArrayList<Mesa> listaMesas) {
		for(Mesa mesa:listaMesas) {
			if(mesa.getClass().getSimpleName().contains("General")) {
			System.out.println("Indice mesa: "+listaMesas.indexOf(mesa)+"\n"+"Clave Mesa: "+mesa.llaveMesa+"\n"+"Tipo de mesa: "+mesa.getClass().getSimpleName());
			}else {
				System.out.println("Tipo de mesa: "+mesa.getClass().getSimpleName());	
			}
			ArrayList<Comensal> listaComensales=mesa.comensalesMesa;
			for(Comensal comensal: listaComensales) {
				System.out.println(comensal.getNombre()+" "+comensal.getApellidos()); 
			}
			System.out.println(listaComensales.size()); 
				
		}
	}
	public static void main(String[] args) {
		 try (Scanner sn = new Scanner(System.in)) {
			int opcion;
			boolean salir=true;
			LeerFichero boda = null;
			while(salir!=false) {
				System.out.println("Pulse: \n 1 Para Introducir datos de prueba \n 2 Para introducir archivo csv propio (Formato: Nombre;Apellidos;edad;alergias;indice;vetados;acompañantes) \n 3 Para asignar y mostrar en pantalla \n 4 Cambiar nombre de mesa");
				opcion = sn.nextInt();
				switch(opcion) {
				case 1:
					boda=new LeerFichero("boda.csv");
					boda.formalizar();
					break;
				case 2:
					System.out.println("Introduce ruta sin comillas");
					String opcion2 ="";
					while(opcion2.isBlank()) {
					 opcion2 = sn.nextLine();
					}
					System.out.println("La ruta introducida es: "+opcion2);
					boda=new LeerFichero(opcion2);
					boda.formalizar();
					break;
				case 3:
					comensales=boda.getComensales();
					boda_1=new Asignador(comensales);
					boda_2=boda_1.Asigna();
					mostrarMesas(boda_2);
					break;
				case 4:
					System.out.println("Introduce el numero de mesa cuyo nombre quieras cambiar:");
					int indice=-1 ;
					while(indice==-1) {
					 indice = sn.nextInt();
					}
					System.out.println("Introduce nuevo nombre:");
					String nombre ="";
					while(nombre.isBlank()) {
					 nombre = sn.nextLine();
					}
					boda_2.get(indice).setLlaveMesa(nombre);
					mostrarMesas(boda_2);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}