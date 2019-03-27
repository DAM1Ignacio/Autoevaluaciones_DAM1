package autoeval7;


public class Empleado {

	private String nombre;
	private double sueldo;
	private int edad;
	private PuestoTrabajo puesto;

	public Empleado(String nombre, double sueldo, int edad, PuestoTrabajo puesto) throws EmpleadoException {
			setNombre(nombre);
			setSueldo(sueldo);
			setEdad(edad);
			setPuesto(puesto);

	}

	
	public Empleado(Empleado empleado) {
		nombre = new String(empleado.nombre);
	}

	public void setNombre(String nombre) throws EmpleadoException {
		assert nombre != null;
		if (nombreValido(nombre)) {
			this.nombre = nombre;
		} else {
			throw new EmpleadoException("Nombre no valido");
		}

	}

	public void setSueldo(double sueldo) throws EmpleadoException {
		if(sueldoValido(sueldo)) {
			this.sueldo = sueldo;
		}else {
			throw new EmpleadoException("Sueldo invalido");
		}
	}

	public void setEdad(int edad) throws EmpleadoException {
		if(edadValida(edad)) {
			this.edad = edad;
		}else {
			throw new EmpleadoException("Edad no valida");
		}
	}

	public void setPuesto(PuestoTrabajo puesto) {
		assert puesto != null;
		this.puesto = puesto;
	}

	public String getNombre() {
		return nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public int getEdad() {
		return edad;
	}

	public PuestoTrabajo getPuesto() {
		return puesto;
	}

	private boolean nombreValido(String nombre) {
		return nombre.matches("^[A-ZÑÁÉÍÓÚa-zñáéíóúü][A-ZÑÁÉÍÓÚa-zñáéíóúü]+");
	}

	private boolean sueldoValido(double sueldo) {
		return sueldo>10000;
	}

	private boolean edadValida(int edad) {
		return edad>16 && edad<65;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", sueldo=" + sueldo + ", edad=" + edad + ", puesto=" + puesto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((puesto == null) ? 0 : puesto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sueldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (edad != other.edad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (puesto != other.puesto)
			return false;
		if (Double.doubleToLongBits(sueldo) != Double.doubleToLongBits(other.sueldo))
			return false;
		return true;
	}
	
	public Empleado clone() {
		return new Empleado(this);
	}

}
