package autoeval5;

/**
 * Clase que contiene un array de objetos de la clase Usuario y métodos para las
 * pruebas y manipulación del array.
 * 
 * @author Ignacio Belmonte
 */
public class Datos {

	public static Usuario[] datosUsuarios;

	/**
	 * Método principal que coordina la llamada a los distintos métodos probados.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String texto = "0344556K,pepe0,López Pérez0,C/Luna 27 30132 Murcia,pepe0@gmail.com,1990.11.12,2015.12.3,miau0,usuario normal;";

		importarUsuariosTexto(texto);
		
		for (int i = 0; i < datosUsuarios.length; i++) {
			System.out.println(datosUsuarios[i].toString());
		}

	}

	private static void importarUsuariosTexto(String texto) {
		String[] personas = texto.split(";");
		datosUsuarios = new Usuario[personas.length + 20];
		for (int i = 0; i < personas.length; i++) {
			String[] datosPersonas = personas[i].split(",");
			datosUsuarios[i] = new Usuario();
			datosUsuarios[i].nif = datosPersonas[0];
			datosUsuarios[i].nombre = datosPersonas[1];
			datosUsuarios[i].apellidos = datosPersonas[2];
			datosUsuarios[i].domicilio = datosPersonas[3];
			datosUsuarios[i].correo = datosPersonas[4];
			datosUsuarios[i].fechaNacimiento = datosPersonas[5];
			datosUsuarios[i].fechaAlta = datosPersonas[6];
			datosUsuarios[i].claveAcceso = datosPersonas[7];
			datosUsuarios[i].rol = datosPersonas[8];
		}
	}

} // class

/**
 * Clase que representa el usuario de un sistema.
 * 
 * @author Ignacio Belmonte
 */
class Usuario {

	// Atributos
	public String nif;
	public String nombre;
	public String apellidos;
	public String domicilio;
	public String correo;
	public String fechaNacimiento;
	public String fechaAlta;
	public String claveAcceso;
	public String rol;
	
	@Override
	public String toString() {
		return "Usuario [nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", domicilio=" + domicilio
				+ ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", fechaAlta=" + fechaAlta
				+ ", claveAcceso=" + claveAcceso + ", rol=" + rol + "]";
	}
	
	

} // class