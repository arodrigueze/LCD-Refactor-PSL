import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class LCDTester {

	static final String CADENA_FINAL = "0,0";

	public static void main(String[] args) {

		List<String> listaComando = new ArrayList<>();
		ImpresorLCD impresorLCD = new ImpresorLCD();
		String comando;

		try {
			Scanner lector = new Scanner(System.in);
			System.out.print("Espacio entre Digitos (0 a 5): ");

			comando = lector.next();

			impresorLCD.validarEspacioEntreDigitos(comando);

			do {
				System.out.print("Entrada: ");
				comando = lector.next();
				if (!comando.equalsIgnoreCase(CADENA_FINAL)) {
					listaComando.add(comando);
				}
			} while (!comando.equalsIgnoreCase(CADENA_FINAL));

			lector.close();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}

		Iterator<String> iterator = listaComando.iterator();
		while (iterator.hasNext()) {
			try {
				impresorLCD.procesar(iterator.next());
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

	}

}
