/**
 * La clase Validacion realiza acciones
 * de validacion de los datos ingresados
 * por el usuario
 */
public class Validacion {

	/**
	 * el metodo validarContenido realiza las
	 * validaciones sobre el formato del
	 * tamaño,numero, se valida rango de tamaño,
	 * existencia de solo dos argumentos, una 
	 * sola coma de separacion.
	 * @param contenido
	 * 			string con el formato de datos
	 * 			tamaño,numero
	 * @return parametros
	 * 			arreglo de String con tamaño y numero
	 * 			el tamaño siempre es de 2
	 */
	public String[] validarContenido(String contenido) {

		String[] parametros = contenido.split(",");

		if (!contenido.contains(",")) {
			throw new IllegalArgumentException("Cadena " + contenido + " no contiene caracter ,");
		}

		if (parametros.length > 2) {
			throw new IllegalArgumentException("Cadena " + contenido + " contiene mas caracter ,");
		}

		if (parametros.length < 2) {
			throw new IllegalArgumentException("Cadena " + contenido + " no contiene los parametros requeridos");
		}

		if (!this.validarSiEsNumero(parametros[0])) {
			throw new IllegalArgumentException("Parametro Size [" + parametros[0] + "] no es un numero");
		}

		int tamanoDelDigito = Integer.parseInt(parametros[0]);

		if (tamanoDelDigito < 1 || tamanoDelDigito > 10) {
			throw new IllegalArgumentException("El parametro size [" + tamanoDelDigito + "] debe estar entre 1 y 10");
		}

		char[] digitos = parametros[1].toCharArray();

		for (char digito : digitos) {
			if (!Character.isDigit(digito)) {
				throw new IllegalArgumentException("Caracter " + digito + " no es un digito");
			}
		}
		return parametros;

	}
	
	
	/**
	 * el metodo validarEspacioEntreDigitos
	 * valida el rango del espacio y tipo de 
	 * dato que ingresa sea un numero
	 *@param 	espacioEntreNumeros
	 * 			espacio entre cada digito
	 *@return numero
	 * 			espacio como tipo de dato
	 * 			entero.
	 */
	public int validarEspacioEntreDigitos(String espacioEntreNumeros) {

		if (!this.validarSiEsNumero(espacioEntreNumeros)) {
			throw new IllegalArgumentException("El espacio debe ser un numero entero.");
		}

		int numero = Integer.parseInt(espacioEntreNumeros);

		if (numero < 0 || numero > 5) {
			throw new IllegalArgumentException("El espacio debe estar entre 0 y 5");
		}

		return numero;
	}
	
	/**
	 * el metodo validarSiEsNumero permite 
	 * establecer si un numero es de tipo
	 * entero o no
	 *@param 	numero
	 * 			cadena de caracter 
	 *@return true or false
	 * 			verdadero si es tipo entero
	 * 			falso si no es tipo entero
	 */
	private boolean validarSiEsNumero(String numero) {
		try {
			Integer.parseInt(numero);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}
