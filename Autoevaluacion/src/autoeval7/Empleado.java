package autoeval7;


public class Empleado {

	private String nombre;
	private double sueldo;
	private int edad;
	private PuestoTrabajo puesto;

	public Empleado(String nombre, double sueldo, int edad, PuestoTrabajo puesto) {
		try {
			setNombre(nombre);

		this.sueldo = sueldo;
		this.edad = edad;
		this.puesto = puesto;
		} catch (EmpleadoException e) {
			e.printStackTrace();
		}
	}

	
	public Empleado(Empleado empleado) {
		nombre = new String(empleado.nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws EmpleadoException {
		assert nombre != null;
		if (nombreValido(nombre)) {
			this.nombre = nombre;
		} else {
			throw new EmpleadoException("Nombre no valido");
		}

	}

	private boolean nombreValido(String nombre) {
		return nombre.matches("^[A-ZÑÁÉÍÓÚa-zñáéíóúü][A-ZÑÁÉÍÓÚa-zñáéíóúü]+");
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public PuestoTrabajo getPuesto() {
		return puesto;
	}

	public void setPuesto(PuestoTrabajo puesto) {
		this.puesto = puesto;
	}

}
