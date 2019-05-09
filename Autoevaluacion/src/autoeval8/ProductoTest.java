package autoeval8;
/** 
 *  Clase JUnit5 para tets de Producto según el enunciado del examen.
 *  @source: ProductoTest.java
 *  @version: 1.4
 *  @author: ajp
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoTest {

	//Datos para las pruebas
	private static Producto producto1;
	private static Producto producto2;
	
	/**
	 * Método que se ejecuta una sola vez al principio del conjunto pruebas.
	 * @throws DatosException 
	 */
	@BeforeAll
	public static void iniciarlizarDatosFijos() {
		// Objetos no modicados en las pruebas.
		producto1 = new Producto(
				"Calabaza amarilla", 
				2.50, 
				new Proveedor("Pepe López Ruiz", "C/Luna 27, 30132 Murcia", 
						"+034 (968) 123 456", "pepe@gmail.com", new GregorianCalendar()), 
				Producto.TipoProducto.IMPORTADO
				); 	
	}
	
	/**
	 * Método que se ejecuta antes de cada @Test para preparar datos de prueba.
	 */
	@BeforeEach 
	public void creaProducto() {
		producto2 = new Producto();
	}

	/**
	 * Método que se ejecuta después de cada @Test para limpiar datos de prueba.
	 */
	@AfterAll	
	public static void borraProducto() {
		producto2 = null;
	}

	/**
	 * Después de ejecutar el constructor convencional en el método @Before 
	 * debe haber un objeto construido no null.
	 */
	@Test
	public void testProductoConvencional() {
		assertNotNull(producto1);
	}

	/**
	 * Después de ejecutar el constructor por defecto en el método @Before 
	 * debe haber un objeto construido no null.
	 */
	@Test
	public void testProductoDefecto() {
		assertNotNull(producto2);
	}

	/**
	 * Después de ejecutar el constructor copia
	 * debe haber un objeto construido no null.
	 */
	@Test
	public void testProductoCopia() {
		Producto p = new Producto(producto1);
		assertNotNull(producto1);
	}
	
	/**
	 * Una vez se tiene un objeto, creado en el método @Before, 
	 * debe coincidir: el valor del atributo con el valor modificado.
	 */
	@Test
	public void testSetNombre() {
		producto2.setNombre("Calabaza amarilla");	
		assertEquals(producto2.getNombre(), "Calabaza amarilla");
	}
	
	/**
	 * Una vez se tiene un objeto, creado en el método @Before, 
	 * debe coincidir: el valor del atributo con el valor modificado.
	 */
	@Test
	public void testSetPrecioCoste() {
		producto2.setPrecioCoste(2.50);	
		assertTrue(producto2.getPrecioCoste() == 2.50);
	}
	
	/**
	 * Una vez se tiene un objeto, creado en el método @Before, 
	 * debe coincidir: el valor del atributo con el valor modificado.
	 */
	@Test
	public void testSetSuministrador() {
		Proveedor p = new Proveedor("Pepe López Ruiz", 
				"C/Luna 27, 30132 Murcia", 
				"+034 (968) 123 456", 
				"pepe@gmail.com", 
				new GregorianCalendar());
		producto2.setSuministrador(p);
		assertSame(producto2.getSuministrador(), p);
	}
	
	/**
	 * Una vez se tiene un objeto, creado en el método @Before, 
	 * debe coincidir: el valor del atributo con el valor modificado.
	 */
	@Test
	public void testSetTipo() {
		producto2.setTipo(Producto.TipoProducto.IMPORTADO);	
		assertEquals(producto2.getTipo(), Producto.TipoProducto.IMPORTADO);
	}
	
	/**
	 * Una vez inicializado un objeto en el método @Before 
	 * debe obtenerse un texto como el esperado.
	 */
	@Test
	public void testToString() {
		assertNotNull(producto1.toString());
	}

	// Test CON DATOS NO VALIDOS
	/**
	 * Una vez se tiene un objeto, creado en el método @BeforeClass, 
	 * al intentar cambiar a un valor no válido, 
	 * debe coincidir: el valor del atributo con el valor por defecto.
	 */
	@Test
	public void testSetNombreNull() {
		try {
			producto1.setNombre(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
		}
	}
	
	/**
	 * Una vez se tiene un objeto, creado en el método @Before, 
	 * al intentar cambiar a un valor no válido, 
	 * debe coincidir: el valor del atributo con el valor por defecto.
	 */
	@Test
	public void testSetPrecioCosteNoValido() {
		producto2.setPrecioCoste(0);	
		assertTrue(producto2.getPrecioCoste() == 1.0);

		producto2.setPrecioCoste(-3.0);	
		assertTrue(producto2.getPrecioCoste() == 1.0);
	}
	
	/**
	 * Una vez se tiene un objeto, creado en el método @Before, 
	 * al intentar cambiar a un valor no válido, 
	 * debe coincidir: el valor del atributo con el valor por defecto.
	 */
	@Test
	public void testSetSuministradorNull() {
		try {
			producto1.setSuministrador(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
		}
	}
	
	/**
	 * Una vez se tiene un objeto, creado en el método @BeforeClass, 
	 * al intentar cambiar a un valor no válido, 
	 * debe coincidir: el valor del atributo con el valor por defecto.
	 */
	@Test
	public void testSetTipoNull() {
		try {
			producto1.setTipo(null);
			fail("No debe llegar aquí...");
		} 
		catch (AssertionError e) { 
		}
	}
	
} // class