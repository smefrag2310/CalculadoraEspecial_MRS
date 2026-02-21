package calculadora.dominio;

/**
 * Esta clase se encarga de hacer los cálculos anteriormente organizados por la clase Operaciones
 * de forma que se encuentran divididas en operaciones sencillas
 */

public class Calculo {

	/**
	 * Suma los dos números
	 * 
	 * @param numero1 Primer número de la operación
	 * @param numero2 Segundo número de la operación 
	 * @return  Devuelve un double con el resultado
	 */
	public double sumar(double numero1, double numero2) {
		return numero1 + numero2;
	}

	/**
	 * Resta los dos números
	 * 
	 * @param numero1 Primer número de la operación
	 * @param numero2 Segundo número de la operación 
	 * @return  Devuelve un double con el resultado
	 */
	public double restar(double numero1, double numero2) {
		return numero1 - numero2;
	}

	/**
	 * Multiplica los dos números
	 * 
	 * @param numero1 Primer número de la operación
	 * @param numero2 Segundo número de la operación 
	 * @return  Devuelve un double con el resultado
	 */
	public double multiplicar(double numero1, double numero2) {
		return numero1 * numero2;
	}

	/**
	 * Divide los dos números
	 * 
	 * @param numero1 Primer número de la operación
	 * @param numero2 Segundo número de la operación 
	 * @return  Devuelve un double con el resultado
	 */
	public double dividir(double numero1, double numero2) {
		return numero1 / numero2;
	}
}
