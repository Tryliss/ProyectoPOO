package gestorBoda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerFichero {
	String defecto	=	"boda.csv";
	String line 	=	"";  
	String splitBy 	= 	";"; 
	ArrayList<Comensal> comensales	= new ArrayList<Comensal>();
	
	public LeerFichero(String defecto) {
		this.defecto = defecto;
	}
	
	public void formalizar() throws IOException{
	try (BufferedReader br = new BufferedReader(new FileReader(defecto))) {
		while ((line = br.readLine()) != null){
			//Atributos
			ArrayList<Integer> vetados			= 	new ArrayList<Integer>();
			ArrayList<Integer> acompannantes	= 	new ArrayList<Integer>();
		
			//Lectura
			String[] comensal 					= 	line.split(splitBy); 
			String[] vetadosNum					= 	comensal[6].split("[,]", 0);
			String[] acompannantesNum 			= 	comensal[7].split("[,]", 0);
		
			//Formalizacion vetados y acompañantes
			for(String vetado:vetadosNum) {
				vetados.add(Integer.parseInt(vetado));
			}
		
			for(String acompannante:acompannantesNum) {
				acompannantes.add(Integer.parseInt(acompannante));
			}
			
			//Añadimos comensal a la lista
			int    indice		=	Integer.parseInt(comensal[5]);
			String nombre		=	comensal[0];
			String apellidos	=	comensal[1];
			int    edad			=	Integer.parseInt(comensal[2]);
			String alergias		=	comensal[3];
			String invitante	=	comensal[4];
		
			//Creamos y añadimos comensal a la lista
			comensales.add(indice,new Comensal(nombre, apellidos, edad, alergias, invitante,vetados,acompannantes));
		
		}
		
	} catch (FileNotFoundException e) {
		
		//Excepcion de falta de archivo
		System.out.println("No se ha encontrado archivo en la direccion indicada");
	}
	}

	public ArrayList<Comensal> getComensales() {
		return comensales;
	}
	
	
}
