package calculadora.app;

import java.util.Scanner;

import calculadora.dominio.Calculo;
import calculadora.dominio.Operaciones;

	/**
	 * Es la clase que se encarga de recoger el input del usuario, 
	 * llevarlo a GestorCalculadora y devolver el resultado
	 */
public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Consola consola = new Consola(sc);
		Analizador analizador= new Analizador();
		Calculo calculo = new Calculo();
		Operaciones operaciones = new Operaciones(calculo);
		GestorCalculadora gestor = new GestorCalculadora(analizador,consola,operaciones);
		String input, respuesta;

		do {
			input = consola.leerTexto(gestor.prompt());

			respuesta = gestor.analizarInput(input);

			consola.escribir(respuesta);

		} while (!input.equals("quit"));
		// Fallos tontos que hacen el bucle infinito: poner input != "quit", las cadenas se comparan con equals GENIO
	}
}
