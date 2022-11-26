package gestorCelebraciones;

import java.util.ArrayList;



public abstract class Mesa { 
	static final int minimo=0; 
	static final int maximo=15;
	static int comensalesT; 
	static int sillasT; 
	static int mesasT;
	String llaveMesa;
	ArrayList<Comensal> comensalesMesa= new ArrayList<Comensal>();

	public Mesa(String llaveMesa) {
		this.llaveMesa = llaveMesa;
	}

	public static int getComensalesT() {
		return comensalesT;
	}

	public static void setComensalesT() {
		comensalesT++;
	}

	public static int getSillasT() {
		return sillasT;
	}

	public static void setSillasT(int sillasT) {
		Mesa.sillasT = sillasT;
	}

	public static int getMesasT() {
		return mesasT;
	}

	public static void setMesasT(int mesasT) {
		Mesa.mesasT = mesasT;
	}

	public String getLlaveMesa() {
		return llaveMesa;
	}

	public void setLlaveMesa(String llaveMesa) {
		this.llaveMesa = llaveMesa;
	}

	public static int getMinimo() {
		return minimo;
	}

	public static int getMaximo() {
		return maximo;
	}
	public abstract void annadirComensales(Comensal comensal);
	public abstract void eliminarComensales(Comensal comensal);

	
}
