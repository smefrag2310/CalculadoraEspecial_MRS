package calculadora.app;

import java.util.ArrayList;
import java.util.List;

import calculadora.dominio.Operaciones;
import calculadora.dominio.ResultadoAnalisis;

	/**
	 * Esta clase es la encargada de obtener el input del usuario y acceder a otras clases 
	 * para hacer su funcionalidad, además de a otros métodos para su correcto funcionamiento.
	 */

public class GestorCalculadora {

	private Analizador analizador;
	private double ultimoResultado;
	private List<String> historial;
	private Consola consola;
	private Operaciones operaciones;

	/**
	 * 
	 * @param analizador	Es el objeto analizador creado en Main para acceder a sus métodos
	 * @param consola		Es el objeto consola creado en Main para acceder a sus métodos
	 * @param operaciones	Es el objeto operaciones creado en Main para accedder a sus métodos
	 */
	GestorCalculadora(Analizador analizador,Consola consola, Operaciones operaciones) {
		ultimoResultado = 0;
		this.analizador = analizador;
		historial = new ArrayList<>();
		this.consola = consola;
		this.operaciones = operaciones;
	}
	/**
	 * 
	 * @return	El prompt que tiene que aparecer antes de poner cualquier comando en calculadora
	 */
	public String prompt() {
		return String.format("\nCALCULADORA\r\n" + "-----------------\r\n" + ">");
	}
	/**
	 * 
	 * @param texto	Es el input del usuario
	 * @return		Devuelve un String con el input del usuario junto al resultado de la operacion o comando
	 */
	public String analizarInput(String texto) {
		ResultadoAnalisis resultados;
		double resultado;
		String linea;

		if (texto == null || texto.isBlank()) {
			return "Entrada vacía.";
		}

		texto = texto.trim();

		resultados = analizador.analizar(texto, ultimoResultado);

		switch (resultados.comando()) {

		case LIST:
			return mostrarHistorial();
		case QUIT:
			return salirDelPrograma();
		case RESET:
			resetHistorial();
			reiniciarUltimoResultado();
			return String.format("Se ha reiniciado el historial");
		case CALCULO:
			resultado = operaciones.OrganizarOperaciones(resultados.numeros(), resultados.operadores());
			guardarUltimoResultado(resultado);

			linea = String.format("%s = %.2f", texto, resultado);
			añadirHistorial(linea);

			return linea;
		case RESULT:
			return String.format("Último resultado: %.2f", ultimoResultado);
		default:
			return "Comando no reconocido";
		}
	}
	
	private void resetHistorial() {
		historial.clear();
	}
	/**
	 * 
	 * @return	Devuelve un String con todo el historial almacenado en el atributo historial.
	 */
	private String mostrarHistorial() {

		StringBuilder sb = new StringBuilder();

		if (historial.isEmpty()) {
			return "El historial está vacío";
		}

		for (String linea : historial) {
			sb.append(linea).append("\n");
		}

		return sb.toString();
	}
	/**
	 * 
	 * @param resultado El último resultado obtenido
	 */
	private void guardarUltimoResultado(double resultado) {
		this.ultimoResultado = resultado;
	}
	
	private void reiniciarUltimoResultado() {
		this.ultimoResultado = 0;
	}
	/**
	 * 
	 * @param texto	String del resultado completo, con operaciones y resultado.
	 */
	private void añadirHistorial(String texto) {
		historial.add(texto);
	}
	/**
	 * 
	 * @return	String mensaje de despedida
	 */
	private String salirDelPrograma() {
		consola.cerrar();
		return String.format("Saliendo del programa...\n ¡Hasta la próxima!");
	}
}
