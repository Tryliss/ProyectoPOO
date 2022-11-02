package gestorBoda;

public class DatosPersonales {
	private String nombre;
	private String apellidos;
	private int edad;
	private String alergias;
	private int identificador;
	private static int contador;
	
	protected DatosPersonales(String nombre, String apellidos, int edad, String alergias) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.alergias = alergias;
		this.identificador = contador;
		contador++;
	}
	
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected String getApellidos() {
		return apellidos;
	}
	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	protected int getEdad() {
		return edad;
	}
	protected void setEdad(int edad) {
		this.edad = edad;
	}
	protected String getAlergias() {
		return alergias;
	}
	protected void setAlergias(String alergias) {
		this.alergias = alergias;
	}
	protected int getIdentificador() {
		return identificador;
	}
	protected void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}
