package gestorCelebraciones;

public class General extends Mesa{
	static final int minimo=0; 
	static final int maximo=15;
	public General(String llaveMesa) {
		super(llaveMesa);
		// TODO Auto-generated constructor stub
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
