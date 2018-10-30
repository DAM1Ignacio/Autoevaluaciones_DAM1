package autoeval2;


/**
 * MayorMenorT.java
 * Pide una serie de números naturales (enteros positivos sin el 0).
 * Una vez leidos al menos dos datos válidos, admite cero para terminar pidiendo confirmación.
 * Muestra la cantidad de datos válidos introducidos, el mayor y el menor. 
 * ajp - 2018.10.17
 */

import java.util.Scanner;

public class MayorMenorT {

	public static void main(String[] args) {

		final int MIN_DATOS_VALIDOS = 2;
		final int PRIMER_DATO_VALIDO = 1;
		final int ULTIMO_DATO_VALIDO = Integer.MAX_VALUE;
		final String TECLA_CONFIRMACION = "T";

		int contadorDatosValidos = 0;
		int elMayor = PRIMER_DATO_VALIDO;
		int elMenor = ULTIMO_DATO_VALIDO;
		boolean noFinPrograma = true;
		Scanner teclado = new Scanner(System.in);

		System.out.println("Teclea números entre " + PRIMER_DATO_VALIDO + " y " + ULTIMO_DATO_VALIDO);
		System.out.println("-Cero para terminar-");
		do {
			int datoEntrada = teclado.nextInt();

			// Tratamiento del fin de programa.
			if (datoEntrada == 0) {
				if (contadorDatosValidos >= MIN_DATOS_VALIDOS) {
					System.out.println("Pulsa la tecla " + TECLA_CONFIRMACION + " para salir... ");
					String tecla = new Scanner(System.in).nextLine();
					if (tecla.equalsIgnoreCase(TECLA_CONFIRMACION)) {
						noFinPrograma = false;
					} else {
						System.out.println("Teclea dato: ");
					}
				} else {
					System.out.println("Error: Hacen falta " + MIN_DATOS_VALIDOS + " datos válidos como mínimo...");
					System.out.println("Teclea dato: ");
					continue;
				}
			}

			// Tratamiento de datos.
			if (datoEntrada >= PRIMER_DATO_VALIDO && datoEntrada <= ULTIMO_DATO_VALIDO) {
				if (datoEntrada > elMayor) {
					elMayor = datoEntrada;
				}

				if (datoEntrada < elMenor) {
					elMenor = datoEntrada;
				}
				contadorDatosValidos++;
			} else {
				System.out
						.println("Error: El dato debe estar entre " + PRIMER_DATO_VALIDO + " y " + ULTIMO_DATO_VALIDO);
				System.out.println("Teclea dato: ");
			}

		} while (noFinPrograma);

		System.out.println("\nResultados:\n");
		System.out.println("Total de datos válidos: " + contadorDatosValidos);
		System.out.println("El mayor: " + elMayor);
		System.out.println("El menor: " + elMenor);
	}

} // class