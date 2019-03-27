package autoeval7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EmpleadoTest {

	private static Empleado empleado;
	private static Empleado empleado2;

	@BeforeAll
	public static void inicializarEmpleado() {
		try {
			empleado = new Empleado("Nacho", 10500, 20, PuestoTrabajo.Jefe);
			empleado2 = new Empleado("Jose", 10400, 23, PuestoTrabajo.Empleado);
		} catch (EmpleadoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUsuarioDefecto() {
		assertEquals(empleado.getNombre(), "Nacho");
		assertEquals(empleado.getSueldo(), 10500, 00);
		assertEquals(empleado.getEdad(), 20);
		assertEquals(empleado.getPuesto(), PuestoTrabajo.Jefe);

	}

	@Test
	public void testUsuarioCopia() {
		Empleado empleado = empleado2.clone();
		assertNotSame(empleado, empleado2);
		assertNotSame(empleado.getNombre(), empleado2.getNombre());
		assertNotSame(empleado.getSueldo(), empleado2.getSueldo());
		assertNotSame(empleado.getEdad(), empleado2.getEdad());
		assertNotSame(empleado.getPuesto(), empleado2.getPuesto());
	}

	@Test
	public void testSetNombre() {
		try {
			empleado.setNombre("Nacho");
		} catch (EmpleadoException e) {
		}
		assertEquals(empleado.getNombre(), "Nacho");
	}

	@Test
	public void testNombreBlanco() {
		try {
			empleado.setNombre("  ");
			fail("No debe llegar aquí...");
		} catch (EmpleadoException e) {
		}
	}

	@Test
	public void testNombreNull() {
		try {
			empleado.setNombre(null);
			fail("No debe llegar aquí...");
		} catch (AssertionError | EmpleadoException e) {
		}
	}

	@Test
	public void testSetSueldo() {
		try {
			empleado.setSueldo(10500);
		} catch (EmpleadoException e) {
		}
		assertEquals(empleado.getSueldo(), 10500, 00);
	}

	@Test
	public void testSetSueldoBajo() {
		try {
			empleado.setSueldo(500);
			fail("No debe llegar aquí...");
		} catch (EmpleadoException e) {
		}
	}

	@Test
	public void testSetEdad() {
		try {
			empleado.setEdad(20);
		} catch (EmpleadoException e) {
		}
		assertEquals(empleado.getEdad(), 20);
	}

	@Test
	public void testSetEdadInvalida() {
		try {
			empleado.setEdad(15);
			fail("No debe llegar aquí...");
		} catch (EmpleadoException e) {
		}
	}

	@Test
	public void testSetPuesto() {
		empleado.setPuesto(PuestoTrabajo.Jefe);
		assertEquals(empleado.getPuesto(), PuestoTrabajo.Jefe);
	}

	@Test
	public void testSetPuestoNull() {
		try {
			empleado.setPuesto(null);
			fail("No debe llegar aquí...");
		} catch (AssertionError e) {
		}
	}

	@Test
	public void testToString() {
		assertEquals(empleado.toString(), "Empleado [nombre=" + empleado.getNombre() + ", sueldo="
				+ empleado.getSueldo() + ", edad=" + empleado.getEdad() + ", puesto=" + empleado.getPuesto() + "]");
	}

}
