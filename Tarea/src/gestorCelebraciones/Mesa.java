package gestorCelebraciones;

import java.util.ArrayList;


/** Clase mesa */
public abstract class Mesa { 
	static final int minimo=0; 
	static final int maximo=15;
	static int comensalesT; 
	static int sillasT; 
	static int mesasT;
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
	/** Devuelve minimo por mesa */
	public static int getMinimo() {
		return minimo;
	}
	/** Devuelve maximo por mesa */
	public static int getMaximo() {
		return maximo;
}
	/** Metodo abstracto que añade comensales a una mesa */
	public abstract void annadirComensales(Comensal comensal);
	/** Metodo abstracto que elimina comensales a una mesa */
	public abstract void eliminarComensales(Comensal comensal);

	
}
