package autoeval2;
import java.util.Scanner;

/**
 * Programa que muestra el numero mayor y el menor de una serie de numeros
 * 
 * @author nacho 18.10.21
 */
public class MayorMenor {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Teclea números entre 1 y 2147483647\n-Cero para terminar-");

		int elMayor = 0;
		int contadorDatosValidos = 0;
		int elMenor = Integer.MAX_VALUE;

		// Bucle para introducir numeros
		while (true) {

			int valorEntrada = Integer.parseInt(teclado.nextLine());

			// Salida del programa
			if (valorEntrada == 0) {

				System.out.print("Pulsa la tecla T para salir... ");
				String salida = teclado.nextLine();

				// Confirmacion de salida
				if (salida.toUpperCase().equals("T")) {
					break;
				} else { // Si no confirma la salida, se le pide un numero nuevo
					valorEntrada = Integer.parseInt(teclado.nextLine());
				}
			}

			// Para que el numero sea valido tiene que ser mayor que 0
			if (valorEntrada > 0) {

				contadorDatosValidos++;

				/*
				 * Si el numero es mayor que el numero mas grande introducido se almacena como
				 * nuevo numero mas grande introducido
				 */
				if (valorEntrada > elMayor) {
					elMayor = valorEntrada;
				}
				/*
				 * Si el numero es menor que el numero mas pequeño introducido se almacena como
				 * nuevo numero mas pequeño introducido
				 */
				if (valorEntrada < elMenor) {
					elMenor = valorEntrada;
				}
			} else {
				System.out.println("!Numero no valido");
			}
		} // Cierre While
		// Se mostraran los resultados si se ha introducido almenos dos numero valido
		if (contadorDatosValidos > 1) {
			System.out.println("\nResultados :\n\n" + "Total de datos válidos: " + contadorDatosValidos + "\n"
					+ "El mayor: " + elMayor + "\n" + "El menor: " + elMenor);
		}
		teclado.close();
	}

}
