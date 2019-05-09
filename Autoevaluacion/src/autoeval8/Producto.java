package autoeval8;

/**
 * Implementa el concepto de Producto según el enunciado del examen.
 * 
 * @source: Producto.java
 * @version: 1.3
 * @author: Ignacio Belmonte
 */
public class Producto {
	public enum TipoProducto {
		NACIONAL, IMPORTADO
	};

	private String nombre;
	private double precioCoste;
	private TipoProducto tipoProducto;
	private Proveedor suministrador;

	public Producto() {
		setNombre("Caja Carton");
		setPrecioCoste(123.32);
		setTipo(TipoProducto.NACIONAL);
		setSuministrador(new Proveedor());
	}

	public Producto(String nombre, double precioCoste, Proveedor suministrador, TipoProducto tipoProducto) {
		setNombre(nombre);
		setPrecioCoste(precioCoste);
		setTipo(tipoProducto);
		setSuministrador(suministrador);
	}

	public Producto(Producto producto) {
		this(new String(producto.getNombre()), producto.getPrecioCoste(), new Proveedor(producto.getSuministrador()),
				producto.getTipo()

		);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombreValido(nombre)) {
			this.nombre = nombre;
		}
	}

	/**
	 * Metodo para seleccionar el precio, si es inferior a cero pone 1.0
	 * 
	 * @param precioCoste
	 */
	public void setPrecioCoste(double precioCoste) {
		if (precioCosteValido(precioCoste)) {
			this.precioCoste = precioCoste;
		} else {
			this.precioCoste = 1.0;
		}
	}

	public void setTipo(TipoProducto tipoProducto) {
		assert tipoProducto != null;
		if (tipoProducto.equals(null)) {
			this.tipoProducto = TipoProducto.NACIONAL;
		} else {
			this.tipoProducto = tipoProducto;
		}
	}

	public void setSuministrador(Proveedor suministrador) {
		assert suministrador != null;
		this.suministrador = suministrador;
	}

	public double getPrecioCoste() {
		return precioCoste;
	}

	public TipoProducto getTipo() {
		return tipoProducto;
	}

	public Proveedor getSuministrador() {
		return suministrador;
	}

	/**
	 * Metodo que comprueba que el nombre no este vacio ni en
	 * 
	 * @param nombre
	 * @return
	 */
	private boolean nombreValido(String nombre) {
		assert nombre != null;
		return nombre.matches("[a-zA-Z0-9].{1,}");
	}

	/**
	 * Comprueba que el precio sea superior a cero
	 * 
	 * @param precioCoste
	 * @return
	 */
	private boolean precioCosteValido(double precioCoste) {
		return precioCoste > 0;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nPrecio Coste: " + precioCoste + "\nTipo Producto: " + tipoProducto
				+ "\nSuministrador: " + suministrador.getNombre();

	}

}
