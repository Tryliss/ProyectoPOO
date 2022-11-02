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
			String[] comensal = line.split(splitBy);    // use comma as separator  
			comensales.add(new Comensal(comensal[0], comensal[1], Integer.parseInt(comensal[2]), comensal[3], comensal[4]));
			}
		}
		//Generamos vetados y acompañantes
		
		comensales.get(40).annadirAcompannante(comensales.get(1));
		comensales.get(40).annadirAcompannante(comensales.get(2));
		comensales.get(41).annadirAcompannante(comensales.get(1));
		System.out.println(comensales.get(1).rol);
		//Falta hacer enemigos y amigos;
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
		}   
}
