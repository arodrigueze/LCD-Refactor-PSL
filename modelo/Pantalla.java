package modelo;
import java.util.Iterator;
import java.util.List;

/**
 * This class take a list of codificated
 * digits and show them in console as a 
 * 7 segment number
 */

public class Pantalla {

	/**
	 * Estos son puntos fijos y se utilizan como
	 * punto de partida para graficar los segmentos
	 * los puntos fijos se ubican de la siguiente 
	 * forma:
	 * 
	 * 		 	 pf1--- pf5
	 * 			 |	    |
	 *     		 pf2--- pf4
	 * 			 |		|
	 *  		 pf3---
	 */
	private int[] pf1;
	private int[] pf2;
	private int[] pf3;
	private int[] pf4;
	private int[] pf5;
	
	/**
	 * size es el tamaño de cada digito
	 */
	private int size;

	/**
	 * filasDig es el Numero de filas por digito
	 */
	private int filasDig;
	
	/**
	 * columDig es el Numero de columnas por digito
	 */
	private int columDig;
	
	/**
	 *totalFilas es el total de filas a mostrar en pantalla
	 */
	private int totalFilas;
	
	/**
	 * totalColum es el total de columnas a mostrar en 
	 * pantalla
	 */
	private int totalColum;
	
	/**
	 * espacio es el espacioque hay entre cada digito.
	 */
	private int espacio;

	/**
	 * matrizImpr es una Matriz de caracteres que representa 
	 * la pantalla. 
	 */
	private String[][] matrizImpr;

	/**
	 * CARACTER_VERTICAL es el carácter que compone 
	 * el segmento vertical de los digitos en la 
	 * visualizacion
	 */
	static final String CARACTER_VERTICAL = "|";

	/**
	 * CARACTER_HORIZONTAL es el carácter que compone 
	 * el segmento horizontal de los digitos en la visualizacion
	 */
	static final String CARACTER_HORIZONTAL = "-";
	
	/**
	 * POSICION_X es el carácter que indica si el 
	 * segmento se debe trazar sobre el eje x
	 */
	static final String POSICION_X = "X";
	
	/**
	 * POSICION_Y es el carácter que indica si el 
	 * segmento se debe trazar sobre el eje y
	 */
	static final String POSICION_Y = "Y";

	/**
	 * El constructor permite incializar las variables de
	 * la siguiente forma: filasDig es igual a size 
	 * multiplicado por 2 y el resultado se le suma 3. columDig
	 * es igual a size mas 2. totalFilas mantiene el mismo valor
	 * de las filas del digito, totalColum es la suma del espacio
	 * multiplicado por la canditad de digitos del numero mas
	 * columDig mutiplicado por la cantidad de digitos. Finalmente
	 * se inicializa la matrizImpr con los tamaños totales y cada
	 * elemento de ella se deja con espacios en blanco
	 * @param size
	 * 			es el tamaño de los digitos
	 * @param numeroImp
	 * 			es el numero el cual se quiere codificar
	 * @param espacio
	 * 			es el espacio que hay entre los digitos
	 */
	public Pantalla(int size, String numeroImp, int espacio) {
		this.pf1 = new int[2];
		this.pf2 = new int[2];
		this.pf3 = new int[2];
		this.pf4 = new int[2];
		this.pf5 = new int[2];
		this.size = size;
		this.espacio = espacio;

		this.filasDig = (2 * this.size) + 3;
		this.columDig = this.size + 2;
		this.totalFilas = this.filasDig;
		this.totalColum = (this.columDig * numeroImp.length()) + (espacio * numeroImp.length());
		this.matrizImpr = new String[this.totalFilas][this.totalColum];

		for (int i = 0; i < this.totalFilas; i++) {
			for (int j = 0; j < this.totalColum; j++) {
				this.matrizImpr[i][j] = " ";
			}
		}
	}
	
