import java.util.ArrayList;
import java.util.List;

/**
 * La clase ImpresorLCD convierte un numero 
 * en formato 7 segmentos. Permite asignar un 
 * tamaño especifico de 1 a 10 para cada 
 * digito y separarlos con espacios de 0 a 5
 */

public class ImpresorLCD {

	/**
	 * validadorDeDatos es un objeto que permite
	 * validar multiples parametros de los datos 
	 * ingresados por el usuario
	 */
	private Validacion validadorDeDatos;
	
	/**
	 * codificadorDeDigitos es un objeto que 
	 * codifica cada digito a siete segmentos
	 */
	private Codificador codificadorDeDigitos;
	
	/**
	 * pantalla es un objeto que se encarga de 
	 * tomar los digitos codificados en 7 segmentos 
	 * y mostrarlos en pantalla
	 */
	private Pantalla pantalla;

	/**
	 * espacioDig es el numero de espacios 
	 * entre los digitos
	 */
	private int espacioDig;


	public ImpresorLCD() {
		this.validadorDeDatos = new Validacion();
		this.codificadorDeDigitos = new Codificador();
	}

	/**
	 * Metodo para iniciar el proceso de convertir 
	 * numeros enteros en digitos de 7 segmentos y 
	 * la visualizacion por consola. 
	 * En el se realiza una validacion de datos 
	 * previa antes de iniciar con la conversion 
	 * del dato en digitos LCD.
	 * 1. validacion de datos de entrada
	 * 2. codificacion de digitos a siete segmentos
	 * 3. cargar digitos codificados en pantalla
	 * 4. imprimir en pantalla
	 * @param comando
	 * es una cadena de caracteres que incluye tanto
	 * 			el tamaño como el numero a visualizar, 
	 * 			viene en el formato tamaño,numero 
	 * 			ejemplo 3,234
	 */
	public void procesar(String comando) {
		String[] parametros = validadorDeDatos.validarContenido(comando);
		validarEspacioEntreDigitos(espacioDig+"");
		this.pantalla = new Pantalla(Integer.parseInt(parametros[0]), parametros[1], espacioDig);
		List<List<Integer>> digitosCodificados = codificarDigitos(parametros[1], espacioDig);
		this.pantalla.cargarDigitosEnPantalla(digitosCodificados);
		this.pantalla.imprimirNumeroEnPantalla();

	}

	
	

	/**
	 * Metodo para validar si el digito que establece 
	 * el espacio entre los dato es un número y está 
	 * en el rango correcto
	 * @param espacio
	 *            es el espacio entre los digitos.
	 */
	public void validarEspacioEntreDigitos(String espacio) {
		espacioDig = validadorDeDatos.validarEspacioEntreDigitos(espacio);
	}
	
	
	/**
	 * Metodo para validar si el digito que establece 
	 * el espacio entre los dato es un numero y esta en 
	 * el rango correcto
	 * @param numero
	 *            Es el numero a codificar.
	 * @param espacio
	 *            es el espacio entre los digitos.
	 * @return lista de segmentos por cada digito del
	 * 			numero, cada numero corresponde a una 
	 * 			lista de enteros correspondientes a 
	 * 			los segmentos.
	 */
	private List<List<Integer>> codificarDigitos(String numero, int espacio) {
		List<List<Integer>> digitoscodificados = new ArrayList<>();
		char[] digitos;
		digitos = numero.toCharArray();
		for (char digito : digitos) {
			int numeroEntero = Integer.parseInt(String.valueOf(digito));
			digitoscodificados.add(codificadorDeDigitos.codificarDigitoASieteSegmentos(numeroEntero));
		}
		return digitoscodificados;
	}

}
