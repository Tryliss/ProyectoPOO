package gestorCelebraciones;

/** Clase mesa general*/
public class General extends Mesa{
	static final int minimo=0; 
	static final int maximo=15;
	/** Constructor mesa general */
	public General(String llaveMesa) {
		super(llaveMesa);
	}


	@Override
	public void annadirComensales(Comensal comensal) {
		this.comensalesMesa.add(comensal);
		Mesa.setComensalesT();
		
	}


	@Override
	public void eliminarComensales(Comensal comensal) {
		this.comensalesMesa.add(comensal);
		
	}

}
