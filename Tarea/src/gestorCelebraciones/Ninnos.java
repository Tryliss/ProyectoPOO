package gestorCelebraciones;


public class Ninnos extends Mesa{
	public static final int minimo=0; 
	public static final int maximo=15;

	public Ninnos() {
		super("Niños");
	}

	@Override
	public void annadirComensales(Comensal comensal) {
				this.comensalesMesa.add(comensal);
				Mesa.setComensalesT();
	}

	@Override
	public void eliminarComensales(Comensal comensal) {
		// TODO Auto-generated method stub
		
	}

}
