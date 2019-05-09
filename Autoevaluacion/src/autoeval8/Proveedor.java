package autoeval8;

/** 
 *  Implementa el concepto de Proveedor según el enunciado del examen.
 *  @source: Proveedor.java
 *  @version: 1.3 
 *  @author: Ignacio Belmonte
 */

import java.util.GregorianCalendar;

public class Proveedor extends Persona {

	private GregorianCalendar fechaAlta;

	public Proveedor(String nombre, String direccion, String telefono, String correo, GregorianCalendar fechaAlta) {
		super(nombre, direccion, telefono, correo);
		setFechaAlta(fechaAlta);
	}

	public Proveedor() {
		super("Nacho Belmonte Perez", "direccion", "656565656", "correo");
		setFechaAlta(new GregorianCalendar());
	}

	public Proveedor(Proveedor proveedor) {
		super(new String(proveedor.getNombre()), new String(proveedor.getDireccion()),
				new String(proveedor.getTelefono()), new String(proveedor.getCorreo()));
		setNombre(new String(proveedor.getNombre()));
		setFechaAlta(new GregorianCalendar(proveedor.getFechaAlta().get(0), proveedor.getFechaAlta().get(1),
				proveedor.getFechaAlta().get(2)));
	}

	/**
	 * Metodo que genera el id del proveedor. El idProveedor esta formado por las 3
	 * primeras letras del nombre y las 3 ultimas del telefono Todas las letras iran
	 * en mayuscula
	 * 
	 * @return
	 */
	public String getIdProveedor() {
		String id = nombre.substring(0, 3) + telefono.substring(telefono.length() - 3, telefono.length());
		return id.toUpperCase();
	}

	/**
	 * Metodo para obtener la fecha de alta del proveedor
	 * 
	 * @return
	 */
	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * Metodo para seleccionar la fecha de alta, comprueba que no sea nula
	 * 
	 * @param fechaAlta
	 */
	public void setFechaAlta(GregorianCalendar fechaAlta) {
		assert fechaAlta != null;
		this.fechaAlta = fechaAlta;
	}

	/**
	 * Metodo toString, muestra informacion sobre el proveedor, muestra tambien los
	 * atributos heredados de persona
	 */
	@Override
	public String toString() {
		return super.toString() + "\nId Proveedor: " + getIdProveedor() + "\nFecha alta: " + fechaAlta.getTime();
	}

}
