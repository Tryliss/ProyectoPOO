package gestorCelebraciones;

import java.util.ArrayList;


/** Clase mesa */
public abstract class Mesa { 

	public static int comensalesT; 
	public static int sillasT; 
	public static int mesasT;
	String llaveMesa;
	ArrayList<Comensal> comensalesMesa= new ArrayList<Comensal>();

	/** Constructor mesa */
	public Mesa(String llaveMesa) {
		this.llaveMesa = llaveMesa;
	}
	/** Obtiene numero total de comensales */
	public static int getComensalesT() {
		return comensalesT;
	}
	/** Aumenta en uno el total de comensales */
	public static void setComensalesT() {
		comensalesT++;
	}
	/** Obtiene numero total de sillas */
	
	public static int getSillasT() {
		return sillasT;
	}

	/** Obtiene numero total de mesas */
	public static int getMesasT() {
		return mesasT;
	}
	
	/** Devuelve la llave de una mesa*/
	public String getLlaveMesa() {
		return llaveMesa;
	}
	/** Modifica la llave de una mesa */
	public void setLlaveMesa(String llaveMesa) {
		this.llaveMesa = llaveMesa;
	}
	/** Metodo abstracto que añade comensales a una mesa */
	public abstract void annadirComensales(Comensal comensal);
	/** Metodo abstracto que elimina comensales a una mesa */
	public abstract void eliminarComensales(Comensal comensal);

	
}
