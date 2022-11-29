package gestorCelebraciones;

public class DatosPersonales {
	private String nombre;
	private String apellidos;
	private int edad;
	private String alergias;
	private int identificador;
	private static int contador;
	
	protected DatosPersonales(String nombre, String apellidos, int edad, String alergias) {
		this.nombre 		= 	nombre;
		this.apellidos 		= 	apellidos;
		this.edad 			= 	edad;
		this.alergias 		= 	alergias;
		this.identificador 	= 	contador;
		contador++;
	}
	
	protected String getNombre() {
		return nombre;
	}
	
	
	protected String getApellidos() {
		return apellidos;
	}
	
	
	protected int getEdad() {
		return edad;
	}
	
	
	protected String getAlergias() {
		return alergias;
	}
	
	
	public int getIdentificador() {
		return identificador;
	}
	
}
