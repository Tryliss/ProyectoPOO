package gestorBoda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerFichero {
	String defecto="boda.csv";
	String line = "";  
	String splitBy = ";"; 
	ArrayList<Comensal> comensales= new ArrayList<Comensal>();
	
	public LeerFichero(String defecto) {
		this.defecto = defecto;
	}
	
	public void formalizar() throws IOException{
	try (BufferedReader br = new BufferedReader(new FileReader(defecto))) {
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
		comensales.add(Integer.parseInt(comensal[5]),new Comensal(comensal[0], comensal[1], Integer.parseInt(comensal[2]), comensal[3], comensal[4],vetados,acompannantes));
		}
	} catch (FileNotFoundException e) {
		System.out.println("No se ha encontrado archivo en la direccion indicada");
	}
	}

	public ArrayList<Comensal> getComensales() {
		return comensales;
	}
	
	
}
