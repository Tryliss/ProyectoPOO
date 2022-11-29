package gestorCelebraciones;

/** Clase mesa niños*/
public class Ninnos extends Mesa{
	/** Tamaño minimo mesa niños */
	public static final int minimo=0; 
	/** Tamaño maximo mesa niños */
	public static final int maximo=15;

	/** Constructor mesa niños */
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
