package gestorBoda;

import java.util.ArrayList;

public class Comensal extends DatosPersonales{
	
	ArrayList<Comensal> vetados =new ArrayList<Comensal>();
	static ArrayList<Comensal> acompannantesNvo= new ArrayList<Comensal>() ;
	static ArrayList<Comensal> acompannantesNva= new ArrayList<Comensal>() ;
	static ArrayList<Comensal> preferente= new ArrayList<Comensal>() ;
	ArrayList<Comensal> acompannantes= new ArrayList<Comensal>() ;
	int rol=-2 ;
	
	protected Comensal(String nombre, String apellidos, int edad, String alergias,String invitante) {
		super(nombre, apellidos, edad, alergias);
		Invitante(invitante);
		setRol();
	}

	//Esta funcion asigna a los novios su rol,o añade a la lista de novio invitante
	private void Invitante(String invitante) {
		switch(invitante) {
		case "EsNovio": this.rol=0;
		case "EsNovia": this.rol=1;
		case "Novio":	acompannantesNvo.add(this);
		case "Novia":	acompannantesNva.add(this);
		}	
	}

	//Getters y Setters
	public int getRol() {
		return rol;
	}

	private void setRol() {
		//Los roles indican quien es la persona:
		//0)Novios(Se define en en procedimento)
		//1)Novios(Se define en el procedimento)
		//2)Preferentes: Indica los que se sentaran en la mesa presidencial
		//3)Invitados Novio: Indica quien ha invitado, se sobreecribe en caso de ser preferente o niño
		//4)Invitados Novia: Indica quien ha invitado, se sobreecribe en caso de ser preferente o niño
		//5)Niño:Años entre 2 y 12 años
		//-1)Bebe:Menor de 2 años no ocupa silla
		if(this.rol==0||this.rol==1){
			return;
		}
		
		if (this.getEdad()<2) {
			this.rol=-1;
			return;
		}
		
		if(this.getEdad()>2&&this.getEdad()<12) {
			this.rol=5;
			return;
		}
		
		if(preferente.contains(this)) {
			this.rol=2;
			return;
		}
		
		if(acompannantesNvo.contains(this)) {
			this.rol=3;
			return;
		}
		
		if(acompannantesNva.contains(this)) {
			this.rol=4;
			return;	
			
		}
	}

	public ArrayList<Comensal> getVetados() {
		return vetados;
	}

	public ArrayList<Comensal> getAcompannantes() {
		return acompannantes;
	}
	
	//Añadir y eliminar vetados
	public void annadirAcompannante(Comensal comensal) {
		if(this.rol==0||this.rol==1) {
			preferente.add(comensal);
			comensal.setRol();
		}else{
			acompannantes.add(comensal);
		}
	}
	public void eliminarAcompannante(Comensal comensal) {
		if(this.rol==0||this.rol==1) {
			preferente.remove(comensal);
			comensal.setRol();
		}else{
			acompannantes.remove(comensal);
		}
	}
	
	public void annadirVetado(Comensal comensal) {
		vetados.add(comensal);
		
	}
	public void eliminarVetado(Comensal comensal) {
		vetados.remove(comensal);
	}

}
