package autoeval6;

/**
 * Representa la implementación parcial de una lista enlazada simple en la que
 * se tiene acceso directo al primer elemento y también al último.
 */
public class ListaLink {

	/**
	 * La clase Nodo está anidada y representa la estructura de un elemento de la
	 * lista enlazada simple.
	 */
	class Nodo {

		// Atributos
		Object dato;
		Nodo siguiente;

		/**
		 * Constructor que inicializa atributos al valor por defecto.
		 */
		public Nodo() {
			dato = null;
			siguiente = null;
		}

		public Nodo(Object dato) {
			this.dato = dato;
			siguiente = null;
		}

	} // class Nodo

	// Atributos ListaLink
	private Nodo primero;
	private Nodo ultimo;
	private int numElementos;

	/**
	 * Constructor que inicializa los atributos al valor por defecto
	 */
	public ListaLink() {
		primero = null;
		ultimo = null;
		numElementos = 0;
	}

	public void add(Object dato) {
		// variables auxiliares
		Nodo nuevo = new Nodo(dato);
		Nodo ultimo = null;
		if (numElementos == 0) {
			// Si la lista está vacía enlaza el nuevo nodo el primero.
			primero = nuevo;
		} else {
			// Obtiene el último nodo y enlaza el nuevo.
			ultimo = obtenerNodo(numElementos - 1);
			ultimo.siguiente = nuevo;
		}
		numElementos++; // Actualiza el número de elementos.
		this.ultimo = obtenerNodo(numElementos - 1);
	}

	public void add(int indice, Object dato) {
		if (indice >= numElementos || indice < 0) {
			if (indice == numElementos) {
				add(dato);
			} else {
				throw new IndexOutOfBoundsException("Indice erroneo: " + indice);
			}
		} else {
			Nodo nuevo = new Nodo(dato);
			Nodo posterior = obtenerNodo(indice);
			Nodo anterior = obtenerNodo(indice - 1);

			anterior.siguiente = nuevo;
			nuevo.siguiente = posterior;
			numElementos++;
			this.ultimo = obtenerNodo(numElementos - 1);
		}

	}

	public Nodo obtenerNodo(int indice) {
		// Lanza excepción si el índice no es válido.
		if (indice >= numElementos || indice < 0) {
			throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
		}
		// Recorre la lista hasta llegar al nodo de posición buscada.
		Nodo actual = primero;
		for (int i = 0; i < indice; i++)
			actual = actual.siguiente;
		return actual;
	}

	public Object get(int indice) {
		// lanza excepción si el índice no es válido
		if (indice >= numElementos || indice < 0) {
			throw new IndexOutOfBoundsException("índice incorrecto: " + indice);
		}
		Nodo aux = obtenerNodo(indice);
		return aux.dato;
	}
	
	public Object getUltimo() {
		return ultimo.dato;
	}

	public int size() {
		return numElementos;
	}

} // class listaLink