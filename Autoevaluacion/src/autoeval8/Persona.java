package autoeval8;
/** 
 *  Implementa el concepto de Persona según el enunciado del examen.
 *  @source: Persona.java
 *  @version: 1.3 
 *  @author: ajp
 */
public abstract class Persona {

	//ATRIBUTOS
	protected String nombre;
	protected String direccion;
	protected String telefono;
	protected String correo;

	/**
	 * Constructor convencional
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param correo
	 */
	public Persona(String nombre, String direccion, String telefono, String correo) {
		setNombre(nombre);
		setDireccion(direccion);
		setTelefono(telefono);
		setCorreo(correo);
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return la direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @return el telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @return el correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param nombre, el nombre a asignar.
	 */
	public void setNombre(String nombre) {
		assert nombre != null;
		if (nombreValido(nombre)) {
			this.nombre = nombre;
		}
	}

	/**
	 * Comprueba validez del un nombre.
	 * @param nombre.
	 * @return true si cumple.
	 */
	protected boolean nombreValido(String nombre) {
		// Comprueba que:
		// No es null
		// Nombre está formado por tres partes separadas por un espacio y
		// cada uno de ellos a su vez es un bloque de tres letras, al menos que
		// empiezan por mayúscula. Sólo se adminten caracteres alfabéticos.
		return nombre.matches("^[A-ZÑ][a-zñáéíóú]{3,} [A-ZÑ][a-zñáéíóú]{3,} [A-ZÑ][a-zñáéíóú]{3,}");
	}

	/**
	 * @param direccion, la direccion a asignar
	 */
	public void setDireccion(String direccion) {
		assert  direccion != null;
		if (direccionValida(direccion)) {
			this.direccion = direccion;
		}
	}

	/**
	 * Comprueba validez del un direccion.
	 * @param nombre.
	 * @return true si cumple.
	 */
	private boolean direccionValida(String direccion) {
		if (direccion.equals("") || direccion.equals(" ")) {
			return false;
		}
		return true;
	}

	/**
	 * @param telefono, el teléfono a asignar
	 */
	public void setTelefono(String telefono) {
		assert telefono != null;
		if (telefonoValido(telefono)) {
			this.telefono = telefono;
		}
	}

	/**
	 * Comprueba validez del un número de teléfono.
	 * @param telefono.
	 * @return true si cumple.
	 */
	protected boolean telefonoValido(String telefono) {
		// Comprueba que:
		// No es null
		// Teléfono está formado por un código de pais y
		// tres bloques de dígitos.
		return telefono.matches("^\\+?\\d{1,3}?[ ]?\\(?\\d{2,3}\\)?[ ]?\\d\\d\\d[ ]?\\d\\d\\d$");
	}

	/**
	 * @param correo, el correo a asignar
	 */
	public void setCorreo(String correo) {
		assert  correo != null;
		if (correoValido(correo)) {
			this.correo = correo;
		}
	}

	/**
	 * Comprueba validez de una dirección de correo.
	 * @param correo.
	 * @return true si cumple.
	 */
	protected boolean correoValido(String correo) {
		return correo.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$");
	}

	/**
	 * @return el texto con todos el valor de todos los atributos
	 */
	@Override
	public String toString() {
		return "Nombre: "+nombre +
				"\nDireccion: " + direccion +
				"\nTelefono: " + telefono +
				"\nCorreo: " + correo;
	}

} //class