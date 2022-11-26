package gestorBoda;

import java.util.ArrayList;

public class Comensal extends DatosPersonales{
	
	
	static ArrayList<Comensal> acompannantesNvo= new ArrayList<Comensal>() ;
	static ArrayList<Comensal> acompannantesNva= new ArrayList<Comensal>() ;
	static ArrayList<Comensal> preferente= new ArrayList<Comensal>() ;
	ArrayList<Integer> acompannantes= new ArrayList<Integer>() ;
	ArrayList<Integer> vetados =new ArrayList<Integer>();
	Rol rol;
	
	
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
		case "EsNovio": this.rol=Rol.NOVIO;
		case "EsNovia": this.rol=Rol.NOVIA;
		case "Novio":	acompannantesNvo.add(this);
		case "Novia":	acompannantesNva.add(this);
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
		if(this.rol==Rol.NOVIO||this.rol==Rol.NOVIA){
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
		
		if(acompannantesNvo.contains(this)) {
			this.rol=Rol.INVNOVIO;
			return;
		}
		
		if(acompannantesNva.contains(this)) {
			this.rol=Rol.INVNOVIA;
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
