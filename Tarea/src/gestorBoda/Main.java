package gestorBoda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	private static ArrayList<Comensal> comensales= new ArrayList<Comensal>();

	public static void main(String[] args) throws IOException {
		String line = "";  
		String splitBy = ";"; 
		try (BufferedReader br = new BufferedReader(new FileReader("boda.csv"))) {
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
			ArrayList<Integer> vetados= new ArrayList<Integer>();
			ArrayList<Integer> acompannantes= new ArrayList<Integer>();
			String[] comensal = line.split(splitBy);    // use comma as separator 
			String[] vetado = comensal[6].split(",");
			String[] acompannante = comensal[7].split(",");
			for(String vet:vetado) {
				vetados.add(Integer.parseInt(vet));
			}
			for(String aco:acompannante) {
				acompannantes.add(Integer.parseInt(aco));
			}
			comensales.add(Integer.parseInt(comensal[5]),new Comensal(comensal[0], comensal[1], Integer.parseInt(comensal[2]), comensal[3], comensal[4],vetados,acompannantes));
			}
		}
		
		//Recorrer y mostrar
		Asignador guau=new Asignador(comensales);
		ArrayList<Mesa> perros=guau.Inicia();
		for(Mesa perro:perros) {
			System.out.println(perro.getClass().getSimpleName());
			ArrayList<Comensal> pequeno=perro.comensalesMesa;
			for(Comensal diminuto: pequeno) {
				System.out.println(diminuto.getNombre()+" "+diminuto.getApellidos()); 
			}
			System.out.println(pequeno.size()); 
				
		}
		System.out.println( Mesa.getComensalesT());	
		//Falta generar pdf
		}   
}
