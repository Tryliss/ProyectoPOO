package gestorBoda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<Comensal> comensales= new ArrayList<Comensal>();
	public static void leerFichero() throws FileNotFoundException, IOException {
		String line = "";  
		String splitBy = ";"; 
		try (BufferedReader br = new BufferedReader(new FileReader("boda.csv"))) {
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
			ArrayList<Integer> vetados= new ArrayList<Integer>();
			ArrayList<Integer> acompannantes= new ArrayList<Integer>();
			String[] comensal = line.split(splitBy);    // use comma as separator 
			String[] vetado = comensal[6].split("[,]", 0);
			String[] acompannante = comensal[7].split("[,]", 0);
			for(String vet:vetado) {
				vetados.add(Integer.parseInt(vet));
			}
			for(String aco:acompannante) {
				acompannantes.add(Integer.parseInt(aco));
			}
			System.out.println(acompannante.length);
			comensales.add(Integer.parseInt(comensal[5]),new Comensal(comensal[0], comensal[1], Integer.parseInt(comensal[2]), comensal[3], comensal[4],vetados,acompannantes));
			}
		}
	}
	//Debug
	public static void mostrarMesas() {
		Asignador boda_1=new Asignador(comensales);
		ArrayList<Mesa>boda_2=boda_1.Inicia();
		for(Mesa boda_3:boda_2) {
			System.out.println(boda_3.getClass().getSimpleName());
			ArrayList<Comensal> boda_4=boda_3.comensalesMesa;
			for(Comensal boda_5: boda_4) {
				System.out.println(boda_5.getNombre()+" "+boda_5.getApellidos()); 
			}
			System.out.println(boda_4.size()); 
				
		}
	}
	public static void main(String[] args) throws IOException {
		 Scanner sn = new Scanner(System.in);
		 int opcion;
		boolean salir=true;
		while(salir!=false) {
			System.out.println("Pulse: \n 1 Para Introducir datos \n 2 Para asignar y mostrar en pantalla \n 3 Para salir");
			opcion = sn.nextInt();
			switch(opcion) {
			case 1:
				leerFichero();
				break;
			case 2:
				mostrarMesas();
				break;
			case 3:
				salir=false;
			}
		}   
	}
}