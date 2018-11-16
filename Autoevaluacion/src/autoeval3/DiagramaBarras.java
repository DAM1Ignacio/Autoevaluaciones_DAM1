package autoeval3;

import java.util.Scanner;

/**
 * Programa para dibujar un numero de caracteres de -10 a 10
 * 
 * @author nacho
 *
 */
public class DiagramaBarras {

	final static int LIMITE_SUPERIOR = 11;
	final static int LIMITE_INFERIOR = -11;
	final static char CARACTER_BASE = '*';

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduce numeros del -10 hasta 10 para dibujar una barra de asteriscos");
		System.out.println("- Introduce cualquier valor no numerico para salir");

		boolean esNumerico = true;

		do {
			String numeroCaracteres = teclado.nextLine();

			for (int i = 0; i < numeroCaracteres.length(); i++) {
				if (!Character.isDigit(numeroCaracteres.charAt(i))) {
					esNumerico = false;
					break;
				}
			}
			if (esNumerico) {
				System.out.println(generarBarraHorizontal(Integer.parseInt(numeroCaracteres)) + "\n");
			}
		} while (esNumerico);

		teclado.close();
	}

	/**
	 * 
	 * @param numeroRepresentar
	 * @return barra final con el numero de caracteres indicado
	 */
	public static String generarBarraHorizontal(int numeroRepresentar) {

		if (numeroRepresentar > LIMITE_INFERIOR && numeroRepresentar < LIMITE_SUPERIOR) {

			if (numeroRepresentar > 0) {

				return "          |" + generarBloqueCaracteres(numeroRepresentar, CARACTER_BASE);

			} else if (numeroRepresentar == 0) {

				return "          |          ";

			} else {

				return generarBloqueCaracteres(numeroRepresentar, CARACTER_BASE) + "|          ";
			}

		} else {

			return "FUERA DE RANGO";
		}
	}

	/**
	 * 
	 * @param numeroCaracteres
	 * @param caracter
	 * @return Bloque de caracteres
	 */
	public static String generarBloqueCaracteres(int numeroCaracteres, char caracter) {

		String bloqueCaracteres = "";

		if (numeroCaracteres > 0) {

			for (int i = 0; i < numeroCaracteres; i++) {

				bloqueCaracteres += caracter;
			}
			for (int i = 0; i < 10 - numeroCaracteres; i++) {

				bloqueCaracteres += " ";
			}
			return bloqueCaracteres;

		} else {

			for (int i = 0; i > -10 - numeroCaracteres; i--) {

				bloqueCaracteres += " ";
			}
			for (int i = 0; i > numeroCaracteres; i--) {

				bloqueCaracteres += caracter;
			}
			return bloqueCaracteres;
		}
	}

}// class