	/**
	 * el metodo cargarDigitosEnPantalla recibe la lista
	 * de digitos codificados y establece los puntos fijos
	 * para cada digito, posteriormente carga cada
	 * segmento de cada digito en la matriz matrizImpr 
	 * utilizando el metodo agregarSegmentoALaPantalla
	 * @param digitosCodificados
	 * 			es la lista segmentos por cada digito
	 */
	public void cargarDigitosEnPantalla(List<List<Integer>> digitosCodificados) {
		int pivotX = 0;
		for (List<Integer> digito : digitosCodificados) {

			this.pf1[0] = 0;
			this.pf1[1] = 0 + pivotX;

			this.pf2[0] = (this.filasDig / 2);
			this.pf2[1] = 0 + pivotX;

			this.pf3[0] = (this.filasDig - 1);
			this.pf3[1] = 0 + pivotX;

			this.pf4[0] = (this.columDig - 1);
			this.pf4[1] = (this.filasDig / 2) + pivotX;

			this.pf5[0] = 0;
			this.pf5[1] = (this.columDig - 1) + pivotX;

			pivotX = pivotX + this.columDig + espacio;

			Iterator<Integer> iterator = digito.iterator();

			while (iterator.hasNext()) {
				agregarSegmentoALaPantalla(iterator.next());
			}
		}

	}

	/**
	 * El metodo agregarSegmentoALaPantalla relaciona
	 * los segmentos con los puntos fijos, la posicion
	 * x o y hacia el cual se va a trazar el segmento y
	 * el tamaño del segmento, estos puntos
	 * fijos son el origen del segmento en la matriz. 
	 * @param segmento
	 *            segmento que se desea mostrar en 
	 *            pantalla.
	 */
	private void agregarSegmentoALaPantalla(Integer segmento) {
		switch (segmento) {
		case 1:
			adicionarLinea(this.matrizImpr, this.pf1, POSICION_Y, this.size, CARACTER_VERTICAL);
			break;
		case 2:
			adicionarLinea(this.matrizImpr, this.pf2, POSICION_Y, this.size, CARACTER_VERTICAL);
			break;
		case 3:
			adicionarLinea(this.matrizImpr, this.pf5, POSICION_Y, this.size, CARACTER_VERTICAL);
			break;
		case 4:
			adicionarLinea(this.matrizImpr, this.pf4, POSICION_Y, this.size, CARACTER_VERTICAL);
			break;
		case 5:
			adicionarLinea(this.matrizImpr, this.pf1, POSICION_X, this.size, CARACTER_HORIZONTAL);
			break;
		case 6:
			adicionarLinea(this.matrizImpr, this.pf2, POSICION_X, this.size, CARACTER_HORIZONTAL);
			break;
		case 7:
			adicionarLinea(this.matrizImpr, this.pf3, POSICION_X, this.size, CARACTER_HORIZONTAL);
			break;
		default:
			break;
		}

	}

	/**
	 * Metodo encargado de añadir una linea a la matriz de Impresion
	 * @param matriz
	 *            Matriz Impresion
	 * @param punto
	 *            Punto Pivote
	 * @param posFija
	 *            Posicion Fija
	 * @param size
	 *            Tamaño Segmento
	 * @param caracter
	 *            Caracter Segmento
	 */
	private void adicionarLinea(String[][] matriz, int[] punto, String posFija, int size, String caracter) {
		if (posFija.equalsIgnoreCase(POSICION_X)) {
			for (int y = 1; y <= size; y++) {
				int valor = punto[1] + y;
				matriz[punto[0]][valor] = caracter;
			}
		} else {
			for (int i = 1; i <= size; i++) {
				int valor = punto[0] + i;
				matriz[valor][punto[1]] = caracter;
			}
		}
	}
	
	/**
	 * metodo para visualizar la matriz de impresion
	 */
	public void imprimirNumeroEnPantalla() {
		for (int i = 0; i < this.totalFilas; i++) {
			for (int j = 0; j < this.totalColum; j++) {
				System.out.print(this.matrizImpr[i][j]);
			}
			System.out.println();
		}
	}

}
