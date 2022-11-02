package gestorBoda;


public class Presidencial extends Mesa{
	static final int minimo=0; 
	static final int maximo=15;

	public Presidencial() {
		super("Presidencial");
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
