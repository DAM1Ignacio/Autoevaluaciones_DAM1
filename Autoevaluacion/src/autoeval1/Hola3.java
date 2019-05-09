package autoeval1;
/**
  * Hola3.java
 * Programa simple que compara dos numeros y te dice el mayor
 * ibp - 2018.10.07
 */

import java.util.Scanner;

public class Hola3
{
    public static void main(String argumentos[]) {
        
        // teclado es un canal de entrada de texto a traves de un Scanner
        // 
        Scanner teclado = new Scanner(System.in);

        int num;               // Inicializacion de la variable num
       
        // Primer parrafo que se muestra por pantalla
        num = 1;
        System.out.println("Hola, Soy un modesto ");
        System.out.print("programa de ordenador...\n");
        System.out.println("Mi número de orden es el " + num + " por ser el primero.");

        // El programa pide dos valores y los almacena como enteros
        System.out.println("Escribe dos números...\n");
        int dato1 = teclado.nextInt();
        int dato2 = teclado.nextInt();

        // Muestra por pantalla los valores introducidos
        System.out.println("Dato1: " + dato1);
        System.out.println("Dato2: " + dato2);

        // Comparacion de que dato introducido es el mayor y lo muestra por pantalla
        String mensaje = "";

        if (dato1 == dato2) {
            mensaje = "Ninguno de los dos es mayor... ";
        }

        if (dato1 > dato2) {
            mensaje = "El mayor es: " + dato1;
        }

        if (dato2 > dato1) {
            mensaje = "El mayor es: " + dato2;
        }

        System.out.println(mensaje);
        teclado.close();
    }

}