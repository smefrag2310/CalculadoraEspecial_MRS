package calculadora.dominio;

import java.util.List;

	/**
	 * Esta clase se encarga de organizar las operaciones recibidas del record resultadoAnalisis
	 * en GestorCalculadora
	 */

public class Operaciones {

	private Calculo calculo;
	
	/**
	 * 
	 * @param calculo El objeto calculo proveniente de Main
	 */
	public Operaciones(Calculo calculo){
		this.calculo= calculo;
	}

	/**
	 * 
	 * @param numeros Una lista de doubles con todos los números introducidos por el usuario
	 * @param operadores Una lista de TipoOperador con todos los operadores introducidos por el usuario
	 * @return Devuelve un double con el resultado de la operacion
	 */
	public double OrganizarOperaciones(List<Double> numeros, List<TipoOperador> operadores) {

		double resultado, valor;
		TipoOperador operador;
		Object[] numbers = numeros.toArray();
		Object[] operators = operadores.toArray(); // Me he enterado luego que pasarlo a array no sirve de nada,
		resultado = (double) numbers[0];			// hace lo mismo .size() en el bucle

		for (int i = 0; i < operators.length; i++) {
			valor = (double) numbers[i + 1];
			operador = (TipoOperador) operators[i];

			switch (operador) {
			case SUMA -> resultado = calculo.sumar(resultado, valor);
			case RESTA -> resultado = calculo.restar(resultado, valor);
			case MULTIPLICACION -> resultado = calculo.multiplicar(resultado, valor);
			case DIVISION -> resultado = calculo.dividir(resultado, valor);
			}
		}
		return resultado;
	}
}
