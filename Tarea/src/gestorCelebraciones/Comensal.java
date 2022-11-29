package gestorCelebraciones;

import java.util.ArrayList;

public class Comensal extends DatosPersonales{
	
	
	public static ArrayList<Comensal> acompannantesPr1= new ArrayList<Comensal>() ;
	public static ArrayList<Comensal> acompannantesPr2= new ArrayList<Comensal>() ;
	public static ArrayList<Comensal> preferente= new ArrayList<Comensal>() ;
	public ArrayList<Integer> acompannantes= new ArrayList<Integer>() ;
	public ArrayList<Integer> vetados =new ArrayList<Integer>();
	public Rol rol;
	
	
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
		case "EsNovio": this.rol=Rol.PROTAGONISTA1;
		case "EsNovia": this.rol=Rol.PROTAGONISTA1;
		case "Novio":	acompannantesPr1.add(this);
		case "Novia":	acompannantesPr2.add(this);
		}	
	}

	//Getters y Setters
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol=rol;
	}
	private void setRol() {
		if(this.rol==Rol.PROTAGONISTA1||this.rol==Rol.PROTAGONISTA2){
			return;
		}
		
		if (this.getEdad()<2) {
			this.rol=Rol.BEBE;
			return;
		}
		
		if(this.getEdad()>2&&this.getEdad()<12) {
			this.rol=Rol.NINNO;
			return;
		}
		
		if(preferente.contains(this)) {
			this.rol=Rol.PREFERENTE;
			return;
		}
		
		if(acompannantesPr1.contains(this)) {
			this.rol=Rol.INVPR1;
			return;
		}
		
		if(acompannantesPr2.contains(this)) {
			this.rol=Rol.INVPR2;
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
	public void eliminarAcompannante(Integer comensal) {
		acompannantes.remove(comensal);
	}
	
	public void annadirVetado(Integer comensal) {
		vetados.add(comensal);
		
	}
	public void eliminarVetado(Integer comensal) {
		vetados.remove(comensal);
	}

}
