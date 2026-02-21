package calculadora.app;

import java.util.Scanner;

/**
 * Esta es la clase que se encarga de recoger todos los mensajes por consola a través de sus métodos
 * usando el util Scanner
 */
public class Consola {

	private Scanner sc;

	public Consola(Scanner sc) {
		this.sc = sc;
	}

	/**
	 * 
	 * @param mensaje El mensaje que queremos que salga por consola antes de la entrada del usuario
	 * @return Devuelve un String del texto aplicado el trim()
	 */
	public String leerTexto(String mensaje) {
		String texto;

		escribir(mensaje);
		texto = sc.nextLine();

		return texto.trim();
	}

	public void cerrar() {
		this.sc.close();
	}

	/**
	 * 
	 * @param texto El mensaje que queremos que salga por consola
	 */
	public void escribirLinea(String texto) {
		System.out.println(texto);
	}

	/**
	 * 
	 * @param texto El mensaje que queremos que salga por consola pero sin salto de línea
	 */
	public void escribir(String texto) {
		System.out.print(texto);
	}

	/**
	 * 
	 * @param mensaje El mensaje que queremos que salga antes de leer la respuesta del usuario
	 * @return Devuelve un String escrito por el usuario
	 */
	public String leerTextoNoVacio(String mensaje) {
		String texto;

		texto = "";
		while (texto.isBlank()) {
			escribir(mensaje);
			texto = sc.nextLine();
			texto = texto.trim();
			if (texto.isBlank()) {
				escribirLinea("ERROR - No puede estar vacío.");
			}
		}
		return texto;
	}
}
