package gestorBoda;

import java.util.ArrayList;

public class Comensal extends DatosPersonales{
	
	ArrayList<Integer> vetados =new ArrayList<Integer>();
	static ArrayList<Comensal> acompannantesNvo= new ArrayList<Comensal>() ;
	static ArrayList<Comensal> acompannantesNva= new ArrayList<Comensal>() ;
	static ArrayList<Comensal> preferente= new ArrayList<Comensal>() ;
	ArrayList<Integer> acompannantes= new ArrayList<Integer>() ;
	int rol=-2 ;
	
	
	protected Comensal(String nombre, String apellidos, int edad, String alergias,String invitante,ArrayList<Integer> vetados,ArrayList<Integer> acompannantes) {
		super(nombre, apellidos, edad, alergias);
		this.vetados=vetados;
		this.acompannantes=acompannantes;
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
	public void setRol(int rol) {
		this.rol=rol;
	}
	private void setRol() {
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

	public ArrayList<Integer> getVetados() {
		return vetados;
	}

	public ArrayList<Integer> getAcompannantes() {
		return acompannantes;
	}
	
	//Añadir y eliminar vetados
	public void annadirAcompannante(Integer comensal) {
		acompannantes.add(comensal);
	}
	public void eliminarAcompannante(Comensal comensal) {
		if(this.rol==0||this.rol==1) {
			preferente.remove(comensal);
			comensal.setRol();
		}else{
			acompannantes.remove(comensal);
		}
	}
	
	public void annadirVetado(Integer comensal) {
		vetados.add(comensal);
		
	}
	public void eliminarVetado(Comensal comensal) {
		vetados.remove(comensal);
	}

}
