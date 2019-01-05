package autoeval4;

/**
 * 
 * @author Ignacio Belmonte 5 ene. 2019
 */
public class Principal {
	final static int MAX_USUARIOS = 45;
	static Usuario[] datosUsuarios = new Usuario[MAX_USUARIOS];
	static Usuario[] datosUsuarioParaCargar;
	private static int posicionEnElPatron = 0;
	private static int posicionEnDatosUsuarioParaCargar = 0;

	public static void main(String[] args) {
		crearDatosUsuarioPrueba();
		int[] patron = { 1, 1, 1, 0, 1 };
		cargarDatosUsuariosPatron(patron);

		// Comprobacion de que se han guardado los datos en la posicion
		System.out.println(datosUsuarios[0].getNombre());
		System.out.println(datosUsuarios[1].getNombre());
		System.out.println(datosUsuarios[2].getNombre());
		System.out.println(datosUsuarios[4].getNombre());
	}

	/**
	 * Metodo utilizado para crear datos de prueba de usuarios
	 */
	private static void crearDatosUsuarioPrueba() {
		String[] nifPrueba = { "00001a", "00002b", "00003c", "000004d", "00005e" };
		String[] nombrePrueba = { "usuario1", "usuario2", "usuario3", "usuario4", "usuario5" };
		String[] apellidosPrueba = { "apellido3", "apellido2", "apellido3", "apellido4", "apellido5" };
		String[] domicilioPrueba = { "calle1", "calle2", "calle3", "calle4", "calle5" };
		String[] correoPrueba = { "cooreo@1", "cooreo@2", "cooreo@3", "cooreo@4", "correo@5" };
		String[] fechaNacimientoPrueba = { "1-2-3", "4-5-6", "1-2-3", "4-5-6", "2-4-5" };
		String[] fechaAltaPrueba = { "1-2-3", "4-5-6", "1-2-3", "4-5-6", "2-4-5" };
		String[] claveAccesoPrueba = { "Miau#1", "Miau#2", "Miau#3", "Miau#4", "Miau#5" };
		String[] rolPrueba = { "NORMAL", "NORMAL", "NORMAL", "NORMAL", "NORMAL" };
		datosUsuarioParaCargar = new Usuario[nombrePrueba.length];
		for (int i = 0; i < nombrePrueba.length; i++) {
			datosUsuarioParaCargar[i] = new Usuario(nifPrueba[i], nombrePrueba[i], apellidosPrueba[i], correoPrueba[i],
					domicilioPrueba[i], fechaNacimientoPrueba[i], fechaAltaPrueba[i], claveAccesoPrueba[i],
					rolPrueba[i]);
		}
	}

	/**
	 * Este metodo carga los datos de prueba de usuario en la array datosUsuarios segun
	 * un patron. El patron es una array que dice en que posiciones se pueden
	 * guardas datos (el valor es 1) y en cuales no (el valor es 0) Este metodo se
	 * termina cuando se han cargado todos los usuarios de prueba.
	 * 
	 * @author Ignacio Belmonte
	 * @param patron
	 */
	private static void cargarDatosUsuariosPatron(int[] patron) {
		for (int posicionEnArrayDatosUsuarios = 0; posicionEnArrayDatosUsuarios < datosUsuarios.length; posicionEnArrayDatosUsuarios++) {
			if (isCargadosTodosLosDatosParaCargar()) {
				break;
			}
			if (isRecoridoElPatronCompleto(patron)) {
				reiniciarPosicionEnElPatron();
			}
			if (isPosicionEnElPatronMarcadaParaGuardarDatos(patron)) {
				cargarDatosEnDatosUsuarios(posicionEnArrayDatosUsuarios);
				posicionEnDatosUsuarioParaCargar++;
			}
			posicionEnElPatron++;
		}
		reiniciarPosicionEnElPatron();
		reiniciarPosicionEnDatosUsuarioParaCargar();
	}

	private static boolean isCargadosTodosLosDatosParaCargar() {
		return posicionEnDatosUsuarioParaCargar == datosUsuarioParaCargar.length;
	}

	private static boolean isRecoridoElPatronCompleto(int[] patron) {
		return posicionEnElPatron >= patron.length;
	}

	private static void reiniciarPosicionEnElPatron() {
		posicionEnElPatron = 0;
	}

	private static boolean isPosicionEnElPatronMarcadaParaGuardarDatos(int[] patron) {
		return patron[posicionEnElPatron] == 1;
	}

	private static void cargarDatosEnDatosUsuarios(int posicionGuardar) {
		datosUsuarios[posicionGuardar] = datosUsuarioParaCargar[posicionEnDatosUsuarioParaCargar];
	}

	private static void reiniciarPosicionEnDatosUsuarioParaCargar() {
		posicionEnDatosUsuarioParaCargar = 0;
	}

} // class