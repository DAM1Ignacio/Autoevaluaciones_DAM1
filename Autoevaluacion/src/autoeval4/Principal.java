package autoeval4;

/**
 * Programa para cargar datos de usuario en una array segun un patron
 * 
 * @author Ignacio Belmonte 5 ene. 2019
 */
public class Principal {
	final static int MAX_USUARIOS = 45;
	static Usuario[] datosUsuarios = new Usuario[MAX_USUARIOS];
	static Usuario[] datosUsuarioParaCargar;
	private static int posicionEnElPatron = 0;
	private static int numUsuarioParaCargar = 1;

	public static void main(String[] args) {
		int[] patron = { 1, 1, 1, 0, 1 };
		cargarDatosUsuariosPatron(patron);

		// Comprobacion de que se han guardado los datos en la posicion
		for (int i = 0; i < datosUsuarios.length; i++) {
			System.out.println(datosUsuarios[i]);
		}
	}

	/**
	 * Este metodo carga datos de prueba en la array datosUsuarios segun un patron.
	 * El patron es una array que dice en que posiciones se pueden guardar datos (el
	 * valor es 1) y en cuales no (el valor es 0)
	 * 
	 * @author Ignacio Belmonte
	 * @param patron
	 */
	private static void cargarDatosUsuariosPatron(int[] patron) {
		for (int posicionDatosUsuarios = 0; posicionDatosUsuarios < datosUsuarios.length; posicionDatosUsuarios++) {
			if (isRecoridoElPatronCompleto(patron)) {
				reiniciarPosicionEnElPatron();
			}
			if (isPosicionEnElPatronMarcadaParaGuardarDatos(patron)) {
				cargarDatosEnDatosUsuarios(posicionDatosUsuarios);
				numUsuarioParaCargar++;
			}
			posicionEnElPatron++;
		}
		reiniciarPosicionEnElPatron();
		reiniciarNumUsuarioParaCargar();
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
		datosUsuarios[posicionGuardar] = new Usuario("nif" + numUsuarioParaCargar + numUsuarioParaCargar,
				" nombre" + numUsuarioParaCargar, " apellidos" + numUsuarioParaCargar, " correo" + numUsuarioParaCargar,
				" domicilio" + numUsuarioParaCargar, " fechaNacimiento" + numUsuarioParaCargar,
				" fechaAlta" + numUsuarioParaCargar, " claveAcceso" + numUsuarioParaCargar,
				"rol" + numUsuarioParaCargar);
	}

	private static void reiniciarNumUsuarioParaCargar() {
		numUsuarioParaCargar = 1;
	}

} // class