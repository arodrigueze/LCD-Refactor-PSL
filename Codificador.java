import java.util.ArrayList;
import java.util.List;

/**
*La clase Codificador se encarga de codificar 
*los digitos en siete segmentos. 
*/

public class Codificador {

	/**
	 * Metodo que define los segmentos que componen
	 * un digito, cada segmento esta identificado
	 * de la siguiente forma:
	 * 
	 *		 	   ---5
	 * 			1|		|3
	 *     		   ---6
	 * 			2|		|4
	 *  		   ---7
	 *     
	 * @param numero
	 *          Digito a codificar
	 * @return segList
	 * 			Lista de enteros con los segmentos
	 * 			de cada digito
	 */	
	public List<Integer> codificarDigitoASieteSegmentos(int numero) {

		List<Integer> segList = new ArrayList<>();

		switch (numero) {
		case 1:
			segList.add(3);
			segList.add(4);
			break;
		case 2:
			segList.add(5);
			segList.add(3);
			segList.add(6);
			segList.add(2);
			segList.add(7);
			break;
		case 3:
			segList.add(5);
			segList.add(3);
			segList.add(6);
			segList.add(4);
			segList.add(7);
			break;
		case 4:
			segList.add(1);
			segList.add(6);
			segList.add(3);
			segList.add(4);
			break;
		case 5:
			segList.add(5);
			segList.add(1);
			segList.add(6);
			segList.add(4);
			segList.add(7);
			break;
		case 6:
			segList.add(5);
			segList.add(1);
			segList.add(6);
			segList.add(2);
			segList.add(7);
			segList.add(4);
			break;
		case 7:
			segList.add(5);
			segList.add(3);
			segList.add(4);
			break;
		case 8:
			segList.add(1);
			segList.add(2);
			segList.add(3);
			segList.add(4);
			segList.add(5);
			segList.add(6);
			segList.add(7);
			break;
		case 9:
			segList.add(1);
			segList.add(3);
			segList.add(4);
			segList.add(5);
			segList.add(6);
			segList.add(7);
			break;
		case 0:
			segList.add(1);
			segList.add(2);
			segList.add(3);
			segList.add(4);
			segList.add(5);
			segList.add(7);
			break;
		default:
			break;
		}

		return segList;
	}

}
