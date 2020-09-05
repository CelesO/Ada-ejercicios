package ejercicios;

import java.util.Scanner;

public class Ejercicios210Autobus {

	private static final int MINIMO_PERSONAS = 20;
	private static final int COSTO_A = 2;
	private static final float COSTO_B = 2.5f;
	private static final int COSTO_C = 3;
	private static final String BUS_A = "A";
	private static final String BUS_B = "B";
	private static final String BUS_C = "C";

	public static void main(String[] args) {
		// tres costos diferentes por km
		// para cada autobus
		// minimo 20 personas, si hay mas cambia el precio
		// determinar costo total
		// determinar costo por persona

		// solicitar la cantidad de personas
		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese cantidad de personas");
		int personas = sc.nextInt();

		System.out.println("Ingreso: " + personas);

		// solicitar la cantidad de km
		System.out.println("Ingrese cantidad de km");
		int km = sc.nextInt();

		// solicitar el tipo de autobus
		System.out.println("Ingrese tipo de autobus (A, B, C)");
		String tipo = sc.next();
		// sc.close();podria estar aca porque ya no necesito sc, no necesito mas datos
		// de teclado
		int totalPersonas = MINIMO_PERSONAS;

		// calcular costo del transporte. Hay muchas formas de hacer esto
		if (personas > MINIMO_PERSONAS) {
			totalPersonas = personas;
		}

		// calcular costo total
		// total de personas * km * precio boletos
		int costoTotal = totalPersonas * km;

		float totalGrupal = 0;

		switch (tipo.toUpperCase()) {
		case BUS_A:
			totalGrupal = costoTotal * COSTO_A;
			break;
		case BUS_B:
			totalGrupal = costoTotal * COSTO_B;
			break;
		case BUS_C:
			totalGrupal = costoTotal * COSTO_C;
			break;
		}

		System.out.println("El total grupal es: " + totalGrupal);

		sc.close();

		System.out.println("Usted ha reservado un autobus " + tipo + " para viajar " + km
				+ " kilometros y transportar a " + personas + " personas" + " por un costo total de " + totalGrupal);
	}

}
