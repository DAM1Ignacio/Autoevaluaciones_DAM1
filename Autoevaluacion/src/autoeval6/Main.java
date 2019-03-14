package autoeval6;

public class Main {

	public static void main(String[] args) {
		ListaLink lista = new ListaLink();
		lista.add( 0,"hola");
		lista.add(1, "fin");
		lista.add(1, "quetal");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}

}