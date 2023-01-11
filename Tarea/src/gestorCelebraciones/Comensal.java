package gestorCelebraciones;

import java.util.ArrayList;

/** Clase comensal extiende datos personales */
public class Comensal extends DatosPersonales{
	
	/** Arraylist de los comensales invitados por el protagonista 1 */
	public static ArrayList<Comensal> acompannantesPr1= new ArrayList<Comensal>() ;
	/** Arraylist de los comensales invitados por el protagonista 2 */
	public static ArrayList<Comensal> acompannantesPr2= new ArrayList<Comensal>() ;
	/** Arraylist de los comensales que se sentaran en la mesa presidencial */
	public static ArrayList<Comensal> preferente= new ArrayList<Comensal>() ;
	/** Arraylist de acompañantes */
	public ArrayList<Integer> acompannantes= new ArrayList<Integer>() ;
	/** Arraylist vetados */
	public ArrayList<Integer> vetados =new ArrayList<Integer>();
	/** Enumerado rol */
	public Rol rol;
	
	/** Constructor de comensal */
	public Comensal(String nombre, String apellidos, int edad, String alergias,String invitante,ArrayList<Integer> vetados,ArrayList<Integer> acompannantes) {
		super(nombre, apellidos, edad, alergias);
		this.vetados=vetados;
		this.acompannantes=acompannantes;
		Invitante(invitante);
		setRol();
		
	}


	/**Funcion asigna a los protagonistas su rol,o añade a la lista de protagonista invitante */
	private void Invitante(String invitante) {
		switch(invitante) {
		case "EsNovio": this.rol=Rol.PROTAGONISTA1;
		case "EsNovia": this.rol=Rol.PROTAGONISTA1;
		case "Novio":	acompannantesPr1.add(this);
		case "Novia":	acompannantesPr2.add(this);
		}	
	}

	/** Devuelve el rol */
	public Rol getRol() {
		return rol;
	}
	/** Modifica el rol */
	public void setRol(Rol rol) {
		this.rol=rol;
	}
	/** Asigna el rol al comensal */
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
	/** Devuelve lista vetados */
	public ArrayList<Integer> getVetados() {
		return vetados;
	}
	/** Devuelve lista acompañantes */
	public ArrayList<Integer> getAcompannantes() {
		return acompannantes;
	}
	
	/** Añadir acompañante */
	public void annadirAcompannante(Integer comensal) {
		acompannantes.add(comensal);
	}
	/** Eliminar acompañante */
	public void eliminarAcompannante(Integer comensal) {
		acompannantes.remove(comensal);
	}
	/** Añade vetados */
	public void annadirVetado(Integer comensal) {
		vetados.add(comensal);
		
	}
	/** Eliminar vetados */
	public void eliminarVetado(Integer comensal) {
		vetados.remove(comensal);
	}



	public String toString() {
		return super.getIdentificador()+":"+super.getNombre()+" "+super.getApellidos();
	}
	
	

}
